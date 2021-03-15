package space.ffisherr.openborders.service;

import org.springframework.stereotype.Service;
import space.ffisherr.openborders.entity.Countries;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public List<String> getOpenedCountries(Long userId) {
        return null; // TODO
    }

    @Override
    public Countries getCountry(String lastUserMessage) {
        return null; // TODO
    }

    @Override
    public void addCountryForUser(Countries country, Long userId) {
        // TODO
    }

}
