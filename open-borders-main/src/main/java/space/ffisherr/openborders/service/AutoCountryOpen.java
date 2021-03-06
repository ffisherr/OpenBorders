package space.ffisherr.openborders.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import space.ffisherr.openborders.entity.Countries;
import space.ffisherr.openborders.repository.CountriesRepository;

@Slf4j
@Configuration
@EnableScheduling
@Service //srvic обозначение сервиса, создать экземпляр
@RequiredArgsConstructor//создание кострукстора со всеми полями(final)
public class AutoCountryOpen {

    private final CountriesRepository repository;

    @Scheduled(fixedDelay = 120000)
    public void scheduleFixedDelayTask(){
        if(!repository.findAllClosedCountries().isEmpty()) {
            Countries country = repository.findAllClosedCountries().get(0);
            log.warn("Открываем страну: " + country.getName());
            country.setIsAvailable(true);
            repository.save(country);
        }
    }
}
