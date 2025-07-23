package ictech.u2_w2_d3_spring_web_2.controllers;

import ictech.u2_w2_d2_spring_web.entities.Author;
import ictech.u2_w2_d2_spring_web.payloads.NewAuthorPayload;
import ictech.u2_w2_d2_spring_web.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // is a specialization of @Component:
// When the application starts, Spring will automatically create an instance of the class and add it to the Spring Container.
// It defines a collection of endpoints.
// It's a class that handles web requests and returns data
@RequestMapping("/authors") // endpoint of this controller => (http://localhost:3001/authors)
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    // 1. GET http://localhost:3001/authors
    @GetMapping
    public List<Author> getAuthors() {
        return this.authorsService.findAll();
    }

    // 2. POST http://localhost:3001/authors (+ payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Author createAuthor(@RequestBody NewAuthorPayload body) {
        return this.authorsService.saveAuthors(body);
    }

    // 3. GET http://localhost:3001/authors/{authorId}
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return this.authorsService.findById(authorId);
    }

    // 4. PUT http://localhost:3001/authors/{authorId} (+ payload)
    @PutMapping("/{authorId}")
    public Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody NewAuthorPayload body) {
        return this.authorsService.findByIdAndUpdate(authorId, body);
    }

    // 5. DELETE http://localhost:3001/authors/{blogPostId}
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void findAuthorByIdAndDelete(@PathVariable int authorId) {
        this.authorsService.findByIdAndDelete(authorId);
    }
}
