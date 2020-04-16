package org.btu.sst.swt.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Management component for multiple plugins. Plugins can be registered, unregistered, activated and deactivated using this model.
 * 
 * @author Markus Uhlig 2014 <markus.uhlig@b-tu.de>
 * 
 */
public class PluginModel {

	private List<IPlugin> plugins = new ArrayList<>();
	private IPlugin activePlugin = null;

	public PluginModel() {
		// default constructor, nothing to do yet
	}

	/**
	 * Adds the given plugin to this model. If {@code plugin} is already registered it's been removed and added to the end of the
	 * underlying plugin list.
	 * 
	 * @param plugin
	 *            - the plugin to add.
	 */
	public void addPlugin(final IPlugin plugin) {
		removePlugin(plugin);
		if (plugin != null) plugins.add(plugin);
	}

	/**
	 * Removes the given plugin and deactivates it.
	 * 
	 * @param plugin
	 *            - the plugin to remove.
	 */
	public void removePlugin(final IPlugin plugin) {
		if (plugins.contains(plugin)) {
			deactivatePlugin(plugin);
			plugins.remove(plugin);
		}
	}

	/**
	 * Method gives the currently active plugin. A plugin model always contains not any or exactly one active plugin.
	 * 
	 * @return the active plugin or {@code null} if there is no active plugin.
	 */
	public IPlugin getActivePlugin() {
		return activePlugin;
	}

	/**
	 * Method can be used to retrieve the number of registered plugins.
	 * 
	 * @return the number of plugins.
	 */
	public int getPluginCount() {
		return plugins.size();
	}

	/**
	 * Methods returns a set of authors over all plugin.
	 * 
	 * @return all authors
	 */
	public Set<String> getPluginAuthors() {
		final Set<String> authors = new HashSet<>();
		for (final IPlugin plugin : plugins) {
			authors.add(plugin.getMetaData().getAuthor());
		}
		return authors;
	}

	/**
	 * Convenient method to find plugins for a specific author. You'll never need to deal with {@code null} values.
	 * 
	 * @param author
	 *            - the author to find plugins for.
	 * @return a list of plugin for {@code author} or an empty list.
	 */
	public Collection<IPlugin> getPluginsByAuthor(final String author) {
		final Collection<IPlugin> result = new ArrayList<>();
		for (final IPlugin plugin : plugins) {
			if (plugin.getMetaData().getAuthor().equals(author)) {
				result.add(plugin);
			}
		}
		if (plugins.size() == result.size()) {
			return plugins;
		}
		return result.isEmpty() ? Collections.<IPlugin> emptyList() : result;
	}

	/**
	 * Method activates the given plugin. Activation fails if the given plugin is not yet registered at the model. Make sure to
	 * call {@link #addPlugin(IPlugin)} before. Additionally this method deactivates the currently active plugin and sets
	 * {@code plugin} as the new active one.
	 * 
	 * @param plugin
	 *            - the plugin to activate.
	 */
	public void activatePlugin(final IPlugin plugin) {
		if (plugin == null) return;
		if (!plugins.contains(plugin)) {
			System.out.println("Activation failed: Plugin not yet registered.");
		} else {
			if (activePlugin != null && activePlugin != plugin) {
				activePlugin.deactivatePlugin();
			}
			activePlugin = plugin;
			if (!plugin.isActive()) {
				plugin.activatePlugin();
			}
		}
	}

	/**
	 * Method works analoguously to {@link #activatePlugin(IPlugin)} but for the deactivation.
	 * 
	 * @param plugin
	 *            - the plugin to deactivate.
	 */
	public void deactivatePlugin(final IPlugin plugin) {
		if (plugin == null) return;
		if (!plugins.contains(plugin)) {
			System.out.println("Deactivation failed: Plugin not yet registered.");
		} else {
			if (plugin.isActive()) {
				plugin.deactivatePlugin();
			}
		}
	}

	/**
	 * Convenient method to retrieve all plugins. The resulting list is unmodifiable.
	 * 
	 * @return a list of all plugins (unmodifiable).
	 */
	public Collection<IPlugin> getPlugins() {
		return Collections.unmodifiableList(plugins);
	}

}
