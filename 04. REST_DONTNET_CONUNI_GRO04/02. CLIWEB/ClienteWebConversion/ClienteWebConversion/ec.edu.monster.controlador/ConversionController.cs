using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Threading.Tasks;
using System.Web.Mvc;
using ClienteWebConversion.ec.edu.monster.modelo;

namespace ClienteWebConversion.ec.edu.monster.controlador
{
    public class ConversionController : Controller
    {
        private readonly ConversionModel _modelo = new ConversionModel();

        public ActionResult Index()
        {
            return View(new ConversionViewModel());
        }

        [HttpPost]
        public async Task<ActionResult> Index(ConversionViewModel vm)
        {
            if (ModelState.IsValid)
            {
                bool ok = await _modelo.LoginAsync();
                if (!ok)
                {
                    ModelState.AddModelError("", "Error al autenticar con el servicio.");
                    return View(vm);
                }

                string resultado = await _modelo.ConvertAsync(vm.TipoConversion, vm.ValorEntrada);
                vm.Resultado = resultado;
            }

            return View(vm);
        }
    }
}
