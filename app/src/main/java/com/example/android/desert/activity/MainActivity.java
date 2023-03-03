package com.example.android.desert.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.desert.R;
import com.example.android.desert.entity.enumeration.BlockRelationEnum;
import com.example.android.desert.entity.enumeration.DesertMapBlockEnum;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // view
    private ImageView desertMap;
    // view的宽度
    float imageViewWidth;
    // view的高度
    float imageViewHeight;
    // 图片的宽度
    float imageWidth;
    // 图片的高度
    float imageHeight;
    // 本次点击的块
    DesertMapBlockEnum recentBlock;
    // 上一次次点击的块
    DesertMapBlockEnum preciousBlock;
    DecimalFormat f = new DecimalFormat("#0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        desertMap = (ImageView) findViewById(R.id.desert_map);
        ViewGroup.LayoutParams lp = desertMap.getLayoutParams();

        desertMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP://抬起的时候
                        onSingleTap(motionEvent);
                        break;
                }
                return true;
            }
        });

        recentBlock = DesertMapBlockEnum.D1;
    }

    public void loadLength() {
        if (imageHeight == 0) {
            /* 获取ImageView的实际宽度* */
            imageViewWidth = desertMap.getWidth();
            imageViewHeight = desertMap.getHeight();
            //获得ImageView中Image的真实宽高，
//            imageWidth = desertMap.getDrawable().getBounds().width();
//            imageHeight = desertMap.getDrawable().getBounds().height();
        }
    }


    public void onSingleTap(MotionEvent e) {
        loadLength();
        Log.i("onSingleTap", "imageViewWidth: " + imageViewWidth + ", imageViewHeight: " + imageViewHeight);
//        Log.i("onSingleTap", "imageWidth = " + imageWidth + ", imageHeight = " + imageHeight);

        // 获取触摸点的坐标 x, y
        float x = e.getX();
        float y = e.getY();
        // 目标点的坐标
        float dst[] = new float[2];
        // 获取到ImageView的matrix
        Matrix imageMatrix = desertMap.getImageMatrix();
        // 创建一个逆矩阵
        Matrix inverseMatrix = new Matrix();
        // 求逆，逆矩阵被赋值
        imageMatrix.invert(inverseMatrix);
        // 通过逆矩阵映射得到目标点 dst 的值
        inverseMatrix.mapPoints(dst, new float[]{x, y});
        // 判断dstX, dstY在Bitmap上的位置即可
        float dstX = dst[0];
        float dstY = dst[1];
        // Log.i("OnTouchListener", "dstX: " + dstX + " +++ dstY: " + dstY);


        double proportionX = 100 * dstX / imageViewWidth;
        double proportionY = 100 * dstY / imageViewHeight;

//        Log.i("OnTouchListener", " proportionX and proportionY:" + f.format(proportionX) + ", " + f.format(proportionY) + ", ");
        preciousBlock = recentBlock;
        DesertMapBlockEnum tempBlock = DesertMapBlockEnum.inWhichBlock(proportionX, proportionY);
        Log.i("OnTouchListener", "dstX: " + dstX + " +++ dstY: " + dstY);
        Log.i("OnTouchListener", "点击了" + tempBlock.getDesc());
        if (recentBlock.isAdjacent(tempBlock)) {
            Toast.makeText(this, "点击了" + tempBlock.getDesc() + "，移动", Toast.LENGTH_SHORT).show();
            preciousBlock = recentBlock;
            recentBlock = tempBlock;
        } else {
            Toast.makeText(this, "点击了" + tempBlock.getDesc() + "，不可以移动！！！，还在" + recentBlock.getDesc(), Toast.LENGTH_SHORT).show();

        }

    }
}