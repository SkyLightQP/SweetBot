package kr.skylightqp.sweetbot.utils

enum class WeatherStatus(val krName: String) {
    HAZE("안개"), RAIN("비"), SNOW("눈"), CLOUDS("흐림"), CLEAR("맑음");

    override fun toString(): String {
        return krName
    }
}