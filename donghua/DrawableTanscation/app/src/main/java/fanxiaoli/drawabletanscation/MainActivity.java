package fanxiaoli.drawabletanscation;

import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        mLinearLayout = new LinearLayout(this);
        ImageView i = new ImageView(this);
        i.setAdjustViewBounds(true);
        i.setLayoutParams(new Gallery.LayoutParams
                (Gallery.LayoutParams.WRAP_CONTENT,Gallery.LayoutParams.WRAP_CONTENT));
        mLinearLayout.addView(i);
        setContentView(mLinearLayout);
        Resources res = getResources();
        TransitionDrawable transitionDrawable = (TransitionDrawable)res.getDrawable(R.drawable.expand_collapse);
        i.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(10000);
    }
}
