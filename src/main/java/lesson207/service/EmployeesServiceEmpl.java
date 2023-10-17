package lesson207.service;

import lesson207.exceptionAPI.EmployeeStorageIsFullException;
import lesson207.models.Emploees;
import lesson207.repositories.EmploeesRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EmployeesServiceEmpl implements EmployeesService {

    private EmploeesRepositories emploeesRepositories;
    private Map<String, Emploees> mapEmploees;
    public EmployeesServiceEmpl(EmploeesRepositories emploeesRepositories){
        this.emploeesRepositories = emploeesRepositories;

        initMap();
    }

    private void initMap(){
        mapEmploees = new HashMap<>();
        for(var item : emploeesRepositories.findAll()){
            mapEmploees.put(item.getId(), item);
        }
    }

    public List<String> info(){
        return new ArrayList<>(List.of(
                "Назначение: Справочник сотрудников комапании",
                "Кол-во сотрудников: " +  emploeesRepositories.count(),
                "Добавить сотрудника: (POST json) localhost:8080/serv/add-emploee",
                "Изменение данных: (POST json) localhost:8080/serv/upd-emploee",
                "Поиск сотрудника по id: (GET) localhost:8080/serv/find/{id}",
                "Список сотрудников: (GET) localhost:8080/serv/all-emploee",
                "Удаление сотрудника по id: (GET) localhost:8080/serv/del-emploee/{id}"
        ));
    }

    @Override
    public Emploees modfEmploees(Emploees emploees) {

        String err = "";
        try{
            emploeesRepositories.save(emploees);
            initMap();

        } catch (Exception ex){
            err = ex.getMessage();
            throw new EmployeeStorageIsFullException(err);
        }

        return mapEmploees.get(emploees.getId());
    }

    @Override
    public Emploees addEmploee(Emploees emploee) {

        var resSave = emploeesRepositories.save(emploee);
        initMap();

        return mapEmploees.get(resSave.getId());
    }

    @Override
    public String deleteEmploee(String id) {
        var result = mapEmploees.remove(id);

        if (result == null){
            throw new EmployeeStorageIsFullException("Нет данных по сотруднику");
        }

        emploeesRepositories.deleteById(result.getId());
        initMap();

        return "Выполнено удаление " + result.getFirstname() + " " + result.getLastname();
    }

    @Override
    public Emploees findEmploee(String id) {
        var result = mapEmploees.get(id);
        if (result == null){
            throw new EmployeeStorageIsFullException("Нет данных по сотруднику");
        }

        return result;
    }

    @Override
    public List<Emploees> allEmploee() {
        return mapEmploees.values().stream().collect(Collectors.toList());
    }

    @Override
    public String getAmount() {
        return "Размер: " + mapEmploees.size();
    }

    @Override
    public Integer getAmountExt() {
        return mapEmploees.size();
    }
}
