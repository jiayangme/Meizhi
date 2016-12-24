package sample.xiangkai.com.meizhi;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by xiangkai on 2016/11/10.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
