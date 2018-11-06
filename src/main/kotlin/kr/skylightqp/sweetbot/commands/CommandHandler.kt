package kr.skylightqp.sweetbot.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class CommandHandler : ListenerAdapter() {
    val COMMAND_PREFIX: String = "~"

    companion object {
        private val commands = mutableMapOf<String, ICommand>()
    }

    fun addCommand(command: ICommand) {
        commands.put(command.name, command)
        for(cmd in command.alias){
            commands.put(cmd, command)
        }
    }

    fun get(alias: String) = commands.get(alias)

    fun test() = commands
}