package no.dossier.app.kotlindemo.frontend.components

import kotlinx.html.js.onClickFunction
import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import react.*
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
        state.quote = ""
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
            span {
                +state.quote

            }
            button {
                attrs.onClickFunction = { refresh() }
                +"Hit me again"
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
