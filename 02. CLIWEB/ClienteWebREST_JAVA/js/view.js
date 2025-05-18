export const view = {
  mostrarLogin() {
    document.body.style.backgroundImage = "url('../assets/fondo_login.jpg')";
    document.getElementById('app').innerHTML = `
      <div class="container">
        <h2>Login</h2>
        <input type="text" id="usuario" placeholder="Usuario">
        <input type="password" id="password" placeholder="Contraseña">
        <button id="loginBtn">Ingresar</button>
      </div>
    `;
  },

  mostrarConversor() {
    document.body.style.backgroundImage = "url('../assets/fondo_conversion.jpg')";
    document.getElementById('app').innerHTML = `
      <div class="container">
        <h2>Conversión</h2>
        <input type="number" id="valor" placeholder="Valor">
        <select id="tipo">
          <option>Celsius a Fahrenheit</option>
          <option>Fahrenheit a Celsius</option>
        </select>
        <button id="convertirBtn">Convertir</button>
        <p id="resultado"></p>
      </div>
    `;
  }
};
