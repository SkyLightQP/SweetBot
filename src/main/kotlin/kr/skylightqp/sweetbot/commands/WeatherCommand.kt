package kr.skylightqp.sweetbot.commands

import com.google.gson.Gson
import kr.skylightqp.sweetbot.json.data.WeatherData
import kr.skylightqp.sweetbot.requests.WeatherRequest
import kr.skylightqp.sweetbot.utils.CityName
import kr.skylightqp.sweetbot.utils.WeatherStatus
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
                            "서울, 인천, 부산, 청주")

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
        val weatherStatus = data.weather[0].main.toUpperCase()

       val eb = EmbedBuilder()
                .setColor(Color(95, 135, 243))
                .setTitle("${args[1]}의 날씨는...")
                .addField("현재 날씨", WeatherStatus.valueOf(weatherStatus).toString(), true)
                .addField("기온", "$editedTemp ℃", true)
                .addField("습도", "${data.main.humidity} %", true)
                .addField("풍속", "${data.wind.windSpeed} ㎧", true)
                .addField("풍향", getDegree(data.wind.windDegrees.toInt()), true)
        channel.sendMessage(eb.build()).queue()
    }

    private fun getDegree(degree: Int): String {
        if (degree > 337.5) return "북";
        if (degree > 292.5) return "북서"
        if (degree > 247.5) return "서"
        if (degree > 202.5) return "남서"
        if (degree > 157.5) return "남"
        if (degree > 122.5) return "남동"
        if (degree > 67.5) return "동"
        if (degree > 22.5) return "북동"
        return "북"
    }

}