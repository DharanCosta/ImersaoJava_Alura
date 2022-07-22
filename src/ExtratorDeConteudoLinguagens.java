import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoLinguagens implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

        try{
            JsonElement fileElement = JsonParser.parseString(json);
//            JsonObject fileObject = fileElement.getAsJsonArray();

            //Extrair só os dados que interessam (Titulo, poster e classificação)
            JsonArray jsonArrayOfLinguagens = fileElement.getAsJsonArray();
            List<Conteudo> conteudos = new ArrayList<>();
            for(  JsonElement atributos : jsonArrayOfLinguagens) {
                JsonObject atributosJsonObject = atributos.getAsJsonObject();

                String titulo = atributosJsonObject.get("title").getAsString();
                String urlImg = atributosJsonObject.get("image").getAsString();
                float rating = Float.parseFloat(atributosJsonObject.get("rating").getAsString());
                String date = null;

                var conteudo = new Conteudo(titulo,urlImg,rating,date);
                conteudos.add(conteudo);
            }
            return conteudos;
        }catch(IllegalArgumentException e){
            System.err.println("Erro input file not found");
            e.printStackTrace();
        }catch (Exception e){
            System.err.println("Erro processing input file");
            e.printStackTrace();
        }
        return null;
    }

}
