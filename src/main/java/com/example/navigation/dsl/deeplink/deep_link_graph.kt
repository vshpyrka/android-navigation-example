package com.example.navigation.dsl.deeplink

object deep_link_graph {

    var id_counter = 1

    val id = id_counter++

    object dest {
        val destination_fragment_one = id_counter++
        val destination_fragment_two = id_counter++
    }

    object args {
        const val arg1 = "id"
        const val arg2 = "status"
    }
}
