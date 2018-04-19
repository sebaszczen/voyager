package trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trips.domain.Trip;
import trips.services.ClientService;
import trips.services.TripService;

import javax.validation.Valid;

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/addTrip")
    public String addTrip(Model model, @ModelAttribute @Valid Trip trip, BindingResult bind,
                          @RequestParam(value = "clientID") Long id) {
        if (bind.hasErrors()) {
            return "tripForm";
        } else {
            tripService.addTrip(trip, id);
            model.addAttribute("trips", tripService.displayAllTrips());
            return "tripHome";
        }
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("clients", clientService.displayAllClients());
        return "tripForm";
    }

    @GetMapping("/displayAllTrips")
    public String displayAllTrips(Model model) {
        model.addAttribute("trips", tripService.displayAllTrips());
        return "tripHome";
    }
}
