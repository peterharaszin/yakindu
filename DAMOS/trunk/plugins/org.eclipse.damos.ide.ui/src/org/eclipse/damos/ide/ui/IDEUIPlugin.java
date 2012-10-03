package org.eclipse.damos.ide.ui;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class IDEUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.damos.ide.ui";
	
	public static final String IMAGE_ERROR_FIXED = "errorFixed";
	public static final String IMAGE_WARNING_FIXED = "warningFixed";
	public static final String IMAGE_CORRECTION_ADD = "correctionAdd";
	public static final String IMAGE_CORRECTION_REMOVE = "correctionRemove";
	public static final String IMAGE_CORRECTION_CHANGE = "correctionChange";
	public static final String IMAGE_CORRECTION_RENAME = "correctionRename";
	public static final String IMAGE_CORRECTION_SYNCHRONIZE = "correctionSynchronize";

	// The shared instance
	private static IDEUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public IDEUIPlugin() {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(IMAGE_ERROR_FIXED, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/ErrorFixed.png"));
		reg.put(IMAGE_WARNING_FIXED, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/WarningFixed.png"));
		reg.put(IMAGE_CORRECTION_ADD, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/full/obj16/correction_add.gif"));
		reg.put(IMAGE_CORRECTION_REMOVE, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/full/obj16/correction_remove.gif"));
		reg.put(IMAGE_CORRECTION_CHANGE, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/full/obj16/correction_change.gif"));
		reg.put(IMAGE_CORRECTION_RENAME, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/full/obj16/correction_rename.gif"));
		reg.put(IMAGE_CORRECTION_SYNCHRONIZE, imageDescriptorFromPlugin(IDEUIPlugin.PLUGIN_ID, "icons/full/obj16/correction_synchronize.gif"));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		PreferencesHint.registerPreferenceStore(IDEUIModule.PREFERENCES_HINT, getPreferenceStore());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static IDEUIPlugin getDefault() {
		return plugin;
	}

}
