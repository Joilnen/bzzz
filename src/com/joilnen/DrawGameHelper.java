package com.joilnen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.joilnen.Bzzz.RenderView;
import com.joilnen.Mosca;
import com.joilnen.BigMosca;
import com.joilnen.Bolo;

class  DrawGameHelper {

	private RenderView renderView;
	private Canvas canvas;

	public DrawGameHelper(RenderView renderView, Canvas canvas) {
		this.canvas = canvas;
		this.renderView = renderView;
	}

	public void draw() {
		canvas.drawRGB(255, 255, 255);
		try {
			new InfoBar(renderView, canvas).draw();
			canvas.drawBitmap(renderView.bolo.getBitmap(), 10, 310, null);
			for(Mosca it:renderView.moscas) {
				if(it.getY() < 450) 
					it.move();
				else {
					System.out.format("valor %d\n", it.getStatus());
					if(it.getStatus() == SkinType.VOANDO_D)
						it.setStatus(SkinType.POUSADA_D);
					else
						it.setStatus(SkinType.POUSADA_E);
				}
				canvas.drawBitmap(it.getBitmap(), it.getX(), it.getY(), null);

			}

			for(Mosca it:renderView.moscas2) {
				if(it.getY() < 450) 
					it.move();
				else {
					System.out.format("valor %d\n", it.getStatus());
					if(it.getStatus() == SkinType.VOANDO_D)
						it.setStatus(SkinType.POUSADA_D);
					else
						it.setStatus(SkinType.POUSADA_E);
				}
				canvas.drawBitmap(it.getBitmap(), it.getX(), it.getY(), null);
				// if(it.getStatus() == SkinType.MORRENDO) renderView.moscas.remove(it);
			}

			for(BigMosca it:renderView.big_moscas) {
				if(it.getY() < 430) 
					it.move();
				else {
					System.out.format("valor %d\n", it.getStatus());
					if(it.getStatus() == SkinType.VOANDO_D)
						it.setStatus(SkinType.POUSADA_D);
					else
						it.setStatus(SkinType.POUSADA_E);
				}
				canvas.drawBitmap(it.getBitmap(), it.getX(), it.getY(), null);
				// if(it.getStatus() == SkinType.MORRENDO) renderView.moscas.remove(it);
			}


			for(Mosca it:renderView.moscas) 
				if(it.getStatus() == SkinType.MORRENDO)
					renderView.moscas.remove(it);
	
			for(Mosca it:renderView.moscas2) 
				if(it.getStatus() == SkinType.MORRENDO)
					renderView.moscas2.remove(it);

			/*** Rever codigo com bug recriacao das moscas

			if(renderView.moscas.size() < 1) {
				for(int i = 0; i < 4; i++) {
					renderView.moscas.add(new Mosca(renderView.getContext()));
				}
			}
			***/

		}
		catch(Exception e) {
			Log.d("Bzzz", "Nao consegui mover a mosca");
		}
		try { Thread.sleep(25); } catch (Exception e) {  }
	}
}


