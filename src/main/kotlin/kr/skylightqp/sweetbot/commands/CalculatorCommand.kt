package kr.skylightqp.sweetbot.commands

import kr.skylightqp.sweetbot.requests.WolframAlphaRequest
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color

class CalculatorCommand : ICommand {
    override var name: String = "계산"
    override var alias: Array<String> = arrayOf("calc")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.channel

        val w = WolframAlphaRequest()
        val result = w.calc(args[1])

        val eb = EmbedBuilder()
                .setTitle("계산 결과")
                .setDescription(result)
                .setColor(Color(73, 148, 204))

        channel.sendMessage(eb.build()).queue()
    }
}