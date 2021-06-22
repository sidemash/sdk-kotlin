package com.sidemash.sdk

data class CallException(val statusCode:Int,
                         val statusMessage:String,
                         val body:String) : Exception()