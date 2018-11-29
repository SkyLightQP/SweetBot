package kr.skylightqp.sweetbot.utils

enum class CityName(val cityKR: String) {
    SEOUL("서울"), INCHEON("인천"), BUSAN("부산"), CHEONGJU("청주");

    companion object {
        fun getValueByName(cityKR: String) = values().find { it.cityKR == cityKR }
    }
}