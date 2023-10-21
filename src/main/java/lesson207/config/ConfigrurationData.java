package lesson207.config;


import lesson207.models.Emploees;
import lesson207.repositories.EmploeesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class ConfigrurationData {
    public void LoadDataIntoDB(EmploeesRepositories repo) {

        repo.deleteAll();

        repo.save(new Emploees(null,"60 12453","Мария", "Андреева"));
        repo.save(new Emploees(null,"60 12454","Даниил", "Андрианов"));
        repo.save(new Emploees(null,"60 12455","Екатерина", "Анисимова" ));
        repo.save(new Emploees(null,"60 12456","Денис","Артамонов"));
        repo.save(new Emploees(null,"60 12457","Кирилл", "Артемов"));
        repo.save(new Emploees(null,"60 12458","Илья", "Афанасьев"));
        repo.save(new Emploees(null,"60 12459","Алиса","Беляева"));
        repo.save(new Emploees(null,"60 12460","Егор", "Борисов"));
        repo.save(new Emploees(null,"60 12461", "София", "Васильева"));
        repo.save(new Emploees(null,"60 12462", "София", "Бородина"));

    }

}
