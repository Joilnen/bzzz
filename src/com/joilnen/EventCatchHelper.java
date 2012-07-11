package com.joilnen;

import com.joilnen.Bzzz.RenderView;
import com.joilnen.SoundEfect;

import android.view.MotionEvent;
import android.content.Context;
import android.util.Log;
import android.hardware.SensorEvent;

class EventCatchHelper {

	private RenderView renderView;
	private MotionEvent motionEvent;
	private SensorEvent sensorEvent;
	private Context context;
	private SoundEfect soundEfect;

	public EventCatchHelper(RenderView renderView, MotionEvent motionEvent) {
		this.renderView = renderView;
		this.motionEvent = motionEvent;
		this.context = renderView.getContext();
	}

	public EventCatchHelper(RenderView renderView, SensorEvent sensorEvent) {
		this.renderView = renderView;
		this.sensorEvent = sensorEvent;
		this.context = renderView.getContext();
	}

	public boolean doCatch() {

		StringBuilder builder = new StringBuilder();
		builder.setLength(0);
		switch(motionEvent.getAction()) {
		    case MotionEvent.ACTION_UP:
			for(Mosca it:renderView.moscas) {
				if(motionEvent.getX() > (it.getX() - 15) && motionEvent.getX() < (it.getX() + 40)  &&
				   motionEvent.getY() > (it.getY() - 15) && motionEvent.getY() < (it.getY() + 40)) {
					builder.append("Down, ");
					builder.append(new String().format("%.0f", motionEvent.getX()));
					builder.append(", ");
					builder.append(new String().format("%.0f", motionEvent.getY()));
					String text = builder.toString();
					Log.d("Teste de toque", text);

					it.setStatus(SkinType.MORRENDO);
					SoundEfect.getSingleton(context).play(SoundEfectType.PLUK);

				}
			}
		}

		return true;
	}

	public void doSensorCatch() {
		for(Mosca it:renderView.moscas) {
			if(it.getY() >= 450) it.setPosY(449);
		}
	}

}


