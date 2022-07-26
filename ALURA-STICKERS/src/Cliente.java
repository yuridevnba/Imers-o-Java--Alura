import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import javax.management.RuntimeErrorException;

public class Cliente {
   public String buscaDados(String url){
       
    try{

        URI endereco = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        String body = response.body();
        return body;

    }catch(IOException|InterruptedException ex){
       throw new RuntimeException(ex);
    }

   
   


   }
}
