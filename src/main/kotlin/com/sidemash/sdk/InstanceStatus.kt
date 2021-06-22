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

sealed class InstanceStatus(val value: String) {
    object Initializing : InstanceStatus("Initializing")
    object Running : InstanceStatus("Running")
    object Restarting : InstanceStatus("Restarting")
    object Updating : InstanceStatus("Updating")
    object Maintaining : InstanceStatus("Maintaining")
    object PartiallyAvailable : InstanceStatus("PartiallyAvailable")
    object NotAvailable : InstanceStatus("NotAvailable")
    object Terminating : InstanceStatus("Terminating")
    object Terminated : InstanceStatus("Terminated")

    @JsonValue
    override fun toString() : String {
        return value
    }

    fun isValid() : Boolean {
        return isValid(this.value)
    }

    fun isNotInitializing() : Boolean {
        return isNotInitializing(this.value)
    }

    fun isNotRunning() : Boolean {
        return isNotRunning(this.value)
    }

    fun isNotRestarting() : Boolean {
        return isNotRestarting(this.value)
    }

    fun isNotUpdating() : Boolean {
        return isNotUpdating(this.value)
    }

    fun isNotMaintaining() : Boolean {
        return isNotMaintaining(this.value)
    }

    fun isNotPartiallyAvailable() : Boolean {
        return isNotPartiallyAvailable(this.value)
    }

    fun isNotNotAvailable() : Boolean {
        return isNotNotAvailable(this.value)
    }

    fun isNotTerminating() : Boolean {
        return isNotTerminating(this.value)
    }

    fun isNotTerminated() : Boolean {
        return isNotTerminated(this.value)
    }

    fun ifNotInitializing(fn: (InstanceStatus) -> Unit) {
        ifNotInitializing(this.value, fn)
    }

    fun ifNotRunning(fn: (InstanceStatus) -> Unit) {
        ifNotRunning(this.value, fn)
    }

    fun ifNotRestarting(fn: (InstanceStatus) -> Unit) {
        ifNotRestarting(this.value, fn)
    }

    fun ifNotUpdating(fn: (InstanceStatus) -> Unit) {
        ifNotUpdating(this.value, fn)
    }

    fun ifNotMaintaining(fn: (InstanceStatus) -> Unit) {
        ifNotMaintaining(this.value, fn)
    }

    fun ifNotPartiallyAvailable(fn: (InstanceStatus) -> Unit) {
        ifNotPartiallyAvailable(this.value, fn)
    }

    fun ifNotNotAvailable(fn: (InstanceStatus) -> Unit) {
        ifNotNotAvailable(this.value, fn)
    }

    fun ifNotTerminating(fn: (InstanceStatus) -> Unit) {
        ifNotTerminating(this.value, fn)
    }

    fun ifNotTerminated(fn: (InstanceStatus) -> Unit) {
        ifNotTerminated(this.value, fn)
    }

    fun isInitializing() : Boolean {
        return isInitializing(this.value)
    }

    fun isRunning() : Boolean {
        return isRunning(this.value)
    }

    fun isRestarting() : Boolean {
        return isRestarting(this.value)
    }

    fun isUpdating() : Boolean {
        return isUpdating(this.value)
    }

    fun isMaintaining() : Boolean {
        return isMaintaining(this.value)
    }

    fun isPartiallyAvailable() : Boolean {
        return isPartiallyAvailable(this.value)
    }

    fun isNotAvailable() : Boolean {
        return isNotAvailable(this.value)
    }

    fun isTerminating() : Boolean {
        return isTerminating(this.value)
    }

    fun isTerminated() : Boolean {
        return isTerminated(this.value)
    }

    fun asInitializingOrNull() : Initializing? {
         return asInitializingOrNull(this.value)
    }

    fun asRunningOrNull() : Running? {
         return asRunningOrNull(this.value)
    }

    fun asRestartingOrNull() : Restarting? {
         return asRestartingOrNull(this.value)
    }

    fun asUpdatingOrNull() : Updating? {
         return asUpdatingOrNull(this.value)
    }

    fun asMaintainingOrNull() : Maintaining? {
         return asMaintainingOrNull(this.value)
    }

    fun asPartiallyAvailableOrNull() : PartiallyAvailable? {
         return asPartiallyAvailableOrNull(this.value)
    }

    fun asNotAvailableOrNull() : NotAvailable? {
         return asNotAvailableOrNull(this.value)
    }

    fun asTerminatingOrNull() : Terminating? {
         return asTerminatingOrNull(this.value)
    }

    fun asTerminatedOrNull() : Terminated? {
         return asTerminatedOrNull(this.value)
    }

    fun ifInitializing(fn: (Initializing) -> Unit) {
        ifInitializing(this.value, fn)
    }

    fun ifRunning(fn: (Running) -> Unit) {
        ifRunning(this.value, fn)
    }

    fun ifRestarting(fn: (Restarting) -> Unit) {
        ifRestarting(this.value, fn)
    }

    fun ifUpdating(fn: (Updating) -> Unit) {
        ifUpdating(this.value, fn)
    }

    fun ifMaintaining(fn: (Maintaining) -> Unit) {
        ifMaintaining(this.value, fn)
    }

    fun ifPartiallyAvailable(fn: (PartiallyAvailable) -> Unit) {
        ifPartiallyAvailable(this.value, fn)
    }

    fun ifNotAvailable(fn: (NotAvailable) -> Unit) {
        ifNotAvailable(this.value, fn)
    }

    fun ifTerminating(fn: (Terminating) -> Unit) {
        ifTerminating(this.value, fn)
    }

    fun ifTerminated(fn: (Terminated) -> Unit) {
        ifTerminated(this.value, fn)
    }

    fun asOneOf(vararg selection: InstanceStatus) : InstanceStatus? {
        for (s in selection) {
            if(s.value == value) return s
        }
        return null
    }

    fun ifOneOf(vararg selection: InstanceStatus) : ((InstanceStatus) -> Unit) -> Unit {
        return InstanceStatus.ifOneOf(value, *selection)
    }

    fun ifNoneOf(vararg selection: InstanceStatus) : ((InstanceStatus) -> Unit) -> Unit {
        return InstanceStatus.ifNoneOf(value, *selection)
    }

    companion object {
        val AllPossiblesValues: Set<String> =
            setOf("Initializing",
                  "Running",
                  "Restarting",
                  "Updating",
                  "Maintaining",
                  "PartiallyAvailable",
                  "NotAvailable",
                  "Terminating",
                  "Terminated")

        fun asInitializingOrNull(value: String) : Initializing? {
             return if(isInitializing(value)) Initializing else null
        }

        fun asRunningOrNull(value: String) : Running? {
             return if(isRunning(value)) Running else null
        }

        fun asRestartingOrNull(value: String) : Restarting? {
             return if(isRestarting(value)) Restarting else null
        }

        fun asUpdatingOrNull(value: String) : Updating? {
             return if(isUpdating(value)) Updating else null
        }

        fun asMaintainingOrNull(value: String) : Maintaining? {
             return if(isMaintaining(value)) Maintaining else null
        }

        fun asPartiallyAvailableOrNull(value: String) : PartiallyAvailable? {
             return if(isPartiallyAvailable(value)) PartiallyAvailable else null
        }

        fun asNotAvailableOrNull(value: String) : NotAvailable? {
             return if(isNotAvailable(value)) NotAvailable else null
        }

        fun asTerminatingOrNull(value: String) : Terminating? {
             return if(isTerminating(value)) Terminating else null
        }

        fun asTerminatedOrNull(value: String) : Terminated? {
             return if(isTerminated(value)) Terminated else null
        }

        fun ifInitializing(value: String, fn: (Initializing) -> Unit) {
             if(isInitializing(value)) fn(Initializing)
        }

        fun ifRunning(value: String, fn: (Running) -> Unit) {
             if(isRunning(value)) fn(Running)
        }

        fun ifRestarting(value: String, fn: (Restarting) -> Unit) {
             if(isRestarting(value)) fn(Restarting)
        }

        fun ifUpdating(value: String, fn: (Updating) -> Unit) {
             if(isUpdating(value)) fn(Updating)
        }

        fun ifMaintaining(value: String, fn: (Maintaining) -> Unit) {
             if(isMaintaining(value)) fn(Maintaining)
        }

        fun ifPartiallyAvailable(value: String, fn: (PartiallyAvailable) -> Unit) {
             if(isPartiallyAvailable(value)) fn(PartiallyAvailable)
        }

        fun ifNotAvailable(value: String, fn: (NotAvailable) -> Unit) {
             if(isNotAvailable(value)) fn(NotAvailable)
        }

        fun ifTerminating(value: String, fn: (Terminating) -> Unit) {
             if(isTerminating(value)) fn(Terminating)
        }

        fun ifTerminated(value: String, fn: (Terminated) -> Unit) {
             if(isTerminated(value)) fn(Terminated)
        }

        fun asOneOf(value:String, vararg selection: InstanceStatus) : InstanceStatus? {
            for (s in selection) {
                if(s.value == value) return s
            }
            return null
        }

        fun ifOneOf(value: String, vararg selection: InstanceStatus) : ((InstanceStatus) -> Unit) -> Unit {
            for (s in selection) {
                if(s.value == value) return { fn -> fn(s) }
            }
            return {}
        }

        fun ifNoneOf(value: String, vararg selection: InstanceStatus) : ((InstanceStatus) -> Unit) -> Unit {
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

        fun isNotInitializing(value: String) : Boolean {
            return value != Initializing.value
        }

        fun isNotRunning(value: String) : Boolean {
            return value != Running.value
        }

        fun isNotRestarting(value: String) : Boolean {
            return value != Restarting.value
        }

        fun isNotUpdating(value: String) : Boolean {
            return value != Updating.value
        }

        fun isNotMaintaining(value: String) : Boolean {
            return value != Maintaining.value
        }

        fun isNotPartiallyAvailable(value: String) : Boolean {
            return value != PartiallyAvailable.value
        }

        fun isNotNotAvailable(value: String) : Boolean {
            return value != NotAvailable.value
        }

        fun isNotTerminating(value: String) : Boolean {
            return value != Terminating.value
        }

        fun isNotTerminated(value: String) : Boolean {
            return value != Terminated.value
        }

        fun ifNotInitializing(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotInitializing(value)) fn(Initializing)
        }

        fun ifNotRunning(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotRunning(value)) fn(Running)
        }

        fun ifNotRestarting(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotRestarting(value)) fn(Restarting)
        }

        fun ifNotUpdating(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotUpdating(value)) fn(Updating)
        }

        fun ifNotMaintaining(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotMaintaining(value)) fn(Maintaining)
        }

        fun ifNotPartiallyAvailable(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotPartiallyAvailable(value)) fn(PartiallyAvailable)
        }

        fun ifNotNotAvailable(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotNotAvailable(value)) fn(NotAvailable)
        }

        fun ifNotTerminating(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotTerminating(value)) fn(Terminating)
        }

        fun ifNotTerminated(value: String, fn: (InstanceStatus) -> Unit) {
             if(isNotTerminated(value)) fn(Terminated)
        }

        fun isInitializing(value: String) : Boolean {
            return value == Initializing.value
        }

        fun isRunning(value: String) : Boolean {
            return value == Running.value
        }

        fun isRestarting(value: String) : Boolean {
            return value == Restarting.value
        }

        fun isUpdating(value: String) : Boolean {
            return value == Updating.value
        }

        fun isMaintaining(value: String) : Boolean {
            return value == Maintaining.value
        }

        fun isPartiallyAvailable(value: String) : Boolean {
            return value == PartiallyAvailable.value
        }

        fun isNotAvailable(value: String) : Boolean {
            return value == NotAvailable.value
        }

        fun isTerminating(value: String) : Boolean {
            return value == Terminating.value
        }

        fun isTerminated(value: String) : Boolean {
            return value == Terminated.value
        }

        @JvmStatic
        @JsonCreator
        fun fromString(value: String) : InstanceStatus? {
            return when (value) {
                "Initializing" -> Initializing
                "Running" -> Running
                "Restarting" -> Restarting
                "Updating" -> Updating
                "Maintaining" -> Maintaining
                "PartiallyAvailable" -> PartiallyAvailable
                "NotAvailable" -> NotAvailable
                "Terminating" -> Terminating
                "Terminated" -> Terminated
                else -> null
            }
        }
    }
}