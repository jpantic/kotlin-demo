package no.dossier.app.kotlindemo.backend;

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import kotlin.random.Random

fun generateQuote(json: JsonObject): String {
    val entryPoint = json["entryPoint"].toString()
    val wordClasses = json["wordClasses"] as JsonObject


    return recursiveCall(wordClasses, entryPoint).capitalize()
}

fun recursiveCall(json: JsonObject, key: String): String {
 val words = json[key] as JsonArray<*>
 val index = Random.nextInt(words.size)
 val phrase = words[index].toString()

 return phrase.replace(Regex("<(.+?)>")) {
  recursiveCall(json, it.groupValues[1])
 }
}
