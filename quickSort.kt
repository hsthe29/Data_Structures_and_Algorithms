val arr_qs = intArrayOf(9, 8, 7,6 ,5 ,4, 3, 2 ,1)

fun partition(l : Int, r : Int, m : Int) : Int {
    val pivot = arr_qs[m]
    arr_qs[r] = arr_qs[m].also { arr_qs[m] = arr_qs[r] } // swap(arr[r], arr[m])
    var index = l
    for(k in l until r){
        if (arr_qs[k] < pivot) {
            arr_qs[index] = arr_qs[k].also { arr_qs[k] = arr_qs[index] }
            index++
        }
    }
    arr_qs[index] = arr_qs[r].also { arr_qs[r] = arr_qs[index] }
    return index
}

fun quickSort(l : Int, r : Int){
    if (l < r){
        val m = partition(l, r, (l + r) shr 1)
        if (l < m)
            quickSort(l, m - 1)
        if (m < r)
            quickSort(m + 1, r)
    }
}

fun main(){
    val n = arr_qs.size
    quickSort(0, n - 1)
    println(arr_qs.contentToString())
}