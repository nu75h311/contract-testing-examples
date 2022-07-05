# Contract testing examples using spring-cloud-contract

Each folder here represents a separate repository.

## On the consumer side

1. From the `songs-contracts` folder, generate the songs-service stubs jar.
2. From the consumers' folders (`radio-app` and `mixtape-app`), run the contract tests using the stubs stored in the local maven repository.

## On the producer side
1. From the `songs-contracts` folder, generate the songs-contracts jar.
2. From the producer folder (`songs-service`), run the contract tests generated using the contracts stored in the songs-contracts jar.
