package kr.skylightqp.sweetbot.requests


import kr.skylightqp.sweetbot.json.BotSetting
import kr.skylightqp.sweetbot.utils.CityName
import java.net.URL

class WeatherRequest {
    fun getLocalWeather(cityName: CityName): String{
        val botSetting = BotSetting()
        val api = BotSetting.botSettingGson.weatherApiKey
        val url = "http://api.openweathermap.org/data/2.5/weather?appid=$api&q=$cityName"
        val response = URL(url)
                .openStream()
                .bufferedReader()
                .use { it.readText() }

        return response
    }
}