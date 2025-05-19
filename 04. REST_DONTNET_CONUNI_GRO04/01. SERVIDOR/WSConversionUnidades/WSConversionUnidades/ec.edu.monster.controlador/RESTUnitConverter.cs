using Microsoft.AspNetCore.Mvc;
using System.Globalization;

namespace WSConversionUnidades.ec.edu.monster.controlador
{
    [Route("api/[controller]")]
    [ApiController]
    public class RESTUnitConverter : ControllerBase
    {
        private static bool TryParseInvariant(string input, out double result)
        {
            return double.TryParse(input, NumberStyles.Float, CultureInfo.InvariantCulture, out result);
        }

        [HttpPost("KgToLib")]
        public ActionResult<string> KgToLb([FromBody] string kg)
        {
            if (!TryParseInvariant(kg, out var value))
                return BadRequest("Valor inválido");

            var result = value * 2.20462;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("LbToKg")]
        public ActionResult<string> LbToKg([FromBody] string lb)
        {
            if (!TryParseInvariant(lb, out var value))
                return BadRequest("Valor inválido");

            var result = value / 2.20462;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("CmToM")]
        public ActionResult<string> CmToM([FromBody] string cm)
        {
            if (!TryParseInvariant(cm, out var value))
                return BadRequest("Valor inválido");

            var result = value / 100.0;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("MToKm")]
        public ActionResult<string> MToKm([FromBody] string m)
        {
            if (!TryParseInvariant(m, out var value))
                return BadRequest("Valor inválido");

            var result = value / 1000.0;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("KmToM")]
        public ActionResult<string> KmToM([FromBody] string km)
        {
            if (!TryParseInvariant(km, out var value))
                return BadRequest("Valor inválido");

            var result = value * 1000.0;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("MmToM")]
        public ActionResult<string> MmToM([FromBody] string mm)
        {
            if (!TryParseInvariant(mm, out var value))
                return BadRequest("Valor inválido");

            var result = value / 1000.0;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }

        [HttpPost("MToCm")]
        public ActionResult<string> MToCm([FromBody] string m)
        {
            if (!TryParseInvariant(m, out var value))
                return BadRequest("Valor inválido");

            var result = value * 100.0;
            return Ok(result.ToString("F4", CultureInfo.InvariantCulture));
        }
    }
}
