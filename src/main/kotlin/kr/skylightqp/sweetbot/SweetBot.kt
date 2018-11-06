package kr.skylightqp.sweetbot

import kr.skylightqp.sweetbot.commands.CommandLoad
import kr.skylightqp.sweetbot.json.BotAccount
import kr.skylightqp.sweetbot.listener.MessageListener
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>) {
    val botAcccount = BotAccount()
    botAcccount.load()

    CommandLoad()

    val jda = JDABuilder(botAcccount.botAccountGson.discordToken).build()
    jda.addEventListener(MessageListener())
}
