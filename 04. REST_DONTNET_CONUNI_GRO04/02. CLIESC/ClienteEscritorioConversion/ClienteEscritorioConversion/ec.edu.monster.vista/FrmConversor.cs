using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ClienteEscritorioConversion.ec.edu.monster.controlador;  // Asegúrate de que la ruta sea correcta según tu estructura

namespace ClienteEscritorioConversion.ec.edu.monster.vista
{
    public partial class FrmConversor : Form
    {
        // Controlador con salida tipo Label (según tu implementación)
        private ConversionControlador controlador;

        public FrmConversor()
        {
            InitializeComponent();
        }

        // Evento al cargar el formulario
        private async void FrmConversor_Load(object sender, EventArgs e)
        {
            // Asegúrate que los controles existen y están nombrados correctamente en el diseñador:
            // ComboBox: cmbConversion
            // TextBox (entrada): txtValor
            // Label (salida): lblResultado
            controlador = new ConversionControlador(cmbConversion, txtValor, lblResultado);
            await controlador.InicializarAsync(); // Incluye login automático
        }

        // Evento al presionar el botón Convertir
        private async void btnConvertir_Click(object sender, EventArgs e)
        {
            await controlador.ConvertirAsync();
        }

        // Eventos generados por el diseñador (puedes dejar vacíos si no los usas)
        private void lblTitulo_Click(object sender, EventArgs e)
        {
        }

        private void lblSeleccion_Click(object sender, EventArgs e)
        {
        }

        private void cmbConversion_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void lblValor_Click(object sender, EventArgs e)
        {
        }

        private void txtValor_TextChanged(object sender, EventArgs e)
        {
        }

        private void lblResultado_Click(object sender, EventArgs e)
        {
        }

        private void txtResultado_TextChanged(object sender, EventArgs e)
        {
        }
    }
}