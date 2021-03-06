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
	private MediaPlayer mediaPlayer = null;
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

	String music_name = "loop_bongo1.ogg";
	public void playMusic() {
		try { 
			if(mediaPlayer == null) {
				mediaPlayer = new MediaPlayer();
				AssetFileDescriptor audioStream = context.getAssets().openFd(music_name);
				mediaPlayer.setDataSource(audioStream.getFileDescriptor(), audioStream.getStartOffset(), audioStream.getLength()); 
				audioStream.close();
				mediaPlayer.setLooping(true);
				mediaPlayer.prepare();
				mediaPlayer.start();
			}
		}
		catch(Exception e) {

		}
	}

	public void stopMusic() {
		if(mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}

	public void pauseMusic() {
		if(mediaPlayer != null) {
			stopMusic();
		}
	}

	public void changeMusic(boolean b) {
		if(b == true) 
			music_name = "loop_musica2.ogg";
		else
			music_name = "loop_bongo1.ogg";
		stopMusic();
		playMusic();
	}
}


