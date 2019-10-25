package no.dossier.app.kotlindemo.frontend.components

import kotlinx.html.js.onClickFunction
import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import react.*
import react.dom.h1
import react.dom.div
import react.dom.button
import react.dom.span
import kotlin.browser.window

interface AppState : RState {
    //variables
    var quote: String

    //actions
    var getQuote: (String) -> Unit
}

class App : RComponent<RProps, AppState>() {

    init {
        state.quote = "Fetching quote..."
    }

    private fun refresh () {
        window.fetch(RestEndpoint.GetQuote.value).then {
            it.text()
        }.then {
            setState {
                quote = it
            }
        }
    }

    override fun componentDidMount() {
        this.refresh()
    }

    override fun RBuilder.render() {
        appContext.Provider(state) {
            div(classes="beer-quote") {
                h1 {
                    +state.quote
                }
                div(classes="brand") {
                    +"Beerbusters & Partners BeerAI - advanced human beer language generation platform"
                }
                button {
                    attrs.onClickFunction = { refresh() }
                    +"Hit me again"
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
