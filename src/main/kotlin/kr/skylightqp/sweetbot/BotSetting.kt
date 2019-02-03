package kr.skylightqp.sweetbot

import com.google.gson.Gson
import com.google.gson.JsonObject
import kr.skylightqp.sweetbot.utils.Logger
import kr.skylightqp.sweetbot.json.data.BotSettingData
import java.io.File

class BotSetting {
    val gson = Gson()

    companion object {
        lateinit var data: BotSettingData
    }

    val file = File("config.json")

    fun load() {
        if (!file.exists()) {
            file.createNewFile()

            val jsonObject = JsonObject()
            jsonObject.addProperty("token", "")
            jsonObject.addProperty("weather_api_key", "")
            jsonObject.addProperty("naver_api_client", "")
            jsonObject.addProperty("naver_api_secret", "")
            jsonObject.addProperty("wolframalpha_api_key", "")

            val buffer = file.bufferedWriter()
            buffer.write(gson.toJson(jsonObject))
            buffer.close()

            Logger.info("Created config.json file.")
            Logger.info("Bot has been terminated. Please enter the token and restart.")
            System.exit(0);
        }

        data = gson.fromJson(file.reader(), BotSettingData().javaClass)
        Logger.info("config.json was loaded successfully.")
    }
}