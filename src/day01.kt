
fun main(){
    assignmentA()
    assignmentB()
}

fun assignmentB() {
    val input = readFile("src/input/day01.txt")
    var current = 0
    var elves = mutableListOf<Int>()
    for(line in input) {
        if (line.equals("")) {
            elves.add(current)
            current = 0
        } else {
            current += Integer.parseInt(line)
        }
    }

    val sortedDescending = elves.sortedDescending()
    val sum = sortedDescending.get(0) + sortedDescending.get(1) + sortedDescending.get(2)
    println("------------- day 1: b --------------")
    println("Highest calorie count: $sum")
}

fun assignmentA() {
    val input = readFile("src/input/day01.txt")
    var max = 0
    var current = 0
    //TODO skapa lista och sortera
    for(line in input) {
        if (line.equals("")) {
            if (max < current) {
                max = current
            }
            current = 0
        } else {
            current += Integer.parseInt(line)
        }
    }
    //There is a bug where I will get the wrong output if the last Elf is carrying the most but I cba
    println("------------- day 1: a --------------")
    println("Highest calorie count: $max")
}