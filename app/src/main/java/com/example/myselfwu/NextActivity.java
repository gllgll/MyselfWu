package com.example.myselfwu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        initDate();
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter=new ListViewAdapter(this,items));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NextActivity.this, "点击的位置："+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDate(){
        items = new ArrayList<>();
        String[] core = {"大学语文","嵌入式驱动","Python程序设计","物联网应用技术",
                "无线射频技术","云计算","计算机硬件设计","高数","C语言","嵌入式应用开发",
                "Linux","Java","数据结构"};
        for(int i=0; i<core.length; i++){
            items.add((i+1)+"、"+core[i]);
        }
    }


}


