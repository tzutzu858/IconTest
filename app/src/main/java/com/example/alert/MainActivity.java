package com.example.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView msg;
    private Button button, button2, button3, button4,button5,button6;
    String[] str = {"葡萄", "香蕉", "水蜜桃", "蘋果", "鳳梨"};
    String[] str2={"雞排", "甜不辣", "豆干","米血","四季豆"};
    List<String>noodle=new ArrayList<>();
    private AlertDialog dialog = null;
    AlertDialog.Builder builder1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.msg);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == button.getId()) {
            //按下button之後執行
            msg.setText("輸入折扣碼00112233,立即打9折");
            Toast.makeText(MainActivity.this, msg.getText().toString(), Toast.LENGTH_LONG).show();

        } else if (v.getId() == button2.getId()) {
            //按下 我要離開 按鈕之後執行
            builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("訊息")
                    .setIcon(R.mipmap.question)
                    .setMessage("確定要離開?")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        //設定確定按鈕
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        //設定取消按鈕
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }

                    }).create().show();
        }
        //按下 水果 按鈕之後執行
        else if (v.getId() == button3.getId()) {
            builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("你喜歡什麼水果?").setIcon(R.mipmap.pineapple).setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "選擇的是:" + str[i], Toast.LENGTH_LONG).show();
                }

            });
            dialog = builder1.create();
            dialog.show();


        }
        //按下 多選餐點 按鈕之後執行
        else if (v.getId() == button4.getId()){
            builder1=new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("今天想吃什麼?").setIcon(R.mipmap.pineapple).setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            })
            .setMultiChoiceItems(str2, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                    if (isChecked){
                        noodle.add(str2[i]);
                                  }
                    else {
                        noodle.remove(str2[i]);
                    }
                   // Toast.makeText(MainActivity.this, "選擇的是:" + str2[i], Toast.LENGTH_LONG).show();
                }
            }).create().show();
        }
        //按下 客製化餐點 按鈕之後執行
        else if (v.getId() == button5.getId()){
            final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);//從右邊看回來,因為要給item一個固定的標籤、位置,它是不能被改變的
            builder1=new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("打出你想吃的餐點").setIcon(R.mipmap.pineapple)
                    .setView(item)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EditText editText=(EditText) item.findViewById(R.id.text);
                            String name=editText.getText().toString();
                            if (TextUtils.isEmpty(name)){
                                Toast.makeText(getApplicationContext(),R.string.input_ur_name,Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(getApplicationContext(),getString(R.string.hi)+name,Toast.LENGTH_LONG).show();
                            }
                        }
                    }).show();
        }


        else {
            final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.calendarview_layout, null);
            builder1=new AlertDialog.Builder(MainActivity.this);
            builder1.setView(item).show();
        }














    }
}
