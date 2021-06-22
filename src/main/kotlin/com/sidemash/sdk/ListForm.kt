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

data class ListForm @JsonCreator constructor(@get:JsonProperty("where") @JsonProperty("where") val where: String? = null,
                                             @get:JsonProperty("limit") @JsonProperty("limit") val limit: Int? = null,
                                             @get:JsonProperty("orderBy") @JsonProperty("orderBy") val orderBy: String? = null) {
    @JsonIgnore
    val _type: String = Type

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    fun toQueryString() : String =
        listOf(if(where == null) "" else "where=$where",
               "limit=$limit",
               if(orderBy == null) "" else "orderBy=$orderBy").joinToString(separator = "&", prefix = "?", postfix = "")


    companion object {
        const val Type: String = "ListForm"

        fun fromJson(s: String) : ListForm {
            return Utils.Js.mapper.readValue(s)
        }
    }
}