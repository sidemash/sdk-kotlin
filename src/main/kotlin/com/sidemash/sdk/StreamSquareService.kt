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
import com.sidemash.sdk.Http.Version

class StreamSquareService  constructor(@get:JsonProperty("auth") @JsonProperty("auth") val auth: Auth) {
    fun create(form: CreateStreamSquareForm) : StreamSquare {
        return Http.Post("/$Version/stream-squares", emptyMap(), null, form.toJson(), { StreamSquare.fromJson(it) }, auth)
    }

    fun get(id: String) : StreamSquare {
        return Http.Get("/$Version/stream-squares/$id", { StreamSquare.fromJson(it) }, auth)
    }

    fun list(form: ListForm = ListForm()) : RestCollection<StreamSquare> {
        return Http.List("/$Version/stream-squares", form.toQueryString(), { RestCollection.fromJson(it) }, auth)
    }

    fun update(form: UpdateStreamSquareForm) : StreamSquare {
        return Http.Patch("/$Version/stream-squares/${form.id}", emptyMap(), null, form.toJson(), { StreamSquare.fromJson(it) }, auth)
    }

    fun delete(id: String) {
        Http.Delete("/$Version/stream-squares/$id", emptyMap(), null, null, {}, auth)
    }
}