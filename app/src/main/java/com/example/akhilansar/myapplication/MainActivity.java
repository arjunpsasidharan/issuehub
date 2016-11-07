package com.example.akhilansar.myapplication;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG=MainActivity.class.getSimpleName();

    ProgressDialog progressDialog;
    ListView myList;
    String url="https://api.github.com/repos/crashlytics/secureudid/issues";
    ArrayList<HashMap<String,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     contactList=   new ArrayList<>();

        myList= (ListView)findViewById(R.id.mainlistview);

        new GetData().execute();






    }

    private class GetData extends AsyncTask<Void ,Void ,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("connecting.....");
            progressDialog.setCancelable(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            Httphandler http=new Httphandler();
           String json= http.GetSteam(url);
            Log.e(TAG,"response from url"+json);
            if(json != null){

                try {
                    JSONArray myArray=new JSONArray(json);

                    for(int i=0;i<myArray.length();i++){

                        JSONObject c= myArray.getJSONObject(i);
                       String title = c.getString("title");

                         String body = c.getString("body");
                        HashMap<String, String > post=new HashMap<>();
                        post.put("title",title);
                        post.put("body",body);


                        contactList.add(post);





                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            else {
                Log.e(TAG,"something wrong");


            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {



            super.onPostExecute(aVoid);
            if(progressDialog.isShowing())
            {   progressDialog.dismiss();}


ListView myList=(ListView)findViewById(R.id.mainlistview);
            ListAdapter myAdapter=new SimpleAdapter(MainActivity.this,contactList,R.layout.listrow,new  String[]{"title","body"},new int[]{R.id.issueTitle,R.id.issueBody});
            myList.setAdapter(myAdapter);
        }

    }
}