package org.adol.qrcode.scanqrcode;

import android.app.Application;

import org.xutils.x;

/**
 * Created by adolp on 2017/3/30.
 */

public class SqApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

}
