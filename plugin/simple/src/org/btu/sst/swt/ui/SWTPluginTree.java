package org.btu.sst.swt.ui;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.btu.sst.swt.core.IPlugin;
import org.btu.sst.swt.core.PluginMetaData;
import org.btu.sst.swt.core.PluginModel;

public class SWTPluginTree extends JTree {

	private static final long serialVersionUID = 2245283930157509994L;

	private final DefaultTreeModel treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(""));
	private final PluginModel model;

	public SWTPluginTree(final PluginModel model) {
		setModel(treeModel);
		this.model = model;
		this.setCellRenderer(new TooltipCellRenderer());
		this.addTreeSelectionListener(new CustomSelectionListener());
		javax.swing.ToolTipManager.sharedInstance().registerComponent(this);
		reload();
	}

	private void reload() {
		final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("SWT");
		DefaultMutableTreeNode authorNode, pluginNode;
		for (final String author : model.getPluginAuthors()) {
			authorNode = new DefaultMutableTreeNode(author);
			for (final IPlugin plugin : model.getPluginsByAuthor(author)) {
				pluginNode = new DefaultMutableTreeNode(plugin);
				authorNode.add(pluginNode);
			}
			rootNode.add(authorNode);
		}
		treeModel.setRoot(rootNode);
	}

	private final class CustomSelectionListener implements TreeSelectionListener {

		@Override
		public void valueChanged(final TreeSelectionEvent e) {
			final TreePath path = e.getPath();
			if (path == null || path.getPathCount() < 1) return;
			final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
			final Object userObj = selectedNode.getUserObject();
			if (userObj != null && userObj instanceof IPlugin) {
				model.activatePlugin((IPlugin) userObj);
			}
		}

	}

	private static class TooltipCellRenderer extends DefaultTreeCellRenderer {

		private static final long serialVersionUID = -7344393423508331226L;

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
				int row, boolean hasFocus) {

			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

			final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			final Object userObj = node.getUserObject();

			if (userObj instanceof IPlugin) {
				final PluginMetaData data = ((IPlugin) userObj).getMetaData();
				final StringBuilder builder = new StringBuilder("<html>");
				builder.append("<h3>").append(data.getTitle()).append("</h3>");
				builder.append("<h5>Created by: ").append(data.getAuthor()).append("</h5>");
				builder.append("<p>").append(data.getDescription()).append("</p>");
				builder.append("</html>");
				setToolTipText(builder.toString());
			}
			return this;
		}
	}
}
