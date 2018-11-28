package kr.skylightqp.sweetbot.commands

import kr.skylightqp.sweetbot.Version
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color

class HelpCommand : ICommand {
    override var name: String = "도움말"
    override var alias: Array<String> = arrayOf("help", "h")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.channel

        val eb = EmbedBuilder()
                .setTitle("달콤한 봇 - 명령어 도움말")
                .setDescription("~정보 ~info \n" +
                        "~핑 ~ping \n" +
                        "~도움말 ~help ~h \n" +
                        "~날씨 ~weather")
                .setColor(Color(243, 156, 18))

        channel.sendMessage(eb.build()).queue()
    }
}