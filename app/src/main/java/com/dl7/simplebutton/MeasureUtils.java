package com.dl7.simplebutton;

import android.content.Context;
import android.graphics.Paint;
import android.util.TypedValue;

/**
 * Created by Rukey7 on 2016/7/18.
 * 测量帮助类
 */
public class MeasureUtils {

    private MeasureUtils() {
        throw new AssertionError();
    }


    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static float sp2px(Context context, float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * 裁剪Text
     * @param oriText
     * @param paint
     * @param maxTextWidth
     * @return
     */
    public static String clipShowText(String oriText, Paint paint, float maxTextWidth) {
        float tmpWidth = 0;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < oriText.length(); i++) {
            char c = oriText.charAt(i);
            float cWidth = paint.measureText(String.valueOf(c));
            // 计算每个字符的宽度之和，如果超过能显示的长度则退出
            if (tmpWidth + cWidth > maxTextWidth) {
                break;
            }
            strBuilder.append(c);
            tmpWidth += cWidth;
        }
        // 末尾添加3个.并设置为显示字符
        strBuilder.append("...");
        return strBuilder.toString();
    }
}
