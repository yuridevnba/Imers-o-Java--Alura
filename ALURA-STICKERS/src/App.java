import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

// pegar os dados do imdb, com uma conexão HTTP, fazer um get,  e guardar todas as informações dentro de uma string.

String url="https://alura-filmes.herokuapp.com/conteudos";

var cliente = HttpClient.newHttpClient();
URI endereco = URI.create(url);
HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
String body = response.body();
//System.out.println(body);

// pegar só os dados que interessam, extrair,parsear(título, post,classificação)
JsonParser Parser = new JsonParser();
List<Map<String,String>>listaDeFilmes=Parser.parse(body); //  colocar = body ele vai rejeitar, pq uma string é um texto, n é uma lista de filmes. por isso vai precisar do parse.
System.out.println();
System.out.println("Quantos filmes temos? "+listaDeFilmes.size()+" filmes");
System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
//System.out.println(listaDeFilmes.get(0));// map utilizando chave e demonstrando chave valor,chave valor.

//exibir e manipular os dados do jeito que quiser.


for (Map<String,String> filme : listaDeFilmes) { // n existe foreach no java isso é só um template.
   // System.out.println("Titulo: \u001b[1m" + filme.get("title"));
   // System.out.println(filme.get("title"));  // vai dar o valor da chave título.
    //System.out.println(filme.get("image"));  // list vem na ordem, o map as vezes muda.
    //System.out.println(filme.get("imDbRatingCount"));

    System.out.println("TÍTULO: \u001b[30m\u001b[46m " + filme.get("title") + " \u001b[m");
    System.out.println("POSTER: "+filme.get("image")); 
System.out.println(" \u001b[30m\u001b[41m CLASSIFICAÇÃO:"+filme.get("imDbRating")+ "\u001b[3m\u001b[31m\u001b[m");
System.out.println();
    //System.out.printf("%.1s%n",filme.get("imDbRating"));
   Integer x= Integer.parseInt(filme.get("imDbRating"));
    for(int i=1;i<=x;i++){
        //System.out.println("\uD83D\uDC99 ");//\uD83D\uDC99
        System.out.println("\u2B50");
       
    }
   // System.out.printf();
}
   

    }
}
//"imDbRating":"9.2"
//"\u001b[37m \u001b