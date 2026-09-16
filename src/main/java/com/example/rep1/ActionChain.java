package com.example.rep1;

import java.util.Random;

public class ActionChain {

    public static final int ORE = 1;
    public static final int GEM = 2;
    public static final int EMPTY = 3;
    public static final int COLLAPSE = 4;
    public static final int LUCKY = 5;

    private final Handler chain;
    private final Random random = new Random();

    public ActionChain(GameState game) {
        chain = new OreHandler(
                new GemHandler(
                        new EmptyHandler(
                                new CollapseHandler(
                                        new LuckyHandler(null, game),
                                        game
                                ),
                                game
                        ),
                        game
                ),
                game
        );
    }

    public boolean process(int mine) {
        int result = generateResult(mine);
        return chain.process(result);
    }

    private int generateResult(int mine) {

        int chance = random.nextInt(100);

        switch (mine) {

            case 1:
                if (chance < 45) return ORE;
                if (chance < 55) return GEM;
                if (chance < 85) return EMPTY;
                if (chance < 95) return COLLAPSE;
                return LUCKY;

            case 2:
                if (chance < 40) return ORE;
                if (chance < 60) return GEM;
                if (chance < 75) return EMPTY;
                if (chance < 95) return COLLAPSE;
                return LUCKY;

            case 3:
                if (chance < 30) return ORE;
                if (chance < 60) return GEM;
                if (chance < 70) return EMPTY;
                if (chance < 95) return COLLAPSE;
                return LUCKY;

            default:
                return EMPTY;
        }
    }
}