package com.gasapp.api.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class Util {
    public String inputStreamToString(InputStream inputStream){
        StringBuilder buf = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
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

    public LocalDate stringToLocalDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale(new Locale( "pt" , "BR"));  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        String dateRegexp = date.replace("/", "-");
        LocalDate dateForm = LocalDate.parse(dateRegexp, formatter);

        return dateForm;
    }
}
