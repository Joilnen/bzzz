package com.joilnen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.joilnen.Bzzz.RenderView;
import com.joilnen.Bzzz.RenderView2;
import com.joilnen.Mosca;
import com.joilnen.BigMosca;
import com.joilnen.Bolo;
import com.joilnen.InfoBar2;

import java.util.Random;

class  DrawGameHelper2 {

	private RenderView2 renderView;
	private InfoBar2 infoBar;
	private static long start_elapsed_time = System.currentTimeMillis();

	public DrawGameHelper2(RenderView2 renderView) {
		this.renderView = renderView;
		this.infoBar =	new InfoBar2(renderView);
	}

	public  void draw(Canvas canvas) {
		canvas.drawRGB(255, 255, 255);
		try {
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

			/****

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

			for(MoscaAgulha it:renderView.moscas_agulha) {
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

			for(MoscaOndular it:renderView.moscas_ondular) {
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
			***/

			for(Mosca it:renderView.moscas) {
				if(it.getStatus() == SkinType.MORRENDO)  {
					renderView.moscas.remove(it);
					infoBar.increment(10);
				}
			}
	
			if(renderView.moscas.size() < 6) {
				// for(int i = 0; i < 6; i++) {
					int i = new Random().nextInt(10);;
					Mosca m = new Mosca(this.renderView.getContext());
					if((i % 3) == 0) m.setStatus(SkinType.VOANDO_D);
					else m.setStatus(SkinType.VOANDO_E);
					renderView.moscas.add(m);
				// }
			}

			/*** Rever codigo com bug recriacao das moscas

			if(renderView.moscas.size() < 1) {
				for(int i = 0; i < 4; i++) {
					renderView.moscas.add(new Mosca(renderView.getContext()));
				}
			}
			***/
			infoBar.draw(canvas);

		}
		catch(Exception e) {
			Log.d("Bzzz", "Nao consegui mover a mosca");
		}
		// Log.d("Bzzz", new String("Elapsed time " + Long.toString(System.currentTimeMillis() - start_elapsed_time))); 
		long res = Math.abs(System.currentTimeMillis() - start_elapsed_time); 
		// Log.d("Bzzz", new String("Elapsed time " + Long.toString(res))); 
		if(res < 30000) 
			try { Thread.sleep(55 + (30000 - res)/1000); } catch (Exception e) {  }
		else
			try { Thread.sleep(55); } catch (Exception e) {  }

	}
}


