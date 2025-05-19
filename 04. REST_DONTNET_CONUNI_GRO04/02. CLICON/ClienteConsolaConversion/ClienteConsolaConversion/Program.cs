using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClienteConsolaConversion.ec.edu.monster.controlador;

namespace ClienteConsolaConversion
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var controlador = new ConversionControlador();
            controlador.IniciarAsync().GetAwaiter().GetResult();
        }
    }
}
