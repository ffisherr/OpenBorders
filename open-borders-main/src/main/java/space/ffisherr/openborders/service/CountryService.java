package space.ffisherr.openborders.service;

import space.ffisherr.openborders.entity.Countries;

import java.util.List;

public interface CountryService {

    List<String> getOpenedCountries(Long userId);

    Countries getCountry(String lastUserMessage);

    void addCountryForUser(Countries country, Long userId);

    String getAllUserCountries(Long userId);
}
