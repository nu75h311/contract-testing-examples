# pact

## Using the Pact Broker (Pactflow)

The commands below can be used for both provider and consumer.

### record a deployment example
```
docker run --rm -v ${PWD}:${PWD} \
pactfoundation/pact-cli broker record-deployment \
--broker-base-url <YOUR_PACT_BROKER_URL> \
--broker-token <YOUR_PACT_BROKER_TOKEN> \
--pacticipant SongsService \
--version 0.0.1-SNAPSHOT \
--environment production
```

### can-i-deploy
```
docker run --rm -v ${PWD}:${PWD} \
pactfoundation/pact-cli broker can-i-deploy \
--broker-base-url <YOUR_PACT_BROKER_URL> \
--broker-token <YOUR_PACT_BROKER_TOKEN> \
--pacticipant RadioApp \
--version 0.1.0 \
--to-environment production
```
