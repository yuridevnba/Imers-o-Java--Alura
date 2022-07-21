import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*"); // pegar os itens os filmes. .+ grupo de captura.
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json); // pra chamar a primeira expressão regular usa o matcher
        if (!matcher.find()) {   // o find

            throw new IllegalArgumentException("Não encontrou items."); // se n encontrar usa uma msg.
        }

        String[] items = matcher.group(1).split("\\},\\{"); // }{ é oq vai separar do próximo filme.// filmes, conseguiu um padrão que  vai conseguir olhar filme a filme.

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
  

    }




}
