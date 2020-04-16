package org.btu.sst.swt.Managing;

public enum Spec {

	CROCODILE("Crocodile"),
	FISH("Fish"),
	SPIDER("Spider");

	private final String name;

	private Spec(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
