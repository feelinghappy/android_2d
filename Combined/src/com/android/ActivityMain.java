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
        //Ҫ��ʾͼ�ε�View
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearId);
		//˵������
		String[] titles = new String[] { "���ķ���"};
		//x���ǩ
		List<double[]> x = new ArrayList<double[]>();
		for (int i = 0; i < titles.length; i++) {
		      x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
		}
		//����
		List<double[]> values = new ArrayList<double[]>();
		//��һ���ߵ�ֵ
		values.add(new double[] { 12.3, 12.5, 13.8, 16.8, 20.4, 24.4, 26.4, 26.1, 23.6, 20.3, 17.2,
		        13.9 });
		//��ɫ
		int[] colors = new int[] { Color.GREEN};
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE};
	    //������Ⱦ��
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		//������������ִ�С
		renderer.setAxisTitleTextSize(16);
		//ͼ�α������ִ�С
		renderer.setChartTitleTextSize(20);
		//�����ϱ�ǩ���ִ�С
		renderer.setLabelsTextSize(15);
		//˵�����ִ�С
		renderer.setLegendTextSize(15);  
		//�����۵�Ĵ�С
		renderer.setPointSize(5f);
		//λ��Marginֵ
		renderer.setMargins(new int[] { 20, 30, 15, 20 });
		int length = colors.length;
		//�����Ⱦ����һ������
		for (int i = 0; i < length; i++) {
		      XYSeriesRenderer r = new XYSeriesRenderer();
		      r.setColor(colors[i]);
		      r.setPointStyle(styles[i]);
		      r.setLineWidth(3);
		      r.setFillPoints(true);
		      renderer.addSeriesRenderer(r);
		}
		//ͼ�����
	    renderer.setChartTitle("��������");
	    //X�����
	    renderer.setXTitle("����");
	    //Y�����
	    renderer.setYTitle("�÷�");
	    //X����С�����
	    renderer.setXAxisMin(0.5);
	    //X����������
	    renderer.setXAxisMax(12.5);
	    //Y����С�����
	    renderer.setYAxisMin(0);
	    //Y����������
	    renderer.setYAxisMax(40);
	    //��������ɫ
	    renderer.setAxesColor(Color.GRAY);
	    //��ǩ��ɫ
	    renderer.setLabelsColor(Color.LTGRAY);
	    //��������Ӵ�
		renderer.setTextTypeface("sans_serif", Typeface.BOLD);
		//������ͼ�����Ƿ���ʾֵ��ǩ
	    renderer.getSeriesRendererAt(0).setDisplayChartValues(false);
	    //��ʾ��Ļ�ɼ�����XY�ָ���
	    renderer.setXLabels(12);
	    renderer.setYLabels(10);
	    //X�̶ȱ�ǩ���X��λ��
	    renderer.setXLabelsAlign(Align.CENTER);
	    //Y�̶ȱ�ǩ���Y��λ��
	    renderer.setYLabelsAlign(Align.LEFT);
	    //��ʾ�����
	    renderer.setShowGrid(true);
	    renderer.setZoomButtonsVisible(true);
	    renderer.setPanLimits(new double[] { -10, 20, -10, 40 });
	    renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });
	    //����ļ��
	    renderer.setBarSpacing(0.5);
	    //��״ͼ��Ⱦ��
	    XYSeriesRenderer histogramRenderer = new XYSeriesRenderer();
	    histogramRenderer.setColor(Color.argb(250, 0, 210, 250));
	    histogramRenderer.setDisplayChartValues(true);
	    histogramRenderer.setChartValuesTextSize(10);
	    //���������Ⱦ��
	    renderer.addSeriesRenderer(histogramRenderer);
	    //�������������
	    XYMultipleSeriesDataset mXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
	    //�����������
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
	    //��״ͼ���������
	    XYSeries histogramSeries = new XYSeries("��ҵƽ����");
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
	    //����������������
	    mXYMultipleSeriesDataset.addSeries(histogramSeries);
	    //���ͼ������ ע��˳���XYMultipleSeriesDataset,XYMultipleSeriesRenderer��ӵ�˳��һ��
	    String[] types = new String[] {LineChart.TYPE,BarChart.TYPE};
	    //��ȡͼ��View
	    View chart = ChartFactory.getCombinedXYChartView(this,mXYMultipleSeriesDataset,renderer,
	    		types);
        linearLayout.addView(chart);
    }
    
}