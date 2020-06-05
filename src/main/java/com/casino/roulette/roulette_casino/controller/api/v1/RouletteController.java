package com.casino.roulette.roulette_casino.controller.api.v1;

import com.casino.roulette.roulette_casino.dto.model.RouletteDto;
import com.casino.roulette.roulette_casino.dto.response.Response;
import com.casino.roulette.roulette_casino.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roulette")
public class RouletteController {
    @Autowired
    private RouletteService rouletteService;

    @GetMapping("")
    public Response getRouletteList() {
        List<RouletteDto> rouletteList = rouletteService.getAllRouletteList();
        return Response.ok().setPayload(rouletteList);
    }

    @PostMapping("")
    public Response createNewRoulette() {
        String rouletteId = rouletteService.createRoulette();

        return Response.ok().setPayload(
                "Created Id with " + rouletteId + " ID"
        );
    }

    @PatchMapping("")
    public Response openRoulette(@RequestParam String id) {
        Boolean result = rouletteService.openRoulette(id);

        return result ?
                Response.ok().setPayload("The roulette was opened!") :
                Response.exception().setPayload("The roulette was not opened because it doesn't exist or is already opened");
    }

}
