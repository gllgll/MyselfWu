package com.example.myselfwu;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    Button exitButton, nextButton, messageButton, notifiButton, manyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        隐藏菜单栏，将自定义的菜单栏显示出来
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        exitButton = findViewById(R.id.button);
        nextButton = findViewById(R.id.button2);
        messageButton = findViewById(R.id.button3);
        notifiButton = findViewById(R.id.button4);
        manyButton = findViewById(R.id.button5);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder abexit = new AlertDialog.Builder(MainActivity.this);
                abexit.setTitle("退出提示")
                        .setMessage("你将退出软件！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                .setNegativeButton("取消", null)
                        .create().show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder abMessage = new AlertDialog.Builder(MainActivity.this);
                String message = "姓名：WGH\n" + "\n性别：男\n" + "\n学院：信息科学与技术学院\n"+
                        "\n电话号码：10086\n" + "\n就读大学：九江学院\n" + "\n专业：物联网专业";
                abMessage.setMessage(message)
                        .setCancelable(false)
                        .setPositiveButton("我已了解", null)
                        .create().show();
            }
        });

        notifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "如果没反应，请给软件通知权限", Toast.LENGTH_SHORT).show();
                final NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.qq)
                        .setContentTitle("通知栏消息")
                        .setWhen(System.currentTimeMillis())
                        .setDefaults(DEFAULT_KEYS_DIALER)
                        .setContentText("这是系统通知");
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this,0, new Intent[]{intent},0);
                mbuilder.setContentIntent(pendingIntent);
                mbuilder.setAutoCancel(true);
                final NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1, mbuilder.build());
            }
        });

        manyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder abuniversity = new AlertDialog.Builder(MainActivity.this);
                abuniversity.setMessage("即将前往九江学院")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://www.jju.edu.cn/"));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create().show();
            }
        });
    }
}
