package ictech.u2_w2_d3_spring_web_2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewAuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
}
