package kr.skylightqp.sweetbot

import com.google.gson.Gson
import com.google.gson.JsonObject
import kr.skylightqp.sweetbot.utils.Logger
import kr.skylightqp.sweetbot.json.data.BotSettingData
import java.io.File

class BotSetting {
    val gson = Gson()
    companion object {
        lateinit var botSettingGson: BotSettingData
    }
    val file = File("BotSetting.json")

    fun load() {
        if (!file.exists()) {
            file.createNewFile()

            val jsonObject = JsonObject()
            jsonObject.addProperty("token", "")
            jsonObject.addProperty("weather_api_key", "")

            val buffer = file.bufferedWriter()
            buffer.write(gson.toJson(jsonObject))
            buffer.close()

            Logger.info("Created BotSetting.json file.")
            Logger.info("Bot has been terminated. Please enter the token and restart.")
            System.exit(0);
        }

        Logger.info("BotSetting.json was loaded successfully.")
        botSettingGson = gson.fromJson(file.reader(), BotSettingData().javaClass)
    }
}