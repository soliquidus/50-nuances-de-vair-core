package dev.controller;

import dev.entity.Pollution;
import dev.service.PollutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Pollution Controller
 */
@RestController
@RequestMapping("pollutions")
public class PollutionController {

    private final PollutionService service;

    public PollutionController(PollutionService service) {
        this.service = service;
    }

//    /**
//     *  Current air pollution data
//     */
//    @GetMapping("current")
//    public Pollution getCurrentAirPollution(@RequestParam Long lat, Long lon ){
//        return service.getCurrentAirPollution(lat, lon);
//    }
//
//    /**
//     *  Current air pollution data  by city
//     */
//    @GetMapping("current")
//    public Pollution getCurrentAirPollutionByCity(@RequestParam String cityName ){
//        return service.getCurrentAirPollutionByCity(cityName);
//    }
//
//    /**
//     *  Forecast air pollution data
//     */
//    @GetMapping("forecast")
//    public List<Pollution> getForecastAirPollution(@RequestParam Long lat, Long lon , LocalDate startDate,LocalDate endDate){
//        return service.getForecastAirPollution(lat, lon, startDate, endDate);
//    }
//    /**
//     *  Forecast air pollution data by city
//     */
//    @GetMapping("forecast")
//    public List<Pollution> getForecastAirPollutionByCity(@RequestParam String cityName , LocalDate startDate,LocalDate endDate){
//        return service.getForecastAirPollutionByCity(cityName,startDate,endDate);
//    }
}
