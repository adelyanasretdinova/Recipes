package com.example.recepies

sealed class Screen (val route:String) {
    object MainScreen : Screen("main_screen")
    object PdpScreen : Screen("pdp_screen")

    fun withArgs(vararg args:String):String {
        return buildString {
            append(route)
            args.forEach {
                append("/$args")
            }
        }
    }
}