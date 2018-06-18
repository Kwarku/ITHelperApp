package pl.narodzinyprogramisty.tableManager;

import org.hibernate.Session;
import pl.narodzinyprogramisty.entity.SellerUser;
import pl.narodzinyprogramisty.service.HibernateService;

public class SellerUserManager extends HibernateCrudManager<SellerUser> {

    public SellerUserManager(HibernateService service) {
        super(service);
    }

    @Override
    public String getTableName() {
        return SellerUser.TABLE_NAME;
    }

    @Override
    public SellerUser getObject(Session session, String id) {
        return session.get(SellerUser.class, id);
    }
}
