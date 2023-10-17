package lesson207.service;

import java.util.List;
import lesson207.models.Emploees;

public interface EmployeesService {
    Emploees addEmploee(Emploees emploee);
    String deleteEmploee(String id);
    Emploees findEmploee(String id);

    Emploees modfEmploees(Emploees emploees);

    List<Emploees> allEmploee();

    String getAmount();

    Integer getAmountExt();
}
