package com.joilnen;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Random;
import java.io.InputStream;
import java.lang.NullPointerException;

import android.content.res.AssetManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.joilnen.SkinType;

public class Bolo {

	int x, y, inc_x, inc_y;
	Bitmap skin;
	int status = 0;
	Random random = new Random();
	
	public Bolo(Context context) {
		
		int r = random.nextInt(300); 

		if(r % 2 == 0) {
			x = 5;
			y = r;
		}
		else {
			x = r;
			y = 5;
		}
		inc_x = inc_y = 3;

		try {
			AssetManager am = context.getAssets();
			InputStream in_file = am.open("bolo_test.png");
			skin = BitmapFactory.decodeStream(in_file);
			in_file.close();

			status = 0;
		}
		catch (Exception e) { 
			Log.d("Mosca error mensage", e.toString());
			Log.d("Mosca error mensage", "Problemas em instanciar Mosca");
		}
	}

	public void move() {

	}

	public int getX() { return x; }
	public int getY() { return y; }

	public void slash(int press) {

	}

	protected void die() {

	}

	public Bitmap getBitmap() {
		if(skin == null)
			throw new NullPointerException("skin eh nulo");
		return skin;
	}

	public void setStatus(int i) {
		status = i;
	}

	public int getStatus() {
		return status;
	}
}


