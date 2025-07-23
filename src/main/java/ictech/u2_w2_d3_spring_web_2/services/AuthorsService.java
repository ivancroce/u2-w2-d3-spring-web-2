package ictech.u2_w2_d3_spring_web_2.services;

import ictech.u2_w2_d2_spring_web.entities.Author;
import ictech.u2_w2_d2_spring_web.exceptions.NotFoundException;
import ictech.u2_w2_d2_spring_web.payloads.NewAuthorPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorsService {
    private List<Author> authorsDB = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorsDB;
    }

    public Author saveAuthors(NewAuthorPayload payload) {
        Author newAuthor = new Author(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getBirthDate(), "https://ui-avatars.com/api/?name=Mario+Rossi");
        this.authorsDB.add(newAuthor);
        log.info("The author with email '" + payload.getEmail() + "' was created.");
        return newAuthor;
    }

    public Author findById(int authorId) {
        Author found = null;
        for (Author author : this.authorsDB) {
            if (author.getId() == authorId) found = author;
        }

        if (found == null) throw new NotFoundException(authorId);
        return found;
    }

    public Author findByIdAndUpdate(int authorId, NewAuthorPayload payload) {
        Author found = null;
        for (Author author : this.authorsDB) {
            if (author.getId() == authorId) {
                found = author;
                found.setName(payload.getName());
                found.setSurname(payload.getSurname());
                found.setEmail(payload.getEmail());
                found.setBirthDate(payload.getBirthDate());
                found.setAvatar("https://ui-avatars.com/api/?name=" + payload.getName() + "+" + payload.getSurname());
            }
        }

        if (found == null) throw new NotFoundException(authorId);
        return found;
    }

    public void findByIdAndDelete(int authorId) {
        Author found = null;
        for (Author author : this.authorsDB) {
            if (author.getId() == authorId) found = author;
        }

        if (found == null) throw new NotFoundException(authorId);
        this.authorsDB.remove(found);
    }
}
