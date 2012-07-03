package com.joilnen;

public class StatOption {

	static private final StatOption statOpSingleton = new StatOption();
	private boolean musica = true;
	private boolean somef = true;

	private StatOption() { }

	public static StatOption getSingleton() {
		return statOpSingleton;
	}

	public void setMusicaStat(boolean m) {
		musica = m;
	}

	public void setSomEfectStat(boolean s) {
		somef = s;
	}

	public boolean getMusicaStat() {
		return musica;
	}

	public boolean getSomEfectStat() {
		return somef;
	}

}


