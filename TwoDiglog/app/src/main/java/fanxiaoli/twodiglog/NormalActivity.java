package fanxiaoli.twodiglog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class NormalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }
}