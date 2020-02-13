package pt.ren.mobile.investors.network.rest.model.acao.anual

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class AcaoIndicadoresAnuais : Parcelable {
    var pt_pt__Separator: String? = null
    var pt_pt__share: String? = null
    var pt_pt__unit: String? = null
    var en_gb__Separator: String? = null
    var en_gb__share: String? = null
    var en_gb__unit: String? = null
    var dte_init: String? = null
    var dte_end: String? = null
    var dte_state: String? = null
    var scrId: String? = null
    var srcLang: String? = null
    var srcChannel: String? = null
    var srcState: String? = null
    private var values: List<AcaoIndicadoresAnuaisValues>? = null

    constructor(
        pt_pt__Separator: String?,
        pt_pt__share: String?,
        pt_pt__unit: String?,
        en_gb__Separator: String?,
        en_gb__share: String?,
        en_gb__unit: String?,
        dte_init: String?,
        dte_end: String?,
        dte_state: String?,
        scrId: String?,
        srcLang: String?,
        srcChannel: String?,
        srcState: String?,
        values: List<AcaoIndicadoresAnuaisValues>?
    ) {
        this.pt_pt__Separator = pt_pt__Separator
        this.pt_pt__share = pt_pt__share
        this.pt_pt__unit = pt_pt__unit
        this.en_gb__Separator = en_gb__Separator
        this.en_gb__share = en_gb__share
        this.en_gb__unit = en_gb__unit
        this.dte_init = dte_init
        this.dte_end = dte_end
        this.dte_state = dte_state
        this.scrId = scrId
        this.srcLang = srcLang
        this.srcChannel = srcChannel
        this.srcState = srcState
        this.values = values
    }

    fun getValues(): List<AcaoIndicadoresAnuaisValues>? {
        return values
    }

    fun setValues(values: List<AcaoIndicadoresAnuaisValues>?) {
        this.values = values
    }

    protected constructor(`in`: Parcel?) {
        pt_pt__Separator = in.readString()
        pt_pt__share = in.readString()
        pt_pt__unit = in.readString()
        en_gb__Separator = in.readString()
        en_gb__share = in.readString()
        en_gb__unit = in.readString()
        dte_init = in.readString()
        dte_end = in.readString()
        dte_state = in.readString()
        scrId = in.readString()
        srcLang = in.readString()
        srcChannel = in.readString()
        srcState = in.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(pt_pt__Separator)
        dest.writeString(pt_pt__share)
        dest.writeString(pt_pt__unit)
        dest.writeString(en_gb__Separator)
        dest.writeString(en_gb__share)
        dest.writeString(en_gb__unit)
        dest.writeString(dte_init)
        dest.writeString(dte_end)
        dest.writeString(dte_state)
        dest.writeString(scrId)
        dest.writeString(srcLang)
        dest.writeString(srcChannel)
        dest.writeString(srcState)
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<AcaoIndicadoresAnuais> =
            object : Creator<AcaoIndicadoresAnuais?> {
                override fun createFromParcel(`in`: Parcel): AcaoIndicadoresAnuais? {
                    return AcaoIndicadoresAnuais(`in`)
                }

                override fun newArray(size: Int): Array<AcaoIndicadoresAnuais?> {
                    return arrayOfNulls(size)
                }
            }
    }

    companion object CREATOR : Creator<AcaoIndicadoresAnuais> {
        override fun createFromParcel(parcel: Parcel): AcaoIndicadoresAnuais {
            return AcaoIndicadoresAnuais(parcel)
        }

        override fun newArray(size: Int): Array<AcaoIndicadoresAnuais?> {
            return arrayOfNulls(size)
        }
    }
}