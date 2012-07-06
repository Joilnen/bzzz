package com.joilnen;

import com.joilnen.Bzzz.RenderView;
import android.graphics.Canvas;
import android.graphics.Paint;

class InfoBar {
	private int count = 0;
	private int cakeState = 100;

	private RenderView renderView;

	public InfoBar(RenderView renderView) {
		this.renderView = renderView;
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
		canvas.drawText(sb.toString(), 280, 20, new Paint());
	}
}


