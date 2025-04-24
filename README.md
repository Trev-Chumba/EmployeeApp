# Employee App

###### This is a simple fullstack jakarta ee application with all CRUD actions


## Prerequisites
* Payara Server 6
* JAVA 17 preferred but 11 and above should run
* MYSQL or MARIADB server with a database called "employee_db" (both services are fully compatibe)


## How to run
*Assuming you have already cloned the repo or have the unpacked the zip file.*  
*These instructions are also linux specific but the process should be similar if you have windows and mac commands.* 

1. if you have acces to global payara servers' asadmin command:


```
>asadmin start-domain {preferred_domain_name}
//you can list domains with asadminlist-domains  start-domain will start a default domain
```
**If not head to the payara server bin directory and run the shell file with:** 


```
./asadmin start-domain {preferred_domain_name}
```

2. After you can confirm the the domain is now running you can now deploy the .war file

```
./asadmin deploy /{path_to_directory}/target/EmployeeApp-1.0-SNAPSHOT.war
```
###### This should give you access to the application in payara admin console and can be run from there.

3. Go to the browser of your choice and enter the url to payara admin console mine is:
######  localhost:4848 (the default)

4. You can list the applictions with the asadmin command
```
./asadmin list-applications
```
This means it should be added to your
you can access the application with the url `localhost:8080/EmployeeApp/` (the port is my default you may have different settings).
To be sure go to your admin consolse in the applications menu where you can see the launch options.



## Images

![This is an alt text.](/screenshots/main.png "This is a sample image.")


