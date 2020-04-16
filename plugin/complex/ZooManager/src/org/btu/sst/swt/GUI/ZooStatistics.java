package org.btu.sst.swt.GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import org.btu.sst.swt.Managing.IZooEvent;
import org.btu.sst.swt.Managing.Spec;
import org.btu.sst.swt.Managing.Zoo;
import org.btu.sst.swt.Managing.ZooManager;

public class ZooStatistics extends Canvas implements IZooEvent {

	private static final long serialVersionUID = -1603996339182675177L;

	private static final int SPACING = 2;
	private static final int CHART_HEIGHT = 20;
	private static final Color CHART_COLOR = new Color(110, 150, 190);

	private Map<Spec, Integer> animalMap;
	private int maxAnimals = 0;

	public ZooStatistics(final Zoo model) {
		model.addListener(this);
		this.animalMap = new HashMap<>();
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		if (animalMap.isEmpty()) return;
		int y = SPACING;
		float factor = getWidth() / (float) maxAnimals;
		int chartWidth;
		for (final Spec species : animalMap.keySet()) {
			chartWidth = (int) Math.ceil(animalMap.get(species) * factor);
			g.setColor(CHART_COLOR);
			g.fillRect(0, y, chartWidth, CHART_HEIGHT);
			y += CHART_HEIGHT + SPACING;
			g.setColor(Color.BLACK);
			g.drawString(String.format("%ss (%d)", species.toString(), animalMap.get(species)), SPACING, y
					- (int) (CHART_HEIGHT / 4f));
			g.drawString(species.toString() + "s", SPACING, y - (int) (CHART_HEIGHT / 4f));
		}
	}

	@Override
	public void onZooChanged(final ZooManager zoo) {
		maxAnimals = 0;
		animalMap.clear();
		int size;
		for (final Spec species : Spec.values()) {
			size = zoo.getAnimals(species).size();
			if (size == 0) continue;
			animalMap.put(species, size);
			maxAnimals = Math.max(maxAnimals, size);
		}
		repaint();
	}

}
