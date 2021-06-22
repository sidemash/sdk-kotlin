/*
   Copyright © 2020 Sidemash Cloud Services

   Licensed under the Apache  License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless  required  by  applicable  law  or  agreed to in writing,
   software  distributed  under  the  License  is distributed on an
   "AS IS"  BASIS, WITHOUT  WARRANTIES  OR CONDITIONS OF  ANY KIND,
   either  express  or  implied.  See the License for the  specific
   language governing permissions and limitations under the License.
*/


package com.sidemash.sdk

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.*

data class StreamSquare @JsonCreator constructor(@get:JsonProperty("id") @JsonProperty("id") val id: String,
                                                 @get:JsonProperty("url") @JsonProperty("url") val url: String,
                                                 @get:JsonProperty("status") @JsonProperty("status") val status: InstanceStatus,
                                                 @get:JsonProperty("isElastic") @JsonProperty("isElastic") val isElastic: Boolean,
                                                 @get:JsonProperty("size") @JsonProperty("size") val size: StreamSquare.Size,
                                                 @get:JsonProperty("playDomainName") @JsonProperty("playDomainName") val playDomainName: String? = null,
                                                 @get:JsonProperty("publishDomainName") @JsonProperty("publishDomainName") val publishDomainName: String? = null,
                                                 @get:JsonProperty("publish") @JsonProperty("publish") val publish: Publish,
                                                 @get:JsonProperty("hook") @JsonProperty("hook") val hook: Hook,
                                                 @get:JsonProperty("description") @JsonProperty("description") val description: String? = null,
                                                 @get:JsonProperty("foreignData") @JsonProperty("foreignData") val foreignData: String? = null) {
    val _type: String = Type

    sealed class Size(val value: String) {
        object S : Size("S")
        object M : Size("M")
        object L : Size("L")
        object Xl : Size("XL")
        object Xxl : Size("XXL")

        @JsonValue
        override fun toString() : String {
            return value
        }

        fun isValid() : Boolean {
            return isValid(this.value)
        }

        fun isNotS() : Boolean {
            return isNotS(this.value)
        }

        fun isNotM() : Boolean {
            return isNotM(this.value)
        }

        fun isNotL() : Boolean {
            return isNotL(this.value)
        }

        fun isNotXl() : Boolean {
            return isNotXl(this.value)
        }

        fun isNotXxl() : Boolean {
            return isNotXxl(this.value)
        }

        fun ifNotS(fn: (Size) -> Unit) {
            ifNotS(this.value, fn)
        }

        fun ifNotM(fn: (Size) -> Unit) {
            ifNotM(this.value, fn)
        }

        fun ifNotL(fn: (Size) -> Unit) {
            ifNotL(this.value, fn)
        }

        fun ifNotXl(fn: (Size) -> Unit) {
            ifNotXl(this.value, fn)
        }

        fun ifNotXxl(fn: (Size) -> Unit) {
            ifNotXxl(this.value, fn)
        }

        fun isS() : Boolean {
            return isS(this.value)
        }

        fun isM() : Boolean {
            return isM(this.value)
        }

        fun isL() : Boolean {
            return isL(this.value)
        }

        fun isXl() : Boolean {
            return isXl(this.value)
        }

        fun isXxl() : Boolean {
            return isXxl(this.value)
        }

        fun asSOrNull() : S? {
             return asSOrNull(this.value)
        }

        fun asMOrNull() : M? {
             return asMOrNull(this.value)
        }

        fun asLOrNull() : L? {
             return asLOrNull(this.value)
        }

        fun asXlOrNull() : Xl? {
             return asXlOrNull(this.value)
        }

        fun asXxlOrNull() : Xxl? {
             return asXxlOrNull(this.value)
        }

        fun ifS(fn: (S) -> Unit) {
            ifS(this.value, fn)
        }

        fun ifM(fn: (M) -> Unit) {
            ifM(this.value, fn)
        }

        fun ifL(fn: (L) -> Unit) {
            ifL(this.value, fn)
        }

        fun ifXl(fn: (Xl) -> Unit) {
            ifXl(this.value, fn)
        }

        fun ifXxl(fn: (Xxl) -> Unit) {
            ifXxl(this.value, fn)
        }

        fun asOneOf(vararg selection: Size) : StreamSquare.Size? {
            for (s in selection) {
                if(s.value == value) return s
            }
            return null
        }

        fun ifOneOf(vararg selection: Size) : ((StreamSquare.Size) -> Unit) -> Unit {
            return Size.ifOneOf(value, *selection)
        }

        fun ifNoneOf(vararg selection: Size) : ((StreamSquare.Size) -> Unit) -> Unit {
            return Size.ifNoneOf(value, *selection)
        }

        companion object {
            val AllPossiblesValues: Set<String> = setOf("S", "M", "L", "XL", "XXL")

            fun asSOrNull(value: String) : S? {
                 return if(isS(value)) S else null
            }

            fun asMOrNull(value: String) : M? {
                 return if(isM(value)) M else null
            }

            fun asLOrNull(value: String) : L? {
                 return if(isL(value)) L else null
            }

            fun asXlOrNull(value: String) : Xl? {
                 return if(isXl(value)) Xl else null
            }

            fun asXxlOrNull(value: String) : Xxl? {
                 return if(isXxl(value)) Xxl else null
            }

            fun ifS(value: String, fn: (S) -> Unit) {
                 if(isS(value)) fn(S)
            }

            fun ifM(value: String, fn: (M) -> Unit) {
                 if(isM(value)) fn(M)
            }

            fun ifL(value: String, fn: (L) -> Unit) {
                 if(isL(value)) fn(L)
            }

            fun ifXl(value: String, fn: (Xl) -> Unit) {
                 if(isXl(value)) fn(Xl)
            }

            fun ifXxl(value: String, fn: (Xxl) -> Unit) {
                 if(isXxl(value)) fn(Xxl)
            }

            fun asOneOf(value:String, vararg selection: Size) : StreamSquare.Size? {
                for (s in selection) {
                    if(s.value == value) return s
                }
                return null
            }

            fun ifOneOf(value: String, vararg selection: Size) : ((StreamSquare.Size) -> Unit) -> Unit {
                for (s in selection) {
                    if(s.value == value) return { fn -> fn(s) }
                }
                return {}
            }

            fun ifNoneOf(value: String, vararg selection: Size) : ((StreamSquare.Size) -> Unit) -> Unit {
                for (s in selection) {
                    if(s.value == value) return {}
                }
                return { fn ->
                    val r = fromString(value)
                    if(r != null) { fn(r) }
                }
            }

            fun isValid(value: String) : Boolean {
                return AllPossiblesValues.contains(value)
            }

            fun isNotS(value: String) : Boolean {
                return value != S.value
            }

            fun isNotM(value: String) : Boolean {
                return value != M.value
            }

            fun isNotL(value: String) : Boolean {
                return value != L.value
            }

            fun isNotXl(value: String) : Boolean {
                return value != Xl.value
            }

            fun isNotXxl(value: String) : Boolean {
                return value != Xxl.value
            }

            fun ifNotS(value: String, fn: (Size) -> Unit) {
                 if(isNotS(value)) fn(S)
            }

            fun ifNotM(value: String, fn: (Size) -> Unit) {
                 if(isNotM(value)) fn(M)
            }

            fun ifNotL(value: String, fn: (Size) -> Unit) {
                 if(isNotL(value)) fn(L)
            }

            fun ifNotXl(value: String, fn: (Size) -> Unit) {
                 if(isNotXl(value)) fn(Xl)
            }

            fun ifNotXxl(value: String, fn: (Size) -> Unit) {
                 if(isNotXxl(value)) fn(Xxl)
            }

            fun isS(value: String) : Boolean {
                return value == S.value
            }

            fun isM(value: String) : Boolean {
                return value == M.value
            }

            fun isL(value: String) : Boolean {
                return value == L.value
            }

            fun isXl(value: String) : Boolean {
                return value == Xl.value
            }

            fun isXxl(value: String) : Boolean {
                return value == Xxl.value
            }

            @JvmStatic
            @JsonCreator
            fun fromString(value: String) : StreamSquare.Size? {
                return when (value) {
                    "S" -> S
                    "M" -> M
                    "L" -> L
                    "XL" -> Xl
                    "XXL" -> Xxl
                    else -> null
                }
            }
        }
    }

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "StreamSquare"

        fun fromJson(s: String) : StreamSquare {
            return Utils.Js.mapper.readValue(s)
        }
    }
}