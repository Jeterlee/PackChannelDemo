package cn.jeterlee.packchannel;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ChannelTestActivity extends AppCompatActivity {

    private TextView tv_channel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_test);
        tv_channel = (TextView) findViewById(R.id.channel_test_text);
        tv_channel.setText(getApplicationMetaVlaue("UMENG_CHANNEL"));
    }

    private String getApplicationMetaVlaue(String name) {
        String value = "";
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(),
                    PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
