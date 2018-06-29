Here is the basic structure for the project.  This was built using Maven 3.5.3.  The project's pom.xml is provided as is the test-case.json file.  Dependencies, assumptions, and how to run program is listed below

Dependencies
- [Maven](https://maven.apache.org/docs/3.5.3/release-notes.html)
- [Google's GSON](https://github.com/google/gson)
- [JUnit 4.12](https://junit.org/junit4/)

Assumptions
- A valid json object will be passed in that follows the structure noted in the project
- Valid dates are also passed in

Instructions
- Use provided JAR file and move to a directory where it can be ran.

- In same directory of JAR file, move the json file that will be used for testing.  For this example, the file is named test-case.json.  

- Use the Terminal and navigate to the directory with the JAR and json file.

 In the command line, type the following (without the quotes):

 "java -cp campspot-1.0-SNAPSHOT.jar com.campspot.app.App test-case.json"

The structure of the command is:

java -cp [nameOfJarFile] [locationOfMainMethod] [relativePath to JsonFile]

