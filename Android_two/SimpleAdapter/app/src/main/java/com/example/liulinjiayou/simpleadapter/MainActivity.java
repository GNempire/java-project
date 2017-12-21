package com.example.liulinjiayou.simpleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] names = new String[]{"Lion", "Tiger", "Monkey","Dog","Cat","Elephant"};
    private int[] imgIds = new int[]{R.mipmap.lion, R.mipmap.tiger, R.mipmap.monkey,R.mipmap.dog,R.mipmap.cat,R.mipmap.elephant};
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("name", names[i]);
            showitem.put("touxiang", imgIds[i]);
            listitem.add(showitem);
        }
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.list_item, new String[]{"touxiang", "name"}, new int[]{R.id.imgtou, R.id.name});
        listView = (ListView) findViewById(R.id.list_test);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this,names[position],Toast.LENGTH_SHORT).show();
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView=(ListView)findViewById(R.id.listview);
        dataList=new ArrayList<Map<String,Object>>();
        simpleAdapter=new SimpleAdapter(this,listItems(),R.layout.item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }
    private  List<Map<String,Object>>listItems(){
        for(int i=0;i<text.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",img[i]);
            map.put("text",text[i]);
            dataList.add(map);
        }
        return dataList;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this,text[position],Toast.LENGTH_SHORT).show();
    }*/

}
