package kr.skylightqp.sweetbot

import org.slf4j.LoggerFactory

object Logger {
    private val logger = LoggerFactory.getLogger("SweetBot")

    fun info(log: String) = logger.info(log)
    fun debug(log: String) = logger.debug(log)
}