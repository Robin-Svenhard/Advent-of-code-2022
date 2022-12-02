import java.io.File

fun readFile(filePath: String): List<String> {
    val input = readFileAsLinesUsingUseLines(filePath)
    return input
}
fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines {
    it.toList()
}