using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Text.Json;



namespace ClienteConsolaConversion.ec.edu.monster.modelo
{
    public class ConversionModel
    {
        private readonly HttpClient _client;

        public ConversionModel()
        {
            _client = new HttpClient();
            _client.BaseAddress = new Uri("https://localhost:7177/"); // AJUSTA EL PUERTO
        }

        public async Task<bool> LoginAsync(string username, string password)
        {
            var login = new LoginModel { UserName = username, Password = password };
            var content = new StringContent(JsonSerializer.Serialize(login), Encoding.UTF8, "application/json");

            var response = await _client.PostAsync("api/RESTLoginControllerUnitConverter/Login", content);
            var result = await response.Content.ReadAsStringAsync();

            return result.ToLower().Contains("true");
        }

        public async Task<double> ConvertAsync(string ruta, string valor)
        {
            var content = new StringContent($"\"{valor}\"", Encoding.UTF8, "application/json");
            var response = await _client.PostAsync($"api/RESTUnitConverter/{ruta}", content);

            if (!response.IsSuccessStatusCode)
            {
                var error = await response.Content.ReadAsStringAsync();
                throw new Exception($"Error del servidor: {error}");
            }

            var result = await response.Content.ReadAsStringAsync();
            return double.Parse(result.Trim('"'), System.Globalization.CultureInfo.InvariantCulture);
        }

    }
}