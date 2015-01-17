package iii_properties

import util.TODO

class once<T>(val func: () -> T) {
    var value: T? = null

    fun invoke(): T {
        if (value == null) {
            value = func()
        }
        return value!!
    }
}

class LazyProperty(initializer: () -> Int) {
    val initializer = once(initializer)
    val lazy: Int
        get() = initializer()
}

fun todoTask19() = TODO(
        """
        Task 19.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by 'initializer()' invocation
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use Delegates ;).
    """,
        references = { LazyProperty({ 42 }).lazy }
)
