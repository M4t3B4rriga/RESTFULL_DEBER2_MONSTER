using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClienteConsolaConversion.ec.edu.monster.modelo;
using ClienteConsolaConversion.ec.edu.monster.vista;



namespace ClienteConsolaConversion.ec.edu.monster.controlador
{
    public class ConversionControlador
    {
        private readonly ConversionModel _modelo;
        private readonly ConversionVista _vista;

        public ConversionControlador()
        {
            _modelo = new ConversionModel();
            _vista = new ConversionVista();
        }

        public async Task IniciarAsync()
        {
            // Pedir usuario y contraseña al usuario
            string usuario = _vista.PedirUsuario();
            string contrasena = _vista.PedirContrasena();

            bool loginOK = await _modelo.LoginAsync(usuario, contrasena);
            if (loginOK)
            {
                _vista.MostrarLoginExitoso();
            }
            else
            {
                _vista.MostrarLoginFallido();
                return; // Finaliza si no pasa login
            }

            string opcion;
            do
            {
                _vista.MostrarMenu();
                opcion = Console.ReadLine();
                try
                {
                    switch (opcion)
                    {
                        case "1": await Convertir("KgToLib", "kg", "libras"); break;
                        case "2": await Convertir("LbToKg", "lb", "kilogramos"); break;
                        case "3": await Convertir("CmToM", "cm", "metros"); break;
                        case "4": await Convertir("MToKm", "m", "kilómetros"); break;
                        case "5": await Convertir("KmToM", "km", "metros"); break;
                        case "6": await Convertir("MToCm", "m", "centímetros"); break;
                        case "7": await Convertir("MmToM", "mm", "metros"); break;
                        case "0": Console.WriteLine("Programa terminado."); break;
                        default: Console.WriteLine("Opción inválida."); break;
                    }
                }
                catch (Exception ex)
                {
                    _vista.MostrarError(ex.Message);
                }

                Console.WriteLine("Presione una tecla para continuar...");
                Console.ReadKey();
                Console.Clear();

            } while (opcion != "0");
        }


        private async Task Convertir(string ruta, string unidadIn, string unidadOut)
        {
            var valor = _vista.PedirValor(unidadIn);
            var resultado = await _modelo.ConvertAsync(ruta, valor);
            _vista.MostrarResultado(resultado, unidadOut);
        }
    }
}