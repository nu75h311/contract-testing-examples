# songs-service

The producer service with the following endpoints:

### `GET /songs`

- retrieves the list of all songs in the database.
- optional query parameter `artist` retrieves all songs by the queried artist.

### `POST /songs`

- saves a new song to the database.
- requires a JSON body containing:
  ```json
  {
    "name": "Name of the song",
    "artist": "Name of the artist",
    "duration": "1:23"
  }
  ```

## Start app:

`./gradlew bootRun`

## Contract tests

Contract tests are based on the test class under the `contracts` package.  
The base class can be configured to read pacts from a local folder (`@PactFolder`) or to
retrieve pacts from a broker (`@PactBroker`), for which an
`application-contract-test.properties` resource file containing the pact broker
connection information is required.

- `./gradlew clean build` builds the app, generates the contract tests and run all tests.
- `./gradlew test --tests *ContractTests` only runs contract tests.
- `./gradlew test --tests *ContractTests -DpublishPactVerification` runs contract tests
and publishes the results to the broker if the `application-contract-test.properties` is
filled.