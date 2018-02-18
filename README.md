# Zendesk-Intern-Coding-Challenge #

A Java Application to View Zendesks Tickets on Console.

###	Installation And Usage Instructions ###

#### Requirements ####

1. Java version : 1.8.0
2. org.json in java Library : json-20140107.jar
3. Junit Library : junit-4.12.jar

#### How To Run the Application on windows. ####
* Clone the repository into your local machine.
* Create two folders : classes and libraries in the local repository (inside repository).
* Put the required jars(json-20140107.jar, junit-4.12.jar) in the libraries folders.
* Compile the source code using following command.

 `javac -sourcepath src -d classes -cp libraries/json-20140107.jar src/Master.java`
* Run the application using following command.

 `java -cp classes;libraries/json-20140107.jar Master`

* While running the junit tests, Enter credentials in loginTest method of UserAuthenticationTest 

