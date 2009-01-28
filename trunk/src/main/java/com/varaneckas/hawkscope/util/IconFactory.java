package com.varaneckas.hawkscope.util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.varaneckas.hawkscope.cfg.ConfigurationFactory;
import com.varaneckas.hawkscope.gui.swt.SWTIconFactory;

/**
 * Icon object factory
 * 
 * @author Tomas Varaneckas
 * @version $Id$
 * @param <IconType> Icon class of the implementation
 */
public abstract class IconFactory<IconType> {

    /**
     * Logger
     */
    private static final Log log = LogFactory.getLog(IconFactory.class);
    
    @SuppressWarnings("unchecked")
    private static IconFactory instance = null;
    
    /**
     * Preloaded resources
     */
    protected static final Map<String, URL> resources = new HashMap<String, URL>();
    
    static {
        try {
            //initialize resources
            resources.put("drive",  IconFactory.class.getClassLoader().getResource("icons/hdd24.png"));
            resources.put("floppy",  IconFactory.class.getClassLoader().getResource("icons/fdd24.png"));
            resources.put("cdrom",  IconFactory.class.getClassLoader().getResource("icons/cdrom24.png"));
            resources.put("network",  IconFactory.class.getClassLoader().getResource("icons/network24.png"));
            resources.put("removable",  IconFactory.class.getClassLoader().getResource("icons/removable24.png"));
            resources.put("folder", IconFactory.class.getClassLoader().getResource("icons/folder24.png"));
            resources.put("folder.open", IconFactory.class.getClassLoader().getResource("icons/folder.open.24.png"));
            resources.put("file",   IconFactory.class.getClassLoader().getResource("icons/file24.png"));
            resources.put("executable",   IconFactory.class.getClassLoader().getResource("icons/executable24.png"));
            resources.put("exit",   IconFactory.class.getClassLoader().getResource("icons/exit24.png"));
            resources.put("hide",   IconFactory.class.getClassLoader().getResource("icons/down24.png"));
            resources.put("more",   IconFactory.class.getClassLoader().getResource("icons/more24.png"));
            resources.put("unknown", IconFactory.class.getClassLoader().getResource("icons/unknown24.png"));  
            resources.put("about",  IconFactory.class.getClassLoader().getResource("icons/about24.png"));  
            resources.put("open",  IconFactory.class.getClassLoader().getResource("icons/open24.png")); 
            resources.put("empty",  IconFactory.class.getClassLoader().getResource("icons/empty24.png")); 
            resources.put("update", IconFactory.class.getClassLoader().getResource("icons/update24.png"));
            resources.put("settings", IconFactory.class.getClassLoader().getResource("icons/settings24.png"));
        } catch (final Exception e) {
            log.warn("Cannot find icon", e);
        }
    }
    
    /**
     * Gets the {@link IconFactory} instance
     * 
     * @param <T> Icon class
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> IconFactory<T> getIconFactory() {
        if (instance == null) {
            instance = new SWTIconFactory();
        }
        return (IconFactory<T>) instance;
    }
    
    /**
     * Gets the icon object
     * 
     * @param icon
     * @return
     */
    abstract public IconType getIcon(final String icon);
    
    /**
     * Gets uncached icon object
     * 
     * @param iconFile
     * @return
     */
    abstract public IconType getUncachedIcon(final String iconFile);

    /**
     * Gets Hawkscope Tray Icon object
     * 
     * @return
     */
    abstract public Object getTrayIcon();
    
    /**
     * Gets icon for {@link File}
     * 
     * @param targetFile any file
     * @return icon
     */    
    public IconType getIcon(final File targetFile) {
        if (ConfigurationFactory.getConfigurationFactory().getConfiguration()
                .useOsIcons()) {
            IconType icon = getFileSystemIcon(targetFile);
            if (icon != null) {
                return icon;
            }
        }
        if (OSUtils.isFileSystemRoot(targetFile)) {
            if (OSUtils.isFloppyDrive(targetFile)) {
                return getIcon("floppy");
            }
            if (OSUtils.isOpticalDrive(targetFile)) {
                return getIcon("cdrom");
            } 
            if (OSUtils.isNetworkDrive(targetFile)) {
                return getIcon("network");
            }
            if (OSUtils.isRemovableDrive(targetFile)) {
                return getIcon("removable");
            }
            return getIcon("drive");
        } else if (targetFile.isFile()) {
        	if (OSUtils.isExecutable(targetFile)) {
        	    return getIcon("executable");
        	}
            return getIcon("file");
        } else if (targetFile.isDirectory()) {
            //mac app
            if (OSUtils.CURRENT_OS.equals(OSUtils.OS.MAC) 
                    && targetFile.getName().endsWith(".app")) {
                return getIcon("executable");  
            } 
            return getIcon("folder");
        } else {
            return getIcon("unknown");
        }
    }
    
    /**
     * Gets best sized tray icon name for current setup
     * 
     * @return tray icon name
     */
    protected String getBestTrayIcon() {
        float height = OSUtils.getTrayIconSize();
        int[] sizes = new int[] { 64, 48, 32, 24, 16 };
        int best = 64;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i] / height >= 1) {
                best = sizes[i];
            }
            else {
                break;
            }
        }
        final String res = "icons/hawkscope" + best + ".png";
        if (log.isDebugEnabled()) {
            log.debug("Chose best icon for " + (int) height 
                    + " pixel tray: " + res);
        }
        return res;
    }    
    
    /**
     * Override to get it working
     * 
     * @param file
     * @return
     */
    public IconType getFileSystemIcon(final File file) {
        return null;
    }
    
    /**
     * Cleanup resources
     */
    public abstract void cleanup();
}
