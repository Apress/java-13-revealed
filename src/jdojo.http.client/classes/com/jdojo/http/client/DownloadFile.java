// DownloadFile.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class DownloadFile {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        try {
            // Prepare a query string by encoding the parameter value
            String paramName = "Content-Disposition";
            String paramValue = "attachment; filename=test.json";
            String encodedParamValue
                    = URLEncoder.encode(paramValue, UTF_8);

            // Prepare the URI with a query string 
            String uriStr = "http://httpbin.org/response-headers"
                    + "?" + paramName + "=" + encodedParamValue;

            // Create an HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriStr))
                    .header("Accept", "application/json")
                    .build();

            // Create a Path for the download directory, which would be
            // the current directory in this case
            Path dirPath = Paths.get(".");

            // Send the request to the server
            HttpResponse<Path> response = client.send(request,
                    BodyHandlers.ofFileDownload(dirPath, CREATE, WRITE));

            // Get the response status and body. 
            // Response body is a Path to the downloaded file.
            int statusCode = response.statusCode();
            Path filePath = response.body();

            // Print the response status and body
            System.out.println("Response Status: " + statusCode);
            System.out.println("File downloaded at "
                    + filePath.toAbsolutePath().normalize());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
