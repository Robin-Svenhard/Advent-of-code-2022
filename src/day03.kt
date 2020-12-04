fun day03(input: List<String>): Int {
    var result = 1



    result = result * calculateSlope(input, 1, 1)
    println(result)
    result = result * calculateSlope(input, 3, 1)
    println(result)
    result = result * calculateSlope(input, 5, 1)
    println(result)
    result = result * calculateSlope(input, 7, 1)
    println(result)
    result = result * calculateSlope(input, 1, 2)

    return result
}

private fun calculateSlope(input: List<String>, across: Int, down: Int): Int {
    var position = 0
    var count = 0
    input.forEachIndexed { index, row ->
        if (index % down == 0) {
            if (row[position].equals("#"[0])) {
                count++
            }
            position = (position + across) % row.length
        }
    }



    return count
}