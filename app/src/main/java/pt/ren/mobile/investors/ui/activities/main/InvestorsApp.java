package pt.ren.mobile.investors.ui.activities.main;

import android.app.Application;
import android.content.res.Configuration;

import java.io.File;

public class InvestorsApp extends Application {

    private static final String TAG = "InvestorsApp";
    private static InvestorsApp appInstance;

    private static String sStorageDirPath, sImageDirPath, sCalendarsDirPath, sFilesDirPath;
    private File mStorageDir, mImageDir, mCalendarDir, mFilesDir;


    @Override
    public void onCreate() {
        setInstance(this);
        super.onCreate();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    private static void setInstance(InvestorsApp instance) {
        appInstance = instance;
    }

    public static InvestorsApp getInstance() {
        return appInstance;
    }

}
