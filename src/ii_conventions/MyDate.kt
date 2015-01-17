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

    fun plus(interval: TimeInterval): MyDate {
        return plus(Pair(interval, 1))
    }

    fun plus(times: Pair<TimeInterval, Int>): MyDate {
        return addTimeIntervals(times.first, times.second)
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR

    fun times(i: Int): Pair<TimeInterval, Int> {
        return Pair(this, i)
    }
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

    fun contains(date: MyDate): Boolean {
        return date >= start && date <= end
    }
}
