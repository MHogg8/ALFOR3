package example.codeclan.com.alfor3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_options);

        Button newAlarm  = (Button) findViewById(R.id.newAlarm);
        Button editAlarms = (Button) findViewById(R.id.editAlarms);
        Button deleteAlarms = (Button) findViewById(R.id.deleteAlarms);

        newAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmOptions.this, Alarm.class);
                startActivity(intent);
            }
        });
    }
}
