package fanxiaoli.barchart;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
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


        //要显示图形的View
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
        //说明文字
        String[] titles = new String[] { "上周", "本周" };
        //柱状图数据
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 14230, 12300, 14240, 15244, 15900, 17200, 12030});
        values.add(new double[] { 5230, 7300, 9240, 10540, 7900, 9200, 13030});
        //柱体颜色
        int[] colors = new int[] { Color.GREEN, Color.rgb(200, 150, 0) };
        //创建渲染器
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            //创建SimpleSeriesRenderer单一渲染器
            XYSeriesRenderer r = new XYSeriesRenderer();
            //SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            //设置渲染器颜色
            r.setColor(colors[i]);
            //加入到集合中
            renderer.addSeriesRenderer(r);
        }
        //坐标轴标题文字大小
        renderer.setAxisTitleTextSize(20);
        //图形标题文字大小
        renderer.setChartTitleTextSize(30);
        //轴线上标签文字大小
        renderer.setLabelsTextSize(25);
        //说明文字大小
        renderer.setLegendTextSize(25);
        //图表标题
        renderer.setChartTitle("两周内销售额统计");
        //X轴标题
        renderer.setXTitle("星期");
        //Y轴标题
        renderer.setYTitle("销售金额");
        //X轴最小坐标点
        renderer.setXAxisMin(0.5);
        //X轴最大坐标点
        renderer.setXAxisMax(7.5);
        //Y轴最小坐标点
        renderer.setYAxisMin(0);
        //Y轴最大坐标点
        renderer.setYAxisMax(24000);
        //坐标轴颜色
        renderer.setAxesColor(Color.GRAY);
        //标签颜色
        renderer.setLabelsColor(Color.LTGRAY);
        //设置字体加粗
        renderer.setTextTypeface("sans_serif", Typeface.BOLD);
        //设置在图表上是否显示值标签
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        //显示屏幕可见取区的XY分割数
        renderer.setXLabels(7);
        renderer.setYLabels(10);
        //X刻度标签相对X轴位置
        renderer.setXLabelsAlign(Paint.Align.CENTER);
        //Y刻度标签相对Y轴位置
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        renderer.setPanEnabled(false, false);
        renderer.setZoomEnabled(true);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomRate(1.1f);
        renderer.setBarSpacing(0.5f);
        //显示表格线
        renderer.setShowGrid(true);
        //创建渲染器数据填充器
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
        //获取图形View
        View chart = ChartFactory.getBarChartView(this,mXYMultipleSeriesDataset,renderer,
                BarChart.Type.DEFAULT);
        linearLayout.addView(chart);

    }
}
