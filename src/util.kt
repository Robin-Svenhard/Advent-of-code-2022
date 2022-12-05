import java.io.File
import kotlin.math.min

fun readFile(filePath: String): List<String> {
    val input = readFileAsLinesUsingUseLines(filePath)
    return input
}
fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines {
    it.toList()
}

fun charToInt(c: Char): Int {
    val minorChars = CharRange('a', 'z').toList()
    val majorChars = CharRange('A', 'Z').toList()
    if(minorChars.contains(c)){
        return minorChars.indexOf(c) + 1
    } else {
        return majorChars.indexOf(c) + minorChars.size + 1
    }
}