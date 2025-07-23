package ictech.u2_w2_d3_spring_web_2.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class BlogPost {
    @Setter(AccessLevel.NONE)
    private int id;
    private String genre;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public BlogPost(String genre, String title, String cover, String content, int readingTime) {
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 10000);
        this.genre = genre;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.readingTime = readingTime;
    }
}
