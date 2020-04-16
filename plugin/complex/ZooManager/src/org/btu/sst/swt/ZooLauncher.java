package org.btu.sst.swt;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.btu.sst.swt.GUI.GUIMenue;
import org.btu.sst.swt.Managing.Animal;
import org.btu.sst.swt.Managing.Spec;
import org.btu.sst.swt.Managing.Zoo;

public class ZooLauncher {

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		final Zoo b = new Zoo();

		final GUIMenue d = new GUIMenue(b);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setLocationRelativeTo(null);

		b.addAnimals(new Animal("Sabine", Spec.CROCODILE));
		b.addAnimals(new Animal("Peter", Spec.FISH));
		b.addAnimals(new Animal("Manni", Spec.SPIDER));
		b.addAnimals(new Animal("Udo", Spec.CROCODILE));
		b.addAnimals(new Animal("Martin", Spec.CROCODILE));
		b.addAnimals(new Animal("Susi", Spec.FISH));

		// GUI anzeigen
		d.setSize(800, 600);
		d.setVisible(true);
	}

}
