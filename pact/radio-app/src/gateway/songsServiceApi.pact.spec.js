import path from "path";
import { Pact } from "@pact-foundation/pact";
import { SongsServiceApi } from "./songsServiceApi";
import { eachLike, regex, string, uuid } from "@pact-foundation/pact/src/dsl/matchers";

const provider = new Pact({
    consumer: 'RadioApp',
    provider: 'SongsService',
    log: path.resolve(process.cwd(), 'logs', 'pact.log'),
    logLevel: "warn",
    dir: path.resolve(process.cwd(), 'pacts'),
    spec: 2
});

describe("API Pact test", () => {


    beforeAll(() => provider.setup());
    afterEach(() => provider.verify());
    afterAll(() => provider.finalize());

    describe("getting all songs", () => {
        test("songs exists", async () => {

            // set up Pact interactions
            await provider.addInteraction({
                state: 'songs exist',
                uponReceiving: 'get all songs',
                withRequest: {
                    method: 'GET',
                    path: '/songs'
                },
                willRespondWith: {
                    status: 200,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: eachLike({
                        id: uuid("bf5505af-7418-4277-ad13-a43a9d9bbec7"),
                        name: string("Lingus"),
                        artist: string("Snarky Puppy"),
                        duration: regex({
                            matcher: "((\\d+):)?([0-5]?\\d):([0-5]\\d)",
                            generate: "10:45"
                        })
                    }),
                },
            });

            const api = new SongsServiceApi(provider.mockService.baseUrl);

            // make request to Pact mock server
            const songs = await api.getAllSongs();

            expect(songs).toStrictEqual([
                { "id": "bf5505af-7418-4277-ad13-a43a9d9bbec7", "name": "Lingus", "artist": "Snarky Puppy", "duration": "10:45" }
            ]);
        });
    });
});