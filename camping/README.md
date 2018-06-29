Here is the basic structure for the project.  This was built using Maven 3.5.3.  The project's pom.xml is provided as is the test-case.json file.  Dependencies, assumptions, and how to run program is listed below

## Dependencies
- [Maven](https://maven.apache.org/docs/3.5.3/release-notes.html)
- [Google's GSON](https://github.com/google/gson)
- [JUnit 4.12](https://junit.org/junit4/)

## Assumptions
- A valid json object will be passed in that follows the structure noted in the project
- The reservations in the json object are valid
- Valid dates are also passed in
- CampSite ids are ints
- There is at least one campsite that is available (to correct)
- There are some methods within the classes which are not used - like toString and equals methods.  This was just used for testing and left in.

## Instructions
* Use provided JAR file and move to a directory where it can be ran.

* In same directory of JAR file, move the json file that will be used for testing.  For this example, the file is named test-case.json.  

* Use the Terminal and navigate to the directory with the JAR and json file.

* In the command line, type the following (without the quotes):

	* "java -cp campspot-1.0-SNAPSHOT.jar com.campspot.app.App test-case.json"

* The structure of the command is:

	* java -cp [nameOfJarFile] [locationOfMainMethod] [relativePath to JsonFile]

## High Level Explanation

- This project is designed to take in a Json file that has dates, start and end, for a pending reservation.  The file also includes campsites, which have ids and names, and a list of current reservations on the books, which have the campsite id and start/end date.  It used that file to determine which campsites are open to the reservation dates and prints off the campsite names.

- Here is the high level description for each of the class: 

* App
	* This is the class which contains the main method.  It is used primarily to read in the json file.  The json object is passed to the CampSiteSearch class using GSON to do the serialization.  It then passes the CampSiteSearch to the Driver class, which completes the objective of the project.

* CampSiteSearch
	* This class allows GSON to serialize the information in the json object.  The object also has the method getCampGroundName(int id) which is used to search the list of CampSites and returns the name of the site.

* CampSite
	* This holds a String name and int id.

* Reservations
	* This object holds a campsite id, which references a specific CampSite object, a String StartDate, and a String EndDate.  

* Search
	* From the json object which is the start and end date used for the pending reservation.