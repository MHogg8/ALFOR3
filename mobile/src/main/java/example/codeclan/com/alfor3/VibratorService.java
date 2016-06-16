package example.codeclan.com.alfor3;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;

public class VibratorService extends Service {

    Vibrator vibrateCall;

    public VibratorService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Vibrate", "Big Vibrations");
        vibrateCall = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrateCall.vibrate(5000);

        // I think it is probably in here that we need to set the reminder we could have a delay between the
        // pattern of teh vibration or the pattern of the beep and then it could vibrate slash beep
        // every 15 mins until teh alarm is canceled via the NFC.

        ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
        tone.startTone(ToneGenerator.TONE_DTMF_6, 30000);

        Intent intentimage = new Intent(VibratorService.this, ShowImage.class);
        intentimage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intentimage);

        return  START_REDELIVER_INTENT;
    }
}
