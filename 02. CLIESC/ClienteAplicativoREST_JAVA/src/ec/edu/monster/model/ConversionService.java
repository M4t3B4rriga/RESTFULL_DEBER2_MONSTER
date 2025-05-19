/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
/**
 *
 * @author sebas
 */
public class ConversionService {
     private final String endpoint = "http://10.40.26.92:8080/ServidorRESTConversion/api/conversion";
  

    public String convertir(String tipo, double valor) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            
            String json = String.format("{\"valor\": %s, \"tipo\": \"%s\"}", valor, tipo);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int status = conn.getResponseCode();

           
            InputStream responseStream = (status >= 200 && status < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream, "utf-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line.trim());
                }
            }

            if (status != 200) {
                return "Error: " + status + " - " + response.toString();
            }

            
            String respuesta = response.toString();
            int idx = respuesta.indexOf(":");
            if (idx != -1) {
                return respuesta.substring(idx + 1).replace("}", "").trim();
            } else {
                return "Respuesta inesperada: " + respuesta;
            }

        } catch (Exception e) {
            return "Error al conectar con el servidor: " + e.getMessage();
        }
    }
}
