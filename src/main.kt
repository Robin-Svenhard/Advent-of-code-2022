import java.io.File

fun main() {
    println("Welcome to the advent of code!\n\n")
    //get input
    val input = readFileAsLinesUsingUseLines("C:\\DevStuff\\advent-of-code-2020\\src\\input.txt")

    //print ("Day 1 result: " + day01(input))
    //print ("Day 2 result: " + day02b(input))
    //print ("Day 3 result: " + day03(input))
    print ("Day 4 result: " + day04(input))
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines {
    it.toList()
}

fun day01(input: List<String>): Int {
    for (i in input){
        for (j in input)
            if (i.toInt() + j.toInt() == 2020)
                return i.toInt() * j.toInt()
    }
    return 0
}


