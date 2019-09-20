package pl.inome.shop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "page-info")
public class PageInfo {

    private String author;
    private int creationDate;

    public PageInfo() {
    }

    public PageInfo(String author, int creationDate) {
        this.author = author;
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    //    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        System.out.print(author);
        System.out.println(creationDate);
    }
}
