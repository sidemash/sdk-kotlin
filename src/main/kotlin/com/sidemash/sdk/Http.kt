package com.sidemash.sdk

import java.nio.charset.StandardCharsets
import java.util.Base64
import java.security.MessageDigest
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import com.fasterxml.jackson.module.kotlin.*


object Http {

    fun <T> Get(path:String,  converter:(String) -> T, auth:Auth) : T  =
       call(path = path, method = "GET", headers = emptyMap(), queryString = null, body = null, converter = converter,  auth = auth)


    fun <T> List(path:String, queryString:String? = null,  converter:(String) -> T, auth:Auth) : T  =
       call(path = path, method = "GET", headers = emptyMap(), queryString = queryString, body = null, converter = converter, auth = auth)


    fun <T> Post(path:String, headers: Map<String, String> = emptyMap(), queryString:String? = null, body:String?,  converter:(String) -> T,  auth:Auth) : T  =
       call(path = path, method = "POST", headers = headers, queryString = queryString, body = body, converter = converter, auth = auth)


    fun <T> Patch(path:String, headers: Map<String, String> = emptyMap(), queryString:String? = null, body:String?,  converter:(String) -> T, auth:Auth) : T =
        call(path = path, method = "PATCH", headers = headers, queryString = queryString, body = body, converter = converter, auth = auth)


    fun <T> Put(path:String, headers: Map<String, String> = emptyMap(), queryString:String? = null, body:String?,  converter:(String) -> T, auth:Auth) : T  =
        call(path = path, method = "PUT", headers = headers, queryString = queryString, body = body, converter = converter, auth = auth)

    fun<T> Delete(path:String, headers: Map<String, String> = emptyMap(), queryString:String? = null, body:String? = null, converter:(String) -> T, auth:Auth): T  =
        call(path = path, method = "DELETE", headers = headers, queryString = queryString, body = body, converter = converter, auth = auth)



    private const val host = "http://dev-api.sidemash.io"
    const val Version = "v1.0"
    private fun <T> call(path:String,
                         method:String,
                         headers: Map<String, String>,
                         queryString:String?,
                         body:String?,
                         converter:(String) -> T,
                         auth:Auth) : T {

        val queryUrl: URL = URL(host + path + (queryString ?: ""))
        val connection : HttpURLConnection =  queryUrl.openConnection() as HttpURLConnection

        if(method == "PATCH") connection.requestMethod = "POST"
        else connection.requestMethod = method

        val signedHeaders = computeSignedHeaders(method, body, headers, auth)
        if(method != "GET"){
            val request : SdmRequest = SdmRequest(
                nonce = System.currentTimeMillis().toString(),
                method = method,
                path = path,
                bodyHash = if(body == null) null else sha256(body),
                signedHeaders = signedHeaders,
                queryString = queryString
            )
            connection.setRequestProperty("X-Sdm-Nonce",  request.nonce)
            connection.setRequestProperty("X-Sdm-SignedHeaders", signedHeaders.joinToString(", ") { it.first })
            connection.setRequestProperty("X-Sdm-Signature",  ("SHA256 " + sign(request, auth.secretKey)))
        }
        signedHeaders.forEach { connection.setRequestProperty(it.first, it.second) }

        if(body != null){
            connection.doOutput = true
            connection.outputStream.write(body.toByteArray(StandardCharsets.UTF_8))
        }

        val statusCode = connection.getResponseCode()
        val statusMessage = connection.getResponseMessage()
        fun getResponseBody(input: InputStream) : String {
            val rd : BufferedReader = BufferedReader(InputStreamReader(input))
            val sj: StringJoiner = StringJoiner("\n")

            tailrec fun getResponseBodyRec(line:String?): String {
                return if(line == null) sj.toString()
                else {
                    sj.add(line)
                    getResponseBodyRec(line = rd.readLine())
                }
            }
            return getResponseBodyRec(line = rd.readLine())
        }
        if(statusCode < 300) {
            val resp = getResponseBody(connection.getInputStream())
            return converter(resp)
        }
        else throw CallException(statusCode, statusMessage, getResponseBody(connection.getErrorStream()))
    }

    private fun computeSignedHeaders(method:String, body:String?, headers: Map<String, String>, auth:Auth) : List<Pair<String, String>> {
        return (if(method == "PATCH") listOf("X-HTTP-Method-Override" to "PATCH") else emptyList() ) +
                listOf("Accept" to "application/json", "User-Agent" to  ("Sdk Kotlin $Version"), "Authorization" to "Bearer ${auth.token}") +
                headers.toList() +
                (if(body == null) emptyList() else listOf("Content-Type" to "application/json"))
    }
    private fun sha256(message:String) : String {
        val md : MessageDigest = MessageDigest.getInstance("SHA-256")
        md.update(message.toByteArray(StandardCharsets.UTF_8))
        return Base64.getEncoder().encodeToString(md.digest())
    }
    private const val Algorithm = "HmacSHA256"
    private fun sign(signedRequest: SdmRequest, privateKey: String) : String {
        val message = signedRequest.toMessage()
        val secretKeySpec = SecretKeySpec(privateKey.toByteArray(StandardCharsets.UTF_8), Algorithm)
        val mac : Mac = Mac.getInstance(Algorithm)
        mac.init(secretKeySpec)
        mac.update(message.toByteArray(StandardCharsets.UTF_8))
        return Base64.getEncoder().encodeToString(mac.doFinal())
    }
}
