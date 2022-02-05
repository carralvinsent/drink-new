package store.drink.drink.Data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import store.drink.drink.Model.Bottle;
import store.drink.drink.Model.Crate;
import store.drink.drink.Model.OrderItem;
import store.drink.drink.Model.Orders;
import store.drink.drink.Repository.BottleRepository;
import store.drink.drink.Repository.CrateRepository;
import store.drink.drink.Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DemoData {
    private final BottleRepository bottleRepository;
    private final CrateRepository crateRepository;
    private final OrderRepository orderRepository;

    public DemoData(BottleRepository bottleRepository, CrateRepository crateRepository, OrderRepository orderRepository) {
        this.bottleRepository = bottleRepository;
        this.crateRepository = crateRepository;
        this.orderRepository = orderRepository;
    }

    @EventListener
    public void createDemoData(ApplicationReadyEvent event){

        List<Bottle> bottleList = new ArrayList<>();
        List<Crate> crateList = new ArrayList<>();
//        List<Orders> orderList = new ArrayList<>();
//        List<OrderItem> orderItemsList = new ArrayList<>();

        Bottle bottle1 = new Bottle(null,"Pepsi","https://thumbs.dreamstime.com/b/london-uk-june-bottle-pepsi-cola-soft-drink-white-american-multinational-food-beverage-company-background-94138787.jpg",1.5,false,0.0,2,"ABC Ltd",25);
        Bottle bottle2 = new Bottle(null,"CocaCola","https://5.imimg.com/data5/AF/ZN/JD/SELLER-49520187/2-25-l-coca-cola-cold-drink-500x500.jpg",2.5,false,0.0,3,"XYZ Ltd",17);
        Bottle bottle3 = new Bottle(null,"Gluhwein","https://static.specsonline.com/wp-content/uploads/reload/008036899800.jpg",1,true,18,4,"PQRS Ltd",15);
        Bottle bottle4 = new Bottle(null,"KingfischerBeer","https://www.bigbasket.com/media/uploads/p/m/40199558_3-kingfisher-premium-lager-beer.jpg",1,true,20,2,"DEF Ltd",20);

        bottleList.add(bottle1);
        bottleList.add(bottle2);
        bottleList.add(bottle3);
        bottleList.add(bottle4);

        Crate crate1 = new Crate(null,"BudweiserBeer","https://www.pngitem.com/pimgs/m/3-36220_transparent-six-pack-beer-clipart-budweiser-beer-south.png",6,4,5);
        Crate crate2 = new Crate(null,"AugusteenerBeer","https://www.bluegetraenke.hamburg/WebRoot/Store25/Shops/79860089/5C87/CE9A/F942/F15B/86E2/0A0C/6D05/4730/33005_Augustiner_Lagerbier_hell_20_x_05L_MEHRWEG_Kiste_zzgl._310__8364__Pfand_ml.jpg",20,40,6);

        crateList.add(crate1);
        crateList.add(crate2);

//        Orders order1 = new Orders(null,"23",orderItemsList);
//        Orders order2 = new Orders(null,"34",orderItemsList);
//        Orders order3 = new Orders(null,"45",orderItemsList);
//        Orders order4 = new Orders(null,"12",orderItemsList);

//        orderList.add(order1);
//        orderList.add(order2);
//        orderList.add(order3);
//        orderList.add(order4);


//        orderRepository.saveAll(orderList);
        bottleRepository.saveAll(bottleList);
        crateRepository.saveAll(crateList);
    }
}
