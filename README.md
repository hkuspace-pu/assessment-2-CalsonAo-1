# assessment-2-CalsonAo-1
assessment-2-CalsonAo-1 created by GitHub Classroom

###############################
# part 1: showcase-api
###############################

---------------------------
third-party tool / library
---------------------------
- spring boot framework (https://spring.io/projects/spring-boot)
- apache common (https://commons.apache.org/)
- Spring Initializr (https://start.spring.io/)
- Microsoft JDBC Driver for SQL Server (https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)


---------------------------
Preparation
---------------------------
1. create tables in database
2. create store procedures
3. create trigger
4. create view
5. edit database configuration in application.yml
	- host: socem1.uopnet.plymouth.ac.uk
	- port: 1433
	- database: COMP2001HK_WAo
	- username and password
	- ddl-auto: none
6. edit API server configuration in application.yml
	- port: 8080
	- context-path: /api
7. insert sample data to database (doc/sp_call.txt)
8. start API

---------------------------
Example API calls
---------------------------
1. get all programmes
HTTP Method: GET
URL: http://localhost:8080/api/programmes

2. create a programmes
HTTP Method: POST
URL: http://localhost:8080/api/programmes
params: {"title": "Networking"}

3. update a programmes
HTTP Method: PUT
URL: http://localhost:8080/api/programmes/1
params: {"title": "Advanced Networking"}

4. delete a programmes
HTTP Method: DELETE
URL: http://localhost:8080/api/programmes/1

---------------------------
Database Audit Table
---------------------------
table: programme_registration
description: audit for programme update
SQL: select * from programme_registration;

---------------------------
Database VIEW
---------------------------
view: v_student_programme
description: for checking students' registered programmes
SQL: select * from v_student_programme;

---------------------------------------
Store Procedures
---------------------------------------
- sp_Create_Programme.txt
- sp_Delete_Programme.txt
- sp_Update_Programme.txt

---------------------------------------
Trigger
---------------------------------------
- tg_Update_Programme.txt

---------------------------------------
VIEW
---------------------------------------
- view_student_programme.txt

###############################
# part 2: json-ld-api with web
###############################

---------------------------
third-party tool / library
---------------------------
- spring boot framework (https://spring.io/projects/spring-boot)
- apache common (https://commons.apache.org/)
- Spring Initializr (https://start.spring.io/)
- geojson-jackson (https://github.com/opendatalab-de/geojson-jackson)
- jackson-jsonld (https://github.com/io-informatics/jackson-jsonld)
- apache freemarker (https://freemarker.apache.org/)

---------------------------
Preparation
---------------------------
1. edit API server configuration in application.yml
	- port: 80
	- context-path: /
2. start API

---------------------------
Usage
---------------------------
machine-readable: http://localhost/library/jsonld
human readable: http://localhost/library/list
