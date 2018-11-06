package kr.skylightqp.sweetbot

import kr.skylightqp.sweetbot.json.BotAccount
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>) {
    val botAcccount = BotAccount()

    botAcccount.load()

    val jda = JDABuilder(botAcccount.botAccountGson.discordToken).build()
    jda.addEventListener(MessageListener())
}
