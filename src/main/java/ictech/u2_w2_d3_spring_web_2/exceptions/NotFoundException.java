package ictech.u2_w2_d3_spring_web_2.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Resource with id '" + id + "' not found.");
    }
}
