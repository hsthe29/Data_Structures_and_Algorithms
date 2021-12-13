package DSA

val arr = intArrayOf(0, 3, 2, 5, 7, 1, 6, 8, 9, 4)

tailrec fun heapyfy(i : Int, n : Int){
    val l = i shl 1
    val r = i shl 1 or 1
    var m = i
    if (l <= n && arr[l] > arr[m])
        m = l
    if (r <= n && arr[r] > arr[m])
        m = r
    arr[m] = arr[i].also { arr[i] = arr[m] }
    if (m != i)
        heapyfy(m, n)
}

fun heapSort(n : Int){
    for (i in (n / 2) downTo 1)
        heapyfy(i, n)
    for (i in n downTo 1){
        arr[1] = arr[i].also { arr[i] = arr[1] }
        heapyfy(1, i - 1)
    }
}

fun main(){
    val n = arr.size - 1
    heapSort(n)
    println(arr.slice(1..n))
}