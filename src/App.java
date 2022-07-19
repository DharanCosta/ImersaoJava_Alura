import java.net.URI;
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

        for(Map<String,String> filme : listaDeFilmes){
            System.out.println("\u001b[38;2;240;245;179m Título: \u001b[0m \u001b[1m"+filme.get("title")+"\u001b[0m");
            System.out.println("\u001b[38;2;240;245;179m Poster: \u001b[0m"+filme.get("image"));
            
            System.out.println("\u001b[42m \u001b[34;1m Classificação: "+filme.get("imDbRating")+" \u001b[0m");
        
            float rating = Float.parseFloat(filme.get("imDbRating"));
            int ratingInt = Math.round(rating);
            for(int i=0; i<ratingInt; i++ ){
                System.out.print("\u2b50");
            }
            System.out.println("\n");
        }
       
    }
}
