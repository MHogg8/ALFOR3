package example.codeclan.com.alfor3;

import android.app.AlarmManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    NumberPicker hourNumberPicker;
    NumberPicker minuteNUmberPicker;
    AlarmManager alarmManager;
    TextView alarmReason;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        //Initialize everything on the page.
        //timePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        hourNumberPicker = (NumberPicker) findViewById(R.id.hourNumberPicker);
        minuteNUmberPicker = (NumberPicker) findViewById(R.id.minuteNumberPicker);
        alarmReason = (TextView) findViewById(R.id.alarmReason);
        Button setAlarm = (Button) findViewById(R.id.setAlarm);
        final Calendar calendar = Calendar.getInstance();

        //set the min and max values for the numbers in the scrollwheels.

        hourNumberPicker.setMinValue(0);
        hourNumberPicker.setMaxValue(23);
        minuteNUmberPicker.setMinValue(0);
        minuteNUmberPicker.setMaxValue(59);
        hourNumberPicker.setWrapSelectorWheel(true);
        minuteNUmberPicker.setWrapSelectorWheel(true);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hourNumberPicker.clearFocus();
                minuteNUmberPicker.clearFocus();
                calendar.set(Calendar.HOUR_OF_DAY, hourNumberPicker.getValue());
                calendar.set(Calendar.MINUTE, minuteNUmberPicker.getValue());
                System.out.println(hourNumberPicker.getValue());
                System.out.println(minuteNUmberPicker.getValue());

                int hour = hourNumberPicker.getValue();
                int min= minuteNUmberPicker.getValue();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(min);

                if(min < 10){
                     minute_string = "0" + minute_string;
                 }

                Toast.makeText(Alarm.this, "You have set alarm reminder " + alarmReason.getText().toString() +
                        hour_string + ":" + minute_string, Toast.LENGTH_LONG).show();


            }



        });

    }


}
