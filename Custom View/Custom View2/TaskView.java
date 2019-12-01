package in.bitcode.customview2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class TaskView extends TextView {

    private Task mTask;
    private Paint mPaint;

    public TaskView(Context context) {
        super(context);
        hookup();
    }

    public TaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        hookup();
    }

    private void hookup() {
        setTextSize( 30 );
        setPadding( 60, 10, 10, 10 );
        mPaint = new Paint();
        mPaint.setColor( Color.RED );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.e("tag", "onDraw()");

        canvas.drawLine( 30, 0, 30, getBottom(), mPaint );
        canvas.drawLine( 40, 0, 40, getBottom(), mPaint );
    }

    public void setTask(Task task ) {

        mTask = task;
        this.setText( task.getTitle() );

        if( task.isIsDone() ) {
            setTextColor(Color.GREEN );
        }
        else {
            setTextColor(Color.RED );
        }
    }
}
