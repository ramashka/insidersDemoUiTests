package config;

import lombok.Getter;

@Getter
public enum Config {
    LOCAL("http://localhost:9000", "http://localhost:3666", "http://localhost:9200"),
    PROD("http://localhost:9000", "http://localhost:3667", "http://localhost:9200");

    private String URL_BE;
    private String URL_FE;
    private String URL_ELASTIC;
    Config(String urlBe, String urlFe, String urlElastic) {
        this.URL_BE = urlBe;
        this.URL_FE = urlFe;
        this.URL_ELASTIC = urlElastic;
    }
}
