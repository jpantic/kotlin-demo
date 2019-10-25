package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.ApplicationRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuoteController {

    @GetMapping(RestEndpoint.Urls.GET_QUOTE)
    fun getQuote(): String {
        return "abc 123"
    }

}
