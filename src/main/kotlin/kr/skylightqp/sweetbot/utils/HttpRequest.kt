package kr.skylightqp.sweetbot.utils

object HttpRequest {
    fun get(url: String, params: Map<String, String>) = khttp.get(url, params = params)
    fun get(url: String) = khttp.get(url)
    fun get(url: String, params: Map<String, String>, headers: Map<String, String>) = khttp.get(url, params = params, headers = headers)
    fun post(url: String, params: Map<String, String>, headers: Map<String, String>) = khttp.post(url, params = params, headers = headers)
}