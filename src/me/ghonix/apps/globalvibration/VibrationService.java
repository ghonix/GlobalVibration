package me.ghonix.apps.globalvibration;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Vibrator;
import android.view.accessibility.AccessibilityEvent;

public class VibrationService extends AccessibilityService {

    Vibrator v = null;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // Get instance of Vibrator from current Context
        if (v == null) {
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        }
        // Vibrate for 300 milliseconds
        v.vibrate(new long[] {100, 100}, 1);

    }

    @Override
    public void onInterrupt() {
        if(v != null) {
            v.cancel();
        }
    }

}
