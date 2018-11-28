package kr.skylightqp.sweetbot.commands

import com.google.gson.Gson
import kr.skylightqp.sweetbot.json.data.WeatherData
import kr.skylightqp.sweetbot.requests.WeatherRequest
import kr.skylightqp.sweetbot.utils.CityName
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color
import java.text.DecimalFormat


class WeatherCommand : ICommand {
    override var name: String = "날씨"
    override var alias: Array<String> = arrayOf("weather")

    override fun execute(args: Array<String>, event: MessageReceivedEvent) {
        val channel = event.channel

        if (args.size < 2) {
            val eb = EmbedBuilder()
                    .setColor(Color(95, 135, 243))
                    .setTitle("날씨 도움말")
                    .setDescription("~날씨 <지역이름>\n" +
                            "아래의 지역 이름으로 검색할 수 있습니다. \n\n" +
                            "서울, 인천")
            channel.sendMessage(eb.build()).queue()
            return
        }

        val weatherRequest = WeatherRequest()
        val gson = Gson()

        val cityName = CityName.getValueByName(args[1])

        val data: WeatherData = gson.fromJson(weatherRequest.getLocalWeather(cityName!!), WeatherData().javaClass)

        val temp = data.main.temperature.toDouble() - 273.15
        val format = DecimalFormat(".##")
        val editedTemp = format.format(temp)

        val eb = EmbedBuilder()
                .setColor(Color(95, 135, 243))
                .setTitle("${args[1]}의 날씨는...")
                .addField("기온", editedTemp, true)
                .addField("습도", data.main.humidity, true)
                .addField("풍속", data.wind.windSpeed, true)
                .addField("풍향", data.wind.windDegrees, true)
        channel.sendMessage(eb.build()).queue()
    }

}