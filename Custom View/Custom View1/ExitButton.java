package in.bitcode.customview1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class ExitButton extends Button {

    private boolean mExitable;

    public ExitButton(Context context) {
        super(context);
        hookup();
    }

    public ExitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        hookup();

    }

    private void hookup() {
        mExitable = true;
        this.setOnClickListener( new ExitButtonClickListener() );
    }

    public void setExitable( boolean exitable ) {
        mExitable = exitable;
    }

    public boolean isExitable() {
        return mExitable;
    }

    private class ExitButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if( mExitable == true ) {
                System.exit(0);
            }
        }
    }
}
