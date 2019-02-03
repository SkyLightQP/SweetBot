package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class BotSettingData(
        @SerializedName("token") val discordToken: String = "",
        @SerializedName("weather_api_key") val weatherApiKey: String = "",
        @SerializedName("naver_api_client") val naverApiClient: String = "",
        @SerializedName("naver_api_secret") val naverApiSecret: String = "",
        @SerializedName("wolframalpha_api_key") val wolframalphaApiKey: String = ""
)