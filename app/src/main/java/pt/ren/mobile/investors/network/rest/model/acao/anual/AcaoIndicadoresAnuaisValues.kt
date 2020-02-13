package pt.ren.mobile.investors.network.rest.model.acao.anual


class AcaoIndicadoresAnuaisValues {
    var year: String? = null
    var enValue: String? = null
    var ptValue: String? = null

    constructor(year: String?, enValue: String?, ptValue: String?) {
        this.year = year
        this.enValue = enValue
        this.ptValue = ptValue
    }

    constructor() {}

}
