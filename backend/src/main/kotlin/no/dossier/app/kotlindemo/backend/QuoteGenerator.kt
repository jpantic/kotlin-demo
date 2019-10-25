package no.dossier.app.kotlindemo.backend;

import com.beust.klaxon.JsonObject

fun generateQuote(json: JsonObject): String {
 return json["entryPoint"].toString()
}

