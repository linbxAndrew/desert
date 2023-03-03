package com.example.android.desert.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatButton;

import com.example.android.desert.R;

public class CustomButton extends AppCompatButton {

    // 圆角半径
    private float radius = getResources().getDimension(R.dimen.x6);
    // 按钮正常时的背景颜色
    private int normalColor;

    private GradientDrawable gradientDrawable;

    public CustomButton(Context context) {
        this(context, null, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttris(attrs);
        init();
    }

    private void init() {

        setGravity(Gravity.CENTER);
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(normalColor);
        // 这句话一定不要忘记，不然没效果
        setBackground(gradientDrawable);
    }

    /**
     * 属行初始化
     * @param attrs
     */
    private void initAttris(AttributeSet attrs) {
        if (attrs != null) {  // 获取自定义属性
            TypedArray typedArray  = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton);
            radius = (int) typedArray .getDimension(R.styleable.CustomButton_radius, getResources().getDimension(R.dimen.x6));
            int defaultColor = getResources().getColor(R.color.pow_der_blue);
            normalColor = typedArray.getColor(R.styleable.CustomButton_normal_color, defaultColor);
            typedArray.recycle();
        }
    }
}