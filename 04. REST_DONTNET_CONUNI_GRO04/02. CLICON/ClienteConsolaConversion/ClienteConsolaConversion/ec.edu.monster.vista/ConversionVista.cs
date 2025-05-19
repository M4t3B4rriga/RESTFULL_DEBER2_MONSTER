using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClienteConsolaConversion.ec.edu.monster.controlador;

namespace ClienteConsolaConversion.ec.edu.monster.vista
{
    public class ConversionVista
    {
        public string PedirUsuario()
        {
            Console.Write("Usuario: ");
            return Console.ReadLine();
        }

        public string PedirContrasena()
        {
            Console.Write("Contraseña: ");
            StringBuilder password = new StringBuilder();
            ConsoleKeyInfo key;
            do
            {
                key = Console.ReadKey(true);
                if (key.Key != ConsoleKey.Backspace && key.Key != ConsoleKey.Enter)
                {
                    password.Append(key.KeyChar);
                    Console.Write("*");
                }
                else if (key.Key == ConsoleKey.Backspace && password.Length > 0)
                {
                    password.Remove(password.Length - 1, 1);
                    Console.Write("\b \b");
                }
            } while (key.Key != ConsoleKey.Enter);
            Console.WriteLine();
            return password.ToString();
        }

        public void MostrarLoginExitoso() => Console.WriteLine("Login exitoso\n");

        public void MostrarLoginFallido() => Console.WriteLine("Usuario o contraseña incorrectos\n");

        public void MostrarMenu()
        {
            Console.WriteLine("=== CONVERSIÓN DE UNIDADES ===");
            Console.WriteLine("1. Kilogramos a Libras");
            Console.WriteLine("2. Libras a Kilogramos");
            Console.WriteLine("3. Centímetros a Metros");
            Console.WriteLine("4. Metros a Kilómetros");
            Console.WriteLine("5. Kilómetros a Metros");
            Console.WriteLine("6. Metros a Centímetros");
            Console.WriteLine("7. Milímetros a Metros");
            Console.WriteLine("0. Salir");
            Console.Write("Opción: ");
        }

        public string PedirValor(string unidad)
        {
            Console.Write($"Ingrese valor en {unidad}: ");
            return Console.ReadLine();
        }

        public void MostrarResultado(double resultado, string unidad) =>
        Console.WriteLine($"Resultado: {resultado.ToString("F2", CultureInfo.InvariantCulture)} {unidad}\n");


    public void MostrarError(string mensaje) =>
            Console.WriteLine($"[ERROR] {mensaje}\n");
    }
}