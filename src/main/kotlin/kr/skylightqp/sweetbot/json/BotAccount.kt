package kr.skylightqp.sweetbot.json

import com.google.gson.Gson
import com.google.gson.JsonObject
import kr.skylightqp.sweetbot.Logger
import kr.skylightqp.sweetbot.json.data.BotAccountData
import java.io.File

class BotAccount {
    val gson = Gson()
    lateinit var botAccountGson: BotAccountData
    val file = File("BotAccount.json")

    fun load() {
        if (!file.exists()) {
            file.createNewFile()

            val jsonObject = JsonObject()
            jsonObject.addProperty("token", "")

            val buffer = file.bufferedWriter()
            buffer.write(gson.toJson(jsonObject))
            buffer.close()

            Logger.info("Created BotAccount.json file.")
            Logger.info("Shutdown discord bot. Please enter the token, then start again.")
        }

        botAccountGson = gson.fromJson(file.reader(), BotAccountData().javaClass)
    }
}