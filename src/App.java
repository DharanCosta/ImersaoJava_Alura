import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Acessar os dados da API pelo método HTTP e alocar a resposta dentro de uma String
//
//       // IMDb
        String url = APIsSelector.IMDB.getUrl();
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        //NASA
//        String url = APIsSelector.NASA.getUrl();
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        //Extrair só os dados que interessam (Titulo, poster e classificação)

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        //Exibir e manipular os dados
        // GERADOR DE FIGURINHAS

        var gerador = new GeradorDeStickers();

        for(int i = 0; i <10; i++){
            Conteudo conteudo= conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImg()).openStream();
            String title = conteudo.title();
            String nomeArquivo = title.replace(":", "-")  + ".png";

            float rating = conteudo.rating();
            String date = conteudo.date();
            gerador.create(inputStream, nomeArquivo, rating, date);
            System.out.println("STICKER CREATED: "+conteudo.title()+".png");
        }

    }
}
