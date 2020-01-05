package observer;

import angel.Angel;
import champion.Champion;

import java.io.FileWriter;
import java.io.IOException;

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

    @Override
    public void updateKill(final Champion victim, final Champion killer) throws IOException {
        fileWriter.write("Player " + victim.getFullName() + " " + victim.getID()
                +  " was killed by " + killer.getFullName() + " " + killer.getID() + "\n");
    }

    @Override
    public void updateSpawn(final Angel angel) throws IOException {
        fileWriter.write("Angel " + angel.getName() + " was spawned at " + angel.getPosX()
                + " " + angel.getPosY() + "\n");
    }

    @Override
    public void updateHit(final Angel angel, final Champion champion) throws IOException {
        fileWriter.write(angel.getName() + " hit " + champion.getFullName() + " "
                + champion.getID() + "\n");
    }

    @Override
    public void updateHelp(final Angel angel, final Champion champion) throws IOException {
        fileWriter.write(angel.getName() + " helped " + champion.getFullName() + " "
                + champion.getID() + "\n");
    }

    @Override
    public void updateRevive(final Champion champion) throws IOException {
        fileWriter.write("Player " + champion.getFullName() + " " + champion.getID()
                + " was brought to life by an angel\n");
    }

    @Override
    public void updateLevelUp(final Champion champion) throws IOException {
        fileWriter.write(champion.getFullName() + " " + champion.getID() + " reached level "
                + champion.getLevel() + "\n");
    }

    @Override
    public void updateKillByAgel(final Champion champion) throws IOException {
        fileWriter.write("Player " + champion.getFullName() + " " + champion.getID()
                + " was killed by an angel\n");
    }
}
