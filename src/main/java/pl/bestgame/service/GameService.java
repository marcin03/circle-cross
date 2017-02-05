package pl.bestgame.service;

import org.springframework.stereotype.Service;
import pl.bestgame.controller.FieldNumber;

import java.util.HashSet;
import java.util.Set;

@Service
public class GameService {


    private Set<FieldNumber> playerFields = new HashSet<FieldNumber>();

    private Set<FieldNumber> bootFields = new HashSet<FieldNumber>();

    public FieldNumber bootMove(FieldNumber playerFieldNumber) {

        playerFields.add(playerFieldNumber);

        FieldNumber bootFieldNumber = calculateBootNumber();

        bootFields.add(bootFieldNumber);

        return bootFieldNumber;
    }

    private FieldNumber calculateBootNumber() {

        FieldNumber candidate = new FieldNumber((int) (Math.random() * 9));
        return candidate;
    }

}
