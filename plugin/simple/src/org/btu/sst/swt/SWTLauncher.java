package org.btu.sst.swt;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.btu.sst.swt.core.PluginModel;
import org.btu.sst.swt.core.PluginService;
import org.btu.sst.swt.ui.SWTFrame;

public class SWTLauncher {

	public static void main(final String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("The nimbus look and feel is not supported on your system: " + e.getMessage());
		}

		final PluginModel model = new PluginModel();
		final PluginService service = new PluginService(model);
		service.loadPlugins();

		final SWTFrame frame = new SWTFrame(model);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setSize(600, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
