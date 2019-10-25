package no.dossier.app.kotlindemo.frontend.contexts

import no.dossier.app.kotlindemo.frontend.components.AppState
import react.createContext

val defaultState = object : AppState {
    override var quote: String = ""
    override var getQuote: (String) -> Unit = { }
}

val appContext = createContext(defaultState)
