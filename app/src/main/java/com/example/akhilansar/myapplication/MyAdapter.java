package com.example.akhilansar.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
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
 private class ViewHolder{

        TextView title;
        TextView  body;


    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder=null;
        Rowitem rowitem=getItem(position);

        LayoutInflater myInflator=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            convertView=myInflator.inflate(R.layout.listrow,null);
            holder=new ViewHolder();
            holder.title=(TextView)convertView.findViewById(R.id.issueTitle);
            holder.body=(TextView)convertView.findViewById(R.id.issueBody);
        convertView.setTag(holder);
        }
        else {



            holder=(ViewHolder)convertView.getTag();
            if (rowitem != null) {
                holder.title.setText(rowitem.getTitle());

                holder.body.setText(rowitem.getBody());
            }else
                Log.e("listrow","null");


        }
        return  convertView;

    }
}
