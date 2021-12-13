val arr = intArrayOf(9, 8, 7,6 ,5 ,4, 3, 2 ,1)
val tmp = IntArray(arr.size){0}

fun merge(l : Int, r : Int){
    val m = (l + r) shr 1
    var i = l
    var j = m + 1
    for(k in l..r){
        if (i > m)
            tmp[k] = arr[j++]
        else if (j > r)
            tmp[k] = arr[i++]
        else {
            tmp[k] = if (arr[i] < arr[j])
                    arr[i++] else arr[j++]
        }
    }
    for(k in l..r)
        arr[k] = tmp[k]
}

fun mergeSort(l : Int, r : Int){
    if(l < r){
        val m = (l + r) shr 1
        mergeSort(l, m)
        mergeSort(m + 1, r)
        merge(l, r)
    }
}

fun main(){
    val n = arr.size
    mergeSort(0, n - 1)
    println(arr.contentToString())
}