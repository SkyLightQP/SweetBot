package kr.skylightqp.sweetbot

import kr.skylightqp.sweetbot.commands.CommandLoad
import kr.skylightqp.sweetbot.listener.MessageListener
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>) {
    val botSetting = BotSetting()
    botSetting.load()

    CommandLoad()

    val jda = JDABuilder(BotSetting.botSettingGson.discordToken).build()
    jda.addEventListener(MessageListener())
}
