# radio-app

The consumer application of the songs-service.

## Run tests

`npm run test:pact`

Tests defining the contracts are at the gateway layer under
folder `src/gateway`.  
Running the tests will generate pacts (contracts) under folder
`pacts`.

## Publishing pacts

Set environment variables as shown in the `.env.example` file
and if `PUBLISH_PACT` is set to true, the posttest step will
publish the generated pacts to the broker.  
Publishing can also be done directly by running  
`npm run posttest:pact`

## Start React Application

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
