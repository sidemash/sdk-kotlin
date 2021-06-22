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

data class Pagination @JsonCreator constructor(@get:JsonProperty("selfUrl") @JsonProperty("selfUrl") val selfUrl: String,
                                               @get:JsonProperty("prevUrl") @JsonProperty("prevUrl") val prevUrl: String? = null,
                                               @get:JsonProperty("nextUrl") @JsonProperty("nextUrl") val nextUrl: String? = null,
                                               @get:JsonProperty("startedTime") @JsonProperty("startedTime") val startedTime: UTCDateTime,
                                               @get:JsonProperty("nbItemsOnThisPage") @JsonProperty("nbItemsOnThisPage") val nbItemsOnThisPage: Int,
                                               @get:JsonProperty("page") @JsonProperty("page") val page: Int,
                                               @get:JsonProperty("nbItemsPerPage") @JsonProperty("nbItemsPerPage") val nbItemsPerPage: Int) {
    val _type: String = Type

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "Pagination"

        fun fromJson(s: String) : Pagination {
            return Utils.Js.mapper.readValue(s)
        }
    }
}