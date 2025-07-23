package ictech.u2_w2_d3_spring_web_2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Resource with id '" + id + "' not found.");
    }
}
