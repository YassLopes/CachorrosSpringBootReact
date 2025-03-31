import React, { useState, useEffect } from 'react';
import './App.css';
import { DogResponse } from './types/DogResponse';

function App() {
  const [dogImage, setDogImage] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string>('');

  // URL do backend baseada no ambiente
  const backendUrl = process.env.REACT_APP_BACKEND_URL || 'http://localhost:8080';

  useEffect(() => {
    fetchDogImage();
  }, []);

  const fetchDogImage = async () => {
    try {
      setLoading(true);
      // Usando um ID aleatório (1-100) para a API
      const randomId = Math.floor(Math.random() * 100) + 1;
      const response = await fetch(`${backendUrl}/info/${randomId}`);
      if (!response.ok) {
        throw new Error('Erro ao buscar imagem do cachorro');
      }
      const data: DogResponse = await response.json();
      setDogImage(data.message);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Erro desconhecido');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Imagem Aleatória de Cachorro</h1>
        {loading && <p>Carregando...</p>}
        {error && <p className="error-message">{error}</p>}
        {dogImage && (
          <div className="image-container">
            <img src={dogImage} alt="Cachorro aleatório" />
            <button onClick={fetchDogImage} className="load-button">
              Carregar Nova Imagem
            </button>
          </div>
        )}
      </header>
    </div>
  );
}

export default App;
