package com.appshacking.ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    EditText etFlag = null;
    TextView tvResult = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button verifyBtn = findViewById(R.id.verifyBtn);
        etFlag = findViewById(R.id.etFlag);
        tvResult = findViewById(R.id.tvResult);

        String f = "hack_ac_flag{print_args}";
        String fo = "flag{pass_shared}";
        byte[] bytes = f.getBytes();
        byte[] flagByteArr = new byte[] {104, 97, 99, 107, 95, 97, 99,95,102,108,97,103,123,112,114,105,110
        ,116,95,97,114,103,115,125};

//        byte[] byt = string.getBytes(Charset.forName("UTF-8"));
//        byte[] b = string.getBytes(StandardCharsets.UTF_8);
        for(byte b: bytes){
            Log.d(",", String.valueOf(b));

        }
        String flag = new String(flagByteArr);

        verifyBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String usrInput = etFlag.getText().toString();
                if(compare(flag,usrInput)){
                    tvResult.setText("correct, you have solved the challenge");
                    tvResult.setTextColor(Color.GREEN);

                }
                else{
                    tvResult.setText("Wrong");
                    tvResult.setTextColor(Color.RED);

                }
            }
        });

    }

    public boolean compare(String a, String b){

        if(a.equals(b)){
            return true;
        }
        return false;
    }
}