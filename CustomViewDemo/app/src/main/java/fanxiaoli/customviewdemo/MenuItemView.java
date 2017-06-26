package fanxiaoli.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MenuItemView extends RelativeLayout {

    ImageView iconLeft;
    ImageView iconRight;
    TextView menuTextRight;
    TextView menuTextLeft;

    public MenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.menuitem_layout, this);

        iconLeft = getView(R.id.icon_left);
        iconRight = getView(R.id.icon_right);
        menuTextLeft = getView(R.id.menu_text_left);
        menuTextRight = getView(R.id.menu_text_right);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MenuItemView);
        int rightTextColor = ta.getColor(R.styleable.MenuItemView_rightTextColor, Color.GRAY);
        int leftTextColor = ta.getColor(R.styleable.MenuItemView_leftTextColor, Color.BLACK);
        menuTextRight.setTextColor(rightTextColor);
        menuTextLeft.setTextColor(leftTextColor);

        float textSize = ta.getDimension(R.styleable.MenuItemView_textSize, getResources().getDimension(R.dimen.default_text_size));
        menuTextLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        menuTextRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        int leftIconId = ta.getResourceId(R.styleable.MenuItemView_leftIcon, R.mipmap.icon0);
        iconLeft.setImageResource(leftIconId);
        int rightIconId = ta.getResourceId(R.styleable.MenuItemView_rightIcon, R.mipmap.icon_right);
        iconRight.setImageResource(rightIconId);

        String text = ta.getString(R.styleable.MenuItemView_text);
        if (text != null) {
            menuTextLeft.setText(text);
        }
        ta.recycle();

    }

    public CharSequence getMenuTextRight() {
        return menuTextRight.getText();
    }

    public void setMenuTextRight(String text) {
        menuTextRight.setText(text);
    }

    public CharSequence getMenuTextLeft() {
        return menuTextLeft.getText();
    }

    public void setMenuTextLeft(String text) {
        menuTextLeft.setText(text);
    }

    public <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
