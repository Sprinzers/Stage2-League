package observer;

import angel.Angel;
import champion.Champion;

import java.io.FileWriter;

public final class GreatMagician extends Observer {
    private static GreatMagician instance = null;
    private FileWriter fileWriter;

    private GreatMagician(final FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public static GreatMagician getInstance(final FileWriter fileWriter) {
        if (instance == null) {
            instance = new GreatMagician(fileWriter);
        }
        return instance;
    }

    /*
        Observer is notified when a champion kills another champion.
     */
    @Override
    public void updateKill(final Champion victim, final Champion killer) {
        try {
            fileWriter.write("Player " + victim.getFullName() + " " + victim.getID()
                    +  " was killed by " + killer.getFullName() + " " + killer.getID() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Observer is notified when an angel spawns.
     */
    @Override
    public void updateSpawn(final Angel angel) {
        try {
            fileWriter.write("Angel " + angel.getName() + " was spawned at " + angel.getPosX()
                    + " " + angel.getPosY() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Observer is notified when a bad angel interacts with a champion.
     */
    @Override
    public void updateHit(final Angel angel, final Champion champion) {
        try {
            fileWriter.write(angel.getName() + " hit " + champion.getFullName() + " "
                    + champion.getID() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Observer is notified when a good angel interacts with a champion.
     */
    @Override
    public void updateHelp(final Angel angel, final Champion champion) {
        try {
            fileWriter.write(angel.getName() + " helped " + champion.getFullName() + " "
                    + champion.getID() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        Observer is notified when an angel revives a champion.
     */
    @Override
    public void updateRevive(final Champion champion) {
        try {
            fileWriter.write("Player " + champion.getFullName() + " " + champion.getID()
                    + " was brought to life by an angel\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Observer is notified when a champion levels up.
     */
    @Override
    public void updateLevelUp(final Champion champion) {
        try {
            fileWriter.write(champion.getFullName() + " " + champion.getID() + " reached level "
                    + champion.getLevel() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Observer is notified when an angel kills a champion.
     */
    @Override
    public void updateKillByAgel(final Champion champion) {
        try {
            fileWriter.write("Player " + champion.getFullName() + " " + champion.getID()
                    + " was killed by an angel\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
