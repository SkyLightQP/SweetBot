package kr.skylightqp.sweetbot.json.data

import com.google.gson.annotations.SerializedName

data class BotAccountData(
    @SerializedName("token") val discordToken: String = ""
)