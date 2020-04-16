package org.btu.sst.swt.FileSystem;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ZooFileFilter extends FileFilter {

	@Override
	public boolean accept(final File f) {
		return f.isDirectory() || f.getName().toLowerCase().endsWith(".zoo");
	}

	@Override
	public String getDescription() {
		return "Zoo (*.zoo)";
	}

}
