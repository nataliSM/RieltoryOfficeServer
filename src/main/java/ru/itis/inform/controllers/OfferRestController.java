package ru.itis.inform.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.dto.OfferDto;
import ru.itis.inform.models.Offer;
import ru.itis.inform.services.OffersService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Natalia on 09.04.17.
 */

@RestController
public class OfferRestController {

    @Autowired
    OffersService offersServices;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public List<OfferDto> getOffers() {
        List<Offer> offers = offersServices.getAll();
        return  offers.stream()
                .map(offer -> convertToDto(offer))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDto createPost(@RequestBody OfferDto offerDto) {
        Offer offer = convertToEntity(offerDto);
        Offer createdOffer = offersServices.save(offer);
        return convertToDto(createdOffer);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<OfferDto> getOffer(@PathVariable("offerId") Integer offerId) {
        Offer offer = offersServices.findOffer(offerId);
        return new ResponseEntity<OfferDto>(convertToDto(offer), HttpStatus.OK);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateOffer(@RequestBody OfferDto offerDto) {
        Offer offer = convertToEntity(offerDto);
        offersServices.update(offer);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOffer(@PathVariable("offerId") Integer offerId) {
        offersServices.delete(offerId);
    }




    private OfferDto convertToDto (Offer offer) {
        OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        return offerDto;
    }

    private Offer convertToEntity (OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        return offer;
    }


}
