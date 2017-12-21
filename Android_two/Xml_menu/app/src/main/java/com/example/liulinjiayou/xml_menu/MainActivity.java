package com.example.liulinjiayou.xml_menu;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {


    private EditText etHelloWorld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHelloWorld = (EditText) findViewById(R.id.et_hello_world);
        registerForContextMenu(etHelloWorld);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {


        getMenuInflater().inflate(R.menu.context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 普通箱单被点击处所进行的操作。
            case R.id.menu_plain_menu:
                Toast.makeText(this, "你单击了普通菜单", Toast.LENGTH_LONG).show();
                break;
            // 为子菜单的子项定义被点击时所进行的操作。
            case R.id.font_10:
                etHelloWorld.setTextSize(10);
                break;
            case R.id.font_16:
                etHelloWorld.setTextSize(16);
                break;
            case R.id.font_20:
                etHelloWorld.setTextSize(20);
                break;
            case R.id.font_red:
                item.setChecked(true);
                etHelloWorld.setHintTextColor(Color.RED);
                break;
            case R.id.font_blue:
                item.setChecked(true);
                etHelloWorld.setHintTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.font_red:
                item.setChecked(true);
                etHelloWorld.setBackgroundColor(Color.RED);
                break;
            case R.id.font_blue:
                item.setChecked(true);
                etHelloWorld.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }


}
