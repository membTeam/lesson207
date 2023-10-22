package lesson207.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emploees {
    @Id
    private String id;
    private String pasport;
    private String firstname;
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploees emploees = (Emploees) o;
        return Objects.equals(pasport, emploees.pasport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasport);
    }
}
