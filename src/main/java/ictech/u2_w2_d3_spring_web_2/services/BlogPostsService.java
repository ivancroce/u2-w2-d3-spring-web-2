package ictech.u2_w2_d3_spring_web_2.services;

import ictech.u2_w2_d2_spring_web.entities.BlogPost;
import ictech.u2_w2_d2_spring_web.exceptions.NotFoundException;
import ictech.u2_w2_d2_spring_web.payloads.NewBlogPostPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogPostsService {
    private List<BlogPost> blogPostsDB = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogPostsDB;
    }

    public BlogPost saveBlogPosts(NewBlogPostPayload payload) {
        BlogPost newBlogPost = new BlogPost(payload.getGenre(), payload.getTitle(), "https://picsum.photos/200/300", payload.getContent(), payload.getReadingTime());
        this.blogPostsDB.add(newBlogPost);
        log.info("The BlogPost with title '" + payload.getTitle() + "' was created.");
        return newBlogPost;
    }

    public BlogPost findById(int BlogPostId) {
        BlogPost found = null;
        for (BlogPost BlogPost : this.blogPostsDB) {
            if (BlogPost.getId() == BlogPostId) found = BlogPost;
        }

        if (found == null) throw new NotFoundException(BlogPostId);
        return found;
    }

    public BlogPost findByIdAndUpdate(int BlogPostId, NewBlogPostPayload payload) {
        BlogPost found = null;
        for (BlogPost BlogPost : this.blogPostsDB) {
            if (BlogPost.getId() == BlogPostId) {
                found = BlogPost;
                found.setGenre(payload.getGenre());
                found.setTitle(payload.getTitle());
                found.setContent(payload.getContent());
                found.setReadingTime(payload.getReadingTime());
            }
        }

        if (found == null) throw new NotFoundException(BlogPostId);
        return found;
    }

    public void findByIdAndDelete(int BlogPostId) {
        BlogPost found = null;
        for (BlogPost BlogPost : this.blogPostsDB) {
            if (BlogPost.getId() == BlogPostId) found = BlogPost;
        }

        if (found == null) throw new NotFoundException(BlogPostId);
        this.blogPostsDB.remove(found);
    }
}
