package org.btu.sst.swt.Managing;

import java.io.Serializable;

public class Animal implements Serializable {

	private static final long serialVersionUID = -1165169387293930966L;

	private Spec species;
	private String name;

	public Animal(final String name, final Spec species) {
		setName(name);
		setSpecies(species);
	}

	public Spec getSpecies() {
		return species;
	}

	public void setSpecies(final Spec species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(getName());
		builder.append(" (").append(species).append(")");
		return builder.toString();
	}

}
