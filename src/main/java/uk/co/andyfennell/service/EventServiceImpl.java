package uk.co.andyfennell.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import uk.co.andyfennell.model.hibernate.domain.Event;
import uk.co.andyfennell.model.hibernate.domain.EventDao;

@Transactional
public class EventServiceImpl implements EventService {

    private EventDao eventDao;
    
    public EventDao getEventDao() {
        return eventDao;
    }
    
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    
    public void addEvent(Event event) {
        System.out.println("EventService addEvent 1");
        //assert TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("EventService addEvent 2");
        
        eventDao.insert(event);
        System.out.println("EventService addEvent 3");
    }
    
    public List<Event> fetchAllEvents() {
        return eventDao.selectAll();
    }

}
