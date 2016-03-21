package products.entity;

import java.util.List;

public class Catalogue {
    private List<Sports> sports;
    private List<News> news;

    public Catalogue() {
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Sports> getSports() {
        return sports;
    }

    public void setSports(List<Sports> sports) {
        this.sports = sports;
    }
}
