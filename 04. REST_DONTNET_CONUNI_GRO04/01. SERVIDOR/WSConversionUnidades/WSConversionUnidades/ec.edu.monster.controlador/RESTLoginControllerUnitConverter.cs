using Microsoft.AspNetCore.Mvc;
using WSConversionUnidades.ec.edu.monster.modelo;



namespace WSConversionUnidades.ec.edu.monster.controlador
{
    [Route("api/[controller]")]
    [ApiController]
    public class RESTLoginControllerUnitConverter : ControllerBase
    {
        [HttpPost("Login")]
        public ActionResult<bool> Login([FromBody] UserModel user)
        {
            if (user.UserName == "MONSTER" && user.Password == "MONSTER9")
            {
                return Ok(true);
            }
            return BadRequest(false);
        }
    }
}