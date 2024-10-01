package dev.project

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = "Hello or bye, ${platform.name}!"
}
