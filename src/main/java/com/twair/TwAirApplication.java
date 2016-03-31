package com.twair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@EnableAutoConfiguration
public class TwAirApplication {
	@RequestMapping("/")
	public String home(Model model) {
        model.addAttribute("locations", DataSource.instance().fetchLocations());
		return "FlightSearch";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute(value="searchForm") SearchForm searchForm, Model model) throws Exception {
		model.addAttribute("locations", DataSource.instance().fetchLocations());
		try {
			FlightSearch matchingFlights = DataSource.instance().fetchFlights().byLocation(searchForm.getFrom(), searchForm.getTo());
            int capacity = 1;
            String sCapacity = searchForm.getNumber();
            if (!sCapacity.isEmpty()){
                capacity = Integer.parseInt(sCapacity);
            }
            model.addAttribute("flights", matchingFlights.byCapacity(capacity).getFlightList());
			model.addAttribute("passengernum", new Integer(capacity).toString());
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("flights", new ArrayList());
            model.addAttribute("errorMessage", e.getMessage());
		}
		return "FlightSearch";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TwAirApplication.class, args);
	}
}
