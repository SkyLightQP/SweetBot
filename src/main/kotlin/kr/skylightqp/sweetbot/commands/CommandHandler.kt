package kr.skylightqp.sweetbot.commands

class CommandHandler{
    val COMMAND_PREFIX: String = "~"

    companion object {
        private val commands = mutableMapOf<String, ICommand>()
    }

    fun addCommand(command: ICommand) {
        commands.put(command.name, command)
        for (cmd in command.alias) {
            commands.put(cmd, command)
        }
    }

    fun get(alias: String) = commands.get(alias)
}