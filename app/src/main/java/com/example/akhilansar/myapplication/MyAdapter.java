package com.example.akhilansar.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



class MyAdapter extends ArrayAdapter<Rowitem>{
   Context context;
    public MyAdapter(Context context, int resource, List<Rowitem> rowitems) {


        super(context,R.layout.listrow, resource);
this.context=context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflator=LayoutInflater.from(getContext());
View myView=myInflator.inflate(R.layout.listrow,parent,false);
        Rowitem rowitem=getItem(position);
        TextView title= (TextView)myView.findViewById(R.id.issueTitle);
        title.setText(rowitem.getTitle());
        TextView body=(TextView)myView.findViewById(R.id.issueBody);
        body.setText(rowitem.getBody());
        return  myView;
    }
}
