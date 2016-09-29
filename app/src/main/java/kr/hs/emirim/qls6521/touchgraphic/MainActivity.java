package kr.hs.emirim.qls6521.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    static final int LINE=1,RECT=2,CIRCLE=3;
    int chooseShape=CIRCLE;
    DrawShape ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//객체생성
        LinearLayout linear=(LinearLayout)findViewById(R.id.linear_view);
        ds=new DrawShape(getApplicationContext());
        linear.addView(ds);
    }

    public void drawShape(View v){
        switch(v.getId()) {
            case R.id.but_line:
                chooseShape = LINE;
                break;
            case R.id.but_rect:
                chooseShape = RECT;
                break;
            case R.id.but_circle:
                chooseShape = CIRCLE;
                break;
        }
        ds.invalidate();
    }

    class DrawShape extends View{
        DrawShape(Context context){
            super(context);//상속을 받았으면 부모 객체 생성을 위한 super를 써줘야함 왜냐면 default생성자가 없기때문이다
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float cx=getWidth()/2.0f;
            float cy=getHeight()/2.0f;
            Paint paint=new Paint();

            switch(chooseShape){
                case LINE:
                    paint.setStrokeWidth(7);
                    canvas.drawLine(50,100,650,100,paint);
                    break;
                case RECT:
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(100,100,500,250,paint);
                    break;
                case CIRCLE:
                    canvas.drawCircle(cx,cy,200,paint);
                    break;
            }


        }
    }
}
