package ictech.u2_w2_d3_spring_web_2.services;

import ictech.u2_w2_d3_spring_web_2.entities.Author;
import ictech.u2_w2_d3_spring_web_2.entities.BlogPost;
import ictech.u2_w2_d3_spring_web_2.exceptions.NotFoundException;
import ictech.u2_w2_d3_spring_web_2.payloads.NewBlogPostPayload;
import ictech.u2_w2_d3_spring_web_2.repositories.BlogPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BlogPostsService {
    @Autowired
    BlogPostRepository blogPostRepository;

    @Autowired
    AuthorsService authorsService;

    public BlogPost saveBlogPost(NewBlogPostPayload payload) {

        Author author = authorsService.findById(payload.getAuthorId());

        BlogPost newBlogPost = new BlogPost(payload.getGenre(), payload.getTitle(), "https://picsum.photos/200/300", payload.getContent(), payload.getReadingTime(), author);

        log.info("The Blog Post with title '" + newBlogPost.getTitle() + "' was created.");
        return this.blogPostRepository.save(newBlogPost);
    }

    public List<BlogPost> findAll() {
        return this.blogPostRepository.findAll();
    }

    public BlogPost findById(UUID blogPostId) {
        return this.blogPostRepository.findById(blogPostId).orElseThrow(() -> new NotFoundException(blogPostId));
    }

    public BlogPost findByIdAndUpdate(UUID blogPostId, NewBlogPostPayload payload) {
        BlogPost found = this.findById(blogPostId);

        Author newAuthor = authorsService.findById(payload.getAuthorId());
        found.setAuthor(newAuthor);

        found.setGenre(payload.getGenre());
        found.setTitle(payload.getTitle());
        found.setContent(payload.getContent());
        found.setReadingTime(payload.getReadingTime());

        BlogPost updatedBlogPost = this.blogPostRepository.save(found);

        log.info("The Blog Post with ID '" + blogPostId + "' was updated.");
        return updatedBlogPost;
    }

    public void findByIdAndDelete(UUID blogPostId) {
        BlogPost found = this.findById(blogPostId);
        this.blogPostRepository.delete(found);
    }
}
