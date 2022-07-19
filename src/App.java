import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        // Acessar os dados da API pelo método HTTP e alocar a resposta dentro de uma String
        String url = "https://alura-imdb-api.herokuapp.com/movies";
//        String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


        //Extrair só os dados que interessam (Titulo, poster e classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(0));
        
        //Exibir e manipular os dados
          //Lista de Título, LinkImagem, Classificação e estrelas no terminal
//        for(Map<String,String> filme : listaDeFilmes){
//
////            System.out.println("\u001b[38;2;240;245;179m Título: \u001b[0m \u001b[1m"+filme.get("title")+"\u001b[0m");
////            System.out.println("\u001b[38;2;240;245;179m Poster: \u001b[0m"+filme.get("image"));
//
////            System.out.println("\u001b[42m \u001b[34;1m Classificação: "+filme.get("imDbRating")+" \u001b[0m");
////            int ratingInt = Math.round(rating);
////            for(int i=0; i<ratingInt; i++ ){
////                System.out.print("\u2b50");
////            }
////            System.out.println("\n");
//        }


        for(Map<String,String> filme : listaDeFilmes) {
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            float rating = Float.parseFloat(filme.get("imDbRating"));

            if(urlImagem.contains("@")) {
                //substring
                String subUrlImg = urlImagem.substring(0, urlImagem.lastIndexOf("@") + 1);
                System.out.println(subUrlImg + ".jpg");

                InputStream inputStream = new URL(subUrlImg).openStream();
                String nomeArquivo = titulo + ".png";

                GeradorDeStickers gerador = new GeradorDeStickers();
                gerador.create(inputStream, nomeArquivo, rating);
            }else{
                InputStream inputStream = new URL(urlImagem).openStream();
                System.out.println(urlImagem);
                String nomeArquivo = titulo + ".png";
                GeradorDeStickers gerador = new GeradorDeStickers();
                gerador.create(inputStream, nomeArquivo, rating);
            }
        }
    }
}
