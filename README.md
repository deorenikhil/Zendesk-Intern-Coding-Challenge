# Zendesk-Intern-Coding-Challenge #

A Java Application to View Zendesks Tickets on Console.

###	Installation And Usage Instructions ###

#### Requirements ####

1. Java version : 1.8.0
2. org.json in java Library : json-20140107.jar
3. Junit Library : junit-4.12.jar

#### How To Run the Application on windows. ####
* Clone the repository into your local machine.
* create two folders : classes and libraries in the local repository (inside repository).
* Put the required jars(json-20140107.jar, junit-4.12.jar) in the libraries folders.
* Compile the source code using following command.

 `javac -sourcepath src -d classes -cp libraries/json-20140107.jar src/Master.java`
* Run the application using following command.

 `java -cp classes;libraries/json-20140107.jar Master`
 
* Following is the snapshot of the console output
	 
	 Welcome to Ticket Viewer Application

 Please Enter Subdomain : subdomain

 Please Enter the E-mail : email

 Please Enter the password : password

	 Zendesk Ticket Viewing Application
	 1. View All Tickets
	 2. Search Ticket by ID
	 3. exit


Please Enter the number from the Menu : 1

ID  | SUBJECT                                            | STATUS | GROUP ID     | PRIORITY   | TYPE       | TAGS                          
-------------------------------------------------------------------------------------------------------------------------------------
1   | Sample ticket: Meet the ticket                     |  OPEN  | 360000243673 | normal     | incident   | [sample, support, zendesk]                        
2   | velit eiusmod reprehenderit officia cupidatat      |  NEW   | 360000243673 |            |            | [est, incididunt, nisi]                           
3   | excepteur laborum ex occaecat Lorem                |  NEW   | 360000243673 |            |            | [amet, labore, voluptate]                         
4   | ad sunt qui aute ullamco                           |  NEW   | 360000243673 |            |            | [laborum, mollit, proident]                       
5   | aliquip mollit quis laborum incididunt             |  NEW   | 360000243673 |            |            | [consectetur, mollit, sit]                        
6   | nisi aliquip ipsum nostrud amet                    |  NEW   | 360000243673 |            |            | [cillum, et, occaecat]                            
7   | cillum quis nostrud labore amet                    |  NEW   | 360000243673 |            |            | [ad, et, lorem]                                   
8   | proident est nisi non irure                        |  NEW   | 360000243673 |            |            | [aute, consectetur, sit]                          
9   | veniam ea eu minim aute                            |  NEW   | 360000243673 |            |            | [ad, aute, et]                                    
10  | magna reprehenderit nisi est cillum                |  NEW   | 360000243673 |            |            | [aliquip, magna, non]                             
11  | quis veniam ad sunt non                            |  NEW   | 360000243673 |            |            | [aliquip, consequat, magna]                       


 For more tickets enter 1 to exit press 2 : 1

ID  | SUBJECT                                            | STATUS | GROUP ID     | PRIORITY   | TYPE       | TAGS                          
-------------------------------------------------------------------------------------------------------------------------------------
12  | tempor aliquip sint dolore incididunt              |  NEW   | 360000243673 |            |            | [ad, minim, non]                                  
13  | labore pariatur ut laboris laboris                 |  NEW   | 360000243673 |            |            | [culpa, dolor, eiusmod]                           
14  | officia mollit aliqua eu nostrud                   |  NEW   | 360000243673 |            |            | [cillum, fugiat, irure]                           
15  | do incididunt incididunt quis anim                 |  NEW   | 360000243673 |            |            | [exercitation, officia, veniam]                   
16  | tempor magna anim ea id                            |  NEW   | 360000243673 |            |            | [id, laborum, reprehenderit]                      
17  | exercitation sit incididunt magna laboris          |  NEW   | 360000243673 |            |            | [non, proident, tempor]                           
18  | laborum ea ut in cupidatat                         |  NEW   | 360000243673 |            |            | [commodo, exercitation, sunt]                     
19  | est fugiat labore pariatur esse                    |  NEW   | 360000243673 |            |            | [dolore, reprehenderit, veniam]                   
20  | commodo sint laboris est et                        |  NEW   | 360000243673 |            |            | [excepteur, sunt, ut]                             
21  | laboris sint Lorem ex Lorem                        |  NEW   | 360000243673 |            |            | [commodo, duis, minim]                            


 For more tickets enter 1 to exit press 2 : 2

	 Zendesk Ticket Viewing Application
	 1. View All Tickets
	 2. Search Ticket by ID
	 3. exit


Please Enter the number from the Menu : 2

 Please Enter The ID for the Ticket :  100

ID  | SUBJECT                                            | STATUS | GROUP ID     | PRIORITY   | TYPE       | TAGS                          
-------------------------------------------------------------------------------------------------------------------------------------
100 | adipisicing duis quis consequat velit              |  NEW   | 360000243673 |            |            | [fugiat, mollit, quis]                            

	 Zendesk Ticket Viewing Application
	 1. View All Tickets
	 2. Search Ticket by ID
	 3. exit


Please Enter the number from the Menu : 3
Exiting the application, Thank You !
