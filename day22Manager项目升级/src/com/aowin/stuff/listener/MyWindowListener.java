package com.aowin.stuff.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.aowin.stuff.view.ItmView;
import com.aowin.stuff.view.PrimeView;

public class MyWindowListener extends WindowAdapter {
	
	private ItmView iView;
	private PrimeView pView;
	
	public MyWindowListener(ItmView iView, PrimeView pView) {
		super();
		this.iView = iView;
		this.pView = pView;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		pView.setEnabled(true);
		pView.setVisible(true);
		iView.getJf().setVisible(false);
	}

}
