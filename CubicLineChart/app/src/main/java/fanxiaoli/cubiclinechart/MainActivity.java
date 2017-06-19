package fanxiaoli.cubiclinechart;

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
        String[] titles = new String[] { "2009年", "2010年",
                "2009-2010的变化" };
        List<double[]> values = new ArrayList<double[]>();
        //第一条线的值
        values.add(new double[] { 14230, 12300, 14240, 15244, 14900, 12200,
                11030, 12000, 12500, 15500, 14600, 15000 });
        //第二条线的值
        values.add(new double[] { 10230, 10900, 11240, 12540, 13500, 14200,
                12530, 11200, 10500, 12500, 11600, 13500 });
        int length = values.get(0).length;
        //计算点的差值做为第三条
        double[] diff = new double[length];
        for (int i = 0; i < length; i++) {
            diff[i] = values.get(0)[i] - values.get(1)[i];
        }
        //第三条线
        values.add(diff);
        //每条线的颜色
        int[] colors = new int[] { Color.BLUE, Color.CYAN, Color.GREEN };
        //点样式
        PointStyle[] styles = new PointStyle[] { PointStyle.POINT,
                PointStyle.POINT, PointStyle.POINT };
        //渲染器创建
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        //坐标轴标题文字大小
        renderer.setAxisTitleTextSize(25);
        //图表标题文字大小
        renderer.setChartTitleTextSize(30);
        //轴线上标签文字大小
        renderer.setLabelsTextSize(30);
        //说明文字大小
        renderer.setLegendTextSize(30);
        //设置折点的大小
        renderer.setPointSize(15f);
        length = colors.length;
        //添加子渲染器
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(colors[i]);
            r.setPointStyle(styles[i]);
            //将第三条线设置为填充
            r.setFillBelowLine(i == length - 1);
            r.setFillBelowLineColor(colors[i]);
            //线宽
            r.setLineWidth(5f);
            //显示值标签,，及文字大小设置
            r.setDisplayChartValues(true);
            r.setChartValuesTextSize(20f);
            renderer.addSeriesRenderer(r);
        }
        //图表标题
        renderer.setChartTitle("两年的销售额对比");
        //X轴标题
        renderer.setXTitle("月份");
        renderer.setYTitle("销售额");
        //X轴最小坐标点
        renderer.setXAxisMin(0.75);
        //X轴最大坐标点
        renderer.setXAxisMax(12.25);
        //Y轴最小坐标点
        renderer.setYAxisMin(-5000);
        //Y轴最大坐标点
        renderer.setYAxisMax(19000);
        //坐标轴颜色
        renderer.setAxesColor(Color.GRAY);
        //标签颜色
        renderer.setLabelsColor(Color.LTGRAY);
        //设置字体加粗
        renderer.setTextTypeface("sans_serif", Typeface.BOLD);
        //显示屏幕可见区的XY分割数
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        //X刻度标签相对X轴位置
        renderer.setXLabelsAlign(Paint.Align.CENTER);
        //Y刻度标签相对Y轴位置
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        renderer.setPanEnabled(true, false);
        renderer.setZoomEnabled(true);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomRate(1.1f);
        renderer.setBarSpacing(0.5f);
        //数据填充器
        XYMultipleSeriesDataset mXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            mXYMultipleSeriesDataset.addSeries(series.toXYSeries());
        }
        //获取图表View，平滑度为0.5
        View chart = ChartFactory.getCubeLineChartView(this,mXYMultipleSeriesDataset,renderer,0.5f);
        linearLayout.addView(chart);
    }
}
