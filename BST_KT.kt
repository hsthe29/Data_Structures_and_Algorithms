package DSA

data class Node<T : Comparable<T>> (var value: T, var left: Node<T>? = null, var right : Node<T>? = null)

class BinaryTree<T : Comparable<T>> {
    private var root : Node<T>? = null


    fun addAll(vararg args : T){
        for(v in args)
            add(v)
    }
    // add element into bst
    fun add(v : T) {
        if (root == null) {
            root = Node(v)
        }
        else {
            var temp = root
            while (temp != null) {
                if (v == temp.value)
                    return
                if (v > temp.value){
                    if (temp.right != null)
                        temp = temp.right
                    else
                        temp.right = Node(v)
                }
                else {
                    if (temp.left != null)
                        temp = temp.left
                    else
                        temp.left = Node(v)
                }
            }
        }
    }

    fun find(v : T) : Node<T>? {
        var temp = root
        while (temp != null){
            if (temp.value == v)
                return temp
            temp = if (v > temp.value) temp.right else temp.left
        }
        return null
    }

    // overloading 'in' keyword

    operator fun contains(v : T) = find(v) != null

    fun isEmpty() = root == null

    // traversal

    fun preOrder() {
        fun preOrder(t : Node<T>?) {
            if(t != null){
                print("${t.value} ")
                preOrder(t.left)
                preOrder(t.right)
            }
        }
        preOrder(root)
        println()
    }

    fun inOrder() {
        fun inOrder(t : Node<T>?) {
            if(t != null){
                inOrder(t.left)
                print("${t.value} ")
                inOrder(t.right)
            }
        }
        inOrder(root)
        println()
    }

    fun postOrder() {
        fun postOrder(t : Node<T>?) {
            if(t != null){
                postOrder(t.left)
                postOrder(t.right)
                print("${t.value} ")
            }
        }
        postOrder(root)
        println()
    }
}

fun main(){
    val obj = BinaryTree<Int>()

    println(obj.isEmpty())
    obj.addAll(19, 3, 5, 7, 1, 10, 20, 23, 25, 14, 21)
    println(obj.isEmpty())
    obj.preOrder()
    obj.inOrder()
    obj.postOrder()
    println("5 in bst?: ${5 in obj}")
    println("100 in bst? ${100 in obj}")
}