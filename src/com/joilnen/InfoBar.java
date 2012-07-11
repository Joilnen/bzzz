package com.joilnen;

import com.joilnen.Bzzz.RenderView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;

class InfoBar {
	private int count = 0;
	private int cakeState = 100;
	private Typeface font;

	private RenderView renderView;

	public InfoBar(RenderView renderView) {
		this.renderView = renderView;
		this.font = Typeface.createFromAsset(renderView.getContext().getAssets(), "font.ttf");
	}

	public void increment(int value) {
		count += value;
	}

	public void increment() {
		increment(1);
	}

	public void clear() {

	}

	public void cakeDemage() {

	}

	public void draw(Canvas canvas) {
		StringBuilder sb = new StringBuilder();
		sb.append(count);
		Paint paint = new Paint();
		paint.setTypeface(font);
		paint.setTextSize(25);
		paint.setTextAlign(Align.RIGHT);
		canvas.drawText(sb.toString(), canvas.getWidth() -  10, 32, paint);
	}
}


