package kr.hs.emirim.qls6521.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawShape(getApplicationContext()));//객체생성
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
            canvas.drawCircle(cx,cy,50,paint);
        }
    }
}
