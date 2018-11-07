package kr.skylightqp.sweetbot.commands

import kr.skylightqp.sweetbot.Version
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color


class BotInfoCommand : ICommand {
    override var name: String = "정보"
    override var alias: Array<String> = arrayOf("info")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.channel

        val eb = EmbedBuilder()
                .setTitle("달콤한 봇")
                .setDescription("각종 기능들이 추가된 달콤한 봇을 디스코드에서 써보세요!")
                .addBlankField(false)
                .addField("제작자","하늘빛QP(SkyLightQP)",true)
                .addField("봇 버전", Version.VERSION, true)
                .addField("봇 홈페이지","https://foo.bar",false)
                .addField("GitHub","https://github.com/SkyLightQP/SweetBot",false)
                .setColor(Color(243, 156, 18))

        channel.sendMessage(eb.build()).queue()
    }
}