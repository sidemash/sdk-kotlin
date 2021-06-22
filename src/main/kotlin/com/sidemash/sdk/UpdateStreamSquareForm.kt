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
import java.util.Objects

class UpdateStreamSquareForm private constructor(@get:JsonProperty("id") @JsonProperty("id") val id: String,
                                                 private @get:JsonProperty("remove") @JsonProperty("remove") val remove: Set<RemovableFields> = emptySet(),
                                                 private @get:JsonProperty("set") @JsonProperty("set") val set: Map<EditableFields, Any> = emptyMap()) {
    fun byId(id: String) : Builder {
        return Builder(id)
    }

    class Builder  constructor(@get:JsonProperty("id") @JsonProperty("id") val id: String) {
        fun removeDescription() : UpdateStreamSquareForm {
            return UpdateStreamSquareForm(id, setOf(RemovableFields.DESCRIPTION), emptyMap())
        }

        fun removeForeignData() : UpdateStreamSquareForm {
            return UpdateStreamSquareForm(id, setOf(RemovableFields.FOREIGN_DATA), emptyMap())
        }

        fun setIsElastic(i: Boolean) : UpdateStreamSquareForm {
            val set = mapOf(EditableFields.IS_ELASTIC to i)
            return UpdateStreamSquareForm(id, emptySet(), set)
        }

        fun setSize(s: StreamSquare.Size) : UpdateStreamSquareForm {
            val set = mapOf(EditableFields.SIZE to s)
            return UpdateStreamSquareForm(id, emptySet(), set)
        }

        fun setHook(h: Hook) : UpdateStreamSquareForm {
            val set = mapOf(EditableFields.HOOK to h)
            return UpdateStreamSquareForm(id, emptySet(), set)
        }

        fun setDescription(d: String) : UpdateStreamSquareForm {
            val set = mapOf(EditableFields.DESCRIPTION to d)
            return UpdateStreamSquareForm(id, emptySet(), set)
        }

        fun setForeignData(f: String) : UpdateStreamSquareForm {
            val set = mapOf(EditableFields.FOREIGN_DATA to f)
            return UpdateStreamSquareForm(id, emptySet(), set)
        }
    }

    fun removeDescription() : UpdateStreamSquareForm {
        val remove = this.remove + setOf(RemovableFields.DESCRIPTION)
        return UpdateStreamSquareForm(id, remove, emptyMap())
    }

    fun removeForeignData() : UpdateStreamSquareForm {
        val remove = this.remove + setOf(RemovableFields.FOREIGN_DATA)
        return UpdateStreamSquareForm(id, remove, emptyMap())
    }

    fun setIsElastic(i: Boolean) : UpdateStreamSquareForm {
        val newSet = this.set + mapOf(EditableFields.IS_ELASTIC to i)
        return UpdateStreamSquareForm(id, remove, newSet)
    }

    fun setIsElasticWithNullable(i: Boolean?) : UpdateStreamSquareForm {
        return if(i == null) this
               else setIsElastic(i)
    }

    fun setSize(s: StreamSquare.Size) : UpdateStreamSquareForm {
        val newSet = this.set + mapOf(EditableFields.SIZE to s)
        return UpdateStreamSquareForm(id, remove, newSet)
    }

    fun setSizeWithNullable(s: StreamSquare.Size?) : UpdateStreamSquareForm {
        return if(s == null) this
               else setSize(s)
    }

    fun setHook(h: Hook) : UpdateStreamSquareForm {
        val newSet = this.set + mapOf(EditableFields.HOOK to h)
        return UpdateStreamSquareForm(id, remove, newSet)
    }

    fun setHookWithNullable(h: Hook?) : UpdateStreamSquareForm {
        return if(h == null) this
               else setHook(h)
    }

    fun setDescription(d: String) : UpdateStreamSquareForm {
        val newSet = this.set + mapOf(EditableFields.DESCRIPTION to d)
        return UpdateStreamSquareForm(id, remove, newSet)
    }

    fun setDescriptionWithNullable(d: String?) : UpdateStreamSquareForm {
        return if(d == null) this
               else setDescription(d)
    }

    fun setForeignData(f: String) : UpdateStreamSquareForm {
        val newSet = this.set + mapOf(EditableFields.FOREIGN_DATA to f)
        return UpdateStreamSquareForm(id, remove, newSet)
    }

    fun setForeignDataWithNullable(f: String?) : UpdateStreamSquareForm {
        return if(f == null) this
               else setForeignData(f)
    }

    enum class RemovableFields {
        DESCRIPTION {
            override fun toString() : String {
                return "description"
            }
        },
        FOREIGN_DATA {
            override fun toString() : String {
                return "foreignData"
            }
        }
    }

    enum class EditableFields {
        IS_ELASTIC {
            override fun toString() : String {
                return "isElastic"
            }
        },
        SIZE {
            override fun toString() : String {
                return "size"
            }
        },
        HOOK {
            override fun toString() : String {
                return "hook"
            }
        },
        DESCRIPTION {
            override fun toString() : String {
                return "description"
            }
        },
        FOREIGN_DATA {
            override fun toString() : String {
                return "foreignData"
            }
        }
    }

    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }

    override fun equals(other: Any?) : Boolean {
        if (this === other) return true
        if (other !is UpdateStreamSquareForm) return false
        return Objects.equals(id, other.id) &&
               Objects.equals(remove, other.remove) &&
               Objects.equals(set, other.set)
    }

    override fun hashCode() : Int {
        return Objects.hash(id, remove, set)
    }

    override fun toString() : String {
        return "UpdateStreamSquareForm(id=" + id +
                                      ", remove=" + remove +
                                      ", set=" + set + ')'
    }

    companion object {
    fun toJson() : String {
        return Utils.Js.toJson(this)
    }

    fun toJsonNode() : JsonNode {
        return Utils.Js.toJsonNode(this)
    }
    }
}