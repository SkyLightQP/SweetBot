package kr.skylightqp.sweetbot.listener

import kr.skylightqp.sweetbot.Logger
import kr.skylightqp.sweetbot.commands.CommandHandler
import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {
    val handler = CommandHandler()

    override fun onMessageReceived(event: MessageReceivedEvent) {

        when (event.channel.type) {
            ChannelType.PRIVATE -> {
                Logger.info("[PM] ${event.author.name} : ${event.message.contentDisplay}")
            }
            else -> {
                Logger.info("[${event.guild.name}] [${event.textChannel.name}] ${event.author.name} : ${event.message.contentDisplay}")
            }
        }

        if(event.author.isBot) return

        val chat = event.message.contentRaw
        val args = chat.substring(1).split(' ')
        if(chat.startsWith(handler.COMMAND_PREFIX)) {
            val lable = args[0].replace(handler.COMMAND_PREFIX, "")
            val command = handler.get(lable)
            try {
                command!!.execute(args, event)
            } catch (ex: KotlinNullPointerException){

            }
        }
    }
}