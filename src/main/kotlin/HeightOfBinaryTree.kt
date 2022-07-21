// Hackerrank exercise
// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

/**
 * This method calculate the height from node to the end of the binary tree in all directions.
 * It don't have so good performance because the big O is o(n²)
 */
fun Node.calculateHeight(): Int {
    if (left == null && right == null) return 0
    val leftHeight = left?.calculateHeight() ?: -1
    val rightHeight = right?.calculateHeight() ?: -1
    val highestHeight = if (leftHeight > rightHeight) leftHeight else rightHeight
    return highestHeight + 1
}

/**
 * Here, we use a little more space to store an variable height in memory on each node but in another way there is
 * no computing cost to get height.
 */
fun Node.heightInMemory(): Int = height

fun Node?.insert(newData: Int): Node {
    if (this == null) return Node(newData, 0)

    val newLeft = if (newData <= data) left.insert(newData) else left
    val newRight = if (newData > data) right.insert(newData) else right

    return copy(
        left = newLeft,
        right = newRight,
        height = highestHeight(newLeft, newRight) + 1
    )
}

private fun highestHeight(left: Node?, right: Node?): Int {
    val leftHeight = left?.height ?: -1
    val rightHeight = right?.height ?: -1
    return if (leftHeight > rightHeight) leftHeight else rightHeight
}

data class Node(
    val data: Int,
    val height: Int,
    val left: Node? = null,
    val right: Node? = null
)
