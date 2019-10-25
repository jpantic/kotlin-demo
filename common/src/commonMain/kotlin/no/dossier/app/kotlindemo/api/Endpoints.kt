package no.dossier.app.kotlindemo.api

enum class RestEndpoint(val value: String) {
    GetQuote(Urls.GET_QUOTE);

    class Urls {
        companion object {
            const val GET_QUOTE = "/quotes"
        }
    }
}
