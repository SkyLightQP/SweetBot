package kr.skylightqp.sweetbot.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

interface ICommand {
    var name: String
    var alias: Array<String>

    fun execute(args: List<String>, event: MessageReceivedEvent)
}
