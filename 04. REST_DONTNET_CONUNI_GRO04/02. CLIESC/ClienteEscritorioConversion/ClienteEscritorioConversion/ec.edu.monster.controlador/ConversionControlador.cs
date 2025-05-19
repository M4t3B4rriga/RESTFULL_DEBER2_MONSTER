using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClienteEscritorioConversion.ec.edu.monster.modelo;
using System.Windows.Forms;



namespace ClienteEscritorioConversion.ec.edu.monster.controlador
{
    public class ConversionControlador
    {
        private readonly ConversionModel _modelo;
        private readonly ComboBox _combo;
        private readonly TextBox _entrada;
        private readonly Label _salida;

        public ConversionControlador(ComboBox combo, TextBox entrada, Label salida)
        {
            _modelo = new ConversionModel();
            _combo = combo;
            _entrada = entrada;
            _salida = salida;
        }

        public async Task InicializarAsync()
        {
            bool ok = await _modelo.LoginAsync();
            if (!ok)
            {
                MessageBox.Show("Error de autenticación", "Login", MessageBoxButtons.OK, MessageBoxIcon.Error);
                Application.Exit();
            }

            _combo.Items.AddRange(new object[]
            {
                "KgToLib",
                "LbToKg",
                "CmToM",
                "MToKm",
                "KmToM",
                "MToCm",
                "MmToM"
            });
            _combo.SelectedIndex = 0;
        }

        public async Task ConvertirAsync()
        {
            try
            {
                string ruta = _combo.SelectedItem.ToString();
                string valor = _entrada.Text;
                double resultado = await _modelo.ConvertAsync(ruta, valor);
                _salida.Text = $"Resultado: {resultado:F4}";
            }
            catch
            {
                _salida.Text = "Error en la conversión.";
            }
        }
    }
}