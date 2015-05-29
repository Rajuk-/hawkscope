# About this section #
If you are looking for a simple Help, go [here](Help.md). This section is more of a "Hacking Hawkscope".

# Running the jar #

You have to [build](BuildingHawkscope.md) it first.

If you have your [Java Runtime Environment](http://java.sun.com/javase/downloads/index.jsp) installed correctly, double click hawkscope.jar to run it.

Otherwise you can run it from command line:
```
java -jar hawkscope.jar
```

# Running Hawkscope on Startup #

## Windows ##
Hawkscope is automatically added to your Start Menu -> Programs -> Startup folder during setup. If you don't want it to run on Windows startup, remove the shortcut.

## Linux (Gnome) ##
Go to System -> Preferences -> Sessions
Add new autostart item with command:
```
hawkscope -delay 5000
```
Ubuntu users may look here: https://help.ubuntu.com/community/AddingProgramToSessionStartup.
Startup delay is required due to Java Bug [#6438179](http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6438179)

## Mac OS X ##
Right click Hawkscope dock item and then select "Open at Login". Or go to System Preferences > Accounts > Login Items and add Hawkscope there manually.


# Configuration #

Hawkscope writes it's own configuration file `.hawkscope.properties` in user home folder.

Operating Systems have different user home folder:
  * Windows XP: `C:\Documents and Settings\username\`
  * Windows Vista: `C:\Users\username\`
  * Linux: `/home/username`
  * Mac: `/Users/username`

You can edit this file with plain text editor to manually configure several options. As of 0.4.0 Hawkscope has a configuration window, you should only edit `.hawkscope.properties` to add Quick Acess path hacks:
| Property | Title | Description |
|:---------|:------|:------------|
| quick.access.list | Quick Access List | Adds custom entries to quick access list. Entries separated with ";". It can either be a full path, a java property, like ${user.home} (default) or environmental variable like ${$JAVA\_HOME}.|

Example .hawkscope.properties path hack:
```
quick.access.list = ${user.home};${user.home}/Development;/mnt/myserv;${$JAVA_HOME}
```

