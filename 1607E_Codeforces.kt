// https://codeforces.com/problemset/problem/1607/E

fun main(){
    repeat(readLine()!!.toInt()){
        val (n, m) = readLine()!!.split(" ").map{it.toInt()}
        val s = readLine()!!
        val target = object {
            var i = 0
            var j = 0
        }
        val board = object {
            var l = 0; var d = 0; var u = 0; var r = 0
        }
        for(k in s){
            when(k){
                'L' -> {
                    target.j--
                    if(target.j < board.l)
                        board.l--
                }
                'R' -> {
                    target.j++
                    if(target.j > board.r)
                        board.r++
                }
                'U' -> {
                    target.i--
                    if(target.i < board.u)
                        board.u--
                }
                'D' -> {
                    target.i++
                    if(target.i > board.d)
                        board.d++
                }
            }
            if(board.r - board.l + 1 > m || board.d - board.u + 1> n)
                break
        }
        val width = board.r - board.l + 1
        val depth = board.d - board.u + 1
        if(width > m && target.j < 0)
            board.l++
        if(depth > n && target.i < 0)
            board.u++
        println("${1 - board.u} ${1 - board.l}")
    }
}