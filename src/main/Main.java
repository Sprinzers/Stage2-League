package main;

import champion.Champion;
import champion.ChampionFactory;
import util.Constants;
import game.TileMap;
import input.GameInput;
import input.GameInputLoader;

import java.util.ArrayList;

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        TileMap.generateMap(gameInput.getTerrainDescription());
        TileMap map = TileMap.getInstance();

        ArrayList<Champion> champions = new ArrayList<Champion>();

        for (int i = 0; i < gameInput.getChampionsOrder().size(); ++i) {
            // place the champions at the initial position
            ArrayList<String> currChampion = gameInput.getChampionsOrder().get(i);
            int posX = Integer.parseInt(currChampion.get(Constants.CHAMPION_POS_X));
            int posY = Integer.parseInt(currChampion.get(Constants.CHAMPION_POS_Y));
            Champion newChampion = ChampionFactory.getChampion(currChampion
                    .get(Constants.CHAMPION_TYPE), posX, posY);
            newChampion.setID(i);
            champions.add(newChampion);
        }
        // move all the champions
        for (int i = 0; i < gameInput.getRoundsOrder().size(); ++i) {
            for (int j = 0; j < gameInput.getRoundsOrder().get(i).length(); ++j) {
                if (champions.get(j).isAlive() && !champions.get(j).isIncapacitated()) {
                    char move = gameInput.getRoundsOrder().get(i).charAt(j);
                    champions.get(j).makeMove(move);
                }
            }
            // determine which champions have a terrain modifier active and apply DOT effects
            for (Champion currChampion : champions) {
                currChampion.hasTerrainModifier(map.getTileType(currChampion.getPosX(),
                        currChampion.getPosY()));
                currChampion.applyDamageOverTime();
            }
            // fight all the champions located in the same tile
            for (Champion currChampion : champions) {
                if (currChampion.isAlive()) {
                    for (Champion opponent : champions) {
                        if (currChampion.verifyOpponent(opponent) && currChampion.isAlive()
                                && opponent.isAlive()) {
                            // store the initial HP
                            currChampion.setHPBeforeRound(currChampion.getHP());
                            opponent.setHPBeforeRound(opponent.getHP());
                            // fight between the two champions
                            currChampion.isAttackedBy(opponent);
                            opponent.isAttackedBy(currChampion);
                            currChampion.setFoughtThisRound(true);
                            opponent.setFoughtThisRound(true);
                            int levelFirstChampion = currChampion.getLevel();
                            int levelSecondChampion = opponent.getLevel();
                            // give XP and level up
                            if (!currChampion.isAlive() && opponent.isAlive()) {
                                if (opponent.awardXP(levelFirstChampion)) {
                                    opponent.restoreHP();
                                }
                            } else if (currChampion.isAlive() && !opponent.isAlive()) {
                                if (currChampion.awardXP(levelSecondChampion)) {
                                    currChampion.restoreHP();
                                }
                            } else if (!currChampion.isAlive() && !opponent.isAlive()) {
                                currChampion.awardXP(levelSecondChampion);
                                opponent.awardXP(levelFirstChampion);
                            }
                        }
                    }
                }
            }
            // reset fight status at the end of the round
            for (Champion currChampion : champions) {
                currChampion.setFoughtThisRound(false);
                currChampion.increaseRoundCounter();
            }
        }
        gameInputLoader.write(champions);
    }
}
