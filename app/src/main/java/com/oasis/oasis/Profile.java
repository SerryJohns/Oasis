package com.oasis.oasis;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        EditText fullName=findViewById(R.id.names);
        Button submitUpdates=findViewById(R.id.applyUpdate);
        final TextView birthDay=findViewById(R.id.birthDay);

        RelativeLayout pickDate=findViewById(R.id.pickDate);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatePicker(birthDay);
            }
        });

    }

    private void getDatePicker(final TextView birthDay){
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(this);
        final View mView=getLayoutInflater().inflate(R.layout.date_picker, null);

        DatePicker pickDate=mView.findViewById(R.id.pickDate);
        Calendar calendar=Calendar.getInstance();
        pickDate.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                birthDay.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog=mBuilder.create();
        dialog.show();
    }


}

