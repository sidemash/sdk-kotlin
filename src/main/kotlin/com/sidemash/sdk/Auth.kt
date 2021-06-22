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
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.*

data class Auth @JsonCreator constructor(@get:JsonProperty("token") @JsonProperty("token") val token: String,
                                         @get:JsonProperty("secretKey") @JsonProperty("secretKey") val secretKey: String) {
    val _type: String = Type

    override fun toString() : String {
        return "Auth(token=" + token +
                    ", secretKey=******" + ')'
    }

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "Auth"

        fun fromJson(s: String) : Auth {
            return Utils.Js.mapper.readValue(s)
        }
    }
}