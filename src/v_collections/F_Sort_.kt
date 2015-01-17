package v_collections

fun example5() {
    val result = listOf("a", "bbb", "cc").sortBy { it.length() }

    result == listOf("a", "cc", "bbb")
}

fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortBy { it.orders.size() }
