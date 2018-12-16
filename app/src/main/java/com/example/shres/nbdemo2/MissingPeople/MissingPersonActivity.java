package com.example.shres.nbdemo2.MissingPeople;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shres.nbdemo2.Activity.NavigationDrawerActivity;
import com.example.shres.nbdemo2.R;

public class MissingPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_person);
        //ACTION BAR SETUP
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Missing People");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);





        TextView mName = findViewById(R.id.missingname);
        TextView mAge = findViewById(R.id.age);
        TextView mDiscription = findViewById(R.id.missing_discription);
        TextView mtitle = findViewById(R.id.missingtitle);
        ImageView mimage = findViewById(R.id.missingimage);

        // get data

        byte[] bytes=getIntent().getByteArrayExtra("image");
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String discription = getIntent().getStringExtra("discription");
        String title = getIntent().getStringExtra("title");
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        //set data to view
        mName.setText("Name-"+name);
        mAge.setText("Age-"+age);
        mDiscription.setText(discription);
        mtitle.setText(title);
        mimage.setImageBitmap( bitmap);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.call) {
           call();
            return true;
        }
        if (id==R.id.message){
            message();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void call() {
        Intent callintent = new Intent(Intent.ACTION_DIAL);
        callintent.setData(Uri.parse("tel:100"));
        startActivity(callintent);
    }

    public void message(){
        final EditText taskEditText = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Message")
                /*.setMessage("What do you want to do next?")*/
                .setView(taskEditText)
                .setPositiveButton("send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String smsMessage = String.valueOf(taskEditText.getText());
                        if(checkPermission(Manifest.permission.SEND_SMS)){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage("9804185934", null, smsMessage, null, null);
                            Toast.makeText(MissingPersonActivity.this, "Message Sent!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MissingPersonActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        dialog.show();

    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}
