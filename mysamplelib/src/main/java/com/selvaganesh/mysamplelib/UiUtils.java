package com.selvaganesh.mysamplelib;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import java.text.DecimalFormat;


public class UiUtils {

    public static final int NUM_HASHED_BYTES = 9;
    public static final int NUM_BASE64_CHAR = 11;
    //SMS
    private static final String HASH_TYPE = "SHA-256";
    public static Dialog clDialog, connectBankDia;
    public static TextView clMessage_txt, tv_connect_msg, tv_cancel;
    private static String TAG = UiUtils.class.getSimpleName();
    private static Toast mToast;
    //timer
    private static CountDownTimer timer = null;
    private static boolean pauseTimer = false;
    private static boolean timerRunning = false;
    private static int expireIn = 60;

    public static void showToast(Context context, String input) {
        try {
            if (!TextUtils.isEmpty(input)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    mToast = Toast.makeText(context, input, Toast.LENGTH_SHORT);
                    mToast.setGravity(Gravity.CENTER, 0, 0);
                    mToast.show();
                } else {
                    mToast = Toast.makeText(context, input, Toast.LENGTH_SHORT);
                    mToast.setGravity(Gravity.CENTER, 0, 0);
                    CountDownTimer toastCountDown;
                    int toastDurationInMilliSeconds = 1000;
                    toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 100) { /*Tick duration*/
                        public void onTick(long millisUntilFinished) {
                            mToast.show();
                        }

                        public void onFinish() {
                            mToast.cancel();
                        }
                    };
                    mToast.show();
                    toastCountDown.start();
                }
            }
        } catch (Exception e) {
            UiUtils.appErrorLog(TAG, "Toast Ex : " + e.getMessage());
        }
    }

    public static void appLog(String tag, String msg) {
        try {
            Log.v(tag, msg);
        } catch (Exception e) {
            //Crashlytics.logException(e);
            e.printStackTrace();
        }
    }

    public static void appErrorLog(String tag, String msg) {
        try {
            Log.e(tag, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getDoubleAmount(String s) {
        s = s.replaceAll(",", "");
        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
        decimalFormat.setMaximumFractionDigits(2);
        Double returnAmount = 0.00;
        if (!TextUtils.isEmpty(s)) {
            try {
                returnAmount = Double.parseDouble(decimalFormat.format(Double.valueOf(s)));
            } catch (Exception e) {
                UiUtils.appErrorLog("getDoubleAmount", e.getMessage());
            }
        }
        return returnAmount;
    }

    public static double getAmount(Double s) {
        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
        decimalFormat.setMaximumFractionDigits(2);
        Double returnAmount = 0.00;
        if (s != null) {
            try {
                returnAmount = Double.parseDouble(decimalFormat.format(s));
            } catch (Exception e) {
                UiUtils.appErrorLog("getToAccCurencyAmount", e.getMessage());
            }
        }
        return returnAmount;
    }

    public static int getIntFromString(String s) {
        int i = 0;
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {
            UiUtils.appErrorLog("getIntParse", e.getMessage());
        }
        return i;
    }

    public static Drawable getDrawable(Resources resources, int id) {
        return ResourcesCompat.getDrawable(resources, id, null);
    }

    public static int getColor(Resources resources, int id) {
        return ResourcesCompat.getColor(resources, id, null);
    }

    public static String removeDot(String txt) {
        String inputValue = TextUtils.getString(txt);
        String returnValue = inputValue;
        try {
            if (!TextUtils.isEmpty(inputValue) && inputValue.contains(".")) {
                String[] separated = inputValue.split("\\.");
                String prefix = separated[0];
                String suffix = TextUtils.getString(separated[1]);
                if (suffix.length() == 0 || (suffix.equals("0") || suffix.equals("00"))) {
                    returnValue = prefix;
                } else {
                    returnValue = inputValue;
                }
            } else {

                returnValue = inputValue;
            }
        } catch (Exception e) {
            UiUtils.appErrorLog("removeDot", e.getMessage());
        }

        return returnValue;
    }

    public static void setHtmlString(TextView textView, String msg) {
        String message = TextUtils.getString(msg);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(message));
        } else {
            textView.setText(Html.fromHtml(message, Html.FROM_HTML_MODE_COMPACT));
        }
    }
}
