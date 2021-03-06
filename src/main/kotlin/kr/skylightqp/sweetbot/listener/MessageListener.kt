package kr.skylightqp.sweetbot.listener

import kr.skylightqp.sweetbot.utils.Logger
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
        if(chat.startsWith(handler.COMMAND_PREFIX)) {
            val args = chat.substring(1).split(' ')
            val command = handler.get(args[0])
            try {
                command!!.execute(args.toTypedArray(), event)
            } catch (ex: KotlinNullPointerException){

            }
        }
    }
}