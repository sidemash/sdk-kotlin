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
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.*

data class CreateStreamSquareForm @JsonCreator constructor(@get:JsonProperty("isElastic") @JsonProperty("isElastic") val isElastic: Boolean,
                                                           @get:JsonProperty("size") @JsonProperty("size") val size: StreamSquare.Size,
                                                           @get:JsonProperty("hook") @JsonProperty("hook") val hook: Hook,
                                                           @get:JsonProperty("description") @JsonProperty("description") val description: String? = null,
                                                           @get:JsonProperty("foreignData") @JsonProperty("foreignData") val foreignData: String? = null,
                                                           @get:JsonProperty("playDomainName") @JsonProperty("playDomainName") val playDomainName: String? = null,
                                                           @get:JsonProperty("publishDomainName") @JsonProperty("publishDomainName") val publishDomainName: String? = null) {
    @JsonIgnore
    val _type: String = Type

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "CreateStreamSquareForm"

        fun fromJson(s: String) : CreateStreamSquareForm {
            return Utils.Js.mapper.readValue(s)
        }
    }
}