import { view } from './view.js';
import { model } from './model.js';

view.mostrarLogin();

document.addEventListener('click', async (e) => {
  if (e.target.id === 'loginBtn') {
    const user = document.getElementById('usuario').value;
    const pass = document.getElementById('password').value;
    if (user === 'MONSTER' && pass === 'MONSTER9') {
      view.mostrarConversor();
    } else {
      alert('Credenciales incorrectas');
    }
  }

  if (e.target.id === 'convertirBtn') {
    const valor = parseFloat(document.getElementById('valor').value);
    const tipoSeleccionado = document.getElementById('tipo').value;
    const tipo = tipoSeleccionado.includes('Celsius') ? 'celsiusToFahrenheit' : 'fahrenheitToCelsius';
    try {
      const resultado = await model.convertir(tipo, valor);
      document.getElementById('resultado').textContent = 'Resultado: ' + resultado;
    } catch (err) {
      document.getElementById('resultado').textContent = err.message;
    }
  }
});
