package com.abugauch.bootcamp.Controller;

/**
 * Created by Usuario on 26/1/2017.
 */
import java.util.List;

import com.abugauch.bootcamp.Persistence.CountryDAO;
import com.abugauch.bootcamp.Domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {

    @Autowired
    private CountryDAO countryService;
    //-------------------Retrieve All Countries--------------------------------------------------------
    @RequestMapping(value = "/country/get/all" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> listAllCountries(){
        List<Country> countries = countryService.readAll();
        if(countries.isEmpty()){
            return new ResponseEntity<List<Country>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Country>>(countries,  HttpStatus.OK);
    }

    //-------------------Retrieve Single Country --------------------------------------------------------
    @RequestMapping(value="/country/get/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> getCountry(@PathVariable("name") String name){
        System.out.println("Fetching Country with name " + name);
        Country country= countryService.read(name);
        if (name == null) {
            System.out.println("Country with name " + name + " not found");
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }

}
