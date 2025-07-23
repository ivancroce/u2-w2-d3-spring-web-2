package ictech.u2_w2_d3_spring_web_2.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class Author {
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatar;

    public Author(String name, String surname, String email, LocalDate birthDate, String avatar) {
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 10000);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.avatar = avatar;
    }
}
