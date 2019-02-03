package kr.skylightqp.sweetbot.requests


import kr.skylightqp.sweetbot.BotSetting
import kr.skylightqp.sweetbot.utils.CityName
import kr.skylightqp.sweetbot.utils.HttpRequest

class WeatherRequest {
    fun getLocalWeather(cityName: CityName): String {
        val api = BotSetting.data.weatherApiKey
        val url = "http://api.openweathermap.org/data/2.5/weather"
        val response = HttpRequest.get(url, mapOf("appid" to api, "q" to "$cityName,KR"));

        return response.text
    }
}