# User-Interface

* [Background](#headers) <br/>
* [Versions](#headers) <br/>
  * [Version 1.0](#headers) <br/>
    * [Features](#headers) <br/>
    * [Design](#headers) <br/>
  * [Version 2.0](#headers) <br/>
    * [Features](#headers) <br/>
    * [Design](#headers) <br/>
* [Used Libraries](#headers) <br/>
* [Further Notes](#headers) <br/>

<a name="headers"/>
## Background

This project began in September 2015 and ended in April 2016. It was developed in a team of 5 students for our Engineering Capstone Project. The main objective of the project was to design and implement an automatic bluetooth tracking system that would take the attendance of in a class by detecting a BLE tag in their student ids. The project was split up into 4 components: the desktop software, the scanner software, the smartphone app and the database (Cloudant NoSQL database). This repository contains the desktop software component. The Desktop software will allow school administrators to view the attendance information recorded and add new students, classes and teachers to the system. It does this through a simple to use UI.

<a name="headers"/>
## Versions
There were two versions of the desktop software implemented. The first version was the prototype version while the second version was the finish product. Both versions use a different Java UI framework and version 2 provides significantly more features that version 1.

<a name="headers"/>
### Version 1.0

The initial version used the the Java Swing UI framework. It provided no input validation for user input and data was displayed in tables. 

<a name="headers"/>
#### Features

* Allowed user to view only student's/administrator's name and their timetable. It also displayed course information like it's start and end times
* Allowed user to add new student/administrator/course information. The input supplied had no validation performed on it.
* Information was displayed using tabs and tables

<a name="headers"/>
#### Design

* Consisted of 3 java classes: the UI class, a data wrapper class to handle data sent/received from the database, and a class to interface with the database
* There was no inherent design pattern used to implement version 1, although it was implemented with modularity and separation of concerns in mind

<a name="headers"/>
### Version 2.0

The second version was implemented using the QtJambi UI framework and was completely redesigned ( with the exception of the data wrapper class in version 1). It provided input validation among other things that version 1 lacked.

<a name="headers"/>
#### Features

* Allowed user to view all the information regarding students/adminstrators like their name, ID, timetable, total number of lates, total number of absents, current class, current location and their current status.
* For courses it displayed, the course name, ID, start/end time, and location.
* Allowed users to add or delete students/administrators/courses from the system. The input entered is validated
* It had a login screen to restrict access to only registered administrators
* Consisted of a search function to allow users to search for the information they need by ID or name
* It a refresh button to allow the user to update the displayed information
* Allowed users to specify how long all classes lasted which is important information need by the tracking system to determine whether a student is late or absent. (Useful for half days or change in schedules)
* Each student/administrator/course information is displayed in a customized UI widget

<a name="headers"/>
#### Design

* Implemented using the MVC design pattern. It consists of three packages: controller, model and view packages
* The model package has 7 classes. One class acts as a wrapper for the data sent/received from the database while another class is used to reset the attendance information in the database. The other classes handle a different aspect of information stored in the database. This package was designed using the Facade pattern with the Model.java class acting as the facade.
* The view package consists of 9 classes with each class handling a different aspect of the UI like the widget for displaying student information. It was also designed using the facade pattern and the class MainView.java is the facade
* The controller package consists of 1 java class and uses both the Model and MainView classes to connect both the frontend and backend together as one.

<a name="headers"/>
## Used Libraries
* Cloudant library (Java)
* QtJambi (Java UI framework)

<a name="headers"/>
## Further Notes

For further details regarding this Engineering Capstone Project, please read the attached final report in the repository. See sections 1, 3.1 and 4.1 
