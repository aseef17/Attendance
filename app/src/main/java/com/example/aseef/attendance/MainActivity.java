package com.example.aseef.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText user_id;
    private Button user_id_submit;
    private Button button_time_table;

    String user_id_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user_id = findViewById(R.id.id_number);
        user_id_submit = findViewById(R.id.submit_id);
        button_time_table = findViewById(R.id.button_time_table);

        user_id_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_id_number = user_id.getText().toString();

                if(!TextUtils.isEmpty(user_id_number)) {

                    Intent student_attendance_intent = new Intent(MainActivity.this, StudentAttendanceActivity.class);
                    student_attendance_intent.putExtra("user_id",user_id_number);
                    startActivity(student_attendance_intent);

                } else {


                    Toasty.warning(MainActivity.this, "Please Enter Your ID", Toast.LENGTH_LONG, true).show();

                }

            }
        });

        button_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent time_table_intent = new Intent(MainActivity.this, TimeTableActivity.class);
                startActivity(time_table_intent);

            }
        });

    }

}
