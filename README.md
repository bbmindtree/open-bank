##Summary:
Open Bank application is developed on Spring MVC with the help of camel Spring DSL. Configured in memory spring security. Application showing all transactions, filter transactions and total amount of filtered transactions, for this application expose three endpoints. Application also cover Unit test for all above scenarios.
 
Features:
-	Used jetty embedded web servlet container to startup the web application in maven   
-	Used camel to route web service call
-	Configured Logback for logging
-	Application handle exceptions and redelivery feature with delay (both values are configurable)
-	Tested code on sonar-lint eclipse plugin. 




##Deployment Steps:

Step 1: checkout the project using below command 
	$ git clone https://github.com/bbmindtree/open-bank.git

Step 2:run on embedded jetty 
 
 	Mvn clean install jetty:run

Step 3: open browser and hit the below url :
	
	http://localhost:8080/open-bank

Step 4: use username – admin and password – admin it will redirect to home page.

Step 5: There are three options are coming on select box [All, sendbox and total amount] test all three cases via select option.

##Tomcat deploy step
I have configure maven profile to deploy war into tomcat webapps directory. If you want to test this application on tomcat, simply change the path of your tomcat directory.

Step 1: open pom.xml and change the <tomcat.webapp.dir> property value to your tomcat directory path
Step 2: build the project with deploy-war profile
	
	mvn clean install –Pdeploy-war
	
	
##Exposed three endpoints:

1- /v1/gettransactions with Basic Authentication header parameter [username - admin, password - admin ]

2- /v1/getfiltertransactions with header parameter key - transactiontype  value - sandbox-payment and Basic Authentication

3- /v1/gettotalamount with header parameter key - transactiontype  value - sandbox-payment and Basic Authentication


##Environment test:
Operating system- windows 
Server – tomcat 8, tomcat 7, jetty
Jdk – java 7 and java 8
Ide – eclipse (sonar lint plugin configured)	

	







