package fanxiaoli.paintl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    private Paint mPaint = null;

    public DrawView(Context context) {
        super(context);
        mPaint =new Paint();
        new Thread().start();
    }
    public void  onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setColor(Color.BLUE);
        mPaint.setColor(Color.YELLOW);
        mPaint.setColor(Color.GREEN);

        mPaint.setColor(Color.rgb(255,0,0));
        Color.red(0xcccccc);
        Color.green(0xcccccc);

        mPaint.setARGB(255,255,0,0);
        mPaint.setAlpha(220);
        mPaint.setTextSize(14);
        mPaint.setStrokeWidth(5);
        canvas.drawRect((320-80)/2,20,(320-80)/2+80,20+40,mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,20,40,20+40,mPaint);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        return true;
    }
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        return true;
    }
    public  boolean onKeyUp(int keyCode,KeyEvent event)
    {
        return  false;
    }
    public boolean onKeyMultiple(int keyCode,int repeateCount,KeyEvent event)
    {
        return  true;
    }
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupted();
            }
            postInvalidate();
        }
    }

}