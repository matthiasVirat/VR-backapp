package com.vehiculerental.backapp.boVehicle;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BOVehiculeController {

    private RestTemplate restTemplate = new RestTemplate();
    private String vehiculesListURL = "http://172.22.119.157:9091/vehicules";
    private String getVehiculeByIdURL = "http://172.22.119.157:9091/vehicule/{id}";
    private String addVehiculeURL = "http://172.22.119.157:9091/vehicule/create";
    private String deleteVehiculeURL = "http://172.22.119.157:9081/vehicule/delete/{registrationNbr}";
    private String updateVehiculeURL = "http://172.22.119.157:9081/vehicule/update";

    @ApiOperation(value = "Gets list of vehicles, calls vehicle controller microservice")
    @GetMapping(value = "vehicules")
    public String getVehiculeList(Model model) {
        Vehicule vehiculeList[] = restTemplate.getForObject(vehiculesListURL, Vehicule[].class);
        model.addAttribute("vehiculeList", vehiculeList);
        return "vehicules";
    }

    @ApiOperation(value = "Gets one vehicles, calls vehicle controller microservice")
    @GetMapping(value = "vehicule/{id}")
    public Vehicule getVehiculeById(Model model, @PathVariable String id) {
        Vehicule vehicule = restTemplate.getForObject(getVehiculeByIdURL, Vehicule.class, id);
        model.addAttribute("vehicule", vehicule);
        return vehicule;
    }

    @ApiOperation(value = "Shows add Vehicle page")
    @RequestMapping(value = {"/addVehicule"}, method = RequestMethod.GET)
    public String showAddVehiculePage(Model model){
        Vehicule vehicule = new Vehicule();
        model.addAttribute("vehicule", vehicule);
        return "addVehicule";
    }

    @ApiOperation(value = "Adds a vehicle to DB, calls vehicle controller microservice")
    @PostMapping(value = "vehicule/new")
    public String saveVehicule(Vehicule vehicule) {
        Vehicule result = restTemplate.postForObject(addVehiculeURL, vehicule, Vehicule.class);
        return "redirect:/vehicules";
    }

    @ApiOperation(value = "Deletes a vehicle base on Reg no, calls vehicle microservice")
    @GetMapping(value = "vehicule/delete/{registrationNbr}")
    public String deleteVehicule(@PathVariable String registrationNbr) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("registrationNbr", registrationNbr);
        restTemplate.delete(deleteVehiculeURL, params);
        return "redirect:/vehicules";
    }

    @ApiOperation(value = "Shows update vehicle page")
    @RequestMapping(value = {"/vehicule/update/{id}"}, method = RequestMethod.GET)
    public String showEditVehiculePage(Model model, @PathVariable String id){
        Vehicule vehicule = getVehiculeById(model, id);
        model.addAttribute("vehicule", vehicule);
        return "editVehicule";
    }

    @ApiOperation(value = "Updates a vehicle, calls vehicle microservice")
    @PostMapping(value = "vehicule/update")
    public String updateReservation(Vehicule vehicule){
        restTemplate.put(updateVehiculeURL, vehicule);
        return "redirect:/vehicules";
    }


}
