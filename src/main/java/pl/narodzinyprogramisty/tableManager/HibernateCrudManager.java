package pl.narodzinyprogramisty.tableManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.narodzinyprogramisty.entity.BaseModel;
import pl.narodzinyprogramisty.service.HibernateService;

import java.util.List;

public abstract class HibernateCrudManager<T extends BaseModel> implements CrudManager<T> {
    private HibernateService service;

    public HibernateCrudManager(HibernateService service) {
        this.service = service;
    }

    public abstract String getTableName();

    public abstract T getObject(Session session, String id);

    @Override
    public String create(T t) {
        service.openSession();
        Session session = service.getSession();
        Transaction transaction = null;
        String id = null;
        try {

            transaction = session.beginTransaction();
            id = (String) session.save(t);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public List<T> read() {
        service.openSession();
        Session session = service.getSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            List list = session.createQuery("FROM " + getTableName()).list();
            transaction.commit();

            return list;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(T newT) {
        service.openSession();
        Session session = service.getSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            session.update(newT);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(String id) {
        service.openSession();
        Session session = service.getSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.delete(getObject(session,id));
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
