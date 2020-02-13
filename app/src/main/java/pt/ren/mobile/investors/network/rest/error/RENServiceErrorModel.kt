package pt.ren.mobile.investors.network.rest.error

import

import pt.ren.mobile.investors.InvestorsApp
import pt.ren.mobile.investors.R


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
