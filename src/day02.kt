
fun main(){
    day02AssignmentA()
    day02AssignmentB()
}

fun day02AssignmentA() {
    // X = 1, Y = 2, Z = 3, loss 0, draw 3, win 6
    val pairs = mapOf(
        "A X" to 4, 
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6)
    val input = readFile("src/input/day02.txt")
    var sum = 0
    for(line in input) {
        sum += pairs[line]!!
    }

    println("------------- day 2: b --------------")
    println("Highest calorie count: $sum")
}

fun day02AssignmentB() {
    // X = 0, Y = 3, Z = 6
    val pairs = mapOf(
        "A X" to 3,
        "A Y" to 4,
        "A Z" to 8,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 2,
        "C Y" to 6,
        "C Z" to 7)
    val input = readFile("src/input/day02.txt")
    var sum = 0
    for(line in input) {
        sum += pairs[line]!!
    }
    println("------------- day 2: a --------------")
    println("Highest calorie count: $sum")
}