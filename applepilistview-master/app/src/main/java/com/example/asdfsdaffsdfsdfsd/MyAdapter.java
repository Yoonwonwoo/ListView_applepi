package com.example.asdfsdaffsdfsdfsd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Item> list;
    Context context;
    int layout;

    public MyAdapter(Context context,ArrayList<Item> list,int layout) {
        this.list=list;
        this.context=context;
        this.layout=layout;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Item getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,parent,false);
        final TextView maintv=convertView.findViewById(R.id.item_maintv);
        final TextView subtv=convertView.findViewById(R.id.item_subtv);
        Button deleteButton=convertView.findViewById(R.id.item_itemdel);
        Button contentButton=convertView.findViewById(R.id.item_contentdel);

        maintv.setText(list.get(position).getMainText());
        subtv.setText(list.get(position).getSubText());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                MyAdapter.this.notifyDataSetChanged();
            }
        });

        contentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setMainText("");
                list.get(position).setSubText("");
                MyAdapter.this.notifyDataSetChanged();
            }
        });


        return convertView;
    }
}
