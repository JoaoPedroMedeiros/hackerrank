/**
 * This method calculate the height from node to the end of the binary tree
 */
fun Node.calculateHeight(): Int {
    if (left == null && right == null) return 0
    val leftHeight = left?.calculateHeight() ?: -1
    val rightHeight = right?.calculateHeight() ?: -1
    val highestHeight = if (leftHeight > rightHeight) leftHeight else rightHeight
    return highestHeight + 1
}

/**
 * This method is more performatic than other because use the height value in memory
 */
fun Node.heightInMemory(): Int {
    return height
}

class Node(
    val data: Int,
    var height: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun insert(root: Node?, data: Int): Node =
    root?.also {
        if (data <= root.data) {
            root.left = insert(root.left, data)
            root.left!!.apply { height += 1 }
        } else {
            root.right = insert(root.right, data)
            root.right!!.apply { height += 1 }
        }
        root.apply { height = root.highestHeight() }
    } ?: Node(data, 0)

fun Node.highestHeight(): Int {
    val leftHeight = left?.height ?: -1
    val rightHeight = right?.height ?: -1
    return if (leftHeight > rightHeight) leftHeight else rightHeight
}

