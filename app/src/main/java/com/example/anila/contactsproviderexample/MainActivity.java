package com.example.anila.contactsproviderexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button mButton;
    public static final String PHONE_DISPLAY_NAME= ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
    public static final String  PHONE_NUMBER=ContactsContract.CommonDataKinds.Phone.NUMBER;
    Uri mUri=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.add_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContacts();
            }
        });

    }
    public void showContacts()
    {
        String[] projection=new String[]{PHONE_DISPLAY_NAME,PHONE_NUMBER};
        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(mUri,projection,null,null,null);
        while(cursor.moveToNext()){

            String name=cursor.getString(cursor.getColumnIndex(PHONE_DISPLAY_NAME));
            String number=cursor.getString(cursor.getColumnIndex(PHONE_NUMBER));
            Log.d(name, "name ");
            Log.d(number, "number");
        }
    }
}
