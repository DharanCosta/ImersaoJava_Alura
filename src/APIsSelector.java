public enum APIsSelector {

    IMDB ("https://alura-imdb-api.herokuapp.com/movies",new ExtratorDeConteudoIMDB()),
    NASA ("https://api.mocki.io/v2/549a5d8b/NASA-APOD",new ExtratorDeConteudoNasa()),
    LOCAL ("http://api-linguagens-alura.herokuapp.com/linguagens/ranking",new ExtratorDeConteudoLinguagens());

    private String url;
    private ExtratorDeConteudo extrator;

    APIsSelector(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator=extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
