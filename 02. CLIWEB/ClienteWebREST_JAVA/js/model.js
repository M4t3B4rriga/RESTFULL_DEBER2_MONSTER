export const model = {
  async convertir(tipo, valor) {
    try {
      const response = await fetch('/api/conversion', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ tipo, valor })
      });
      const data = await response.json();
      return data.resultado;
    } catch (error) {
      throw new Error('Error en la conversión: ' + error.message);
    }
  }
};
