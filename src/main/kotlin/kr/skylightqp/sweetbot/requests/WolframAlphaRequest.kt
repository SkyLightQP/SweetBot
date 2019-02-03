package kr.skylightqp.sweetbot.requests

import kr.skylightqp.sweetbot.BotSetting
import kr.skylightqp.sweetbot.utils.HttpRequest
import kr.skylightqp.sweetbot.utils.Logger

class WolframAlphaRequest {
    fun calc(text: String): String {
        val wolfapi = BotSetting.data.wolframalphaApiKey

        val url = "http://api.wolframalpha.com/v1/result"
        val res = HttpRequest.get(url, mapOf("appid" to wolfapi, "i" to text))

        return res.text
    }
}