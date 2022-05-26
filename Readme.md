# Clean-Architecture With Quarkus Multi-modules

## Clean Architecture
Design de software de forma robusta a para separar as cadamadas da aplicação. Como Robert C. Martin fala em seu livro: "screaming architecture!".

<p align="center">
    <img src="./images/cleanarchitecture.jpg" height="350">
</p>

## Camadas/Modules
### domain
Coração do software, onde esta a camada de dominio e as regras do negócio

### usecase
São os casos de uso, é quem  vai orquestrar o dominio e seu funcionamento

### infrastructure
É a camada onde estão api, cli e persistência.

#### persistence
Hoje esta app, possuí uma camda de persistência unica, com jpa(Hibernate Panache)

#### api
Aplicação quarkus onde são expostos os endpoints para a web

#### cli
Aplicações espeficas para persistencia e leitura de filas

### Testabilidade
Desta forma é possivel executar os teste unitários de forma bem tranquila
- JUnit 5

## Build(Com testes)
    mvn clean install

## Build(Sem testes)
    mvn clean install -DskipTests=true

## Iniciando os serviços
Requerido
- Java 11+
- Maven 3+
- docker
- docker-compose

BD:
    
    docker-compose up -d
HTTP:
    
    mvn quarkus:dev

OPEN-API(Swagger):

http://localhost:8080/swagger-ui

CLI:

    mvn quarkus:dev


## Helpers

### Injeção Dependencia(Modulos que serão utilizados):

    <dependency>
      <groupId>javax.inject</groupId>
      <artifactId>javax.inject</artifactId>
      <version>1</version>
    </dependency>
    <dependency>
        <groupId>jakarta.enterprise</groupId>
        <artifactId>jakarta.enterprise.cdi-api</artifactId>
        <version>2.0.2</version>
        <scope>compile</scope>
    </dependency>

Nos métodos que poderão ser injetados, anotar com:
    
    @Named
    @ApplicationScoped
    public class CreateProductUseCase {}

### Injeção Dependencia no Quarkus(Modulos que serão utilizados por ele):
    <build>
        <plugins>
        <plugin>
            <groupId>org.jboss.jandex</groupId>
            <artifactId>jandex-maven-plugin</artifactId>
            <version>1.2.2</version>
            <executions>
            <execution>
                <id>make-index</id>
                <goals>
                <goal>jandex</goal>
                </goals>
            </execution>
            </executions>
        </plugin>

application.properties:

    quarkus.index-dependency.usecase.group-id=com.wagnerww.cleanarch.quarkus
    quarkus.index-dependency.usecase.artifact-id=usecase

### Criando um projeto CLI novo:
    
    mvn io.quarkus.platform:quarkus-maven-plugin:2.9.2.Final:create \
        -DprojectGroupId=com.wagnerww.cleanarch.quarkus \
        -DprojectArtifactId=consumer-event-sourcing \
        -Dextensions="picocli"