 ### Démarrage rapide ###
    git clone https://github.com/raulqueiroz/nexioproject.git
    mvn compile
    mvn package
    mvn clean install  
    

### Persistence ###
__Par défaut, le projet utilise le DB en mémoire H2__

### Swagger ###
    #@timestamp@
    api.inf.versao=@project.version@
    api.inf.artifactid=@project.artifactId@
    api.inf.descricao=Api Nexio Shopping
   
### H2: ###
	_application.properties_
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2
    spring.h2.console.settings.trace=true
    spring.h2.console.settings.web-allow-others=true

### Datasource ###
####Créer un dossier local pour h2: C:/dev/h2/dbh2teset
    spring.datasource.url=jdbc:h2:file:C:/dev/h2/dbh2teset
    spring.datasource.username=sa
    spring.datasource.password=
    spring.datasource.driver-class-name=org.h2.Driver
    spring.jpa.hibernate.ddl-auto=update
    
### Cet projet utilise les technologies suivantes: ###
    IDE: Spring tools 4
    web/REST: Spring 2.1.8
    swagger-ui: 2.9.2
    marshalling: Jackson 2.x (pour JSON) 
    maven:3.6.2
    persistence: Spring Data JPA et Hibernate
    persistence providers: H2
    testing: junit
    
###Swagger ###
	_localhost_
	http://localhost:8080/nexio-shopping/swagger-ui.html

### IDE ###

C'est un projet Maven, donc vous pouvez utilise une  IDE avec support en Maven (Eclipse, Spring Tools, etc).