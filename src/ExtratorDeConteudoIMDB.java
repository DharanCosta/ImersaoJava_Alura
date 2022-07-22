import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

        //Extrair só os dados que interessam (Titulo, poster e classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtibutosJson = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteúdos percorrendo a lista de atributos
        for(Map<String,String> atributos: listaDeAtibutosJson){
            String titulo = atributos.get("title");

            String urlImg= atributos.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            float rating = Float.parseFloat(atributos.get("imDbRating"));
            String date = null;

            var conteudo = new Conteudo(titulo,urlImg,rating,date);

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
