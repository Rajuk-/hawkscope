So, you want to write a Hawkscope Plugin? You are in a right place then.
# Required Knowledge #
  * Core Java 5+
  * [Eclipse SWT](http://www.eclipse.org/swt)

# Anatomy of a Plugin #
Hawkscope Plugin is a Java JAR file, which contains:
  * plugin.loader - a plain-text file with fully qualified class name of main plugin class.
  * Java Class that implements [com.varaneckas.hawkscope.plugin.Plugin](http://hawkscope.googlecode.com/svn/trunk/src/main/java/com/varaneckas/hawkscope/plugin/Plugin.java) interface. For convenience, it is recommended to extend [PluginAdapter](http://hawkscope.googlecode.com/svn/trunk/src/main/java/com/varaneckas/hawkscope/plugin/PluginAdapter.java), which allows you to implement only the functionality you will need.
  * Image resources in "images" folder. (optional)
  * Any other Java classes or resources. (optional)

Hawkscope plugins should be compiled with Java 1.5 compatibility.

# The Bare Minimum #
![http://lh3.ggpht.com/_nP8Aa6cTHpo/SZ0rYiF7FAI/AAAAAAAABVY/M5iotSSwKb8/hs8.png](http://lh3.ggpht.com/_nP8Aa6cTHpo/SZ0rYiF7FAI/AAAAAAAABVY/M5iotSSwKb8/hs8.png)

`plugin.loader`
```
bare.MinimumPlugin
```

`bare/MinimumPlugin.java`
```
package bare;

import com.varaneckas.hawkscope.plugin.PluginAdapter;

class MinimumPlugin extends PluginAdapter {
    
    public String getDescription() {
        return "Bare Minimum Plugin";
    }

    public String getName() {
        return "Bare Minimum";
    }

    public String getVersion() {
        return "1.0";
    }
}
```

# Extension Points #

There are several extension points that plugins can hook into.

### Before Quick Access List ###

Can add menu items on the very top of main Hawkscope menu.

### Before About Menu Item ###

Can add menu items between Hide and About.

### Quick Access List Item creation ###

Can enhance Quick Access List items while they are rendered.

### Folder Menu creation ###

Can enhance Folder Menu items when they are rendered.

### File Menu Item creation ###

Can enhance File items when they are rendered.

### File Menu Item click interception ###

Can intercept File clicks and take various actions.

### Settings Tabs ###

Can add tabs to Settings Window's Tab folder.

# Example Plugin #

You can browse [Open With built-in plugin source](http://hawkscope.googlecode.com/svn/trunk/src/main/java/com/varaneckas/hawkscope/plugin/openwith/) for a sophisticated plugin example.

Another good example - [Twitter plugin](http://hawkscope.googlecode.com/svn/plugins/twitter/trunk).

# Where to start? #
  1. [Checkout](http://code.google.com/p/hawkscope/source/checkout) or [Download](http://code.google.com/p/hawkscope/downloads/list) Hawkscope source, analyze it. Read [BuildingHawkscope](BuildingHawkscope.md).
  1. If you are using [Eclipse](http://www.eclipse.org), create an Eclipse project for Hawkscope source. Otherwise build a hawkscope.jar - you will need it for building your plugin.
  1. Create a Java project in your IDE. If it's Eclipse, reference the Hawkscope project to your plugin's new project. Otherwise add hawkscope.jar to a list of referenced libraries.
  1. Create a class that extends [PluginAdapter](http://hawkscope.googlecode.com/svn/trunk/src/main/java/com/varaneckas/hawkscope/plugin/PluginAdapter.java).
  1. Create a plain-text file named `plugin.loader` and put your plugins fully qualified class name there.
  1. Code your plugin.
  1. Build the JAR. (Compile the classes with Java 1.5 compatibility!)
  1. Try it.

More documentation is coming soon.