package kr.skylightqp.sweetbot.utils

enum class CityName(val cityKR: String) {
    SEOUL("서울"), INCHEON("인천"), BUSAN("부산"), CHEONGJU("청주"),
    CHUNCHEON("춘천"), DAEJEON("대전"), DAEGU("대구"), JEONJU("전주"), GWANGJU("광주"),
    JEJU("제주");

    companion object {
        fun getValueByName(cityKR: String) = values().find { it.cityKR == cityKR }
    }
}