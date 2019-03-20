package fr.paul.game.webservice;

import fr.paul.game.constant.CountryRef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Country Referential Webservice
 */
@RestController
@RequestMapping("/country-ref")
public class CountryRefWS {

    /**
     * Get country ref
     * @return country ref
     */
    @GetMapping("/")
    public ResponseEntity<?> getCountryRef() {

        Map<String, String[]> ref = new HashMap<>();

        // Map enum to iso/neighbors map
        Arrays.asList(CountryRef.values()).stream()
                .forEach(countryRef -> ref.put(countryRef.getId(), countryRef.getNeighbors()));

        return new ResponseEntity<>(ref, HttpStatus.OK);
    }

}