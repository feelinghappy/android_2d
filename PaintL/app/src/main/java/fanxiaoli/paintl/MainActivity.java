package fanxiaoli.paintl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawView mDrawView = new DrawView(this);
        setContentView(mDrawView);
    }
}
