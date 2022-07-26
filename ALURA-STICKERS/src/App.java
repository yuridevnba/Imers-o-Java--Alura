import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // as informações
        // https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14dentro
        // de uma string.
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        var http = new Cliente();
        String json = http.buscaDados(url);
        var extrator = new ExtratorConteudoNasa();
        // String url = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";

        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");

        List<conteudo> Conteudosapp = extrator.extraiConteudos(json);

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            conteudo conteudo = Conteudosapp.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }

}
