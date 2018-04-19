package trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trips.domain.Client;
import trips.services.ClientService;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public String add(Model model, @ModelAttribute @Valid Client client, BindingResult bind) {
        if (bind.hasErrors()) {
            return "clientForm";
        } else {
            clientService.addClient(client);
            model.addAttribute("clients", clientService.displayAllClients());
            return "clientHome";
        }
    }

    @GetMapping("/displayAllClients")
    public String displayAllClients(Model model) {
        model.addAttribute("clients", clientService.displayAllClients());
        return "clientHome";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("client", new Client());
        return "clientForm";
    }
}
