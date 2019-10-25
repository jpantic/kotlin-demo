package no.dossier.app.kotlindemo.frontend.components

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import react.*
import react.dom.h1
import kotlin.browser.window

interface AppState : RState {
    //variables
    var quote: String

    //actions
    var getQuote: (String) -> Unit
}

class App : RComponent<RProps, AppState>() {

    init {
        state.quote = "Test!!!!"
    }

    override fun componentDidMount() {
        window.fetch(RestEndpoint.GetQuote.value).then {
            it.text()
        }.then {
            setState {
                quote = it
            }
        }
    }

    override fun RBuilder.render() {
        appContext.Provider(state) {
            h1 {
                +state.quote
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
