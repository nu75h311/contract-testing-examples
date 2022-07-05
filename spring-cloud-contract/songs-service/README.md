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

- `./gradlew clean build` builds the app, generates the contract tests and run all tests.
- `./gradlew generateContractTests` only generates the contract tests under `build/generated-test-sources/contractTest`.
