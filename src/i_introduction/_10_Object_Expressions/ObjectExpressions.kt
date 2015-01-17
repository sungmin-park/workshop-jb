package i_introduction._10_Object_Expressions

import java.util.Comparator
import util.TODO
import java.io.File
import java.awt.event.MouseListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun objectLiteral() {

    abstract class Foo {
        abstract fun foo()
    }

    // Anonymous object extending a class
    val foo: Foo = object : Foo() {
        override fun foo() {
            // ...
        }
    }

    // Anonymous object extending a trait (interface)
    runInANewThread(object : Runnable {
        override fun run() {
            // ...
        }
    })
}

fun runInANewThread(runnable: Runnable) = Thread(runnable).start()

fun todoTask10() = TODO(
    """
        Task 10.
        Add an object expression that extends MouseAdapter and counts the number of mouse clicks
        as an argument to the function 'handleMouse()'.
    """
)

fun task10(handleMouse: (MouseListener) -> Unit): Int {
    var mouseClicks = 0
    handleMouse(object : MouseListener {
        override fun mouseClicked(e: MouseEvent) {
            mouseClicks++
        }

        override fun mousePressed(e: MouseEvent) {
            throw UnsupportedOperationException()
        }

        override fun mouseReleased(e: MouseEvent) {
            throw UnsupportedOperationException()
        }

        override fun mouseEntered(e: MouseEvent) {
            throw UnsupportedOperationException()
        }

        override fun mouseExited(e: MouseEvent) {
            throw UnsupportedOperationException()
        }
    })
    return mouseClicks
}