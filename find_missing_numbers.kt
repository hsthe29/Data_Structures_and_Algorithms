import java.util.*
import kotlin.random.Random.Default.nextInt


fun main(){
    val arr = IntArray(99){nextInt(1, 100)}
    val n = 100
    findMissingNumber(arr, n)
}

fun findMissingNumber(arr : IntArray, n : Int){
    val bs = BitSet(n)
    for(i in arr)
        bs.set(i - 1)
    var index = 0;
    val m = n - arr.size
    for(i in 1..m){
        index = bs.nextClearBit(index)
        print("${++index} ")
    }


}