package org.btu.sst.swt.Managing;

public interface IZooListener {

	void addListener(final IZooEvent listener);

	void removeListener(final IZooEvent listener);

	void notifyListeners();

}
