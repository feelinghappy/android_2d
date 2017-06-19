package com.android;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.BubbleChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityMain extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //要显示图形的View
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
		//说明文字
		String[] titles = new String[] { "您的分数"};
		//x轴标签
		List<double[]> x = new ArrayList<double[]>();
		for (int i = 0; i < titles.length; i++) {
		      x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
		}
		//数据
		List<double[]> values = new ArrayList<double[]>();
		//第一条线的值
		values.add(new double[] { 12.3, 12.5, 13.8, 16.8, 20.4, 24.4, 26.4, 26.1, 23.6, 20.3, 17.2,
		        13.9 });
		//颜色
		int[] colors = new int[] { Color.GREEN};
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE};
	    //创建渲染器
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		//坐标轴标题文字大小
		renderer.setAxisTitleTextSize(16);
		//图形标题文字大小
		renderer.setChartTitleTextSize(20);
		//轴线上标签文字大小
		renderer.setLabelsTextSize(15);
		//说明文字大小
		renderer.setLegendTextSize(15);  
		//设置折点的大小
		renderer.setPointSize(5f);
		//位置Margin值
		renderer.setMargins(new int[] { 20, 30, 15, 20 });
		int length = colors.length;
		//添加渲染器，一条曲线
		for (int i = 0; i < length; i++) {
		      XYSeriesRenderer r = new XYSeriesRenderer();
		      r.setColor(colors[i]);
		      r.setPointStyle(styles[i]);
		      r.setLineWidth(3);
		      r.setFillPoints(true);
		      renderer.addSeriesRenderer(r);
		}
		//图表标题
	    renderer.setChartTitle("规则遵守");
	    //X轴标题
	    renderer.setXTitle("期数");
	    //Y轴标题
	    renderer.setYTitle("得分");
	    //X轴最小坐标点
	    renderer.setXAxisMin(0.5);
	    //X轴最大坐标点
	    renderer.setXAxisMax(12.5);
	    //Y轴最小坐标点
	    renderer.setYAxisMin(0);
	    //Y轴最大坐标点
	    renderer.setYAxisMax(40);
	    //坐标轴颜色
	    renderer.setAxesColor(Color.GRAY);
	    //标签颜色
	    renderer.setLabelsColor(Color.LTGRAY);
	    //设置字体加粗
		renderer.setTextTypeface("sans_serif", Typeface.BOLD);
		//设置在图形上是否显示值标签
	    renderer.getSeriesRendererAt(0).setDisplayChartValues(false);
	    //显示屏幕可见区的XY分割数
	    renderer.setXLabels(12);
	    renderer.setYLabels(10);
	    //X刻度标签相对X轴位置
	    renderer.setXLabelsAlign(Align.CENTER);
	    //Y刻度标签相对Y轴位置
	    renderer.setYLabelsAlign(Align.LEFT);
	    //显示表格线
	    renderer.setShowGrid(true);
	    renderer.setZoomButtonsVisible(true);
	    renderer.setPanLimits(new double[] { -10, 20, -10, 40 });
	    renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });
	    //柱体的间距
	    renderer.setBarSpacing(0.5);
	    //柱状图渲染器
	    XYSeriesRenderer histogramRenderer = new XYSeriesRenderer();
	    histogramRenderer.setColor(Color.argb(250, 0, 210, 250));
	    histogramRenderer.setDisplayChartValues(true);
	    histogramRenderer.setChartValuesTextSize(10);
	    //添加柱形渲染器
	    renderer.addSeriesRenderer(histogramRenderer);
	    //创建数据填充器
	    XYMultipleSeriesDataset mXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
	    //添加曲线数据
	    for (int i = 0; i < length; i++) {
	        XYSeries series = new XYSeries(titles[i],0);
	        double[] xV = x.get(i);
	        double[] yV = values.get(i);
	        int seriesLength = xV.length;
	        for (int k = 0; k < seriesLength; k++) {
	          series.add(xV[k], yV[k]);
	        }
	        mXYMultipleSeriesDataset.addSeries(series);
	    }
	    //柱状图数据填充器
	    XYSeries histogramSeries = new XYSeries("行业平均分");
	    histogramSeries.add(1, 12.3);
	    histogramSeries.add(2, 12.5);
	    histogramSeries.add(3, 13.8);
	    histogramSeries.add(4, 16.8);
	    histogramSeries.add(5, 20.4);
	    histogramSeries.add(6, 24.4);
	    histogramSeries.add(7, 26.4);
	    histogramSeries.add(8, 26.1);
	    histogramSeries.add(9, 23.6);
	    histogramSeries.add(10, 20.3);
	    histogramSeries.add(11, 17.2);
	    histogramSeries.add(12, 13.9);
	    //添加柱形数据填充器
	    mXYMultipleSeriesDataset.addSeries(histogramSeries);
	    //组合图的类型 注意顺序和XYMultipleSeriesDataset,XYMultipleSeriesRenderer添加的顺序一致
	    String[] types = new String[] {LineChart.TYPE,BarChart.TYPE};
	    //获取图表View
	    View chart = ChartFactory.getCombinedXYChartView(this,mXYMultipleSeriesDataset,renderer,
	    		types);
        linearLayout.addView(chart);
    }
    
}