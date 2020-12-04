fun day02(input: List<String>): Int {
    var numberOfSuccess = 0
    for (i in input) {
        val args = i.split(" ")
        val minMax = args[0].split("-")
        val min = minMax[0].toInt()
        val max = minMax[1].toInt()
        val key = args[1][0]
        val password = args[2]

        val count = countOccurrences(password, key)

        if (count >= min && count <= max) {
            numberOfSuccess++
        }
    }
    return numberOfSuccess
}

fun countOccurrences(s: String, ch: Char): Int {
    return s.filter { it == ch }.count()
}

fun day02b(input: List<String>): Int {
    var numberOfSuccess = 0
    for (i in input) {
        val args = i.split(" ")
        val minMax = args[0].split("-")
        val min = minMax[0].toInt()
        val max = minMax[1].toInt()
        val key = args[1][0]
        val password = args[2]

        if (countIndexedOccurrences(password, key, min - 1, max - 1)) {
            numberOfSuccess++
        }
    }
    return numberOfSuccess
}

fun countIndexedOccurrences(s: String, ch: Char, pos1: Int, pos2: Int): Boolean {
    val positionOneMatch = s[pos1].equals(ch)
    var positionTwoMatch = false
    if (pos2 <= s.length) {
        positionTwoMatch = s[pos2].equals(ch)
    }
    return (positionOneMatch.xor(positionTwoMatch))
}