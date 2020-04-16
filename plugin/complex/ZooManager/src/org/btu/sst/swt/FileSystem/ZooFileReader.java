package org.btu.sst.swt.FileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.btu.sst.swt.Managing.ZooManager;

public class ZooFileReader implements IZooFileReadExcep {

	private File file;

	public ZooFileReader(final File file) {
		this.file = file;
	}

	public ZooFileReader(final String filename) {
		this(new File(filename));
	}

	@Override
	public ZooManager read() throws FileNotFoundException, IOException {
		final ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object obj = null;
		try {
			obj = in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			in.close();
		}
		return (ZooManager) obj;
	}

}
