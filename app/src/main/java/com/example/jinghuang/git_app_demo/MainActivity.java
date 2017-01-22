package com.example.jinghuang.git_app_demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.samples_list)
    ListView mListView;

    private Sample[] mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSamples = new Sample[]{
                new Sample(R.string.demo_test_in_activity, TestActivity.class),
                new Sample(R.string.demo_test_in_fragment, TestActivity.class),
                new Sample(R.string.demo_test_in_listview, TestActivity.class),
        };

        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mSamples));
    }

    @OnItemClick(R.id.samples_list)
    void onSampleListClick(AdapterView<?> parent, View view, int position, long id) {

        if (mSamples != null && position >= 0 && position < mSamples.length) {
            startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
        }
    }

    private class Sample {
        private String title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
