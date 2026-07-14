package refmember;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Tahmin {
	public String puanTahmini(int dogru,int yanlis,int bos,int performans){
        try{
            String veri = String.format(
                "{\"dogru\": %d, \"yanlis\": %d, \"bos\": %d, \"performans\": %d}",
                dogru, yanlis, bos, performans
            );
            
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8000/tahmin"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(veri))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        }catch(Exception e){
            return "{\"hata\": \"API bağlantısı başarısız\"}";
        }
    }
}