
fun main(){
    day03AssignmentA()
    day03AssignmentB()
}

fun day03AssignmentA() {
    val input = readFile("src/input/day03.txt")
    var sum = 0
    for (line in input){
        val lastHalf = line.substring(line.length / 2)
        val firstHalf = line.replaceFirst(lastHalf, "")
        val match = firstHalf.asSequence().filter { c -> lastHalf.contains(c) }.first()
        println("match: " + match)
        sum += charToInt(match)
        println("sum: " + sum)
        println("charToInt: " + charToInt(match))
    }
    
    println("------------- day 3: a --------------")
    println("Sum of priorities: $sum")
}

fun day03AssignmentB() {
    val input = readFile("src/input/day03.txt")
    var sum = 0


    val groups = input.withIndex()
        .groupBy { it.index / 3 }
        .map { it.value.map { it.value } }
  
    for(group in groups){
        val badge = group[0].asSequence().filter { c -> group[1].contains(c) && group[2].contains(c) }.first()
        sum += charToInt(badge)
    }

    println("------------- day 3: b --------------")
    println("Sum of priorities: $sum")
}