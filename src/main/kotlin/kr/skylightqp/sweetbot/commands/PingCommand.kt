package kr.skylightqp.sweetbot.commands

import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color

class PingCommand : ICommand {

    override var name: String = "핑"
    override var alias: Array<String> = arrayOf("ping")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.channel

        val eb = EmbedBuilder()
                .setColor(Color(46, 204, 113))
                .setTitle("Ping? Pong!")
                .setDescription("Pong!")

        channel.sendMessage(eb.build()).queue()
    }
}