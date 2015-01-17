package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    fun compareTo(date: MyDate): Int {
        val yearDiff = year - date.year
        if (yearDiff != 0) {
            return yearDiff
        }
        val month = month - date.month
        if (month != 0) {
            return month
        }
        return dayOfMonth - date.dayOfMonth
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

class DateRange(public val start: MyDate, public val end: MyDate)
