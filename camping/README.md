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
- There are some methods within the classes which are not used - like toString and equals methods.  This was just used for testing and left in.

## Instructions
* Use provided JAR file and move to a directory where it can be ran.

* In same directory of JAR file, move the json file that will be used for testing.  For this example, the file is named test-case.json.  

* Use the Terminal and navigate to the directory with the JAR and json file.

* In the command line, type the following (without the quotes):

	* "java -cp campspot-1.0-SNAPSHOT.jar com.campspot.app.App test-case.json"

* The structure of the command is:

	* java -cp [nameOfJarFile] [locationOfMainMethod] [relativePath to JsonFile/JsonFileName]

## High Level Explanation

- This project is designed to take in a Json file that has dates, start and end, for a pending reservation.  The file also includes campsites, which have ids and names, and a list of current reservations on the books, which have the campsite id and start/end date.  It used that file to determine which campsites are open to the reservation dates and prints off the campsite names.

- Here is the high level description for each of the class: 

* App
	* This is the class which contains the main method.  It is used primarily to read in the json file.  The json object is passed to the CampSiteSearch class using GSON to do the serialization.  It then passes the CampSiteSearch to the Driver class, which completes the objective of the project.

* Driver
	* This class does the heavy lifting for this project.  It takes the information from the CampSiteSearch class (which is the representation of the json object). From this, it parses out the needed information into smaller classes.  The primarily method is run().
		* run() creates a hashMap that is used later to see which CampSites are available for the pending reservation.  At first, it is assumed that each campsite is available. It then goes through each reservation to see if the dates conflict with the pending reservation.  It uses the dateCheck() method to do this validation.  If it is not, its value in the hashMap is changed from being available to unavailable.  It then passes the hashMap to the buildResponse() method that creates a String response.  That is printed out to the screen.
		* dateCheck() uses three helper methods to check if the pending reservation dates are valid based off the current reservation dates.  It first checks if start date is valid, then the end, and then makes sure the either date does not overlap with the current reservation.
		* buildResponse() takes the hashMap and iterates through it.  If the key campId has a 'true' boolean value, it then gets the CampSite name and adds it to the answer. 

* CampSiteSearch
	* This class allows GSON to serialize the information in the json object.  The object also has the method getCampGroundName(int id) which is used to search the list of CampSites and returns the name of the site.

* CampSite
	* This holds a String name and int id.

* Reservations
	* This object holds a campsite id, which references a specific CampSite object, a String StartDate, and a String EndDate.  

* Search
	* From the json object which is the start and end date used for the pending reservation.

## Edits to make project better

* I would add in more error checking - i.e. I would add some checking that the json object was valid as were the values supplied.  

* With error checking, I would add more elegant way of handling those errors and communicate that to user.

* More testing for the Driver, including various date permunations.
