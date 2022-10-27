require('dotenv').config();
const pact = require('@pact-foundation/pact-node');

if (!process.env.PUBLISH_PACT) {
    console.log("skipping Pact publish...");
    process.exit(0)
}

const pactBrokerUrl = process.env.PACT_BROKER_BASE_URL || 'https://<your_broker_name>.pactflow.io';
const pactBrokerToken = process.env.PACT_BROKER_TOKEN || 'pact_workshop';

const gitHash = require('child_process')
    .execSync('git rev-parse --short HEAD')
    .toString().trim();

const opts = {
    pactFilesOrDirs: ['./pacts/'],
    pactBroker: pactBrokerUrl,
    pactBrokerToken: pactBrokerToken,
    tags: ['prod', 'test'],
    branch: 'main',
    consumerVersion: require('./package.json').version
};

pact
    .publishPacts(opts)
    .then(() => {
        console.log('Pact contract publishing complete!');
        console.log('');
        console.log(`Head over to ${pactBrokerUrl}`);
        console.log('to see your published contracts.')
    })
    .catch(e => {
        console.log('Pact contract publishing failed: ', e)
    });
