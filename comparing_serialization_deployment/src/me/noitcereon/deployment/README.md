# Deploying Java Code

This README will contain commands with brief explanations on how to:
- Compile java
- Run Java code
- Make deployable .jar fle (Java ARchive file)


## Compile Java
Below will compile the DeploymentWorker.java into a bytecode (.class) file.
You can use -d to specify an existing directory to output the file in.
> NOTE: you have to be in the same directory as the .java file.
```cli
javac DeploymentWorker.java
```

## Run Java

To run the compiled code run the following command:
> Note: "-cp <class search path of directories and zip/jar files>" (it is important where you search from. In this case my package didn't match directory structure, as it did not include src folder.)
```cli
java DeploymentWorker
or
java -cp "C:\Users\tandersen25\Repositories\TheCompleteJavaCertificationCourse\TheCompleteJavaCertificationCourse\comparing_serialization_deployment\src\"  me.noitcereon.deployment.DeploymentWorker
```

To run an executable jar run the following command:
```
java -jar "myExecuteableJarFile.jar"
```


## Make Executeable JAR file
- Have an entrypoint class that contains "public static void main(String args){} method.'
- Make a manifest file with the entrypoint class specified (manifest.mf). The file needs to end with a new line.

```mf
Main-Class: me.noitcereon.deployment.DeploymentWorker

```

Creates a .jar file with the given name. It's contents would META-INF folder with the MANIFEST.mf and all .class files in this folder.
(c = create, v = verbose, f = file, m = manifest)
```cli
jar -cvfm <Name>.jar MANIFEST.mf *.class
```

If I wanted to make an executeable jar file for DeploymentWorker.class, I'd do the following:

- Change directory to /src directory.
  - In my case the absolute path would be `C:\Users\tandersen25\Repositories\TheCompleteJavaCertificationCourse\TheCompleteJavaCertificationCourse\comparing_serialization_deployment\src`
- Execute the below command.
```
jar -cvfm deploymentWorker.jar .\me\noitcereon\deployment\MANIFEST.mf .\me\noitcereon\deployment\*.class                 
```


Since ours is a console app, we cannot launch it by double-clicking the .jar file.

Instead, we can type `java -jar deploymentWorker.jar`

## Bonus
Example executeable jar: 
- Super Mario Bros in Java: https://sourceforge.net/projects/super-mario-bros-java/

### Commands
- `jar -tvf myJarFile.jar` (table of contents, verbose, file). Lists all files in the .jar file. 
- `jar -xvf myJarFile.jar` (extract, verbose, file). Extracts files out of the .jar file to current directory.
- 