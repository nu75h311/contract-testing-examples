1. Checkout `no-mixtape-duration`
2. Demonstrate songs-app with Postman

## SPRING

Consumer flow:  

1. Show songs-contracts
2. Generate stubs locally for the consumer (show in .m2)  
`./gradlew -b src/main/resources/com/nu75h311/songs/service/build.gradle.kts clean publishToMavenLocal`
3. Show radio-app (service that calls consumer)
4. Show/run radio-app tests (show logs "Request received:")

Producer flow:  
1. Generate contracts jar (show in .m2)  
`./gradlew clean publishToMavenLocal`
2. Show songs-service then build (show in .m2 - now consumers can use official stub)  
`./gradlew clean build publishToMavenLocal`
3. Show generated tests, RadioAppBaseTest

New consumer flow:
1. Checkout `adding-duration`
2. Show new mixtape-app contract
3. Generate new stubs and contracts locally (show in .m2)  
`./gradlew -b src/main/resources/com/nu75h311/songs/service/build.gradle.kts clean publishToMavenLocal`  
`./gradlew clean publishToMavenLocal`
4. Run mixtape-app tests
    
Updating producer flow:  
1. Show the changed base tests (with duration)
2. Show SongDTO for the duration property
3. Build songs-service - test fails  
`./gradlew clean build publishToMavenLocal`
4. Show why in the generated MixtapeappTest
5. Fix SongDTO to  
`23: val seconds: String = (durationInt % 60).toString().padStart(2, '0')`  
`27: return "${hours}:${(minutes).toString().padStart(2, '0')}:${seconds}"`

## PACT

1. Checkout `main`

Consumer flow:
1. Show the React radio-app
2. Show the test, the provider setup and required state
3. Run the tests, generate pacts and publish  
`npm run test:pact`
4. Show PactFlow

Provider flow:
1. Show songs-service
2. Show the base contract test (that uses @PactBroker and @ActiveProfiles)
3. Explain @State
4. Run build, tests and publishing  
`./gradlew clean verifyContracts -DpublishPactVerification`
5. Show PactFlow

Can I deploy:
1. Show can-i-deploy in PactFlow
2. Show can-i-deploy from terminal
3. Record a deployment
4. Check PactFlow
5. Show can-i-deploy from terminal
6. Show can-i-deploy in PactFlow