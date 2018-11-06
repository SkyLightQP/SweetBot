package kr.skylightqp.sweetbot.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent


class BotInfoCommand : ICommand {
    override var name: String = "test"
    override var alias: Array<String> = arrayOf("t", "테스트")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.getChannel()
        channel.sendMessage("Pong!").queue()
    }
}