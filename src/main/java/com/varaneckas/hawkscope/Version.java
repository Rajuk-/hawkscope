package com.varaneckas.hawkscope;

import java.util.Date;

/**
 * Hawkscope Version information
 *
 * @author Tomas Varaneckas
 * @version $Id$
 */
public class Version {
    
    /**
     * Application name
     */
    public static final String APP_NAME = "Hawkscope";
    
    /**
     * Application slogan
     */
    public static final String APP_SLOGAN = "Access anything with single click!";
    
    /**
     * Application version number   
     */
    public static final String VERSION_NUMBER = "0.1.3";
    
    /**
     * Application version date
     */
    public static final String VERSION_DATE = "2008-??-??";
    
    /**
     * Application Homepage URL
     */
    public static final String HOMEPAGE = "http://hawkscope.googlecode.com";
    
    /**
     * Gets a nice application version string
     * 
     * @return long version string
     */
    public static String formatFullString() {
        return APP_NAME.concat(" ").concat(VERSION_NUMBER)
                .concat(" (").concat(VERSION_DATE)
                .concat(") [").concat(HOMEPAGE).concat("]");
    }
    
    /**
     * Gets application name and version
     * 
     * @return name and version
     */
    public static String formatString() {
        return APP_NAME.concat(" ").concat(VERSION_NUMBER);
    }
    
    /**
     * Gets system properties as single formatted string
     * 
     * @return environment
     */
    public static String getSystemProperties() {
        final StringBuilder props = new StringBuilder();
        for (final Object p : System.getProperties().keySet()) {
            props.append(p).append(": ").append(System.getProperty("" + p));
            props.append('\n');
        }
        return props.toString().trim();
    }
    
    /**
     * Generates Environmental report
     * 
     * @return report
     */
    public static String getEnvironmentReport() {
        final StringBuilder env = new StringBuilder("Hawkscope Environment Report\n");
        env.append("--------------------------------------\n");
        env.append(formatFullString()).append('\n');
        env.append("--------------------------------------\n");
        env.append(getSystemProperties()).append('\n');
        env.append("--------------------------------------\n");
        env.append(new Date()).append('\n');
        env.append("--------------------------------------\n");
        return env.toString();
    }
    
}
