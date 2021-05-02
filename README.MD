
# About Gasapp!
**ATENTION!**, http://www.anp.gov.br/ is consumed in this project to consume prices and stations.
**ATENTION!**, change in constants.java file the key to jwt, and fill all application.properties files to connect in your databases

**Gasapp** is an open source API to run and consume Brazilian fuel prices, you can use it to consume prices as a json format and show in your application. **Gasapp**  also is an application to improve some topics from your creator, me! haha per example:

 - Java
 - Spring
 - PostgreSQL
 - MongoDB
 - UML
 - AWS EC2
 - Docker

This tools, languages, dbs and frameworks where used in **Gasapp**, bellow we can see how i used this tools on project:

## Java
Language was used in all modules.

## Spring
Was used like a Java framework to facilitate some jobs, like architeture, database connection and much more.

## PostgreSql
Database Postgre i used to build authentication module, because sql database is more consistent to AUTHENTICATION modules.

## MongoDb

To store fuel data, like price and address i prefer use noSQL db, because this data is volatile and everey week are updated in a Java Spring Cron.

## UML
To modeling bussness rules.

## AWS EC2 & Docker
To deploy and to make available api controllers, and to run every week the java cron.

# How to use ?
Clone the project, import all maven modules and run each api **(API-AUTH / API-STATION)** on separated port, like 8084 and 8080, after this, use the controller endpoints:

 - /v1/auth/signup 
 Post method to register
 
 - /v1/auth/signin
 Post method to to login and get bearer token
 
 - /v1/station/get-stations
 GET method to get list station and prices by district param

## Roles
Api have roles architeture on auth module, just ADMIN role can access **/v1/users/get-all** endpoint.

		
