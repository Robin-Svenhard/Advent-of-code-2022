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
    for (passport in passports) {
        val fields = passport.fields
        if (fields.count() >= 7) {
            if (fields.count() == 8 || !fields.containsKey("cid")) {
                if (validateValues(fields))
                    count++
            }
        }
    }
    return count
}

fun validateValues(fields: Map<String, String>): Boolean {
    val byr = fields.get("byr")
    val iyr = fields.get("iyr")
    val eyr = fields.get("eyr")
    val hgt = fields.get("hgt")
    val hcl = fields.get("hcl")
    val ecl = fields.get("ecl")
    val pid = fields.get("pid")
    if (!validateRange(byr, 1920, 2002)) {
        return false
    } else if (!validateRange(iyr, 2010, 2020)) {
        return false
    } else if (!validateRange(eyr, 2020, 2030)) {
        return false
    } else if (!validateHgt(hgt)) {
        return false
    } else if (!validateHcl(hcl)) {
        return false
    } else if (!validateEcl(ecl)) {
        return false
    } else if (!validatePid(pid)) {
        return false
    }
    return true
}

fun validatePid(pid: String?): Boolean {
    val regex= Regex("^[0-9]{9}\$")
    if(pid!!.matches(regex)){
        return true
    }
    println(pid)
    return false
}

fun validateHcl(hcl: String?): Boolean {
    val regex= Regex("^#[0-9a-f]{6}\$")
    if(hcl!!.matches(regex)){
        return true
    }
    return false
}

fun validateEcl(ecl: String?): Boolean {
    val regex= Regex("amb|blu|brn|gry|grn|hzl|oth")
    if(ecl!!.matches(regex)){
        return true
    }
    return false
}

fun validateHgt(hgt: String?): Boolean {
    if (hgt != null) {
        if (hgt.contains("in")) {
            val hgtInches = hgt.split("i")
            if (validateRange(hgtInches[0], 59, 76)) {
                return true
            }
        } else if (hgt.contains("cm")) {
            val hgtCentimeters = hgt.split("c")
            if (validateRange(hgtCentimeters[0], 150, 193)) {
                return true
            }
        }
    }
    return false
}

fun validateRange(byr: String?, min: Int, max: Int): Boolean {
    val byrAsInt = byr?.toInt()
    if (byrAsInt != null) {
        if (byrAsInt <= max && byrAsInt >= min) {
            return true

        }
    }
    return false
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
    return Passport(passport)
}

