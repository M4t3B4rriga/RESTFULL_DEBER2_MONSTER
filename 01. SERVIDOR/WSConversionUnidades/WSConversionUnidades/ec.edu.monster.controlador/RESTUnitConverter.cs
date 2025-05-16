using Microsoft.AspNetCore.Mvc;

namespace WSConversionUnidades.ec.edu.monster.controlador
{
    [Route("api/[controller]")]
    [ApiController]
    public class RESTUnitConverter : ControllerBase
    {
        [HttpPost("KgToLib")]
        public ActionResult<double> KgToLb([FromBody] string kg)
        {
            if (!double.TryParse(kg, out var value))
                return BadRequest("Valor inválido");

            return Ok(value * 2.20462);
        }

        [HttpPost("LbToKg")]
        public ActionResult<double> LbToKg([FromBody] string lb)
        {
            if (!double.TryParse(lb, out var value))
                return BadRequest("Valor inválido");

            return Ok(value / 2.20462);
        }

        [HttpPost("CmToM")]
        public ActionResult<double> CmToM([FromBody] string cm)
        {
            if (!double.TryParse(cm, out var value))
                return BadRequest("Valor inválido");

            return Ok(value / 100.0);
        }

        [HttpPost("MToKm")]
        public ActionResult<double> MToKm([FromBody] string m)
        {
            if (!double.TryParse(m, out var value))
                return BadRequest("Valor inválido");

            return Ok(value / 1000.0);
        }

        [HttpPost("KmToM")]
        public ActionResult<double> KmToM([FromBody] string km)
        {
            if (!double.TryParse(km, out var value))
                return BadRequest("Valor inválido");

            return Ok(value * 1000.0);
        }

        [HttpPost("MmToM")]
        public ActionResult<double> MmToM([FromBody] string mm)
        {
            if (!double.TryParse(mm, out var value))
                return BadRequest("Valor inválido");

            return Ok(value / 1000.0);
        }

        [HttpPost("MToCm")]
        public ActionResult<double> MToCm([FromBody] string m)
        {
            if (!double.TryParse(m, out var value))
                return BadRequest("Valor inválido");

            return Ok(value * 100.0);
        }
    }
}