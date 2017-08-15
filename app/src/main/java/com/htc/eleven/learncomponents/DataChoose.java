package com.htc.eleven.learncomponents;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class DataChoose extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Button dataChoose;
    private Button timeChoose;
    private Button commitAnswer;
    private RadioButton answer;

    private CheckBox cb1,cb2,cb3,cb4,cb5;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_choose);

        // choose and set date.
        dataChoose = (Button) findViewById(R.id.chooseDate);
        dataChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(DataChoose.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(DataChoose.this, i+"-"+(i1+1)+"-"+i2,Toast.LENGTH_SHORT).show();

                        dataChoose.setText(String.format("%d-%d-%d", i, i1+1, i2));
                    }
                }, 2017, 1 , 1).show();
            }
        });

        // choose and set time.
        timeChoose = (Button) findViewById(R.id.chooseTime);
        timeChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(DataChoose.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(DataChoose.this, i+":"+i1, Toast.LENGTH_SHORT).show();

                        timeChoose.setText(String.format("%d:%d", i, i1));
                    }
                }, 18, 30, true).show();
            }
        });

        //single choose.
        commitAnswer = (Button) findViewById(R.id.btnSubmit);
        answer = (RadioButton) findViewById(R.id.b1);

        commitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.isChecked()) {
                    Toast.makeText(DataChoose.this, "恭喜你,答对了 !", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DataChoose.this, "不好意思,你答错了 !", Toast.LENGTH_LONG).show();
                }
            }
        });

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);

        showResult = (TextView) findViewById(R.id.showResult);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String result = "你最喜欢的水果有: ";

        if(cb1.isChecked()) result += cb1.getText() + " ";
        if(cb2.isChecked()) result += cb2.getText() + " ";
        if(cb3.isChecked()) result += cb3.getText() + " ";
        if(cb4.isChecked()) result += cb4.getText() + " ";
        if(cb5.isChecked()) result += cb5.getText();


        showResult.setText(result);
    }
}
