package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int getItemDefaultMarginResId() {
        return R.dimen.f1232design_bottom_navigation_margin;
    }

    /* access modifiers changed from: protected */
    public int getItemLayoutResId() {
        return R.layout.MT_Bin;
    }
}
