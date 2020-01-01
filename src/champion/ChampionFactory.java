package champion;

public abstract class ChampionFactory {
    public static Champion getChampion(final String championType, final int posX, final int posY) {
        switch (championType) {
            case "K":
                return new Knight(posX, posY);
            case "P":
                return new Pyromancer(posX, posY);
            case "R":
                return new Rogue(posX, posY);
            case "W":
                return new Wizard(posX, posY);
            default:
                return null;
        }
    }
}
