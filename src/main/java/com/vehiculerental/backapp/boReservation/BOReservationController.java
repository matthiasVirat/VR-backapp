package com.vehiculerental.backapp.boReservation;

import com.vehiculerental.backapp.boClient.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class BOReservationController {

    private RestTemplate restTemplate = new RestTemplate();
    private String reservationsListURL = "http://172.22.119.142:9093/reservations";
    private String getReservationByIdURL = "http://172.22.119.142:9093/reservation/{id}";
    private String addReservationURL = "http://172.22.119.142:9093/reservation/create";
    private String deleteReservationURL = "http://172.22.119.142:9093/reservation/delete/{id}";
    private String updateReservationURL = "http://172.22.119.142:9093/reservation/update";

    @ApiOperation(value = "Gets list of reservations, calls reservation controller microservice")
    @GetMapping(value = "reservations")
    public String getReservationsList(Model model) {
        Reservations reservationList[] = restTemplate.getForObject(reservationsListURL, Reservations[].class);
        model.addAttribute("reservations", reservationList);
        return "reservations";
    }

    @ApiOperation(value = "Gets one reservations, calls reservation controller microservice")
    @GetMapping(value = "reservation/{id}")
    public Reservations getReservationById(Model model, @PathVariable String id) {
        Reservations reservation = restTemplate.getForObject(getReservationByIdURL, Reservations.class, id);
        model.addAttribute("reservation", reservation);
        return reservation;
    }

    @ApiOperation(value = "Shows add reservation page")
    @RequestMapping(value = {"/addReservation"}, method = RequestMethod.GET)
    public String showAddReservationPage(Model model){
        Reservations reservation = new Reservations();
        model.addAttribute("reservation", reservation);
        return "addReservation";
    }

    @ApiOperation(value = "Saves a reservation, calls reservation controller microservice")
    @PostMapping(value = "reservation/new")
    public String saveReservation(Reservations reservation) {
        Reservations result = restTemplate.postForObject(addReservationURL, reservation, Reservations.class);
        return "redirect:/reservations";
    }

    @ApiOperation(value = "Deletes a reservation, calls reservation controller microservice")
    @GetMapping(value = "reservation/delete/{id}")
    public String deleteReservationById(@PathVariable String id) {
        restTemplate.delete(deleteReservationURL, id);
        return "redirect:/reservations";
    }

    @ApiOperation(value = "Shows the update reservation page")
    @RequestMapping(value = {"/reservation/update/{id}"}, method = RequestMethod.GET)
    public String showEditReservationPage(Model model, @PathVariable String id){
        Reservations reservation = getReservationById(model, id);
        model.addAttribute("reservation", reservation);
        return "editReservation";
    }

    @ApiOperation(value = "Updates a reservation, calls reservation controller microservice")
    @PostMapping(value = "reservation/update")
    public String updateReservation(Reservations reservation){
        restTemplate.put(updateReservationURL, reservation);
        return "redirect:/reservations";
    }

}




