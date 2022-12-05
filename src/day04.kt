
fun main(){
    day04AssignmentA()
    day04AssignmentB()
}

fun day04AssignmentA() {
    val input = readFile("src/input/day04.txt")
    var sum = 0
    for (line in input){
        val splitPair = line.split(',')
        val rangeLimits = splitPair.get(0).split('-')
        val firstRange = IntRange(rangeLimits.get(0).toInt(), rangeLimits.get(1).toInt()).toList()
        val secondRangeLimits = splitPair.get(1).split('-')
        val secondRange = IntRange(secondRangeLimits.get(0).toInt(), secondRangeLimits.get(1).toInt()).toList()
        
        if (firstRange.containsAll(secondRange) || secondRange.containsAll(firstRange)) {
            sum++
        }
    }

    
    println("------------- day 4: a --------------")
    println("Number of completely overlapped sections: $sum")
}

fun day04AssignmentB() {
    val input = readFile("src/input/day04.txt")
    var sum = 0

    for (line in input){
        val splitPair = line.split(',')
        val rangeLimits = splitPair.get(0).split('-')
        val firstRange = IntRange(rangeLimits.get(0).toInt(), rangeLimits.get(1).toInt()).toList()
        val secondRangeLimits = splitPair.get(1).split('-')
        val secondRange = IntRange(secondRangeLimits.get(0).toInt(), secondRangeLimits.get(1).toInt()).toList()

        if(!firstRange.intersect(secondRange).isEmpty()){
            sum++
        }
    }

    println("------------- day 4: b --------------")
    println("Number of overlapped sections: $sum")
}