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

    fun rangeTo(secondDate: MyDate): DateRange {
        return DateRange(this, secondDate)
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

class DateRangeIterator(val range: DateRange) : Iterator<MyDate> {
    var current: MyDate = range.start
    override fun next(): MyDate {
        try {
            return current
        }
        finally {
            current = current.nextDay()
        }
    }

    override fun hasNext(): Boolean {
        return current <= range.end
    }
}

class DateRange(public val start: MyDate, public val end: MyDate) {
    fun iterator(): Iterator<MyDate> = DateRangeIterator(this)
}
