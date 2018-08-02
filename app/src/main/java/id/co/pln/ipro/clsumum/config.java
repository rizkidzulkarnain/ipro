package id.co.pln.ipro.clsumum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.co.pln.ipro.R;
import id.co.pln.ipro.model.LoginClass;

public class config {
    public static String BASE_URL = ""; //FILL YOUR URL
    public static LoginClass LOGIN_CLASS;

    public static void getVibrate(Context icontext){
        Vibrator avibra = (Vibrator) icontext.getSystemService(icontext.VIBRATOR_SERVICE);
        avibra.vibrate(100);
    }
}
