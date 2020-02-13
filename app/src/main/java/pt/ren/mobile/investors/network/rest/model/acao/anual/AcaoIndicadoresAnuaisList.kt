package pt.ren.mobile.investors.network.rest.model.acao.anual

import pt.ren.mobile.investors.network.rest.base.RENBaseModelList


class AcaoIndicadoresAnuaisList(
    mResult: String?,
    mTotal: String?,
    mContent: List<AcaoIndicadoresAnuais?>?
) :
    RENBaseModelList<AcaoIndicadoresAnuais?>(mResult, mTotal, mContent)