package uk.co.andyfennell.hibernate;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import uk.co.andyfennell.model.hibernate.domain.Event;
import uk.co.andyfennell.service.EventService;
import java.net.URL;
import java.net.URLClassLoader;


public class HibernateDaoSupportTest {

    @Test
    public void testCreate() {
        System.out.println("1");        

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        
        URL[] urls = ((URLClassLoader)cl).getURLs();
 
        for(URL url: urls){
            System.out.println(url.getFile());
        }        
        
        try {
        // Picks up the context from /src/main/resources    
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-spring-config.xml");

        System.out.println("2");        

        EventService eventService = (EventService) context.getBean("eventService");
        
        Event event = new Event();
        event.setTitle("Event DaoSupport");
        
        Calendar calendar = Calendar.getInstance();
        // Just want whole seconds
        calendar.clear(Calendar.MILLISECOND);
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        
        event.setDate(currentTimestamp);
        
        System.out.println("3");        
        
        eventService.addEvent(event);

        System.out.println("4");        
        
        List<Event> events = eventService.fetchAllEvents();
        for (Event tmp : events) {
            System.out.println("Id:" + tmp.getId() + " Title:" + tmp.getTitle() + " Date:" + tmp.getDate());
        }
        
        System.out.println("5");        
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail(e.getMessage());
        }
    }

}
