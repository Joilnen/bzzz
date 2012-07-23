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

public class Mosca {

	int x, y, inc_x, inc_y;
	Bitmap[] skin = new Bitmap[7];
	Bitmap testSkin;
	int status = 0;
	Random random = new Random();
	
	public Mosca(Context context) {
		
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
			InputStream in_file = am.open("mosca_voando_esquerda.png");
			skin[0] = BitmapFactory.decodeStream(in_file);
			// testSkin = BitmapFactory.decodeStream(in_file); 
			in_file.close();

			in_file = am.open("mosca_voando_direita.png");
			skin[1] = BitmapFactory.decodeStream(in_file);
			in_file.close();

			in_file = am.open("mosca_pousada_esquerda.png");
			skin[2] = BitmapFactory.decodeStream(in_file);
			in_file.close();

			in_file = am.open("mosca_pousada_direita.png");
			skin[3] = BitmapFactory.decodeStream(in_file);
			in_file.close();

			in_file = am.open("mosca_morrendo.png");
			skin[4] = BitmapFactory.decodeStream(in_file);
			in_file.close();

			status = SkinType.MORRENDO;
		}
		catch (Exception e) { 
			Log.d("Mosca error mensage", e.toString());
			Log.d("Mosca error mensage", "Problemas em instanciar Mosca");
		}
	}

	public void move() {

		if(x <= 5) inc_x = (1 + random.nextInt(5)); 
		if(x >= 300) inc_x = (-1 - random.nextInt(5)); 

		if(y <= 5) inc_y = (1 + random.nextInt(5)); 
		if(y >= 500) inc_y = (-1 - random.nextInt(5)); 

		x += inc_x; y += inc_y;
	}

	public int getX() { return x; }
	public int getY() { return y; }

	public void slash(int press) {

	}

	protected void die() {
		setStatus(SkinType.MORRENDO);
	}

	public Bitmap getBitmap() {
		if(skin[status] == null)
			throw new NullPointerException("skin eh nulo");
		return skin[status];
	}

	public void setStatus(int i) {
		status = i;
	}

	public int getStatus() {
		return status;
	}

	public void setPosY(int i) {
		y = i;
	}
}


