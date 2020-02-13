package pt.ren.mobile.investors

import android.app.Application
import android.content.res.Configuration
import java.io.File


class InvestorsApp : Application() {
    private val mStorageDir: File? = null
    private val mImageDir: File? = null
    private val mCalendarDir: File? = null
    private val mFilesDir: File? = null
    override fun onCreate() {
        setInstance(this)
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    companion object {
        private const val TAG = "InvestorsApp"
        var instance: InvestorsApp? = null
            private set
        private val sStorageDirPath: String? = null
        private val sImageDirPath: String? = null
        private val sCalendarsDirPath: String? = null
        private val sFilesDirPath: String? = null
        private fun setInstance(instance: InvestorsApp) {
            this.instance = instance
        }

    }
}
