package example.codeclan.com.alfor3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    public AlarmReceiver(){}

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AlarmReceiver", "its receiving loud and clear");
        Intent vibrateSender = new Intent(context, VibratorService.class);
        context.startService(vibrateSender);

    }
}
