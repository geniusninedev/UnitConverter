package com.nineinfosys.unitconverter.Supporter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.nineinfosys.unitconverter.R;

/**
 * Created by Diego on 17/03/17.
 */

public class RomanTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint paint = new Paint();
    private int thousandLineIndex;
    private int strokeWidth;

    public RomanTextView(Context context) {
        super(context);
    }

    public RomanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttributes(attrs, context);
    }

    public RomanTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadAttributes(attrs, context);
    }

    private void loadAttributes(AttributeSet attrs, Context context) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RomanTextView,
                0, 0);

        try {
            strokeWidth = a.getInt(R.styleable.RomanTextView_strokeWidth, 15);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (thousandLineIndex > 0) {
            paint.setColor(getPaint().getColor());
            paint.setStrokeWidth(strokeWidth);

            int startX = (int) this.getLayout().getSecondaryHorizontal(0);
            int stopX = (int) this.getLayout().getSecondaryHorizontal(thousandLineIndex);

            canvas.drawLine(startX, 0, stopX, 0, paint);
        }

        super.onDraw(canvas);
    }

    public void showThousandLine(int untilIndex) {
        this.thousandLineIndex = untilIndex;
    }
}
