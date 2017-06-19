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
        //Ҫ��ʾͼ���View
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
        //ÿ�������ɫ
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };
		//��Ⱦ��
		DefaultRenderer renderer = new DefaultRenderer();
		//��ǩ���ִ�С
		renderer.setLabelsTextSize(15);
		//��ǩ��ɫ
	    renderer.setLabelsColor(Color.BLACK);
		//˵�����ִ�С
		renderer.setLegendTextSize(15);
		for (int color : colors) {
			  //����SimpleSeriesRenderer����
		      SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		      r.setColor(color);
		      renderer.addSeriesRenderer(r);
		}
		renderer.setChartTitleTextSize(20);
		//�������������
		CategorySeries series = new CategorySeries("֧�����");
		series.add("ס��", 28);
		series.add("ʳ��", 25);
		series.add("ˮ��", 2);
		series.add("����", 20);
		series.add("��װ", 25);
		//��ȡͼ��View
	    View chart = ChartFactory.getPieChartView(this,series,renderer);
	    //����ͼ��ı�����ɫ
	    chart.setBackgroundColor(Color.rgb(222, 222, 200));
        linearLayout.addView(chart);
    }
    
}