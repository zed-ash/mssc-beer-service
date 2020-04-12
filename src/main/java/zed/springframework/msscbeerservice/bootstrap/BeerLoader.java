package zed.springframework.msscbeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zed.springframework.msscbeerservice.domain.Beer;
import zed.springframework.msscbeerservice.repositories.BeerRepository;

import java.math.BigDecimal;
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count()==0){

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(394898393L)
                    .price(new BigDecimal(30.33))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(23393833L)
                    .price(new BigDecimal(34.34))
                    .build());

        }
    }
}
