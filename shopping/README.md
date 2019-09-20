 ### Démarrage rapide ###
    git clone https://github.com/raulqueiroz/nexioproduits.git
    mvn clean install
    
### Persistence ###
__Par défaut, le projet utilise le DB en mémoire H2__

### Swagger ###
    #@timestamp@
    api.inf.versao=@project.version@
    api.inf.artifactid=@project.artifactId@
    api.inf.descricao=Api Shopping
   
### H2: ###
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2
    spring.h2.console.settings.trace=true
    spring.h2.console.settings.web-allow-others=true
    
### Cet projet utilise les technologies suivantes: ###
    IDE: Spring tools 4
    web/REST: Spring 2.1.8
    swagger-ui: 2.9.2
    marshalling: Jackson 2.x (pour JSON) 
    maven:1.5.8
    persistence: Spring Data JPA et Hibernate
    persistence providers: H2
    testing: junit, hamcrest, mockito, rest-assured

### IDE ###

C'est un projet Maven, donc vous pouvez utilise une  IDE avec support en Maven (Eclipse, Spring Tools, etc).