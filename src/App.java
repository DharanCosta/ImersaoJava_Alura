import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Acessar os dados da API pelo método HTTP e alocar a resposta dentro de uma String

        APIsSelector minhaAPI = APIsSelector.LOCAL;


        var http = new ClienteHttp();
        String json = http.buscaDados(minhaAPI.getUrl());

        //Extrair só os dados que interessam (Titulo, poster e classificação)

        List<Conteudo> conteudos = minhaAPI.getExtrator().extraiConteudos(json);

        //Exibir e manipular os dados
        // GERADOR DE FIGURINHAS

        var gerador = new GeradorDeStickers();

        for(int i = 0; i < conteudos.size(); i++){
            Conteudo conteudo= conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImg()).openStream();
            String title = conteudo.title();
            String nomeArquivo = title.replace(":", "-")  + ".png";

            float rating = conteudo.rating();
            String date = conteudo.date();
            gerador.create(inputStream, nomeArquivo, rating, date, minhaAPI.name());
            System.out.println("STICKER CREATED: "+conteudo.title()+".png");
        }

    }
}
