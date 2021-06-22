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
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.*

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_type")
@JsonSubTypes(
    JsonSubTypes.Type(value = Hook.HttpCall::class, name = "Hook.HttpCall"),
    JsonSubTypes.Type(value = Hook.WsCall::class, name = "Hook.WsCall")
)
sealed class Hook {
    abstract val _type: String

    data class HttpCall @JsonCreator constructor(@get:JsonProperty("method") @JsonProperty("method") val method: HttpMethod,
                                                 @get:JsonProperty("url") @JsonProperty("url") val url: String) : Hook() {
        @JsonIgnore
        override val _type: String = Type

        fun toJson() : String {
            return Utils.Js.toJson(this)
        }

        fun toJsonNode() : JsonNode {
            return Utils.Js.toJsonNode(this)
        }

        companion object {
            const val Type: String = "Hook.HttpCall"

            fun fromJson(s: String) : HttpCall {
                return Utils.Js.mapper.readValue(s)
            }
        }
    }

    data class WsCall @JsonCreator constructor(@get:JsonProperty("method") @JsonProperty("method") val method: HttpMethod,
                                               @get:JsonProperty("url") @JsonProperty("url") val url: String) : Hook() {
        @JsonIgnore
        override val _type: String = Type

        fun toJson() : String {
            return Utils.Js.toJson(this)
        }

        fun toJsonNode() : JsonNode {
            return Utils.Js.toJsonNode(this)
        }

        companion object {
            const val Type: String = "Hook.WsCall"

            fun fromJson(s: String) : WsCall {
                return Utils.Js.mapper.readValue(s)
            }
        }
    }
}