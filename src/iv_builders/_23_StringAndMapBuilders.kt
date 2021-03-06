package iv_builders

import util.TODO
import java.util.HashSet

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

fun buildStringExample(): String {
    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask23() = TODO(
    """
        Task 23.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
        Use MutableMap, look through syntax/javaCollections for details.
    """,
    references = { syntax.javaCollections.useMutableSet(HashSet())}
)

fun buildMap(function: MutableMap<Int, String>.() -> Unit):Map<Int, String> {
    val map = hashMapOf<Int, String>()
    with(map, function)
    return map
}

fun task23(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}