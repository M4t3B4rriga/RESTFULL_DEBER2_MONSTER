using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Globalization;
using Newtonsoft.Json;

namespace ClienteWebConversion.ec.edu.monster.modelo
{
    public class LoginModel
    {
        public string UserName { get; set; } = "MONSTER";
        public string Password { get; set; } = "MONSTER9";
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
            var login = new LoginModel();
            var json = JsonConvert.SerializeObject(login);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            var response = await _client.PostAsync("api/RESTLoginControllerUnitConverter/Login", content);
            var result = await response.Content.ReadAsStringAsync();

            return result.ToLower().Contains("true");
        }


        public async Task<string> ConvertAsync(string ruta, string valor)
        {
            var content = new StringContent($"\"{valor}\"", Encoding.UTF8, "application/json");
            var response = await _client.PostAsync($"api/RESTUnitConverter/{ruta}", content);
            var result = await response.Content.ReadAsStringAsync();
            return result.Trim('"');
        }
    }
}
