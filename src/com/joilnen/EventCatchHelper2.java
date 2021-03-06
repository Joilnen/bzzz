package com.joilnen;

import com.joilnen.Bzzz.RenderView;
import com.joilnen.SoundEfect;

import android.view.MotionEvent;
import android.content.Context;
import android.util.Log;
import android.hardware.SensorEvent;

class EventCatchHelper2 {

	private RenderView renderView;
	private MotionEvent motionEvent;
	private SensorEvent sensorEvent;
	private Context context;

	public EventCatchHelper2(RenderView renderView) {
		this.renderView = renderView;
		this.context = renderView.getContext();
	}

	public boolean doCatch(MotionEvent motionEvent) {

		switch(motionEvent.getAction()) {
		    case MotionEvent.ACTION_UP:

			StringBuilder builder = new StringBuilder();
			builder.setLength(0);

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

	public void doSensorCatch(MotionEvent motionEventCatch) {
		for(Mosca it:renderView.moscas) {
			if(it.getY() >= 450)
				it.setPosY(449);
		}
	}
}


