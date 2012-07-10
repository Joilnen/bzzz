package com.joilnen;

import android.media.AudioManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.joilnen.StatOption;
import com.joilnen.SoundEfectType;

class SoundEfect {

	private SoundPool soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
	private int plukId = -1;
	private int sairId = -1;
	static private SoundEfect se = null;
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private Context context;

	private SoundEfect(Context context) {
		try {
			AssetManager am = context.getAssets(); 
			AssetFileDescriptor audioStream = am.openFd("pluk.ogg");
			if(plukId == -1) 
				plukId = soundPool.load(audioStream, 1);
			audioStream.close();
			audioStream = am.openFd("loop_sair.ogg");
			if(sairId == -1) 
				sairId = soundPool.load(audioStream, 1);
			audioStream.close();

			audioStream = am.openFd("loop_musica1.ogg");
			mediaPlayer.setDataSource(audioStream.getFileDescriptor(), audioStream.getStartOffset(), audioStream.getLength()); 
			audioStream.close();
			mediaPlayer.prepare();
			mediaPlayer.setLooping(true);
			playMusic();
		}
		catch(Exception e) {
			Log.d("Bzzz", "Nao consegui carregar efeitos de som");
		}
		this.context = context;
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
			break;
			case SoundEfectType.SAIR:
				if(sairId != -1 && StatOption.getSingleton().getSomEfectStat())
					if(soundPool.play(sairId, 1, 1, 0, 0, 1) == 0)
						Log.d("Erro", "Nao consegui tocar o som de efeito"); 

		}
	}

	public void playMusic() {
		if(mediaPlayer != null)
			mediaPlayer.start();
	}

	public void stopMusic() {
		if(mediaPlayer != null) {
			mediaPlayer.stop();
		}
	}
}


