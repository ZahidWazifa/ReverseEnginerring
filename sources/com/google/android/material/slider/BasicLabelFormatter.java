package com.google.android.material.slider;

import java.util.Locale;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

/* compiled from: 00FC */
public final class BasicLabelFormatter implements LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    public String getFormattedValue(float value) {
        if (value >= 1.0E12f) {
            String format = String.format(Locale.US, "%.1fT", new Object[]{Float.valueOf(value / 1.0E12f)});
            Log3FA212.a((Object) format);
            LogEB28DF.a((Object) format);
            Log390828.a((Object) format);
            Log952E92.a((Object) format);
            return format;
        } else if (value >= 1.0E9f) {
            String format2 = String.format(Locale.US, "%.1fB", new Object[]{Float.valueOf(value / 1.0E9f)});
            Log3FA212.a((Object) format2);
            LogEB28DF.a((Object) format2);
            Log390828.a((Object) format2);
            Log952E92.a((Object) format2);
            return format2;
        } else if (value >= 1000000.0f) {
            String format3 = String.format(Locale.US, "%.1fM", new Object[]{Float.valueOf(value / 1000000.0f)});
            Log3FA212.a((Object) format3);
            LogEB28DF.a((Object) format3);
            Log390828.a((Object) format3);
            Log952E92.a((Object) format3);
            return format3;
        } else if (value >= 1000.0f) {
            String format4 = String.format(Locale.US, "%.1fK", new Object[]{Float.valueOf(value / 1000.0f)});
            Log3FA212.a((Object) format4);
            LogEB28DF.a((Object) format4);
            Log390828.a((Object) format4);
            Log952E92.a((Object) format4);
            return format4;
        } else {
            String format5 = String.format(Locale.US, "%.0f", new Object[]{Float.valueOf(value)});
            Log3FA212.a((Object) format5);
            LogEB28DF.a((Object) format5);
            Log390828.a((Object) format5);
            Log952E92.a((Object) format5);
            return format5;
        }
    }
}
