package kr.skylightqp.sweetbot.commands

class CommandLoad {
    val handler = CommandHandler()

    constructor(){
        handler.addCommand(BotInfoCommand())
        handler.addCommand(PingCommand())
        handler.addCommand(WeatherCommand())
        handler.addCommand(HelpCommand())
    }
}