package com.sidemash.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

object Utils {

    object Js {
        val mapper :ObjectMapper = configureMapper(ObjectMapper());

        fun configureMapper(mapper: ObjectMapper) : ObjectMapper{
            return mapper.registerModule(Jdk8Module())
                    .registerModule(JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        }

        fun <T> toJsonNode(obj: T) : JsonNode {
            return mapper.valueToTree(obj);
        }

        fun <T> toJson(obj:T): String {
            return mapper.writeValueAsString(obj)
        }
    }
}
