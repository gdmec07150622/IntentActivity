package com.me.android.intentactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        Intent intent =getIntent();
        String data=intent.getStringExtra("data");
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        textView2.setText(data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                 break;
            case  R.id.button2:
                Intent intent1=new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
            case  R.id.button3:
                Intent intent2=new Intent();
                intent2.putExtra("data_return","这里是第二页发送过来的数据");
                setResult(RESULT_OK,intent2);//此函数专门用于向上一个活动返回数据
                //finish();

        }
    }

    //通过返回键向上一页传递数据
    /*
    @Override
    public void onBackPressed() {
        Intent intent3=new Intent();
        intent3.putExtra("data_return","这是通过返回键发送过来的数据");
        setResult(RESULT_OK,intent3);//此函数专门用于向上一个活动返回数据
        finish();
    }
    */
}
