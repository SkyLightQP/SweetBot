package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class WeatherStatusData(
        @SerializedName("main") val main: String = ""
)