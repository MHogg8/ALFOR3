package example.codeclan.com.alfor3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
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
    PendingIntent pendingIntent;
    Intent intent;


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
        intent  = new Intent(Alarm.this, Alarm_Receiver.class);



        //set the min and max values for the numbers in the scrollwheels.
        hourNumberPicker.setMinValue(0);
        hourNumberPicker.setMaxValue(23);
        minuteNUmberPicker.setMinValue(0);
        minuteNUmberPicker.setMaxValue(59);
        // recycles the wheels if true  - i.e. goes back to 0
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
                     minute_string = "0" + String.valueOf(min);
                 }

                Toast.makeText(Alarm.this, "You have set alarm reminder " + alarmReason.getText().toString() + " " +
                        hour_string + ":" + minute_string, Toast.LENGTH_LONG).show();

                // its probable that the 0 below will need to be a variable that keeps changing if you want to add multiple alarms.
                 pendingIntent = PendingIntent.getBroadcast(Alarm.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
            }



        });

    }


}
