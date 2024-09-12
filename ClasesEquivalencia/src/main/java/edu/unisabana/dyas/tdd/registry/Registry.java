package edu.unisabana.dyas.tdd.registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private final List<Integer> Ids = new ArrayList<>();
    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (p.getAge() > 100) {
            return RegisterResult.INVALID_AGE;
        }
        if (Ids.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        Ids.add(p.getId());
        return RegisterResult.VALID;
    }
}
