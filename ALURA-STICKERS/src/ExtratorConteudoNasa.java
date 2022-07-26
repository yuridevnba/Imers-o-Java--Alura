import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa {

  
  public  List<conteudo> extraiConteudos(String json){
    
  
    JsonParser Parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = Parser.parse(json);
    


    List<conteudo> conteudoextrator = new ArrayList<>();
   

    // popular a lista de conteudoextrator

    for (Map<String, String> atributos:listaDeAtributos){

      String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");

           conteudo con= new conteudo(titulo, urlImagem);
            conteudoextrator.add(con);
    }
    return conteudoextrator;
    }

  }