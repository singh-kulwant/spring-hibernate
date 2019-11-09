#The Hibernate Way

#1. JDBC Database configuration - Hibernate cofiguration
	to tell framework/hibernate, which database we are using.
	it's done in hibernate.cfg.xml file
	
#2. The Model Object - Annotations
	to tell hibernate, which object it needs to save
	configure hibernate.cfg.xml and add annotations on object class
	
#3. Service method to create model object - use hibernate api
	service method will have instance of model object
	it will pass model object to data layer i.e. hibernate api
	hibernate api will save the model object

#4. Database design - NOT NEEDED!

#5. DAO method to save object using SQL queries - NOT NEEDED! 


##Using Hibernate API##

#Create session factory
	its only one object per application
	it uses hibernate.cfg.xml 
	it creates sessions, depending upon requirement of application
	
#Create session from the session factory	
	have to create session in order to interact with database

#Use session to perform CRUD operation on model object

##Creating db user in mysql

SELECT User, Host, plugin FROM mysql.user;

USE mysql;
CREATE USER 'kulwant'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON *.* TO 'kulwant'@'localhost';
UPDATE user SET plugin='auth_socket' WHERE User='kulwant';
FLUSH PRIVILEGES;
exit;

UPDATE user SET plugin='mysql_native_password' WHERE User='kulwant';
ALTER USER 'kulwant'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

	