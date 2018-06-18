package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.service.HibernateService;
import pl.narodzinyprogramisty.service.MySQLService;

public class Main {
    public static void main(String[] args) {
        HibernateService service = new MySQLService();

        service.connect("hibernate.cfg.xml");
        service.disconnect();

    }
}
