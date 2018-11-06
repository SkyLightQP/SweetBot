package kr.skylightqp.sweetbot

import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        when (event.channel.type) {
            ChannelType.PRIVATE -> {
                Logger.info("[PM] ${event.author.name} : ${event.message.contentDisplay}")
            }
            else -> {
                Logger.info("[${event.guild.name}] [${event.textChannel.name}] ${event.author.name} : ${event.message.contentDisplay}")
            }
        }
    }
}