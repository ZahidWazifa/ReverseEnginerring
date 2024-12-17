package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

/* compiled from: 00F9 */
public class MaterialAttributes {
    public static TypedValue resolve(Context context, int attributeResId) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int attributeResId, boolean defaultValue) {
        TypedValue resolve = resolve(context, attributeResId);
        return (resolve == null || resolve.type != 18) ? defaultValue : resolve.data != 0;
    }

    public static boolean resolveBooleanOrThrow(Context context, int attributeResId, String errorMessageComponent) {
        return resolveOrThrow(context, attributeResId, errorMessageComponent) != 0;
    }

    public static int resolveDimension(Context context, int attributeResId, int defaultDimenResId) {
        TypedValue resolve = resolve(context, attributeResId);
        return (resolve == null || resolve.type != 5) ? (int) context.getResources().getDimension(defaultDimenResId) : (int) resolve.getDimension(context.getResources().getDisplayMetrics());
    }

    public static int resolveInteger(Context context, int attributeResId, int defaultValue) {
        TypedValue resolve = resolve(context, attributeResId);
        return (resolve == null || resolve.type != 16) ? defaultValue : resolve.data;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        return resolveDimension(context, R.attr.f535minTouchTargetSize, R.dimen.f1595mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(Context context, int attributeResId, String errorMessageComponent) {
        TypedValue resolve = resolve(context, attributeResId);
        if (resolve != null) {
            return resolve.data;
        }
        String format = String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{errorMessageComponent, context.getResources().getResourceName(attributeResId)});
        Log3FA212.a((Object) format);
        LogEB28DF.a((Object) format);
        Log390828.a((Object) format);
        Log952E92.a((Object) format);
        throw new IllegalArgumentException(format);
    }

    public static int resolveOrThrow(View componentView, int attributeResId) {
        return resolveOrThrow(componentView.getContext(), attributeResId, componentView.getClass().getCanonicalName());
    }
}
