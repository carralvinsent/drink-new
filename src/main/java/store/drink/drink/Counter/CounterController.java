package store.drink.drink.Counter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;

@Slf4j
@Controller
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    private CounterService service;

    @PostConstruct
    public void someLogging(){
        log.info("Construct Controller...");
    }

    @GetMapping
    public String getCounterPage(){
        service.increment();
        return "Home";
    }
}
