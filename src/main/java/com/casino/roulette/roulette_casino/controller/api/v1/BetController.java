package com.casino.roulette.roulette_casino.controller.api.v1;

import com.casino.roulette.roulette_casino.controller.api.request.NewBetRequest;
import com.casino.roulette.roulette_casino.controller.api.request.validation.RequestValidation;
import com.casino.roulette.roulette_casino.dto.model.BetResultsDto;
import com.casino.roulette.roulette_casino.dto.response.Response;
import com.casino.roulette.roulette_casino.model.Client;
import com.casino.roulette.roulette_casino.model.Colour;
import com.casino.roulette.roulette_casino.model.Roulette;
import com.casino.roulette.roulette_casino.service.BetService;
import com.casino.roulette.roulette_casino.service.ClientService;
import com.casino.roulette.roulette_casino.service.RouletteService;
import com.casino.roulette.roulette_casino.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bet")
public class BetController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private RouletteService rouletteService;
    @Autowired
    private BetService betService;

    @PostMapping("")
    public Response newBet(@RequestBody NewBetRequest newBetRequest, @RequestHeader("client-id") String clientId) {
        if (!RequestValidation.isValidNewBetRequest(newBetRequest)) {
            return Response.badRequest().setPayload("Bad formatted request");
        }

        Optional<Client> client = clientService.getClientById(clientId);
        Optional<Roulette> roulette = rouletteService.getRouletteById(newBetRequest.getRouletteId());

        if (!client.isPresent() || !roulette.isPresent()) {
            return Response.exception().setPayload("Client or roulette does not exist");
        }

        if (!roulette.get().getState()){
            return Response.exception().setPayload("The roulette must be open");
        }

        if (client.get().getBalance() < newBetRequest.getAmount()) {
            return Response.exception().setPayload("Client does not have the required amount of money to pay the bet");
        }

        int betNumber = (newBetRequest.getBetNumber() != null) ? newBetRequest.getBetNumber().intValue() : -1;
        Colour betColour = Util.stringToColour((newBetRequest.getColour() != null) ? newBetRequest.getColour() : "");

        if (betNumber != -1 && (betNumber < 0 || betNumber > 36) ){
            return Response.exception().setPayload("The bet number must be between 0 and 36");
        }

        Boolean result = betService.createBet(client.get(),
                roulette.get(),
                newBetRequest.getAmount().floatValue(),
                betNumber,
                betColour);

        if (!result) {
            return Response.exception().setPayload("There was an error creating the bet");
        }
        clientService.subtractBet(client.get(), newBetRequest.getAmount().floatValue());
        return Response.ok().setPayload("Bet was created with success");
    }

    @PatchMapping("")
    public Response closeBet(@RequestParam String rouletteId) {
        Boolean closeRouletteResult = rouletteService.closeRoulette(rouletteId);
        if (!closeRouletteResult) {
            return Response.notFound().setPayload("The roulette does not exist!");
        }
        BetResultsDto betResultsDto = betService.closeBet(rouletteId);
        return Response.ok().setPayload(betResultsDto);
    }

}
