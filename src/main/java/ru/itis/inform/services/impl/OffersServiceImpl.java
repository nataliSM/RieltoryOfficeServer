package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.itis.inform.models.City;
import ru.itis.inform.models.Offer;
import ru.itis.inform.models.Street;
import ru.itis.inform.repositories.CityRepository;
import ru.itis.inform.repositories.OffersRepository;
import ru.itis.inform.repositories.StreetRepository;
import ru.itis.inform.services.OffersService;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
@Service
@Transactional
@Component
public class OffersServiceImpl implements OffersService {

    private OffersRepository offersRepository;
    private CityRepository cityRepository;
    private StreetRepository streetRepository;

    public OffersServiceImpl() {
    }

    @Autowired
    public OffersServiceImpl(
                             OffersRepository offersRepository,
                             CityRepository cityRepository,
                             StreetRepository streetRepository)
    {

        this.offersRepository = offersRepository;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
    }


    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName, Integer startCost, Integer endCost)
    {
        return offersRepository.getAllOffersWithParams(numberOfRooms, condition, repair, cityName,startCost,endCost);
    }



    @Override
    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public List<Street> getAllStreets() {
        return (List<Street>) streetRepository.findAll();
    }

    @Override
    public Offer save(Offer offer) {

        return offersRepository.save(offer);
    }

    public void update(Offer offer) {
        offersRepository.update(offer.getId(), offer.getCost());
    }


    @Override
    public List<Offer> getAll() {
        return (List<Offer>) offersRepository.findAll();
    }

    public void delete(Integer id){
        offersRepository.delete(id);
    }

    public void update(Integer id, Integer cost){
        offersRepository.update(id,cost);
    }

    @Override
    public Offer findOffer(Integer id) {
        return offersRepository.findOne(id);
    }

}
