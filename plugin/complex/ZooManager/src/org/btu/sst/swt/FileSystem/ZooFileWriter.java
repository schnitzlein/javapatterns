package org.btu.sst.swt.FileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.btu.sst.swt.Managing.ZooManager;

public class ZooFileWriter implements IZooFileWriteExcep {

	private final File file;

	public ZooFileWriter(final File file) {
		this.file = file;
	}

	public ZooFileWriter(final String filename) {
		// mittels this(..) können wir an einen anderen Konstruktor weiter delegieren
		this(new File(filename));
	}

	@Override
	public void write(final ZooManager zoo) throws IOException {
		final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(zoo);
		out.close();
	}

}
