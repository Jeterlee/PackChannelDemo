package cn.jeterlee.packchannel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new DemoListAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onListItemClick(i);
            }
        });
    }

    private void onListItemClick(int i) {
        Intent intent = new Intent(MainActivity.this, demos[i].clazz);
        startActivity(intent);
    }

    private class DemoListAdapter extends BaseAdapter {

        public DemoListAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return demos.length;
        }

        @Override
        public Object getItem(int i) {
            return demos[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            convertView = View.inflate(MainActivity.this, R.layout.demo_info_item, null);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView desc = (TextView) convertView.findViewById(R.id.desc);
            title.setText(demos[i].title);
            desc.setText(demos[i].desc);
            if (i >= 16) {
                title.setTextColor(Color.YELLOW);
            }
            return convertView;
        }
    }

    private static final DemoInfo[] demos = {new DemoInfo("ChannelTestActivity", "多渠道打包", ChannelTestActivity.class)};

    private static class DemoInfo {
        private final String title;
        private final String desc;
        private final Class<? extends Activity> clazz;

        public DemoInfo(String title, String desc, Class<? extends Activity> clazz) {
            this.title = title;
            this.desc = desc;
            this.clazz = clazz;
        }
    }
}
