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

data class SecureAndNonSecure @JsonCreator constructor(@get:JsonProperty("secure") @JsonProperty("secure") val secure: String,
                                                       @get:JsonProperty("nonSecureOn80") @JsonProperty("nonSecureOn80") val nonSecureOn80: String,
                                                       @get:JsonProperty("nonSecure") @JsonProperty("nonSecure") val nonSecure: String) {
    val _type: String = Type

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "SecureAndNonSecure"

        fun fromJson(s: String) : SecureAndNonSecure {
            return Utils.Js.mapper.readValue(s)
        }
    }
}