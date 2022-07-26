import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb {
    
    public  List<conteudo> extraiConteudos(String json){
    
  
        JsonParser Parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = Parser.parse(json);
        
    
    
        List<conteudo> conteudos = new ArrayList<>();
       
    
        // popular a lista de conteudos
    
        for (Map<String, String> atributos:listaDeAtributos){
            
            String titulo = atributos.get("title");
          String urlImagem = atributos.get("image");
               
    
               conteudo con= new conteudo(titulo, urlImagem);
                conteudos.add(con);
        }
        return conteudos;


}
