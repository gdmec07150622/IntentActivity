package com.me.android.intentactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
本例,示范如何通过intent跳转页面，并来回传递数据.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转页面
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
               // startActivity(intent);
                startActivityForResult(intent,1);//这里1为请求码，为之后回调中判断数据来源
              //  finish(); //不允许返回该界面
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式跳转页面
                Intent intent =new Intent("com.me.android.intentactivity.ACTION_START");
                //startActivity(intent);
                startActivityForResult(intent,1);

            }
        });

    }

    //requestCod:请求码 resultCode:处理结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    TextView tv=(TextView)findViewById(R.id.textView);
                    tv.setText(returnedData);

                }
        }
    }
}
