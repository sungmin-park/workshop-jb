package v_collections

fun example9() {
    val product = listOf(1, 2, 3, 4).fold(1, { partProduct, element -> element * partProduct })
    product == 24
}

// The same as
fun whatFoldDoes(): Int {
    var product = 1
    listOf(1, 2, 3, 4).forEach { element -> product = element * product }
    return product
}

fun Shop.getProductsOrderedByAllCustomers(): Set<Product> {
    // Return set of products ordered by every customer
    return customers.fold(allOrderedProducts, {
        orderedByAll, customer -> orderedByAll.filter({ it in customer.orderedProducts }).toSet()
    })
}
