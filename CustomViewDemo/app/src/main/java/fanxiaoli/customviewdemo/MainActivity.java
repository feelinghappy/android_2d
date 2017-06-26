package fanxiaoli.customviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MenuItemView menuItemView;
    MenuItemView menuItemView1;
    MenuItemView menuItemView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItemView = getView(R.id.menu);
        menuItemView1 = getView(R.id.menu1);
        menuItemView2 = getView(R.id.menu2);

        menuItemView.setOnClickListener(this );
        menuItemView1.setOnClickListener(this );
        menuItemView2.setOnClickListener(this );


        menuItemView1.setMenuTextRight("0.00元");
        menuItemView2.setMenuTextRight("古铜色会员");
    }

    public <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu:
                Toast.makeText(this, "蚂蚁花呗", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu1:
                Toast.makeText(this, "余额", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "蚂蚁会员", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
