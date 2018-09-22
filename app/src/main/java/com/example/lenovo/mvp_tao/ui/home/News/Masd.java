package com.example.lenovo.mvp_tao.ui.home.News;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class Masd extends ScrollView {
    public Masd(Context context) {
        super(context);
    }

    public Masd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Masd(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        onTouchEvent(event);
        return super.onInterceptHoverEvent(event);
    }
}
