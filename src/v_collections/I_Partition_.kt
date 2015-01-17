package v_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    //the details (how multi-assignment works) were explained in 'Conventions' task earlier
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Customer.hasMoreUndeliveredOrdersThanDelivered():Boolean {
    val (delivered, notDelivered) = orders.partition { it.isDelivered }
    return notDelivered.size() > delivered.size()
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    return customers.filter({ it.hasMoreUndeliveredOrdersThanDelivered() }).toSet()
}
