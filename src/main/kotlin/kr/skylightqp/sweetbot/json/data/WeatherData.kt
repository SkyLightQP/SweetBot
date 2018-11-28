package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class WeatherData(
        @SerializedName("main") val main: WeatherMainData = WeatherMainData(),
        @SerializedName("wind") val wind: WeatherWindData = WeatherWindData()
)