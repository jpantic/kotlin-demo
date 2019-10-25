package no.dossier.app.kotlindemo.backend.controllers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.generateQuote
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuoteController {

    @GetMapping(RestEndpoint.Urls.GET_QUOTE)
    fun getQuote(): String {
        val inputStream = QuoteController::class.java.getResourceAsStream("/data.json")
        val json = Parser.default().parse(inputStream) as JsonObject
        return generateQuote(json)
    }

}
