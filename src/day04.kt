import java.lang.StringBuilder

class Passport(val fields: Map<String, String>)

fun day04(input: List<String>): Int {

    var passportTemplate = StringBuilder()
    val passports: MutableList<Passport> = mutableListOf()

    for (s in input) {
        if (s.length == 0) {
            //create passport and reset template
            passports.add(createPassport(passportTemplate))
            passportTemplate = StringBuilder()
        } else {
            passportTemplate.append(s + " ")
        }
    }
    passports.add(createPassport(passportTemplate))
    return validatePassports(passports)
}

fun validatePassports(passports: List<Passport>): Int {
    var count = 0
    for (passport in passports){
        val fields = passport.fields
        if(fields.count() >= 7){
            if(fields.count() == 8 || !fields.containsKey("cid")){
                count++
            }
        }
    }
    return count
}

fun createPassport(template: StringBuilder): Passport {
    val passport: MutableMap<String, String> = mutableMapOf()
    val templateString = template.toString()
    val fields = templateString.split(" ")
    for (f in fields) {
        if (f.length != 0) {
            val field = f.split(":")
            passport.put(field[0], field[1])
        }
    }
    println(passport)
    return Passport(passport)
}

