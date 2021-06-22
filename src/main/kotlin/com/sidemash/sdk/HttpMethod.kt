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

sealed class HttpMethod(val value: String) {
    object Get : HttpMethod("GET")
    object Post : HttpMethod("POST")
    object Put : HttpMethod("PUT")
    object Delete : HttpMethod("DELETE")
    object Patch : HttpMethod("PATCH")

    @JsonValue
    override fun toString() : String {
        return value
    }

    fun isValid() : Boolean {
        return isValid(this.value)
    }

    fun isNotGet() : Boolean {
        return isNotGet(this.value)
    }

    fun isNotPost() : Boolean {
        return isNotPost(this.value)
    }

    fun isNotPut() : Boolean {
        return isNotPut(this.value)
    }

    fun isNotDelete() : Boolean {
        return isNotDelete(this.value)
    }

    fun isNotPatch() : Boolean {
        return isNotPatch(this.value)
    }

    fun ifNotGet(fn: (HttpMethod) -> Unit) {
        ifNotGet(this.value, fn)
    }

    fun ifNotPost(fn: (HttpMethod) -> Unit) {
        ifNotPost(this.value, fn)
    }

    fun ifNotPut(fn: (HttpMethod) -> Unit) {
        ifNotPut(this.value, fn)
    }

    fun ifNotDelete(fn: (HttpMethod) -> Unit) {
        ifNotDelete(this.value, fn)
    }

    fun ifNotPatch(fn: (HttpMethod) -> Unit) {
        ifNotPatch(this.value, fn)
    }

    fun isGet() : Boolean {
        return isGet(this.value)
    }

    fun isPost() : Boolean {
        return isPost(this.value)
    }

    fun isPut() : Boolean {
        return isPut(this.value)
    }

    fun isDelete() : Boolean {
        return isDelete(this.value)
    }

    fun isPatch() : Boolean {
        return isPatch(this.value)
    }

    fun asGetOrNull() : Get? {
         return asGetOrNull(this.value)
    }

    fun asPostOrNull() : Post? {
         return asPostOrNull(this.value)
    }

    fun asPutOrNull() : Put? {
         return asPutOrNull(this.value)
    }

    fun asDeleteOrNull() : Delete? {
         return asDeleteOrNull(this.value)
    }

    fun asPatchOrNull() : Patch? {
         return asPatchOrNull(this.value)
    }

    fun ifGet(fn: (Get) -> Unit) {
        ifGet(this.value, fn)
    }

    fun ifPost(fn: (Post) -> Unit) {
        ifPost(this.value, fn)
    }

    fun ifPut(fn: (Put) -> Unit) {
        ifPut(this.value, fn)
    }

    fun ifDelete(fn: (Delete) -> Unit) {
        ifDelete(this.value, fn)
    }

    fun ifPatch(fn: (Patch) -> Unit) {
        ifPatch(this.value, fn)
    }

    fun asOneOf(vararg selection: HttpMethod) : HttpMethod? {
        for (s in selection) {
            if(s.value == value) return s
        }
        return null
    }

    fun ifOneOf(vararg selection: HttpMethod) : ((HttpMethod) -> Unit) -> Unit {
        return HttpMethod.ifOneOf(value, *selection)
    }

    fun ifNoneOf(vararg selection: HttpMethod) : ((HttpMethod) -> Unit) -> Unit {
        return HttpMethod.ifNoneOf(value, *selection)
    }

    companion object {
        val AllPossiblesValues: Set<String> = setOf("GET", "POST", "PUT", "DELETE", "PATCH")

        fun asGetOrNull(value: String) : Get? {
             return if(isGet(value)) Get else null
        }

        fun asPostOrNull(value: String) : Post? {
             return if(isPost(value)) Post else null
        }

        fun asPutOrNull(value: String) : Put? {
             return if(isPut(value)) Put else null
        }

        fun asDeleteOrNull(value: String) : Delete? {
             return if(isDelete(value)) Delete else null
        }

        fun asPatchOrNull(value: String) : Patch? {
             return if(isPatch(value)) Patch else null
        }

        fun ifGet(value: String, fn: (Get) -> Unit) {
             if(isGet(value)) fn(Get)
        }

        fun ifPost(value: String, fn: (Post) -> Unit) {
             if(isPost(value)) fn(Post)
        }

        fun ifPut(value: String, fn: (Put) -> Unit) {
             if(isPut(value)) fn(Put)
        }

        fun ifDelete(value: String, fn: (Delete) -> Unit) {
             if(isDelete(value)) fn(Delete)
        }

        fun ifPatch(value: String, fn: (Patch) -> Unit) {
             if(isPatch(value)) fn(Patch)
        }

        fun asOneOf(value:String, vararg selection: HttpMethod) : HttpMethod? {
            for (s in selection) {
                if(s.value == value) return s
            }
            return null
        }

        fun ifOneOf(value: String, vararg selection: HttpMethod) : ((HttpMethod) -> Unit) -> Unit {
            for (s in selection) {
                if(s.value == value) return { fn -> fn(s) }
            }
            return {}
        }

        fun ifNoneOf(value: String, vararg selection: HttpMethod) : ((HttpMethod) -> Unit) -> Unit {
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

        fun isNotGet(value: String) : Boolean {
            return value != Get.value
        }

        fun isNotPost(value: String) : Boolean {
            return value != Post.value
        }

        fun isNotPut(value: String) : Boolean {
            return value != Put.value
        }

        fun isNotDelete(value: String) : Boolean {
            return value != Delete.value
        }

        fun isNotPatch(value: String) : Boolean {
            return value != Patch.value
        }

        fun ifNotGet(value: String, fn: (HttpMethod) -> Unit) {
             if(isNotGet(value)) fn(Get)
        }

        fun ifNotPost(value: String, fn: (HttpMethod) -> Unit) {
             if(isNotPost(value)) fn(Post)
        }

        fun ifNotPut(value: String, fn: (HttpMethod) -> Unit) {
             if(isNotPut(value)) fn(Put)
        }

        fun ifNotDelete(value: String, fn: (HttpMethod) -> Unit) {
             if(isNotDelete(value)) fn(Delete)
        }

        fun ifNotPatch(value: String, fn: (HttpMethod) -> Unit) {
             if(isNotPatch(value)) fn(Patch)
        }

        fun isGet(value: String) : Boolean {
            return value == Get.value
        }

        fun isPost(value: String) : Boolean {
            return value == Post.value
        }

        fun isPut(value: String) : Boolean {
            return value == Put.value
        }

        fun isDelete(value: String) : Boolean {
            return value == Delete.value
        }

        fun isPatch(value: String) : Boolean {
            return value == Patch.value
        }

        @JvmStatic
        @JsonCreator
        fun fromString(value: String) : HttpMethod? {
            return when (value) {
                "GET" -> Get
                "POST" -> Post
                "PUT" -> Put
                "DELETE" -> Delete
                "PATCH" -> Patch
                else -> null
            }
        }
    }
}