using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClienteWebConversion.ec.edu.monster.modelo
{
    public class ConversionViewModel
    {
        public string ValorEntrada { get; set; }
        public string TipoConversion { get; set; }
        public string Resultado { get; set; }

        public string[] Opciones =>
            new string[]
            {
                "KgToLib", "LbToKg", "CmToM", "MToKm", "KmToM", "MToCm", "MmToM"
            };
    }
}
