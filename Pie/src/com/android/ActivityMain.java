package com.android;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityMain extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //要显示图表的View
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
        //每个块的颜色
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };
		//渲染器
		DefaultRenderer renderer = new DefaultRenderer();
		//标签文字大小
		renderer.setLabelsTextSize(15);
		//标签颜色
	    renderer.setLabelsColor(Color.BLACK);
		//说明文字大小
		renderer.setLegendTextSize(15);
		for (int color : colors) {
			  //创建SimpleSeriesRenderer对象
		      SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		      r.setColor(color);
		      renderer.addSeriesRenderer(r);
		}
		renderer.setChartTitleTextSize(20);
		//创建数据填充器
		CategorySeries series = new CategorySeries("支出情况");
		series.add("住房", 28);
		series.add("食物", 25);
		series.add("水电", 2);
		series.add("娱乐", 20);
		series.add("服装", 25);
		//获取图表View
	    View chart = ChartFactory.getPieChartView(this,series,renderer);
	    //设置图表的背景颜色
	    chart.setBackgroundColor(Color.rgb(222, 222, 200));
        linearLayout.addView(chart);
    }
    
}