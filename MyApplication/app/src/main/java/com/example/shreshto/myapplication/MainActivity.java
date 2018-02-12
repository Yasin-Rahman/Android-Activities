package com.example.shreshto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    private static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=(Button) findViewById(R.id.button1);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("activityOne","I am from the first activity");
                startActivityForResult(intent,REQUEST_CODE);
                //startActivity(intent);
               // startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
            if(resultCode==RESULT_OK)
            {
                String stringResult=data.getStringExtra("returndata");
                String stringResult2=data.getStringExtra("returndata2");
                Toast.makeText(this,stringResult,Toast.LENGTH_SHORT).show();
                Toast.makeText(this,stringResult2,Toast.LENGTH_SHORT).show();
            }
    }
}
