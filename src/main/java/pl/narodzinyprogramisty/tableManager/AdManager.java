package pl.narodzinyprogramisty.tableManager;

import org.hibernate.Session;
import pl.narodzinyprogramisty.entity.Ad;
import pl.narodzinyprogramisty.service.HibernateService;

public class AdManager extends HibernateCrudManager<Ad> {

    public AdManager(HibernateService service) {
        super(service);
    }

    @Override
    public String getTableName() {
        return Ad.TABLE_NAME;
    }

    @Override
    public Ad getObject(Session session, String id) {
        return session.get(Ad.class, id);
    }
}
