package pt.ren.mobile.investors.model.error

import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.main.InvestorsApp
import java.io.Serializable


/*
class RENServiceErrorModel : Serializable {
    var error: String? = null
    var message: String
    var html: String? = null

    constructor() {
        message = InvestorsApp.getInstance().getString(R.string.service_error)
    }

    constructor(error: String?, message: String, html: String?) {
        this.error = error
        this.message = message
        this.html = html
    }

}
*/
class RENServiceErrorModel : Serializable {
    private var Error: String? = null
    private var Message: String
    private var Html: String? = null

    constructor() {
        Message = InvestorsApp.getInstance().getString(R.string.service_error)
    }

    constructor(error: String?, message: String, html: String?) {
        Error = error
        Message = message
        Html = html
    }

    fun getError(): String? {
        return Error
    }

    fun setError(error: String?) {
        Error = error
    }

    fun getMessage(): String {
        return Message
    }

    fun setMessage(message: String) {
        Message = message
    }

    fun getHtml(): String? {
        return Html
    }

    fun setHtml(html: String?) {
        Html = html
    }
}
