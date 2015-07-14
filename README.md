## Simple playground for integration testing with dockerized oracle DB

### Check docker is accessible

`docker ps` shall give you no errors but rather a neat table

### Pay a visit to uncle Oracle

[Download](http://www.oracle.com/technology/software/tech/java/sqlj_jdbc/index.html) and install oracle jdbc driver manually: 

````bash
$ mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=10.2.0.4.0 -Dpackaging=jar -Dfile=ojdbc6.jar -DgeneratePom=true
````
 
 [Courtesy](http://stackoverflow.com/questions/1074869/find-oracle-jdbc-driver-in-maven-repository) of Oracle corporation.
   
### Run it

````
mvn verify
````