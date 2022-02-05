package store.drink.drink.Counter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Slf4j
@Service
@SessionScope
public class CounterService {

    private int noOfIncrements = 0;
    private final String session = UUID.randomUUID().toString();

    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @PostConstruct
    public void storeFreshCounter(){
        log.info("Update test counter... - " + session);
        if(this.counterRepository.findById("test").isEmpty()){
            log.info("Store test counter");
            this.counterRepository.save(new Counter("test", 1));
        }
        else{
            log.info("Update test counter");
            Counter c = this.counterRepository.findById("test").get();
            c.setCounter(1);
            this.counterRepository.save(c);
        }
    }

    public void increment(){
        Counter c = this.counterRepository.findById("test").get();
        c.setCounter(c.getCounter() + 1);
        this.counterRepository.save(c);
        this.noOfIncrements++;
        log.info("Increment stored to DB... - " + session);
    }

    @PreDestroy
    public void sessionCleanup(){
        log.info("Counter session cleanup... - " + session);
    }
}
