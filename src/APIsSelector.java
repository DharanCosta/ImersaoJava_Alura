public enum APIsSelector {

    IMDB ("https://alura-imdb-api.herokuapp.com/movies"),
    NASA ("https://api.mocki.io/v2/549a5d8b/NASA-APOD");

    private String url;

    APIsSelector(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
