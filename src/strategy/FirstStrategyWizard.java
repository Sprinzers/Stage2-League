package strategy;

import champion.Wizard;
import util.Constants;

public class FirstStrategyWizard implements StrategyWizard {

    @Override
    public void doStrategy(Wizard wizard) {
        int hpLoss = wizard.getHP() / 10;
        wizard.reduceHP(hpLoss);
        wizard.increaseRaceMod(Constants.DAMAGE_MOD_60);
    }
}
