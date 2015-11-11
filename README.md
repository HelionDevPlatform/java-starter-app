# helion-mysql-java-jersey-eclipse
this project is a port of the 
https://github.com/HelionDevPlatform/helion-mysql-java-eclipse project, ported to [JAX-RS] (https://jersey.java.net/)

## running locally
to run locally (assuming eclipse)

1. import the pom.xml into eclipse
2. configure the following variables:
  1. *VCAP_SERVICES= {"mysql":[{"name":"helion-mysql-java-jersey-db","label":"mysql-5.5","tags":[],"plan":"free","credentials":{"name":"helion-mysql-java-jersey-db","hostname":"127.0.0.1","host":"127.0.0.1","port":3306,"user":"your-user","username":"your-user","password":"your-password","uri":"mysql://your-user:your-password@localhost:3306/helion-mysql-java-jersey-db","jdbcUrl":"jdbc:mysql://your-user:your-password@127.0.0.1:3306/helion-mysql-java-jersey-db"}}]}*
  2. *FQ_MYSQL = _the path to your mysql executable_*
  3. On the mysql instance that you are connecting to (I'm assuming localhost above), create a helion-mysql-java-jersey-db database. 
  4. run ./src/main/webapp/create_db.py to create the database schema
  5. mvn clean package to create the war to debug (if you are using eclipse, you can debug using an embedded instance of Tomcat if you've configured one). 

## deploying to Helion Development Platform
to deploy to an instance of Helion Development Platform with the helion cli: 

1. *helion target _{URI of HDP instance}_*
2. *helion login* (you will be prompted to supply your credentials)
3. From the top level directory, run *helion push -n*



