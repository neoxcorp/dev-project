package dev.project

class Greeting {
    private val platform = getPlatform()

    fun greeting(): String = "Hello or bye, ${platform.name}!"
}
