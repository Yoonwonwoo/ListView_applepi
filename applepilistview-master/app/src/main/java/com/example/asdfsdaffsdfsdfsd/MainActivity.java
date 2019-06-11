package com.example.asdfsdaffsdfsdfsd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Item> list;
    Button item_contentdel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        list=new ArrayList<>();
        list.add(new Item("Applepi","java..."));
        list.add(new Item("Applepi","android..."));
        list.add(new Item("Applepi","studio..."));
        list.add(new Item("Applepi","fun..."));

        final MyAdapter adapter=new MyAdapter(getApplicationContext(),list,R.layout.item);
        listView.setAdapter(adapter);


    }
}
