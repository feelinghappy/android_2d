package fanxiaoli.table;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //要显示图表的View
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
        //XY坐标轴表示的内容
        String[] titles = new String[] { "您的分数", "行业平均分" };
        //保存折线的点的集合
        List<double[]> values = new ArrayList<double[]>();
        //图表展示几条线
        int length = titles.length;
        //两条折线的XY点
        values.add(new double[] { 91, 91, 92, 93, 93, 92, 94, 91, 91, 93});
        values.add(new double[] { 83, 81, 82, 83, 85, 86, 87, 82, 88, 83});
        //两条折线的颜色
        int[] colors = new int[] { Color.GREEN, Color.rgb(200, 150, 0) };
        //点的样式
        PointStyle[] styles = new PointStyle[] { PointStyle.POINT, PointStyle.POINT };
        //渲染器创建
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        //坐标轴标题文字大小
        renderer.setAxisTitleTextSize(50);
        //图表标题文字大小
        renderer.setChartTitleTextSize(40);
        //轴线上标签文字大小
        renderer.setLabelsTextSize(25);
        //说明文字大小
        renderer.setLegendTextSize(25);
        //设置折点的大小
        renderer.setPointSize(20f);
        //位置Margin值
        renderer.setMargins(new int[] { 20, 30, 15, 20 });
        //设置字体加粗
        renderer.setTextTypeface("sans_serif", Typeface.BOLD);
        //增加二个折线渲染器
        for (int i = 0; i < length; i++) {
            //每条线要有一个子渲染器，可设置不同的颜色，线宽等
            XYSeriesRenderer r = new XYSeriesRenderer();
            //设置线的颜色
            r.setColor(colors[i]);
            //点的样式
            r.setPointStyle(styles[i]);
            //线宽
            r.setLineWidth(5);
            //加 入到集合中
            renderer.addSeriesRenderer(r);
        }
        //图表标题
        renderer.setChartTitle("规则遵守情况");
        //X轴标题
        renderer.setXTitle("期数");
        renderer.setYTitle("得分");
        //X轴最小坐标点
        renderer.setXAxisMin(0);
        //X轴最大坐标点
        renderer.setXAxisMax(12);
        //Y轴最小坐标点
        renderer.setYAxisMin(70);
        //Y轴最大坐标点
        renderer.setYAxisMax(100);
        //坐标轴颜色
        renderer.setAxesColor(Color.BLACK);
        //标签颜色
        renderer.setLabelsColor(Color.GRAY);
        //X轴分割数，即将X轴可见区域自动分为12份
        renderer.setXLabels(12);
        //Y轴分割数，即将Y轴可见区域自动分为3份
        renderer.setYLabels(3);
        //X刻度标签相对X轴位置
        renderer.setXLabelsAlign(Paint.Align.CENTER);
        //Y刻度标签相对Y轴位置
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        //设置XY都不能拖动
        renderer.setPanEnabled(false, false);
        //设置可以缩放
        renderer.setZoomEnabled(true);
        //设置缩放按钮可见
        renderer.setZoomButtonsVisible(true);
        //设置每点击缩放按钮的缩放比例
        renderer.setZoomRate(1.1f);
        //显示格线
        renderer.setShowGrid(true);
        //改变背景色
        //renderer.setApplyBackgroundColor(true);
        //renderer.setBackgroundColor(Color.WHITE);
        //显示折点上的值
        for (int i = 0; i < length; i++) {
            //为每个渲染器都设置显示值
            SimpleSeriesRenderer seriesRenderer = renderer.getSeriesRendererAt(i);
            seriesRenderer.setDisplayChartValues(true);
            seriesRenderer.setChartValuesTextSize(20);
        }
        //创建数据填充器
        XYMultipleSeriesDataset mXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < length; i++) {
            //为每条折线设置数据填充
            CategorySeries series = new CategorySeries(titles[i]);
            //值的数组
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            //将每条线的数组填充器加入到总的集合中
            mXYMultipleSeriesDataset.addSeries(series.toXYSeries());
        }

        //获取图形View
        View chart = ChartFactory.getLineChartView(this,mXYMultipleSeriesDataset,renderer);
        //显示View
        linearLayout.addView(chart);


    }
}
