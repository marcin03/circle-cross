package pl.bestgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestgame.service.GameService;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/")
    public String game() {
        return "default";
    }


    @PostMapping(path = "/")
    @ResponseBody
    public FieldNumber move(@RequestBody FieldNumber number) {
        return gameService.bootMove(number);
    }


}
