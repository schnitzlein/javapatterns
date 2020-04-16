package org.btu.sst.swt.plugins.schwachr;
import javax.swing.JOptionPane;

import org.btu.sst.swt.core.*;



public class Plugin1 extends PluginMetaData implements IPlugin {
	//FIXME mit PluginMetaData pmd = new ... arbeiten oder erben? was ist besser
	
	private boolean active = false;
	
	public Plugin1(){
		this.setTitle("Plugin1");
		this.setAuthor("Christoph");
		this.setDescription("Dieses Plugin macht ...");
	}
	
	public Plugin1(String title, String author, String description){
		setTitle(title);
		setAuthor(author);
		setDescription(description);
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
		// TODO Auto-generated method stub
		
		PluginMetaData p = new PluginMetaData();
		p.setAuthor(this.getAuthor());
		p.setDescription(this.getDescription());
		p.setTitle(this.getTitle());
		return p;
	}
	
	/*public static void main(String[] args) { 
		Plugin1 p = new Plugin1();
		p.showDialogPluginActivate();
		p.showDialogPluginDeactivate();
	}*/

}

