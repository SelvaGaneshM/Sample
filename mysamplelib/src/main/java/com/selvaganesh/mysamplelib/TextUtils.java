package com.selvaganesh.mysamplelib;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String getLocalString(Object input) {
        return input.toString().trim();
    }

    public static int getInt(Object input) {
        try {
            return input == null ? 0 : (int) input;
        } catch (Exception e) {
            return 0;
        }
    }

    public static long getLong(Object input) {
        try {
            return input == null ? 0 : (long) input;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double getDouble(Double value) {
        return value == null ? 0.0 : value;
    }

    public static String getString(Object input) {
        return input == null ? "" : input.toString().trim().equals("") ? "" :
                input.toString().trim().equalsIgnoreCase("null") ? "" : input.toString().trim();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(.\\d+)?");
    }

    public static String getFirstChar(String sss) {
        String returnString = "";
        if (!TextUtils.isEmpty(sss)) {
            try {
                /*Pattern p = Pattern.compile("\\b[a-zA-Z]");
                Matcher m = p.matcher(sss);

                while (m.find()) {
                    returnString += m.group();
                }*/

                for (String s : sss.split(" ")) {
                    returnString += s.charAt(0);
                }


                if (returnString.equals("+")) {
                    returnString = sss.substring(1, 2);
                }

                if (returnString.length() > 2) {
                    returnString = returnString.substring(0, 2);
                }

                if (TextUtils.isEmpty(returnString)) {
                    returnString = "Z";
                }

            } catch (Exception e) {
                UiUtils.appErrorLog("TextUtils", e.getMessage());
            }
        }
        return getString(returnString).toUpperCase();

    }


    public static SpannableStringBuilder getColorText(Context context, String filterString, String actualString, int textColor) {


        SpannableStringBuilder sb = new SpannableStringBuilder(TextUtils.getString(actualString));
        try {
            Pattern word = Pattern.compile(TextUtils.getString(filterString).toLowerCase());
            Matcher match = word.matcher(actualString.toLowerCase());
            while (match.find()) {
                ForegroundColorSpan fcs = new ForegroundColorSpan(
                        ContextCompat.getColor(context, textColor)); //specify color here
                sb.setSpan(fcs, match.start(), match.end(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }
        } catch (Exception e) {
            UiUtils.appErrorLog("TextUtils", e.getMessage());
        }
        return sb;

    }

    /**
     * Returns whether the given CharSequence contains only digits.
     */
    public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!Character.isDigit(cp)) {
                return false;
            }
        }
        return true;
    }


}
