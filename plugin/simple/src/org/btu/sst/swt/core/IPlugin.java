package org.btu.sst.swt.core;

/**
 * Main interface for plugins. See method comments for further information.
 * 
 * @author Markus Uhlig 2014 <markus.uhlig@b-tu.de>
 * 
 */
public interface IPlugin {

	/**
	 * Actives this plugin. Implementing plugins have to initialize their context here.
	 */
	void activatePlugin();

	/**
	 * Deactivates this plugin. Implementing plugins have to release all system resources here for performance reasons.
	 */
	void deactivatePlugin();

	/**
	 * Method retrieves the activation state of this plugin. A plugin is activated if and only if {@link #activatePlugin()} was
	 * called. Immediately after calling {@link #deactivatePlugin()} it is deactivated.
	 * 
	 * @return {@code true} if this plugin was activated and {@code false} if this plugin was deactivated.
	 */
	boolean isActive();

	/**
	 * Method can be used to retrieve different meta data. See {@link PluginMetaData} for further information.
	 * 
	 * @return the meta data associated with this plugin.
	 */
	PluginMetaData getMetaData();

}
