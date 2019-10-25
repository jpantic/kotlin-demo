package no.dossier.app.kotlindemo.backend

import java.util.*

class ApplicationRegistry {
    companion object {
        val quotes: MutableList<String> = Collections.synchronizedList(mutableListOf())
    }
}