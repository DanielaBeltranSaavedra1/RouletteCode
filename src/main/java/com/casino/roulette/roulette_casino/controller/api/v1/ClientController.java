package com.casino.roulette.roulette_casino.controller.api.v1;

import com.casino.roulette.roulette_casino.controller.api.request.NewClientRequest;
import com.casino.roulette.roulette_casino.controller.api.request.validation.RequestValidation;
import com.casino.roulette.roulette_casino.dto.model.ClientDto;
import com.casino.roulette.roulette_casino.dto.response.Response;
import com.casino.roulette.roulette_casino.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public Response getAllClients() {
        List<ClientDto> clientList = clientService.getClientList();

        return Response.ok().setPayload(clientList);
    }

    @PostMapping("")
    public Response createNewClient(@RequestBody NewClientRequest newClientRequest) {
        if (!RequestValidation.isValidNewClientRequest(newClientRequest)) {
            return Response.badRequest().setPayload("Bad formatted request");
        }

        String newClientId = clientService.createClient(newClientRequest.getName(), newClientRequest.getBalance().floatValue());
        return Response.ok().setPayload(
                "Created client with ID: " + newClientId
        );
    }
}
