package champion;

import angel.Angel;
import strategy.StrategyRogue;
import strategy.FirstStrategyRogue;
import strategy.SecondStrategyRogue;
import util.Constants;

import java.io.IOException;

public class Rogue extends Champion {

    Rogue(final int newPosX, final int newPosY) {
        setPosX(newPosX);
        setPosY(newPosY);
        setPreferredTerrain(Constants.ROGUE_PREFERRED_TERRAIN);
        setTerrainModifier(Constants.ROGUE_TERRAIN_MODIFIER);
        setHP(Constants.ROGUE_HP);
        setHPStart(Constants.ROGUE_HP);
        setHPGrowth(Constants.ROGUE_HP_GROWTH);
        setXP();
        setLevel();
        setIncapacitated(0);
        setFoughtThisRound(false);
        setFirstAbilityBase(Constants.ROGUE_ABILITY_1_BASE);
        setFirstAbilityGrowth(Constants.ROGUE_ABILITY_1_GROWTH);
        setSecondAbilityBase(Constants.ROGUE_ABILITY_2_BASE);
        setSecondAbilityGrowth(Constants.ROGUE_ABILITY_2_GROWTH);
        setRoundCounter();

        setRaceModKnightFirst(Constants.MODIFIER_10_NEG);
        setRaceModKnightSecond(Constants.MODIFIER_20_NEG);

        setRaceModPyromancerFirst(Constants.MODIFIER_25_POS);
        setRaceModPyromancerSecond(Constants.MODIFIER_20_POS);

        setRaceModRogueFirst(Constants.MODIFIER_20_POS);
        setRaceModRogueSecond(Constants.MODIFIER_10_NEG);

        setRaceModWizardFirst(Constants.MODIFIER_25_POS);
        setRaceModWizardSecond(Constants.MODIFIER_25_POS);
    }

    /**
     *  Method used to apply the right strategy.
     */
    @Override
    public void applyStrategy() {
        StrategyRogue strategy;

        int hpLow = calculateTeoreticalHP() / 7;
        int hpHigh = calculateTeoreticalHP() / 5;
        if (hpLow < getHP() && getHP() < hpHigh) {
            strategy = new FirstStrategyRogue();
            strategy.doStrategy(this);
        } else if (getHP() < hpLow) {
            strategy = new SecondStrategyRogue();
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
        // apply critical hit
        if (getRoundCounter() % Constants.ROGUE_CRITICAL_HIT_CHANCE == 0) {
            if (getApplyTerrainModifier()) {
                firstDamage *= Constants.ROGUE_CRITICAL_HIT_MULTIPLIER;
            } else {
                setRoundCounter();
            }
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
            knight.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            knight.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS);
        }
        // race modifier
        firstDamage *= getRaceModKnightFirst();
        secondDamage *= getRaceModKnightSecond();
        // DOT effects
        if (knight.getDamageOverTime().size() > 0) {
            knight.resetDamageOverTime();
        }
        if (getApplyTerrainModifier()) {
            knight.addDamageOverTime(Math.round(secondDamage),
                    Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            knight.addDamageOverTime(Math.round(secondDamage), Constants.ROGUE_OVERTIME_ROUNDS);
        }
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
        // apply critical hit
        if (getRoundCounter() % Constants.ROGUE_CRITICAL_HIT_CHANCE == 0) {
            if (getApplyTerrainModifier()) {
                firstDamage *= Constants.ROGUE_CRITICAL_HIT_MULTIPLIER;
            } else {
                setRoundCounter();
            }
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
            pyromancer.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            pyromancer.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS);
        }
        // race modifier
        firstDamage *= getRaceModPyromancerFirst();
        secondDamage *= getRaceModPyromancerSecond();
        // DOT effects
        if (pyromancer.getDamageOverTime().size() > 0) {
            pyromancer.resetDamageOverTime();
        }
        if (getApplyTerrainModifier()) {
            pyromancer.addDamageOverTime(Math.round(secondDamage),
                    Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            pyromancer.addDamageOverTime(Math.round(secondDamage), Constants.ROGUE_OVERTIME_ROUNDS);
        }
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
        // apply critical hit
        if (getRoundCounter() % Constants.ROGUE_CRITICAL_HIT_CHANCE == 0) {
            if (getApplyTerrainModifier()) {
                firstDamage *= Constants.ROGUE_CRITICAL_HIT_MULTIPLIER;
            } else {
                setRoundCounter();
            }
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
            rogue.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            rogue.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS);
        }
        // race modifier
        firstDamage *= getRaceModRogueFirst();
        secondDamage *= getRaceModRogueSecond();
        // DOT effects
        if (rogue.getDamageOverTime().size() > 0) {
            rogue.resetDamageOverTime();
        }
        if (getApplyTerrainModifier()) {
            rogue.addDamageOverTime(Math.round(secondDamage),
                    Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            rogue.addDamageOverTime(Math.round(secondDamage), Constants.ROGUE_OVERTIME_ROUNDS);
        }
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
        // apply critical hit
        if (getRoundCounter() % Constants.ROGUE_CRITICAL_HIT_CHANCE == 0) {
            if (getApplyTerrainModifier()) {
                firstDamage *= Constants.ROGUE_CRITICAL_HIT_MULTIPLIER;
            } else {
                setRoundCounter();
            }
        }
        // terrain modifier
        if (getApplyTerrainModifier()) {
            firstDamage += firstDamage * getTerrainModifier();
            secondDamage += secondDamage * getTerrainModifier();
            wizard.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            wizard.setIncapacitated(Constants.ROGUE_OVERTIME_ROUNDS);
        }
        // race modifier
        firstDamage *= getRaceModWizardFirst();
        secondDamage *= getRaceModWizardSecond();
        // DOT efects
        if (wizard.getDamageOverTime().size() > 0) {
            wizard.resetDamageOverTime();
        }
        if (getApplyTerrainModifier()) {
            wizard.addDamageOverTime(Math.round(secondDamage),
                    Constants.ROGUE_OVERTIME_ROUNDS_WOODS);
        } else {
            wizard.addDamageOverTime(Math.round(secondDamage), Constants.ROGUE_OVERTIME_ROUNDS);
        }
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
