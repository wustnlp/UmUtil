package com.chinaums.umutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.chinaums.umutil.view.UCloseView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mRoot = (LinearLayout) findViewById(R.id.root);
        UCloseView mClose = new UCloseView(this);
        //可选，其实宽度在这里设置没有用，高度是可以设置的，单位是像素
        mClose.setHeight(200);
        mClose.setWidth(200);
        mRoot.addView(mClose);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
