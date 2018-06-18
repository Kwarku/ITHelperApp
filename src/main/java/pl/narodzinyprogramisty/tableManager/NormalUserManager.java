package pl.narodzinyprogramisty.tableManager;

import org.hibernate.Session;
import pl.narodzinyprogramisty.entity.NormalUser;
import pl.narodzinyprogramisty.service.HibernateService;

public class NormalUserManager extends HibernateCrudManager<NormalUser> {
    public NormalUserManager(HibernateService service) {
        super(service);
    }

    @Override
    public String getTableName() {
        return NormalUser.TABLE_NAME;
    }

    @Override
    public NormalUser getObject(Session session, String id) {
        return session.get(NormalUser.class, id);
    }
}
