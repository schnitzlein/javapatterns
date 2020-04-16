package org.btu.sst.swt.GUI;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.btu.sst.swt.Managing.Animal;
import org.btu.sst.swt.Managing.IZooEvent;
import org.btu.sst.swt.Managing.Zoo;
import org.btu.sst.swt.Managing.ZooManager;
import org.btu.sst.swt.ZooComperator.AnimalComperator;

public class AnimalPanel extends JPanel implements IZooEvent {

	private static final long serialVersionUID = -8324755851709328098L;

	private final Zoo model;
	private JList<Animal> animalList;

	public AnimalPanel(final Zoo model) {
		super(new BorderLayout());
		this.model = model;
		model.addListener(this);
		add(new JScrollPane(animalList = new JList<>()), BorderLayout.CENTER);
		animalList.addKeyListener(new ListKeyListener());
	}

	@Override
	public void onZooChanged(final ZooManager zoo) {
		animalList.removeAll();
		final List<Animal> animals = new ArrayList<Animal>(zoo.getAnimals());
		Collections.sort(animals, new AnimalComperator());
		animalList.setListData(animals.toArray(new Animal[0]));
		repaint();
	}

	private class ListKeyListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_DELETE) {
				final List<Animal> selectedAnimals = animalList.getSelectedValuesList();
				if (!selectedAnimals.isEmpty()) {
					model.removeAnimals(selectedAnimals.toArray(new Animal[0]));
				}
			}
		}

	}

}
