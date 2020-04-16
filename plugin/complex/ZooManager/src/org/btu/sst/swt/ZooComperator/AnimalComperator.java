package org.btu.sst.swt.ZooComperator;

import java.util.Comparator;

import org.btu.sst.swt.Managing.Animal;

public class AnimalComperator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
	}

}
