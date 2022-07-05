CREATE TABLE IF NOT EXISTS SONGS
(
    id       VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name     VARCHAR NOT NULL,
    artist   VARCHAR NOT NULL,
    duration INTEGER NOT NULL
);

INSERT INTO SONGS (name, artist, duration) VALUES ('Polly', 'Nirvana', 173);
INSERT INTO SONGS (name, artist, duration) VALUES ('Subdivisions', 'Rush', 334);
INSERT INTO SONGS (name, artist, duration) VALUES ('Lingus', 'Snarky Puppy', 645);
