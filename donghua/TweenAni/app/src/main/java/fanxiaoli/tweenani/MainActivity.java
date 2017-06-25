package fanxiaoli.tweenani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取ImageView
        final ImageView iv = (ImageView)this.findViewById(R.id.mImageView);
        //淡出图片按钮
        Button alphaBtn = (Button)this.findViewById(R.id.alphaBtn);
        alphaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //定义Animation对象
                //Animation scale = AnimationUtils.loadAnimation(ActivityMain.this, R.anim.alpha_out);
                //开始动画
                //iv.startAnimation(scale);
                //创建AnimationSet对象
                AnimationSet animationSet = new AnimationSet(true);
                //创建AlphaAnimation对象
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.1f);
                //设置动画持续
                alphaAnimation.setDuration(500);
                //添加到AnimationSet
                animationSet.addAnimation(alphaAnimation);
                //开始动画
                iv.startAnimation(animationSet);
            }
        });


        //缩放按钮
        Button scaleBtn = (Button)this.findViewById(R.id.scaleBtn);
        scaleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //定义Animation对象
                //Animation scale = AnimationUtils.loadAnimation(ActivityMain.this, R.anim.scale_out);
                //开始动画
                //iv.startAnimation(scale);
                //创建AnimationSet对象
                AnimationSet animationSet = new AnimationSet(true);
                //创建ScaleAnimation对象
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,0.5f,1.0f,0.5f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                //设置动画持续
                scaleAnimation.setDuration(500);
                scaleAnimation.setRepeatCount(5);
                //动画插入器
                scaleAnimation.setInterpolator(MainActivity.this, android.R.anim.decelerate_interpolator);
                //添加到AnimationSet
                animationSet.addAnimation(scaleAnimation);
                //开始动画
                iv.startAnimation(animationSet);
            }
        });

        //平移按钮
        Button translateBtn = (Button)this.findViewById(R.id.translateBtn);
        translateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //定义Animation对象
                //Animation scale = AnimationUtils.loadAnimation(ActivityMain.this, R.anim.translate);
                //开始动画
                //iv.startAnimation(scale);
                //创建AnimationSet对象
                AnimationSet animationSet = new AnimationSet(true);
                //创建TranslateAnimation对象
                TranslateAnimation translateAnimation = new TranslateAnimation(10,100,10,100);
                //设置动画持续
                translateAnimation.setDuration(5000);
                //动画插入器
                translateAnimation.setInterpolator(MainActivity.this, android.R.anim.decelerate_interpolator);
                //添加到AnimationSet
                animationSet.addAnimation(translateAnimation);
                //开始动画
                iv.startAnimation(animationSet);
            }
        });

        //旋转按钮
        Button rotateBtn = (Button)this.findViewById(R.id.rotateBtn);
        rotateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //定义Animation对象
                //Animation scale = AnimationUtils.loadAnimation(ActivityMain.this, R.anim.rotate);
                //开始动画
                //iv.startAnimation(scale);
                //创建AnimationSet对象
                AnimationSet animationSet = new AnimationSet(true);
                //创建RotateAnimation对象
                RotateAnimation rotateAnimation = new RotateAnimation(0f,+360f,
                        Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                //设置动画持续
                rotateAnimation.setDuration(5000);
                //动画插入器
                rotateAnimation.setInterpolator(MainActivity.this, android.R.anim.decelerate_interpolator);
                //添加到AnimationSet
                animationSet.addAnimation(rotateAnimation);
                //开始动画
                iv.startAnimation(animationSet);
            }
        });
    }
}
