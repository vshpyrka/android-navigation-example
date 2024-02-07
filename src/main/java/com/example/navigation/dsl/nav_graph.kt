package com.example.navigation.dsl

object nav_graph {

    const val id = 1 // graph id

    const val nested_graph = 6 // nested graph id

    object dest {
        const val home = 2
        const val detail = 3
        const val activity = 5
        const val nested_graph_fragment_one = 7
        const val nested_graph_fragment_two = 8
    }

    object action {
        const val to_detail = 4
        const val to_nested_two = 9
    }

    object args {
        const val id = "plantId"
    }
}
