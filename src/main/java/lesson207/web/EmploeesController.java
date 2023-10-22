package lesson207.web;

import lesson207.config.ConfigLoadData;
import lesson207.models.Emploees;
import lesson207.service.EmployeesServiceEmpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/serv" )
public class EmploeesController {

    private EmployeesServiceEmpl employeesServiceEmpl;

    public EmploeesController(ConfigLoadData configLoadData) {
        this.employeesServiceEmpl = new EmployeesServiceEmpl(configLoadData);
    }

    @GetMapping("/info")
    public List<String> info(){
        return employeesServiceEmpl.info();
    }

    @PostMapping(path ="/add-emploee", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Emploees addEmploee(@RequestBody Emploees emploees){
        return employeesServiceEmpl.addEmploee(emploees);
    }

    @PostMapping(path ="/upd-emploee", consumes="application/json")
    public Emploees updEmploee(@RequestBody Emploees emploees){
        return employeesServiceEmpl.modfEmploees(emploees);
    }

    @GetMapping(value = "/find/{id}")
    public Emploees findEmploee(@PathVariable("id") String id ){
        return employeesServiceEmpl.findEmploee(id);
    }

    @GetMapping("/all-emploee")
    public List<Emploees> allEmploees(){
        return employeesServiceEmpl.allEmploee();
    }

    @GetMapping("/del-emploee/{pasport}")
    public String delEmploee(@PathVariable("pasport") String pasport){
        return employeesServiceEmpl.deleteEmploee(pasport);
    }



}
