package main;

import angel.Angel;
import angel.AngelFactory;
import champion.Champion;
import champion.ChampionFactory;
import observer.GreatMagician;
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
        ArrayList<String> notifications = new ArrayList<>();
        GreatMagician greatMagician = GreatMagician.getInstance();

        for (int i = 0; i < gameInput.getChampionsOrder().size(); ++i) {
            // place the champions at the initial position
            ArrayList<String> currChampion = gameInput.getChampionsOrder().get(i);
            int posX = Integer.parseInt(currChampion.get(Constants.CHAMPION_POS_X));
            int posY = Integer.parseInt(currChampion.get(Constants.CHAMPION_POS_Y));
            Champion newChampion = ChampionFactory.getChampion(currChampion
                    .get(Constants.CHAMPION_TYPE), posX, posY);
            newChampion.setID(i);
            newChampion.addObserver(greatMagician);
            champions.add(newChampion);
        }
        ArrayList<ArrayList<Angel>> angels = new ArrayList<ArrayList<Angel>>();
        // create all angels
        for (int i = 0; i < gameInput.getAngelSpawn().size(); ++i) {
            ArrayList<Angel> currRoundAngels = new ArrayList<Angel>();
            for (int j = 0; j < gameInput.getAngelSpawn().get(i).size(); ++j) {
                String[] parts = gameInput.getAngelSpawn().get(i).get(j).split(",");
                String angelName = parts[0];
                int posX = Integer.parseInt(parts[1]);
                int posY = Integer.parseInt(parts[2]);
                Angel newAngel = AngelFactory.getAngel(angelName, posX, posY);
                newAngel.addObserver(greatMagician);
                currRoundAngels.add(newAngel);
            }
            angels.add(currRoundAngels);
        }

        // move all the champions
        for (int i = 0; i < gameInput.getRoundsOrder().size(); ++i) {
            int round = i + 1;
            notifications.add("~~ Round " + round + " ~~\n");

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
                                notifications.add(currChampion.notifyKill(opponent));

                            } else if (currChampion.isAlive() && !opponent.isAlive()) {
                                if (currChampion.awardXP(levelSecondChampion)) {
                                    currChampion.restoreHP();
                                }
                                notifications.add(opponent.notifyKill(currChampion));

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

            for (int j = 0; j < angels.get(i).size(); ++j) {
                notifications.add(angels.get(i).get(j).spawnAngel());
            }
            notifications.add("\n");

//            for (Champion champion : champions) {
//                System.out.println(champion.getFullName() + " " + champion.getID() + " " + champion.getHP() + " " + champion.isAlive());
//            }
//            System.out.println();
        }
        gameInputLoader.write(champions, notifications);
    }
}
