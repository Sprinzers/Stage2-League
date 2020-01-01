package angel;

public abstract class AngelFactory {
    public static Angel getAngel(final String angelType, final int posX, final int posY) {
        switch (angelType) {
            case "DamageAngel":
                return new DamageAngel(posX, posY);
            case "DarkAngel":
                return new DarkAngel(posX, posY);
            case "Dracula":
                return new Dracula(posX, posY);
            case "GoodBoy":
                return new GoodBoy(posX, posY);
            case "LevelUpAngel":
                return new LevelUpAngel(posX, posY);
            case "LifeGiver":
                return new LifeGiver(posX, posY);
            case "SmallAngel":
                return new SmallAngel(posX, posY);
            case "Spawner":
                return new Spawner(posX, posY);
            case "TheDoomer":
                return new TheDoomer(posX, posY);
            case "XPAngel":
                return new XPAngel(posX, posY);
            default:
                return null;
        }
    }
}
