package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class WeatherWindData(
        @SerializedName("speed") val windSpeed: String = "",
        @SerializedName("deg") val windDegrees: Double = 0.0
)