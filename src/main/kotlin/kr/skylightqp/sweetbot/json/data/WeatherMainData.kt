package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class WeatherMainData(
        @SerializedName("temp") val temperature: String = "",
        @SerializedName("humidity") val humidity: String = ""
)