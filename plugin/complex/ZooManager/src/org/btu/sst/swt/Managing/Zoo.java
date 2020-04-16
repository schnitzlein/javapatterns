package org.btu.sst.swt.Managing;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements IZooListener {

	private final List<IZooEvent> listeners = new ArrayList<>();

	private ZooManager zoo;

	public Zoo() {
		this(new ZooManager());
	}

	public Zoo(final ZooManager zoo) {
		this.zoo = (zoo == null) ? new ZooManager() : zoo;
	}

	public void setZoo(final ZooManager zoo) {
		if (zoo == null) throw new IllegalArgumentException("Null zoo not supported.");
		this.zoo = zoo;
		notifyListeners();
	}

	public ZooManager getZoo() {
		return zoo;
	}

	public void addAnimals(final Animal... animals) {
		for (final Animal animal : animals) {
			zoo.addAnimal(animal);
		}
		notifyListeners();
	}

	public void removeAnimals(final Animal... animals) {
		for (final Animal animal : animals) {
			zoo.removeAnimal(animal);
		}
		notifyListeners();
	}

	@Override
	public void addListener(IZooEvent listener) {
		if (listener != null) listeners.add(listener);
	}

	@Override
	public void removeListener(IZooEvent listener) {
		if (listener != null) listeners.remove(listener);
	}

	@Override
	public void notifyListeners() {
		for (final IZooEvent listener : listeners) {
			listener.onZooChanged(zoo);
		}
	}

}
