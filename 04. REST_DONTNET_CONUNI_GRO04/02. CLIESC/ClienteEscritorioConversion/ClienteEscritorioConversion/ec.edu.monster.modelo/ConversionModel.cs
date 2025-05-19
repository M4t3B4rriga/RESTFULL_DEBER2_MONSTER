using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;


namespace ClienteEscritorioConversion.ec.edu.monster.modelo
{
    public class LoginModel
    {
        public string UserName { get; set; }
        public string Password { get; set; }
    }

    public class ConversionModel
    {
        private readonly HttpClient _client;

        public ConversionModel()
        {
            _client = new HttpClient();
            _client.BaseAddress = new Uri("https://localhost:7177/");
        }

        public async Task<bool> LoginAsync()
        {
            var login = new LoginModel { UserName = "MONSTER", Password = "MONSTER9" };
            var content = new StringContent(JsonSerializer.Serialize(login), Encoding.UTF8, "application/json");
            var response = await _client.PostAsync("api/RESTLoginControllerUnitConverter/Login", content);
            var result = await response.Content.ReadAsStringAsync();
            return result.ToLower().Contains("true");
        }

        public async Task<double> ConvertAsync(string ruta, string valor)
        {
            var content = new StringContent($"\"{valor}\"", Encoding.UTF8, "application/json");
            var response = await _client.PostAsync($"api/RESTUnitConverter/{ruta}", content);
            var result = await response.Content.ReadAsStringAsync();
            return double.Parse(result.Trim('"'), CultureInfo.InvariantCulture);
        }
    }
}