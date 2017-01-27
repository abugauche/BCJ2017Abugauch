package com.abugauch.bootcamp.Controller;

import com.abugauch.bootcamp.Domain.Condition;
import com.abugauch.bootcamp.Persistence.ConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Usuario on 26/1/2017.
 */

@RestController
public class ConditionRestController {

    @Autowired
    ConditionDAO conditionService;

    @RequestMapping(value = "weather/get/all", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Condition>> listAllCondition() {
        List<Condition> conditions = conditionService.readAll();
        return new ResponseEntity<List<Condition>>(conditions, HttpStatus.OK);
    }


}
