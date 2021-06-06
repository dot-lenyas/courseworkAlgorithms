package Model

interface SearchAlgorithm {
     var name: String

     fun Searching(pat: String, txt: String, q: Int)

}