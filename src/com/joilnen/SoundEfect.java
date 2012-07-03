package com.joilnen;

import android.media.AudioManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.util.Log;

import com.joilnen.StatOption;
import com.joilnen.SoundEfectType;

class SoundEfect {

	private SoundPool soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
	private int plukId = -1;
	static private SoundEfect se = null;

	private SoundEfect(Context context) {
		try {
			AssetManager am = context.getAssets(); 
			AssetFileDescriptor audioStream = am.openFd("pluk.ogg");
			if(plukId == -1) 
				plukId = soundPool.load(audioStream, 1);
		}
		catch(Exception e) {
			Log.d("Bzzz", "Nao consegui carregar efeitos de som");
		}
	}

	public static SoundEfect getSingleton(Context context) {
		if(se == null)
			se = new SoundEfect(context);
		return se;
	}

	public void play(int type) {
		switch(type) {
			// case SoundEfectType.INIT:;
			// break;
			case SoundEfectType.PLUK:
				if(plukId != -1 && StatOption.getSingleton().getSomEfectStat())
					if(soundPool.play(plukId, 1, 1, 0, 0, 1) == 0)
						Log.d("Erro", "Nao consegui tocar o som de efeito"); 
		}
	}
}


