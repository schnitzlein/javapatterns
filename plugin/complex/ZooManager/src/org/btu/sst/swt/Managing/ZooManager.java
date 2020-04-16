package org.btu.sst.swt.Managing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZooManager implements Serializable {

	private static final long serialVersionUID = -1142218556334551075L;

	private final List<Animal> animals = new ArrayList<>();

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Animal> getAnimals(final Spec species) {
		final List<Animal> filteredAnimals = new ArrayList<>();
		for (final Animal animal : animals) {
			if (animal.getSpecies().equals(species)) {
				filteredAnimals.add(animal);
			}
		}
		return filteredAnimals;
	}

	public void addAnimal(final Animal animal) {
		animals.add(animal);
	}

	public void removeAnimal(final Animal animal) {
		animals.remove(animal);
	}

}
