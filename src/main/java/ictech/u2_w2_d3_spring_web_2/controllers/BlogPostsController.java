package ictech.u2_w2_d3_spring_web_2.controllers;

import ictech.u2_w2_d3_spring_web_2.entities.BlogPost;
import ictech.u2_w2_d3_spring_web_2.payloads.NewBlogPostPayload;
import ictech.u2_w2_d3_spring_web_2.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {

    @Autowired
    private BlogPostsService blogPostsService;

    // 1. GET http://localhost:3001/blogPosts
    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return this.blogPostsService.findAll();
    }

    // 2. POST http://localhost:3001/blogPosts (+ payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public BlogPost createBlogPost(@RequestBody NewBlogPostPayload payload) {
        return this.blogPostsService.saveBlogPost(payload);
    }

    // 3. GET http://localhost:3001/blogPosts/{blogPostId}
    @GetMapping("/{blogPostId}")
    public BlogPost getBlogPostById(@PathVariable UUID blogPostId) {
        return this.blogPostsService.findById(blogPostId);
    }

    // 4. PUT http://localhost:3001/blogPosts/{blogPostId} (+ payload)
    @PutMapping("/{blogPostId}")
    public BlogPost findBlogPostByIdAndUpdate(@PathVariable UUID blogPostId, @RequestBody NewBlogPostPayload payload) {
        return this.blogPostsService.findByIdAndUpdate(blogPostId, payload);
    }

    // 5. DELETE http://localhost:3001//blogPosts/{blogPostId}
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void findBlogPostByIdAndDelete(@PathVariable UUID blogPostId) {
        this.blogPostsService.findByIdAndDelete(blogPostId);
    }
}

