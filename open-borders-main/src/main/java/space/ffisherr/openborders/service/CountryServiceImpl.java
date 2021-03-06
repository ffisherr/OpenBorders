package space.ffisherr.openborders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.ffisherr.openborders.entity.Countries;
import space.ffisherr.openborders.entity.UserWantedCountries;
import space.ffisherr.openborders.repository.UserCountriesRepository;
import space.ffisherr.openborders.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final UserCountriesRepository repository;
    private final UsersRepository usersRepository;

    @Override
    public List<String> getOpenedCountries(Long userId) {
        return repository.findAllOpenedCountriesNames(userId);

    }

    @Override
    public Countries getCountry(String countryName) {
        return repository.findByName(countryName).orElse(null);
    }

    @Override
    public void addCountryForUser(Countries country, Long userId) {
        usersRepository.findById(userId).ifPresent(user -> {
            final UserWantedCountries userCountry = new UserWantedCountries();
            userCountry.setUser(user);
            userCountry.setName(country.getName());
            repository.save(userCountry);
        });
    }

    @Override
    public String getAllUserCountries(Long userId) {
        final List<UserWantedCountries> countries = repository.findAllByUser(userId);
        final StringBuilder sb = new StringBuilder();
        sb.append("Страны для посещения:\n");
        for (UserWantedCountries c : countries) {
            sb.append(c.getName()).append(" ");
        }
        return sb.toString();
    }

}
