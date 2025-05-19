using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ClienteWebConversion.ec.edu.monster.modelo;

namespace ClienteWebConversion.ec.edu.monster.controlador
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(LoginModel model)
        {
            if (ModelState.IsValid)
            {
                if (model.UserName == "MONSTER" && model.Password == "MONSTER9")
                {
                    return RedirectToAction("Index", "Conversion");
                }
                ViewBag.Error = "Usuario o contraseña incorrectos.";
            }

            return View(model);
        }
    }
}
