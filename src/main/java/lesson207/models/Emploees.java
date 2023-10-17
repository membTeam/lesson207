package lesson207.models;

import lesson207.config.GeneratedId;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@Builder
public class Emploees implements GeneratedId {
    @Id
    private String id;
    private String firstname;
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploees emploees = (Emploees) o;
        return Objects.equals(id, emploees.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
