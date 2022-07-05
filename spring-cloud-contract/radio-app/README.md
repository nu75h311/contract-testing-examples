# radio-app

The consumer application of the songs-service.

## Run tests

`./gradlew clean test`

Tests using the contract stubs at the gateway layer are under
package `com.nu75h311.radio.app.gateway`.

A slightly higher level test set (service layer but using a real gateway)
is under package `com.nu75h311.radio.app.integration`, also using the
contract-generated stubs.
