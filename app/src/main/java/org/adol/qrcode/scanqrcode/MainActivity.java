package org.adol.qrcode.scanqrcode;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.util.qrcode.MipcaActivityCapture;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppActivity {

    public final static String TAG = "MainActivity";
    private final static int SCANNIN_GREQUEST_CODE = 1;

    @ViewInject(R.id.scan_result_txt)
    TextView scan_result_txt;
    @ViewInject(R.id.scan_result_btp)
    ImageView scan_result_btp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(R.id.scan_btn)
    private void scanBtn(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MipcaActivityCapture.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
        Log.e(TAG, "xxxxxxxxxx");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    // 显示扫描到的内容
                    scan_result_txt.setText(bundle.getString("result"));
                    // 显示
                    scan_result_btp.setImageBitmap(BitmapFactory.decodeByteArray(data.getByteArrayExtra("bitmap"), 0, data.getByteArrayExtra("bitmap").length));
                }
                break;
        }
    }
}
