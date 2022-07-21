import java.lang.ProcessBuilder.Redirect;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        HttpClient httpClient = HttpClient.newBuilder()
         .connectTimeout(Duration.ofSeconds(3)) // não conseguir estabelecer a conexão. 
       // .followRedirects(java.net.http.HttpClient.Redirect.NORMAL) // n faz https para http, sendo seguro;301 Moved Permanently, já vai procurar aonde se encontra o destino da requisição, levando para a url nova. 
        .build();

        HttpRequest request = HttpRequest.newBuilder()
           /// .uri(URI.create("https://cat-fact.herokuapp.com/facts/"))
           // .uri(URI.create("https://postman-echo.com/delete"))
           //.uri(URI.create("https://xkcd.com/info.0.json")) // dados d uma tirinha.n pega o delete, pois n temos a permissão de deletar a informação.
          //.uri(URI.create("https://apichallenges.herokuapp.com/todos")) // lista de tarefas.
          .uri(URI.create("https://www.getpostman.com")) // a url foi movida para outra localização.
             //.build();
           //.headers("Accept", "application/xml","chave","valor","chave","valor")   
           .header("Accept", "application/xml") // definindo o tipo da requisiição.
            // .DELETE()
            .GET()
          
           .timeout(Duration.ofSeconds(3)) // dar um tempo hábil para retornar a resposta, se não receber a resposta vai dar um timeout.
            .build();
             
        HttpResponse<String> response =
          httpClient.send(request, BodyHandlers.ofString());

         // System.out.println(response.statusCode()); // status de resposta da requisição, o normal é 200,301 erro.
        //System.out.println(response.body());
       //  System.out.println(response.headers()); // no 301 vai vim a nova localização.
          System.out.println(response.version()); // protocolo, a versão HTTP2, ou seja, a URL está respondendo com http 2.










        // https://www.youtube.com/watch?v=atO7i9kDXvQ&t=310s
      // obs: não vi a parte de assíncrono.


    }
}
