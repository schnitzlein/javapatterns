package org.btu.sst.swt.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.btu.sst.swt.core.PluginModel;

public class SWTFrame extends JFrame {

	private static final long serialVersionUID = 1893136417417486583L;

	private final PluginModel model;
	
	public SWTFrame(final PluginModel model) {
		super("Softwaretechnik - SoSe 2014");
		this.model = model;
		buildComponents();
	}
	
	private void buildComponents() {
		getContentPane().setLayout(new BorderLayout());
		
		final SWTPluginTree tree = new SWTPluginTree(model);
		getContentPane().add(tree, BorderLayout.CENTER);
	}
}
