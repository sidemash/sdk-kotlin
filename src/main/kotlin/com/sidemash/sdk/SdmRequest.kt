package com.sidemash.sdk

data class SdmRequest(val nonce:String,
                      val signedHeaders : List<Pair<String, String>>,
                      val method : String,
                      val path : String,
                      val queryString : String?,
                      val bodyHash : String?) {
    fun toMessage() : String =
        nonce +
                signedHeaders.joinToString("") { it.first + ":" + it.second } +
                method +
                path +
                (queryString ?: "") +
                (bodyHash ?: "")
}
