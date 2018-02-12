package com.example.shreshto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView myTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(this,"This is 2nd Layout!",Toast.LENGTH_SHORT).show();
        myTextView=(TextView) findViewById(R.id.textView1);
        Bundle extras=getIntent().getExtras();
        if(extras !=null)
        {
            String myString = extras.getString("activityOne");
            myTextView.setText(myString);
        }
        backButton=(Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnintent=getIntent();
                returnintent.putExtra("returndata","From 2nd Activity");
                returnintent.putExtra("returndata2","From 2nd Activity2");
                setResult(RESULT_OK,returnintent);
                finish();
            }
        });
    }
}
