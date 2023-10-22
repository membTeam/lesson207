package lesson207;


import lesson207.config.ConfigLoadData;
import lesson207.models.Emploees;
import lesson207.repositories.EmploeesRepositories;
import lesson207.service.EmployeesServiceEmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class EmploeesTests {

    private EmploeesRepositories emploeesRepositories;

    @Autowired
    private ConfigLoadData configLoadData;

    private EmployeesServiceEmpl employeesServiceEmpl;

    @BeforeEach
    void setup(){
        try {
            employeesServiceEmpl = new EmployeesServiceEmpl(configLoadData);
            emploeesRepositories = configLoadData.getEmploeesRepositories();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void CanFindEmploee() {
        var count = emploeesRepositories.count();
        Emploees emploees = emploeesRepositories.findFirstEmploee();

        var pasport = emploees.getPasport();
        var resFindEmploee = employeesServiceEmpl.findEmploee(pasport);

        assertThat(resFindEmploee).isEqualTo(emploees);
        System.out.println(emploees);
    }

    @Test
    public void CanAddEmploee(){
        var emploee = Emploees.builder().pasport("62 12454").firstname("FirstName").lastname("LastName").build();

        Integer amountBefor = employeesServiceEmpl.getAmountExt();
        employeesServiceEmpl.addEmploee(emploee);

        Integer amountAfter = employeesServiceEmpl.getAmountExt();

        System.out.println("amountBefor:" + amountBefor + " amountAfter:" + amountAfter);

        assertThat(amountAfter).isEqualTo(amountBefor + 1);
    }

    @Test
    public void CanModifyEmploee(){
        var emploee = employeesServiceEmpl.allEmploee().get(1);

        var firstNameEditing = emploee.getFirstname() + "_editor";
        emploee.setFirstname(firstNameEditing);

        employeesServiceEmpl.modfEmploees(emploee);

        var emploeeAfterSave = employeesServiceEmpl.findEmploee(emploee.getPasport());

        assertThat(emploeeAfterSave.getFirstname()).isEqualTo(firstNameEditing);
    }

    @Test
    public void CanDeleteEmploee() {
        var emploee = employeesServiceEmpl.allEmploee().get(0);

        var resDelete = employeesServiceEmpl.deleteEmploee(emploee.getPasport());
        var strAssert = "Выполнено удаление " + emploee.getFirstname() + " " + emploee.getLastname();

        assertThat(resDelete).isEqualTo(strAssert);

    }

}
