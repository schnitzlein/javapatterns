package org.btu.sst.swt.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.btu.sst.swt.FileSystem.ZooFileFilter;
import org.btu.sst.swt.FileSystem.ZooFileReader;
import org.btu.sst.swt.FileSystem.ZooFileWriter;
import org.btu.sst.swt.Managing.Animal;
import org.btu.sst.swt.Managing.Zoo;
import org.btu.sst.swt.Managing.ZooManager;

public class GUIMenue extends JFrame {

	private static final long serialVersionUID = -8324755851709328098L;

	final Zoo model;

	public GUIMenue(final Zoo model) {
		this.model = model;
		buildComponents();
	}

	private void buildComponents() {
		setLayout(new BorderLayout());
		getContentPane().add(new AnimalPanel(model), BorderLayout.WEST);
		getContentPane().add(new ZooStatistics(model), BorderLayout.CENTER);
		setJMenuBar(createMenu());
	}

	private JMenuBar createMenu() {
		final JMenuBar bar = new JMenuBar();

		final JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem(new MenueLoadButton("Load...")));
		fileMenu.add(new JMenuItem(new MenueSaveButton("Save...")));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(new MenueAddAnimalButton("Add Animal")));
		bar.add(fileMenu);

		return bar;
	}

	private class MenueLoadButton extends AbstractAction {

		private static final long serialVersionUID = 4591771667106201899L;

		private MenueLoadButton(final String arg) {
			super(arg);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			final JFileChooser chooser = new JFileChooser();
			chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			chooser.setFileFilter(new ZooFileFilter());
			if (chooser.showOpenDialog(GUIMenue.this) == JFileChooser.APPROVE_OPTION) {
				final ZooFileReader reader = new ZooFileReader(chooser.getSelectedFile());
				ZooManager zoo = null;
				try {
					zoo = reader.read();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if (zoo != null) {
					model.setZoo(zoo);
				}
			}
		}
	}

	private class MenueSaveButton extends AbstractAction {

		private static final long serialVersionUID = 4591771667106201899L;

		private MenueSaveButton(final String arg) {
			super(arg);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			final JFileChooser chooser = new JFileChooser();
			chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			chooser.setFileFilter(new ZooFileFilter());
			if (chooser.showSaveDialog(GUIMenue.this) == JFileChooser.APPROVE_OPTION) {
				final ZooFileWriter reader = new ZooFileWriter(chooser.getSelectedFile());
				try {
					reader.write(model.getZoo());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private class MenueAddAnimalButton extends AbstractAction {

		private static final long serialVersionUID = -7812449747258378086L;

		private MenueAddAnimalButton(final String arg) {
			super(arg);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			final Animal animal = NewAnimalPanel.requestNewAnimal(GUIMenue.this);
			if (animal != null) {
				model.addAnimals(animal);
			}
		}

	}

}
