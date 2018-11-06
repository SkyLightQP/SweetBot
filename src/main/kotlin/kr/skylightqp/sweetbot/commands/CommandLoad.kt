package kr.skylightqp.sweetbot.commands

class CommandLoad {
    val handler = CommandHandler()

    constructor(){
        handler.addCommand(BotInfoCommand())
    }
}