package uk.co.andyfennell.model.hibernate.domain;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class EventDao extends HibernateDaoSupport {

    public void insert(Event event) {
        assert TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("EventDao insert 1");
        getHibernateTemplate().save(event);
        System.out.println("EventDao insert 2");
    }
    
    public List<Event> selectAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);
        return (List<Event>) getHibernateTemplate().findByCriteria(criteria);
    }
    
}
