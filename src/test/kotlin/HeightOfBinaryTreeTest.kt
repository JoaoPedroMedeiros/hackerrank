import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HeightOfBinaryTreeTest {

    @Test
    fun `test case 0`() {
        val root = nodeWith(listOf(3, 5, 2, 1, 4, 6, 7))
        assertEquals(3, root.calculateHeight())
        assertEquals(3, root.heightInMemory())
    }

    @Test
    fun `test case 1`() {
        val root = nodeWith(listOf(3, 1, 7, 5, 4))
        assertEquals(3, root.calculateHeight())
        assertEquals(3, root.heightInMemory())
    }

    @Test
    fun `test case 2`() {
        val root = nodeWith(listOf(15))
        assertEquals(0, root.calculateHeight())
        assertEquals(0, root.heightInMemory())
    }

    @Test
    fun `test case 3`() {
        val root = nodeWith(listOf(1, 15))
        assertEquals(1, root.calculateHeight())
        assertEquals(1, root.heightInMemory())
    }

    @Test
    fun `teste case 4`() {
        val root = nodeWith(listOf(1, 3, 2, 5, 4, 6, 7, 9, 8, 11, 13, 12, 10, 15, 14))
        assertEquals(9, root.calculateHeight())
        assertEquals(9, root.heightInMemory())
    }

    @Test
    fun `teste case 5`() {
        val root = nodeWith(listOf(4, 1, 8, 10, 9, 3))
        assertEquals(3, root.calculateHeight())
        assertEquals(3, root.heightInMemory())
    }

    @Test
    fun `teste case 6`() {
        val root = nodeWith(listOf(10))
        assertEquals(0, root.calculateHeight())
        assertEquals(0, root.heightInMemory())
    }

    private fun nodeWith(values: List<Int>): Node {
        var root: Node? = null
        values.forEach {
            root = insert(root, it)
        }
        return root!!
    }
}
