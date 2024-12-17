package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final CalendarConstraints constraints;
    /* access modifiers changed from: private */
    public final DateFormat dateFormat;
    /* access modifiers changed from: private */
    public final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    /* access modifiers changed from: private */
    public final TextInputLayout textInputLayout;

    DateFormatTextWatcher(final String formatHint, DateFormat dateFormat2, TextInputLayout textInputLayout2, CalendarConstraints constraints2) {
        this.dateFormat = dateFormat2;
        this.textInputLayout = textInputLayout2;
        this.constraints = constraints2;
        this.outOfRange = textInputLayout2.getContext().getString(R.string.f2061mtrl_picker_out_of_range);
        this.setErrorCallback = new Runnable() {
            public void run() {
                TextInputLayout access$000 = DateFormatTextWatcher.this.textInputLayout;
                DateFormat access$100 = DateFormatTextWatcher.this.dateFormat;
                Context context = access$000.getContext();
                String string = context.getString(R.string.f2056mtrl_picker_invalid_format);
                String format = String.format(context.getString(R.string.f2058mtrl_picker_invalid_format_use), new Object[]{formatHint});
                Log3FA212.a((Object) format);
                LogEB28DF.a((Object) format);
                Log390828.a((Object) format);
                Log952E92.a((Object) format);
                String format2 = String.format(context.getString(R.string.f2057mtrl_picker_invalid_format_example), new Object[]{access$100.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis()))});
                Log3FA212.a((Object) format2);
                LogEB28DF.a((Object) format2);
                Log390828.a((Object) format2);
                Log952E92.a((Object) format2);
                access$000.setError(string + "\n" + format + "\n" + format2);
                DateFormatTextWatcher.this.onInvalidDate();
            }
        };
    }

    private Runnable createRangeErrorCallback(final long milliseconds) {
        return new Runnable() {
            public void run() {
                TextInputLayout access$000 = DateFormatTextWatcher.this.textInputLayout;
                String access$200 = DateFormatTextWatcher.this.outOfRange;
                Log3FA212.a((Object) access$200);
                LogEB28DF.a((Object) access$200);
                Log390828.a((Object) access$200);
                Log952E92.a((Object) access$200);
                String dateString = DateStrings.getDateString(milliseconds);
                Log3FA212.a((Object) dateString);
                LogEB28DF.a((Object) dateString);
                Log390828.a((Object) dateString);
                Log952E92.a((Object) dateString);
                String format = String.format(access$200, new Object[]{dateString});
                Log3FA212.a((Object) format);
                LogEB28DF.a((Object) format);
                Log390828.a((Object) format);
                Log952E92.a((Object) format);
                access$000.setError(format);
                DateFormatTextWatcher.this.onInvalidDate();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void onInvalidDate() {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError((CharSequence) null);
        onValidDate((Long) null);
        if (!TextUtils.isEmpty(s)) {
            try {
                Date parse = this.dateFormat.parse(s.toString());
                this.textInputLayout.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.constraints.getDateValidator().isValid(time) || !this.constraints.isWithinBounds(time)) {
                    Runnable createRangeErrorCallback = createRangeErrorCallback(time);
                    this.setRangeErrorCallback = createRangeErrorCallback;
                    runValidation(this.textInputLayout, createRangeErrorCallback);
                    return;
                }
                onValidDate(Long.valueOf(parse.getTime()));
            } catch (ParseException e) {
                runValidation(this.textInputLayout, this.setErrorCallback);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void onValidDate(Long l);

    public void runValidation(View view, Runnable validation) {
        view.postDelayed(validation, 1000);
    }
}
