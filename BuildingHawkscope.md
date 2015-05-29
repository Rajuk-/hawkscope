# Building Hawkscope #
If you're into bleeding edge things, building Hawkscope from source is for you! Why wait for releases when you can get all the new features before everyone else - just build the latest version and enjoy. :)

### Prequisites ###
To build Hawkscope, you need:
> Bare minimum:
  * JDK 5+
  * Maven 2.0.6+
  * SVN client (to get the source)
> Optional:
  * Ant 1.7+ (to build the installers)
  * NSIS2 (to build Windows installer)

### Quick build steps for all the lazy ones ###
  * Download JDK, install, set `JAVA_HOME` environmental variable
  * Download Maven, extract somewhere, add maven/bin to your `PATH`
  * Get a working SVN client (i.e. [TortoiseSVN](http://tortoisesvn.tigris.org) on Windows or simply `sudo apt-get install subversion` on Linux)
  * Checkout the source from `http://hawkscope.googlecode.com/svn/trunk`
  * Go to checked out folder with command line terminal (`cmd.exe` on Windows or any shell in Linux)
  * Go to `lib/` folder and execute your line from `install.txt`. You can execute all of them if in doubt. For Windows folks: go to `lib/` with `cmd.exe` and run `mvn install:install-file -DgroupId=org.eclipse.swt -DartifactId=swt-win-32 -Dversion=3.4 -DgeneratePom=true -Dpackaging=jar -Dfile=swt-win-32.jar`
  * Run `mvn clean package`
  * The build result will be in `target/` folder. Look for `hawkscope-...-jar-with-dependencies.jar`
  * That's it. You can run it by double clicking or with `java -jar hawkscope-....jar`
  * If you failed, don't worry. Read more about building below. It should help.

### Adding SWT native library to local Maven repository ###
Hawkscope uses Eclipse SWT native libraries for each os / arch. Library
dependency is automatically selected via Maven profiles in pom.xml.
Current profiles are: win32, win64, linux32, linux64.
To install SWT native library to local Maven repository, find out your
system architecture (i.e. if you're on Windows XP, it is most probably 32 bit,
so your architecture would be win32), then install the appropriate jar from
Hawkscope project's /lib folder. Refer to lib/install.txt to find the
mvn install:install-file line that is suitable for you.
If you want to build Hawkscope and there is no profile for your operating system
and CPU architecture, you can create new Maven profile in pom.xml, download your
SWT implementation from http://www.eclipse.org/swt/ and install it. Please
feel free to contribute new profiles.

### Packaging Hawkscope + dependencies into executable JAR ###
To build an executable jar, simply run:
```
mvn clean package
```
The jar will be in target/ folder, named:
hawkscope-(version)-(os)-(arch)-jar-with-dependencies.jar

### Creating Windows installer ###
Run `ant dist-win`. Installer will reside in dist/output/hawkscope-(version)-installer.exe

### Creating Mac OS X app + packaging it in a Disk Image ###
Run `ant dist-mac` and check the dist/output folder for goodies.

### Creating Debian Package ###
Run `ant dist-deb` and look at dist/output

# Running Hawkscope #

### Running Hawkscope from executable JAR ###
Doubleclick the executable jar, or execute in console:
```
java -jar hawkscope-...jar
```

On Mac:
```
java -jar -XstartOnFirstThread hawkscope-...jar
```