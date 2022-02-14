fun main(){
    val value = 122
    val valueAgoToText = agoToText(value)
    println("был(а) в сети $valueAgoToText")
}

fun agoToText (second:Int):String {
    return when {
        second in 0..60 ->  "только что"
        second in 61..3599 ->  minutesToText(second)
        second in 3600..86399 ->  hoursToText(second)
        second in 86400..172800 -> "сегодня"
        second in 172801..259200 -> "вчера"
        second >= 259201 -> "давно"
        else -> "Невозможно определить"
    }
}

fun minutesToText(second: Int):String{
    val minutes = second / 60
    val minutesText = minutesAgoToText(minutes)
    return ("$minutes $minutesText назад")
}

fun hoursToText(second: Int):String{
    val hours = second / 3600
    val hoursText = hoursAgoToText(hours)
    return("$hours $hoursText назад")
}

fun minutesAgoToText(minutes:Int):String {
    val minutesAgo = minutes % 10
    return when {
        minutesAgo == 1 && minutes != 11 -> "минуту"
        minutesAgo in 2..4 -> "минуты"
        else -> "минут"
    }
}
    fun hoursAgoToText(hour: Int): String {
        val hoursAgo = hour % 10
        return when {
            hoursAgo == 1 && hour != 11 -> "час"
            hoursAgo in 2..4 -> "часа"
            else -> "часов"
        }
    }

