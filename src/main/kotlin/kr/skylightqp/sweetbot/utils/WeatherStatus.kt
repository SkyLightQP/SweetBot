package kr.skylightqp.sweetbot.utils

enum class WeatherStatus(val krName: String) {
    HAZE(":foggy: 안개"), RAIN(":umbrella: 비"), SNOW(":snowflake: 눈"), CLOUDS(":cloud: 흐림"), CLEAR(":sunny: 맑음"), MIST(":foggy: 안개");

    override fun toString(): String {
        return krName
    }
}