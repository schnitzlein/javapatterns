package org.btu.sst.swt.core;

//import org.btu.sst.swt.plugins.schwachr.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Service class that advances the functionality of a common plugin model.
 * 
 * @author Markus Uhlig 2014 <markus.uhlig@b-tu.de>
 * 
 */
public class PluginService {

	private final PluginModel model;

	
	public PluginService(final PluginModel model) {
		this.model = model;
	}
	
	
	/**
	 * Method loads all plugins and registers them to the given {@link PluginModel}.
	 *  
	 */
	public void loadPlugins() {
		// INSERT CODE HERE
		String pluginPfad = "D:/eclipse/workspace/SWT-UE-04/plugins.txt";
		try {

	        FileInputStream fstream = new FileInputStream(pluginPfad);
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        //read fully qualified class name of plugin from plugin descriptor file
	        String fullyQualifiedName;
	        
	        while( (fullyQualifiedName = br.readLine()) !=null ){
	        
	         // Convert File to a URL
	         URI uri = URI.create("file:/"+pluginPfad);
	         URL url = uri.toURL();
	         URL[] urls = new URL[]{url};

	         // Create a new class loader with the directory
	         ClassLoader loader = new URLClassLoader(urls);
	         Class cls = loader.loadClass(fullyQualifiedName);

	         //add loaded plugin to plugin list
	         model.addPlugin((IPlugin)cls.newInstance());
	        }
	        in.close();
	} // try
	catch (FileNotFoundException fnf){
	  System.out.println("Datei nicht gefunden:  "+fnf.getMessage());
	}
	catch (Exception e){
	  System.out.println("Fehler: "+e.getMessage());
	}
}//loadPlugin
	
}
	

/*
 * 
		Plugin1 p1= new Plugin1();
	    Plugin2 p2= new Plugin2();
	    model.addPlugin(p1);
	    model.activatePlugin(p1);
	    model.addPlugin(p2);
	    model.activatePlugin(p2);
		
		
	}*/


