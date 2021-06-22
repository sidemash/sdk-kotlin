package com.sidemash.sdk

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.readValue

data class RestCollection<T>(@JsonProperty("url") val url:String,
                             @JsonProperty("pagination") val pagination: Pagination,
                             @JsonProperty("items") val items: List<T>){

    @JsonIgnore
    val _type: String = Type

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    companion object {
        const val Type: String = "RestCollection"

        fun <T> fromJson(s: String) : RestCollection<T> {
            return Utils.Js.mapper.readValue(s)
        }
    }
}