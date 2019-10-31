package com.vehiculerental.backapp.boClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api(description = "BO Client Controller")
@Controller
public class BoClientController {

    private String clientListURL = "http://172.22.119.138:9082/clients";
    private String addClientURL = "http://172.22.119.138:9082/client/create";
    private String deleteClientURL = "http://172.22.119.138:9082/client/delete/{id}";
    private String getClientByIdURL = "http://172.22.119.138:9082/client/{id}";
    private String updateClientURL = "http://172.22.119.138:9082/client/update/";

    private RestTemplate restTemplate = new RestTemplate();

    @ApiOperation(value = "Gets list of Clients, calls Client microservice")
    @GetMapping(value = "clients")
    public String getClientList(Model model) {
        Client clientList[] = restTemplate.getForObject(clientListURL, Client[].class);
        model.addAttribute("clients", clientList);
        return "clients";
    }

    @ApiOperation(value = "Gets one Client, calls Client microservice")
    @GetMapping(value = "client/{id}")
    public Client getClientById(Model model, @PathVariable String id) {
        Client client = restTemplate.getForObject(getClientByIdURL, Client.class, id);
        model.addAttribute("client", client);
        return client;
    }

    @ApiOperation(value = "Shows the add Client page")
    @RequestMapping(value = {"/addClient"}, method = RequestMethod.GET)
    public String showAddClientPage(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "addClient";
    }

    @ApiOperation(value = "Adds client, calls Client microservice")
    @PostMapping(value = "client/new")
    public String saveClient(Client client) {
        Client result = restTemplate.postForObject(addClientURL, client, Client.class);
        return "redirect:/clients";
    }

    @ApiOperation(value = "Deletes a client, calls Client microservice")
    @GetMapping(value = "client/delete/{id}")
    public String deleteClientById(@PathVariable String id) {
        restTemplate.delete(deleteClientURL, id);
        return "redirect:/clients";
    }

    @ApiOperation(value = "Shows update Client page")
    @RequestMapping(value = {"/client/update/{id}"}, method = RequestMethod.GET)
    public String showEditClientPage(Model model, @PathVariable String id){
        Client client = getClientById(model, id);
        model.addAttribute("client", client);
        return "editClient";
    }

    @ApiOperation(value = "Updates a client, calls Client microservice")
    @RequestMapping(value = "client/update/{id}")
    public String updateClient(Client client, @PathVariable String id){
        restTemplate.put(updateClientURL+ '/'+id, client);
        return "redirect:/clients";
    }



}
