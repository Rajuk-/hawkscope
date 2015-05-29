# General #

### What is Hawkscope? ###
It's an application that resides in your system tray and allows you to browse your hard drive and open anything within seconds.

### How to use Hawkscope? ###
Install it, run it, click the hawk icon ![http://hawkscope.googlecode.com/svn/trunk/src/main/resources/icons/hawkscope16.png](http://hawkscope.googlecode.com/svn/trunk/src/main/resources/icons/hawkscope16.png) in system tray / menu bar, the menu will pop out. Navigate through it to find your files and folders. Click on Settings to pimp your menu with custom Quick Access list, plugins, etc. Refer to [Help](Help.md) for more.

### Is it free? ###
Absolutely, it's free and open source.

### How can I join the development? ###
  * Post issues in [Issue Tracker](http://code.google.com/p/hawkscope/issues/list) to request features or bug fixes
  * Check out the source code
  * Make patches or contributions and post them to the [Issue Tracker](http://code.google.com/p/hawkscope/issues/list) or send by email to tomas.varaneckas@gmail.com.
  * Contribute [Plugins](Plugins.md)

### Will the upgrade from version X to Y break my old settings in .hawkscope.properties? ###
No, it will not. New properties are merged.

### What are the Network Proxy settings for? ###
It's for checking for updates and for accessing the online help while being behind a proxy.

### I like Hawkscope and I want to support the development ###
You are welcome to [donate](http://www.varaneckas.com/projects/opensource/hawkscope) a small amount of money.


---

# Windows #

### I'm getting a "missing msvcr71.dll" warning when running the Windows executable ###
msvcr71.dll is Microsoft Visual C Runtime 7.1 Dynamic Link Library. This library is not distributed along with Hawkscope windows executable (below version 0.5.3). You can [download msvcr71.dll](http://www.dll-files.com/dllindex/dll-files.shtml?msvcr71) and drop it to your C:\Windows\System32 folder, or simply update Hawkscope.

### Where's the Windows 64-bit version? ###
32-bit version should run fine, so I did not install 64-bit Windows just to make a build. If you can provide a 64-bit Windows build, please do.

### How did you make Windows .exe from a JAR file? And the Installer? ###
With [JSmooth](http://jsmooth.sourceforge.net/) and [NSIS](http://nsis.sourceforge.net).

### How to add network shares to quick access list? ###
Since Hawkscope 0.4.0 you can do it via Settings -> Quick Access by adding a mounted share like a regular folder. Or you can map the network share to Windows drive (right click My Computer -> Map Network Drive), i.e.: S:. The drive will be automatically displayed in Hawkscope main menu.


---

# Linux #

### Installation errors due to some dependency issues ###
Try enabling third party repositories. More [here](Installing.md).

### Can't load library: /usr/lib/jvm/java-6-openjdk/jre/lib/i386/xawt/libmawt.so ###
This means you had java-6-openjdk installed prior to sun-java6-jre. Run in Terminal:
```
sudo update-java-alternatives -s java-6-sun
```

### I've made Hawkscope autostart in my Gnome sessions preference, but it does not show up ###
Please read the UsingHawkscope carefully. Due to Java Bug: [#6438179](http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6438179) you have to add `-delay 15000` (starts application 15 seconds later, so system tray loads first).

### How to add network shares to quick access list? ###
Mount them first, then add in regular way (/mnt/share/name)

### Hawkscope sucks, how to remove it? ###
```
sudo dpkg -r hawkscope
#to remove configuration
rm ~/.hawkscope.properties
```


---

# Mac OS X #

### I would like to remove Hawkscope icon from the dock ###
I would like that too ([Issue #31](https://code.google.com/p/hawkscope/issues/detail?id=#31)), however there is an Eclipse SWT bug on this subject: [#268687](https://bugs.eclipse.org/bugs/show_bug.cgi?id=268687)

---

# Plugins #

### Twitter plugin does not work, and it also breaks Hawkscope menu from loading ###
Twitter API has [changed](http://groups.google.com/group/twitter-development-talk/browse_thread/thread/f79c44d905a3e83d?pli=1) recently. When [Twitter4J](http://yusuke.homeip.net/twitter4j/en/index.html) library will adopt this change, new version of Twitter plugin will be out. Meanwhile please remove the plugin. Plugins are located at:
  * Mac: /Users/youruser/Library/Application Support/Hawkscope
  * Windows XP: C:\Documents and Settings\youruser\.hawkscope-plugins
  * Windows Vista: C:\Users\youruser\.hawkscope-plugins
  * Linux: /usr/share/hawkscope/plugins
Hawkscope 0.6.0 does not allow plugins to break the main menu.
Twitter plugin 1.4 has this issue fixed.