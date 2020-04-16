package org.btu.sst.swt.plugins.schwachr;
import javax.swing.JOptionPane;

import org.btu.sst.swt.core.*;



public class Plugin2 extends PluginMetaData implements IPlugin{
	
	private boolean active = false;


	public Plugin2(){
		this.setTitle("Plugin2");
		this.setAuthor("Christoph");
		this.setDescription("Dieses Plugin macht ...");
	}
	
	
	public void showDialogPluginActivate(){
		JOptionPane.showMessageDialog(null, "" + this.getTitle() + " wurde erfolgreich aktiviert.");
		
	}
	
	
	public void showDialogPluginDeactivate(){
		JOptionPane.showMessageDialog(null, "" + this.getTitle() + " wurde erfolgreich deaktiviert.");
		
	}


	@Override
	public void activatePlugin() {
		// TODO Auto-generated method stub
		active = true;
		showDialogPluginActivate();
	}


	@Override
	public void deactivatePlugin() {
		// TODO Auto-generated method stub
		active = false;
		showDialogPluginDeactivate();
	}


	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return active;
	}


	@Override
	public PluginMetaData getMetaData() {
		
		PluginMetaData p = new PluginMetaData();
		p.setAuthor(this.getAuthor());
		p.setDescription(this.getDescription());
		p.setTitle(this.getTitle());
		return p;
	}
	

}

