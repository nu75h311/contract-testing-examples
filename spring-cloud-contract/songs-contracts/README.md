# Generate stubs for consumers

Gradle:  
`./gradlew -b src/main/resources/com/nu75h311/songs/service/build.gradle.kts clean publishToMavenLocal`  
Maven:  
`./mvnw -f src/main/resources/com/nu75h311/songs/service/pom.xml clean install`

# Generate jar with contracts

Gradle:  
`./gradlew clean publishToMavenLocal`  
Maven:  
`./mvn clean install`  
