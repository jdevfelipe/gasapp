package com.gasapp.api.scripts;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CurlScript {
    public static void main(String[] args) throws IOException, ParseException {
        URL url = new URL("https://preco.anp.gov.br/include/Resumo_Semanal_Posto.asp");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Connection", "keep-alive");
        http.setRequestProperty("Cache-Control", "max-age=0");
        http.setRequestProperty("sec-ch-ua", "'Google Chrome';v='89', 'Chromium';v='89', ';Not A Brand';v='99'");
        http.setRequestProperty("sec-ch-ua-mobile", "?0");
        http.setRequestProperty("Upgrade-Insecure-Requests", "1");
        http.setRequestProperty("Origin", "https://preco.anp.gov.br");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
        http.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        http.setRequestProperty("Sec-Fetch-Site", "same-origin");
        http.setRequestProperty("Sec-Fetch-Mode", "navigate");
        http.setRequestProperty("Sec-Fetch-User", "?1");
        http.setRequestProperty("Sec-Fetch-Dest", "document");
        http.setRequestProperty("Referer", "https://preco.anp.gov.br/include/Resumo_Por_Estado_Municipio.asp");
        http.setRequestProperty("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7");
        http.setRequestProperty("Cookie", "_ga=GA1.3.836265207.1616557872; _gid=GA1.3.1235448697.1616557872; ASPSESSIONIDCWRTRDRT=JOLHGDDCAINDLKGMKEDLPMNE");

        String data = "cod_semana=1135&desc_semana=De+14%2F03%2F2021+a+20%2F03%2F2021&cod_combustivel=487&desc_combustivel=+-+GASOLINA+COMUM+R%24%2Fl&selMunicipio=6015*CURITIBA&tipo=1";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        String test = toString(http.getInputStream());
        System.out.print(test);
        http.disconnect();

    }

    public static String toString(InputStream json) {
        StringBuilder buf = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(json));
            String line = reader.readLine();
            while (line != null) {
                buf.append(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e2) {
            return e2.getMessage();
        }
        return buf.toString();
    }
}
