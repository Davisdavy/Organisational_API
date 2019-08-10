package models;

public class News {

    private int news_id;
    private String news_content;
    private int dpt_id;
    private String news_name;

    public News(String news_content, int dpt_id, String news_name) {
        this.news_content = news_content;
        this.dpt_id = dpt_id;
        this.news_name = news_name;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }
}
