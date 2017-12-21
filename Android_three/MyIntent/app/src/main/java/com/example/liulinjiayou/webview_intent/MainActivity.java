package com.example.liulinjiayou.webview_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button btn;
    private String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        btn = (Button)findViewById(R.id.Button1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText =(EditText)findViewById(R.id.edit_text);
                url=editText.getText().toString();
                Intent intent = new Intent("android.intent.action.VIEW",Uri.parse(url));
                //intent.setAction("android.intent.action.VIEW");
                //intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                startActivity(Intent.createChooser(intent, "请选择一款浏览器"));
            }
        });
    }
}
