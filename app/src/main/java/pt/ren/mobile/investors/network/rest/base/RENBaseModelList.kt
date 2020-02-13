package pt.ren.mobile.investors.network.rest.base

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*


class RENBaseModelList<T : Parcelable?> : Parcelable {
    @SerializedName("Result")
    protected var mResult: String?
    @SerializedName("Total")
    protected var mTotal: String?
    @SerializedName("content")
    protected var mContent: List<T?>? = null

    constructor(
        mResult: String?,
        mTotal: String?,
        mContent: List<T>?
    ) {
        this.mResult = mResult
        this.mTotal = mTotal
        this.mContent = mContent
    }

    fun getmResult(): String? {
        return mResult
    }

    fun setmResult(mResult: String?) {
        this.mResult = mResult
    }

    fun getmTotal(): String? {
        return mTotal
    }

    fun setmTotal(mTotal: String?) {
        this.mTotal = mTotal
    }

    fun getmContent(): List<T?>? {
        return mContent
    }

    fun setmContent(mContent: List<T>?) {
        this.mContent = mContent
    }

    protected constructor(`in`: Parcel) {
        mResult = `in`.readString()
        mTotal = `in`.readString()
        if (`in`.readByte().toInt() == 0x01) {
            mContent = ArrayList()
            `in`.readList(mContent, Parcelable::class.java.classLoader)
        } else {
            mContent = null
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(mResult)
        parcel.writeString(mTotal)
        if (mContent == null) {
            parcel.writeByte(0x00.toByte())
        } else {
            parcel.writeByte(0x01.toByte())
            parcel.writeList(mContent)
        }
    }

    companion object {
        val CREATOR: Parcelable.Creator<RENBaseModelList<*>> =
            object : Parcelable.Creator<RENBaseModelList<*>> {
                override fun createFromParcel(`in`: Parcel): RENBaseModelList<*> {
                    return RENBaseModelList<Any?>(`in`)
                }

                override fun newArray(size: Int): Array<RENBaseModelList<*>> {
                    return arrayOfNulls(size)
                }
            }
    }

    companion object CREATOR : Parcelable.Creator<RENBaseModelList> {
        override fun createFromParcel(parcel: Parcel): RENBaseModelList {
            return RENBaseModelList(parcel)
        }

        override fun newArray(size: Int): Array<RENBaseModelList?> {
            return arrayOfNulls(size)
        }
    }
}
