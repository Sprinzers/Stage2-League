package champion;

import angel.Angel;
import strategy.FirstStrategyKnight;
import strategy.SecondStrategyKnight;
import strategy.StrategyKnight;
import util.Constants;

import java.io.IOException;

public class Knight extends Champion {

    Knight(final int newPosX, final int newPosY) {
        setPosX(newPosX);
        setPosY(newPosY);
        setPreferredTerrain(Constants.KNIGHT_PREFERRED_TERRAIN);
        setTerrainModifier(Constants.KNIGHT_TERRAIN_MODIFIER);
        setHP(Constants.KNIGHT_HP);
        setHPStart(Constants.KNIGHT_HP);
        setHPGrowth(Constants.KNIGHT_HP_GROWTH);
        setXP();
        setLevel();
        setIncapacitated(0);
        setFoughtThisRound(false);
        setFirstAbilityBase(Constants.KNIGHT_ABILITY_1_BASE);
        setFirstAbilityGrowth(Constants.KNIGHT_ABILITY_1_GROWTH);
        setSecondAbilityBase(Constants.KNIGHT_ABILITY_2_BASE);
        setSecondAbilityGrowth(Constants.KNIGHT_ABILITY_2_GROWTH);
        setRoundCounter();

        setRaceModKnightFirst(Constants.MODIFIER_0);
        setRaceModKnightSecond(Constants.MODIFIER_20_POS);

        setRaceModPyromancerFirst(Constants.MODIFIER_10_POS);
        setRaceModPyromancerSecond(Constants.MODIFIER_10_NEG);

        setRaceModRogueFirst(Constants.MODIFIER_15_POS);
        setRaceModRogueSecond(Constants.MODIFIER_20_NEG);

        setRaceModWizardFirst(Constants.MODIFIER_20_NEG);
        setRaceModWizardSecond(Constants.MODIFIER_5_POS);
    }

    public void increaseRaceMod(final float newRaceMod) {
        setRaceModWizardFirst(getRaceModWizardFirst() + newRaceMod);
        setRaceModWizardSecond(getRaceModWizardSecond() + newRaceMod);
        setRaceModRogueFirst(getRaceModRogueFirst() + newRaceMod);
        setRaceModRogueSecond(getRaceModRogueSecond() + newRaceMod);
        setRaceModPyromancerFirst(getRaceModPyromancerFirst() + newRaceMod);
        setRaceModPyromancerSecond(getRaceModPyromancerSecond() + newRaceMod);
        setRaceModKnightSecond(getRaceModKnightSecond() + newRaceMod);
    }

    public void reduceRaceMod(final float newRaceMod) {
        setRaceModWizardFirst(getRaceModWizardFirst() - newRaceMod);
        setRaceModWizardSecond(getRaceModWizardSecond() - newRaceMod);
        setRaceModRogueFirst(getRaceModRogueFirst() - newRaceMod);
        setRaceModRogueSecond(getRaceModRogueSecond() - newRaceMod);
        setRaceModPyromancerFirst(getRaceModPyromancerFirst() - newRaceMod);
        setRaceModPyromancerSecond(getRaceModPyromancerSecond() - newRaceMod);
        setRaceModKnightSecond(getRaceModKnightSecond() - newRaceMod);
    }

    /**
     *  Method used to apply the right strategy.
     */
    @Override
    public void applyStrategy() {
        StrategyKnight strategy;

        int hpLow = calculateTeoreticalHP() / 3;
        int hpHigh = calculateTeoreticalHP() / 2;
        if (hpLow < getHP() && getHP() < hpHigh) {
            strategy = new FirstStrategyKnight();
            strategy.doStrategy(this);
        } else if (getHP() < hpLow) {
            strategy = new SecondStrategyKnight();
            strategy.doStrategy(this);
        }
    }

    /**
     * Method is used to complete the double-dispatch mechanism.
     * @param champion that attacks "this"
     */
    @Override
    public void isAttackedBy(final Champion champion) {
        champion.attack(this);
    }

    /**
     *  Method is used to calculate the damage against a knight.
     * @param knight opponent champion.
     */
    @Override
    public void attack(final Knight knight) {
        // base damages
        float firstDamage = firstAbility();
        float secondDamage = secondAbility();
        // calculate execute threshold
        float executePercent = Constants.KNIGHT_HP_PERCENT_INITIAL
                + Constants.KNIGHT_HP_PERCENT_GROWTH * getLevel();
        if (executePercent > Constants.KNIGHT_HP_PERCENT_CAP) {
            executePercent = Constants.KNIGHT_HP_PERCENT_CAP;
        }
        if (knight.getHP() < knight.calculateTeoreticalHP() * executePercent) {
            knight.setHP(0);
            return;
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
        }
        // race modifier
        firstDamage *= getRaceModKnightFirst();
        secondDamage *= getRaceModKnightSecond();
        // DOT effects
        if (knight.getDamageOverTime().size() > 0) {
            knight.resetDamageOverTime();
        }
        knight.setIncapacitated(Constants.KNIGHT_INCAPACITATION_ROUNDS);
        // apply damage to enemy
        int totalDamage = Math.round(firstDamage) + Math.round(secondDamage);
        knight.reduceHP(totalDamage);
    }

    /**
     *  Method is used to calculate the damage against a pyromancer.
     * @param pyromancer opponent champion.
     */
    @Override
    public void attack(final Pyromancer pyromancer) {
        // base damages
        float firstDamage = firstAbility();
        float secondDamage = secondAbility();
        // calculate execute threshold
        float executePercent = Constants.KNIGHT_HP_PERCENT_INITIAL
                + Constants.KNIGHT_HP_PERCENT_GROWTH * getLevel();
        if (executePercent > Constants.KNIGHT_HP_PERCENT_CAP) {
            executePercent = Constants.KNIGHT_HP_PERCENT_CAP;
        }
        if (pyromancer.getHP() < pyromancer.calculateTeoreticalHP() * executePercent) {
            pyromancer.setHP(0);
            return;
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
        }
        // race modifier
        firstDamage *= getRaceModPyromancerFirst();
        secondDamage *= getRaceModPyromancerSecond();
        // DOT effects
        if (pyromancer.getDamageOverTime().size() > 0) {
            pyromancer.resetDamageOverTime();
        }
        pyromancer.setIncapacitated(Constants.KNIGHT_INCAPACITATION_ROUNDS);
        // apply damage to enemy
        int totalDamage = Math.round(firstDamage) + Math.round(secondDamage);
        pyromancer.reduceHP(totalDamage);
    }

    /**
     *  Method is used to calculate the damage against a rogue.
     * @param rogue opponent champion.
     */
    @Override
    public void attack(final Rogue rogue) {
        // base damages
        float firstDamage = firstAbility();
        float secondDamage = secondAbility();
        // calculate execute threshold
        float executePercent = Constants.KNIGHT_HP_PERCENT_INITIAL
                + Constants.KNIGHT_HP_PERCENT_GROWTH * getLevel();
        if (executePercent > Constants.KNIGHT_HP_PERCENT_CAP) {
            executePercent = Constants.KNIGHT_HP_PERCENT_CAP;
        }
        if (rogue.getHP() < rogue.calculateTeoreticalHP() * executePercent) {
            rogue.setHP(0);
            return;
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
        }
        // race modifier
        firstDamage *= getRaceModRogueFirst();
        secondDamage *= getRaceModRogueSecond();
        // DOT efects
        if (rogue.getDamageOverTime().size() > 0) {
            rogue.resetDamageOverTime();
        }
        rogue.setIncapacitated(Constants.KNIGHT_INCAPACITATION_ROUNDS);
        // apply damage to enemy
        int totalDamage = Math.round(firstDamage) + Math.round(secondDamage);
        rogue.reduceHP(totalDamage);
    }

    /**
     *  Method is used to calculate the damage against a wizard.
     * @param wizard opponent champion.
     */
    @Override
    public void attack(final Wizard wizard) {
        // base damages
        float firstDamage = firstAbility();
        float secondDamage = secondAbility();
        // calculate execute threshold
        float executePercent = Constants.KNIGHT_HP_PERCENT_INITIAL
                + Constants.KNIGHT_HP_PERCENT_GROWTH * getLevel();
        if (executePercent > Constants.KNIGHT_HP_PERCENT_CAP) {
            executePercent = Constants.KNIGHT_HP_PERCENT_CAP;
        }
        if (wizard.getHP() <= wizard.calculateTeoreticalHP() * executePercent) {
            wizard.setHP(0);
            return;
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
        }
        // race modifier
        firstDamage *= getRaceModWizardFirst();
        secondDamage *= getRaceModWizardSecond();
        // DOT effects
        if (wizard.getDamageOverTime().size() > 0) {
            wizard.resetDamageOverTime();
        }
        wizard.setIncapacitated(Constants.KNIGHT_INCAPACITATION_ROUNDS);
        // apply damage to enemy
        int totalDamage = Math.round(firstDamage) + Math.round(secondDamage);
        wizard.reduceHP(totalDamage);
    }

    /**
     *  Method used to apply the effect of the angel located on the tile.
     * @param angel angel that appeared on the same tile as the champion
     */
    @Override
    public void effectAppliedBy(final Angel angel) throws IOException {
        angel.applyEffect(this);
    }
}
