package com.abugauch.bootcamp.Controller;

/**
 * Created by Usuario on 26/1/2017.
 */
import java.util.List;

import com.abugauch.bootcamp.Domain.State;
import com.abugauch.bootcamp.Persistence.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StateRestController {
    @Autowired
    private StateDAO stateService;
    @RequestMapping(value = "/state/get/all" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<State>> listAllStates(){
        List<State> states = stateService.readAll();
        if(states.isEmpty()){
            return new ResponseEntity<List<State>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<State>>(states,  HttpStatus.OK);
    }

    @RequestMapping(value="/country/get/{name}/states", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<State>> stateGetAllByCountry(@PathVariable(value="name") String name){
        List<State> states = stateService.readAll();
            for(State state:stateService.readAll()){
                if (state.getCountry_name().equals(name)){
                    states.add(state);
                }
            }
        return new ResponseEntity<List<State>>(states, HttpStatus.OK);
    }
}
