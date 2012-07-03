package com.joilnen;

import com.joilnen.Bzzz.RenderView;
import android.graphics.Canvas;
import android.graphics.Paint;

class InfoBar {
	private int count = 0;
	private int cakeState = 100;

	private RenderView renderView;
	private Canvas canvas;

	public InfoBar(RenderView renderView, Canvas canvas) {
		this.renderView = renderView;
		this.canvas = canvas;
	}

	public void increment(int value) {

	}

	public void clear() {

	}

	public void cakeDemage() {

	}

	public void draw() {
		StringBuilder sb = new StringBuilder();
		sb.append(9999);
		canvas.drawText(sb.toString(), 280, 20, new Paint());
	}
}


