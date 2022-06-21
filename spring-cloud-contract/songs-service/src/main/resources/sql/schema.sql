CREATE TABLE IF NOT EXISTS SONGS
(
    id     VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name   VARCHAR NOT NULL,
    artist VARCHAR NOT NULL
);

INSERT INTO SONGS (name, artist) VALUES ( 'Polly', 'Nirvana' );
INSERT INTO SONGS (name, artist) VALUES ( 'Subdivisions', 'Rush' );
INSERT INTO SONGS (name, artist) VALUES ( 'Lingus', 'Snarky Puppy' );
