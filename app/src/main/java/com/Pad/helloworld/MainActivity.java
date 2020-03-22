package com.Pad.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    ImageView pic;

    //不是dd弹窗设置
    public void dialog_1(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setTitle("传教");
        builder.setMessage("快去推v");
        builder.setPositiveButton("好",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "去吧，凑dd", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("彳亍", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "本质还是dd", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //获取资源id的函数
    public int  getResource(String imageName){
        Context ctx = getBaseContext();
        int resId = getResources().getIdentifier(imageName, "@mipmap" , ctx.getPackageName());
        return resId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tt = findViewById(R.id.tietie);
        Button peko = findViewById(R.id.peko);
        Button pa = findViewById(R.id.pa);
        pic = (ImageView) findViewById(R.id.pic);
        tt.setText("贴贴");
        final TextView tv = findViewById(R.id.tv1);

        //为tietie按钮设置监听动作
        OnClickListener TieTie = new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("我和新科娘贴贴");
                pic.setImageDrawable(getResources().getDrawable(getResource("@mipmap/tietie")));
            }
        };

        //为peko按钮设置监听动作
        OnClickListener Peko = new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("不许草Peko");
                pic.setImageDrawable(getResources().getDrawable(getResource("@mipmap/peko")));
            }
        };

        //为不是dd按钮设置监听动作
        OnClickListener Pa = new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("不是dd给爷爬！");
                pic.setImageDrawable(getResources().getDrawable(getResource("@mipmap/dd2")));
                //不是dd弹窗
                dialog_1(v);
            }
        };
        //绑定动作
        tt.setOnClickListener(TieTie);
        peko.setOnClickListener(Peko);
        pa.setOnClickListener(Pa);
    }
}
