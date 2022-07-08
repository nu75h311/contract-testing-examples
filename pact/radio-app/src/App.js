import React, { useEffect, useState } from 'react';
import SongsServiceApi from './gateway/songsServiceApi';
import './App.css';

const App = () => {

  const [songs, setSongs] = useState([])

  useEffect(() => {
    SongsServiceApi.getAllSongs().then(s => setSongs(s));
  }, [])

  return <div className="App">
    <header className="App-header">
      {songs.length && songs.map(song => (
        <div key={song.id}>
          <p>{song.name} by {song.artist}</p>
        </div>
      ))}
    </header>
  </div>
}

export default App;
