package ictech.u2_w2_d3_spring_web_2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewBlogPostPayload {
    private String genre;
    private String title;
    private String content;
    private int readingTime;
    private UUID authorId;
}
