package champion;

import angel.Angel;
import strategy.FirstStrategyWizard;
import strategy.SecondStrategyWizard;
import strategy.StrategyWizard;
import util.Constants;

public class Wizard extends Champion {

    Wizard(final int newPosX, final int newPosY) {
        setPosX(newPosX);
        setPosY(newPosY);
        setPreferredTerrain(Constants.WIZARD_PREFERRED_TERRAIN);
        setTerrainModifier(Constants.WIZARD_TERRAIN_MODIFIER);
        setHP(Constants.WIZARD_HP);
        setHPStart(Constants.WIZARD_HP);
        setHPGrowth(Constants.WIZARD_HP_GROWTH);
        setXP();
        setLevel();
        setIncapacitated(0);
        setFoughtThisRound(false);
        setFirstAbilityBase(Constants.WIZARD_ABILITY_1_BASE);
        setFirstAbilityGrowth(Constants.WIZARD_ABILITY_1_GROWTH);
        setSecondAbilityBase(Constants.WIZARD_ABILITY_2_BASE);
        setSecondAbilityGrowth(Constants.WIZARD_ABILITY_2_GROWTH);

        setRaceModKnightFirst(Constants.MODIFIER_20_POS);
        setRaceModKnightSecond(Constants.MODIFIER_40_POS);

        setRaceModPyromancerFirst(Constants.MODIFIER_10_NEG);
        setRaceModPyromancerSecond(Constants.MODIFIER_30_POS);

        setRaceModRogueFirst(Constants.MODIFIER_20_NEG);
        setRaceModRogueSecond(Constants.MODIFIER_20_POS);

        setRaceModWizardFirst(Constants.MODIFIER_5_POS);
    }

    /**
     *  Method is used to change the race modifiers.
     * @param newRaceMod race modifier to be added.
     */
    public void increaseRaceMod(final float newRaceMod) {
        setRaceModWizardFirst(getRaceModWizardFirst() + newRaceMod);
        setRaceModRogueFirst(getRaceModRogueFirst() + newRaceMod);
        setRaceModRogueSecond(getRaceModRogueSecond() + newRaceMod);
        setRaceModPyromancerFirst(getRaceModPyromancerFirst() + newRaceMod);
        setRaceModPyromancerSecond(getRaceModPyromancerSecond() + newRaceMod);
        setRaceModKnightFirst(getRaceModKnightFirst() + newRaceMod);
        setRaceModKnightSecond(getRaceModKnightSecond() + newRaceMod);
    }

    /**
     *  Method is used to change the race modifiers.
     * @param newRaceMod race modifier to be subtracted
     */
    public void reduceRaceMod(final float newRaceMod) {
        setRaceModWizardFirst(getRaceModWizardFirst() - newRaceMod);
        setRaceModRogueFirst(getRaceModRogueFirst() - newRaceMod);
        setRaceModRogueSecond(getRaceModRogueSecond() - newRaceMod);
        setRaceModPyromancerFirst(getRaceModPyromancerFirst() - newRaceMod);
        setRaceModPyromancerSecond(getRaceModPyromancerSecond() - newRaceMod);
        setRaceModKnightFirst(getRaceModKnightFirst() - newRaceMod);
        setRaceModKnightSecond(getRaceModKnightSecond() - newRaceMod);
    }

    /**
     *  Method used to apply the right strategy.
     */
    @Override
    public void applyStrategy() {
        StrategyWizard strategy;

        int hpLow = calculateTheoreticalHP() / Constants.WIZARD_HP_LOW;
        int hpHigh = calculateTheoreticalHP() / Constants.WIZARD_HP_HIGH;
        if (hpLow < getHP() && getHP() < hpHigh) {
            strategy = new FirstStrategyWizard();
            strategy.doStrategy(this);
        } else if (getHP() < hpLow) {
            strategy = new SecondStrategyWizard();
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
        // base damage percentages
        float percentageFirst = firstAbility();
        float percentageSecond = secondAbility();

        // terrain modifier
        if (getApplyTerrainModifier()) {
            percentageFirst += percentageFirst * getTerrainModifier();
            percentageSecond += percentageSecond * getTerrainModifier();
        }
        if (percentageSecond > Constants.WIZARD_ABILITY_2_CAP) {
            percentageSecond = Constants.WIZARD_ABILITY_2_CAP;
        }

        // race modifier
        percentageFirst *= getRaceModKnightFirst();
        percentageSecond *= getRaceModKnightSecond();

        // damage to apply from first ability
        float firstDamage = percentageFirst * Math.min(Constants.WIZARD_ABILITY_1_PERCENT
                * knight.calculateTheoreticalHP(), knight.getHP());

        // calculate taken damage
        float dmgTakenFirst = knight.firstAbility();
        float dmgTakenSecond = knight.secondAbility();
        if (knight.getApplyTerrainModifier()) {
            dmgTakenFirst += dmgTakenFirst * knight.getTerrainModifier();
            dmgTakenSecond += dmgTakenSecond * knight.getTerrainModifier();
        }
        int totalDamageTaken = Math.round(dmgTakenFirst) + Math.round(dmgTakenSecond);

        float damageReflected = percentageSecond * totalDamageTaken;
        int totalDamageToGive = Math.round(firstDamage) + Math.round(damageReflected);
        // apply damage to enemy
        knight.reduceHP(totalDamageToGive);
    }

    /**
     *  Method is used to calculate the damage against a pyromancer.
     * @param pyromancer opponent champion.
     */
    @Override
    public void attack(final Pyromancer pyromancer) {
        // base damages
        float percentageFirst = firstAbility();
        float percentageSecond = secondAbility();

        // terrain modifier
        if (getApplyTerrainModifier()) {
            percentageFirst += percentageFirst * getTerrainModifier();
            percentageSecond += percentageSecond * getTerrainModifier();
        }

        // race modifier
        percentageFirst *= getRaceModPyromancerFirst();
        percentageSecond *= getRaceModPyromancerSecond();

        // damage to apply from first ability
        float firstDamage = percentageFirst * Math.min(Constants.WIZARD_ABILITY_1_PERCENT
                * pyromancer.calculateTheoreticalHP(), pyromancer.getHP());

        if (percentageSecond > Constants.WIZARD_ABILITY_2_CAP) {
            percentageSecond = Constants.WIZARD_ABILITY_2_CAP;
        }

        // calculate taken damage
        float dmgTakenFirst = pyromancer.firstAbility();
        float dmgTakenSecond = pyromancer.secondAbility();
        if (pyromancer.getApplyTerrainModifier()) {
            dmgTakenFirst += dmgTakenFirst * pyromancer.getTerrainModifier();
            dmgTakenSecond += dmgTakenSecond * pyromancer.getTerrainModifier();
        }
        int totalDamageTaken = Math.round(dmgTakenFirst) + Math.round(dmgTakenSecond);
        float reflectedDamage = percentageSecond * totalDamageTaken;
        // apply damage to enemy
        int totalDamageToGive = Math.round(firstDamage) + Math.round(reflectedDamage);
        pyromancer.reduceHP(totalDamageToGive);
    }

    /**
     *  Method is used to calculate the damage against a rogue.
     * @param rogue opponent champion.
     */
    @Override
    public void attack(final Rogue rogue) {
        // base damages
        float percentageFirst = firstAbility();
        float percentageSecond = secondAbility();

        // terrain modifier
        if (getApplyTerrainModifier()) {
            percentageFirst += percentageFirst * getTerrainModifier();
            percentageSecond += percentageSecond * getTerrainModifier();
        }

        // race modifier
        percentageFirst *= getRaceModRogueFirst();
        percentageSecond *= getRaceModRogueSecond();

        // damage to apply from first ability
        float firstDamage = percentageFirst * Math.min(Constants.WIZARD_ABILITY_1_PERCENT
                * rogue.calculateTheoreticalHP(), rogue.getHP());

        if (percentageSecond > Constants.WIZARD_ABILITY_2_CAP) {
            percentageSecond = Constants.WIZARD_ABILITY_2_CAP;
        }

        // calculate taken damage
        float dmgTakenFirst = rogue.firstAbility();
        float dmgTakenSecond = rogue.secondAbility();
        // calculate stab with or without critical hit
        int stabCount;
        if (rogue.getFoughtThisRound()) {
            stabCount = rogue.getStabCount() - 1;
        } else {
            stabCount = rogue.getStabCount();
        }
        if (stabCount % Constants.ROGUE_CRITICAL_HIT_CHANCE == 0) {
            if (rogue.getApplyTerrainModifier()) {
                dmgTakenFirst *= Constants.ROGUE_CRITICAL_HIT_MULTIPLIER;
            } else {
                rogue.setStabCount();
            }
        }
        if (rogue.getApplyTerrainModifier()) {
            dmgTakenFirst += dmgTakenFirst * rogue.getTerrainModifier();
            dmgTakenSecond += dmgTakenSecond * rogue.getTerrainModifier();
        }
        int totalDamageTaken = Math.round(dmgTakenFirst) + Math.round(dmgTakenSecond);
        float reflectedDamage = percentageSecond * totalDamageTaken;
        // apply damage to enemy
        int totalDamageToGive = Math.round(firstDamage) + Math.round(reflectedDamage);
        rogue.reduceHP(totalDamageToGive);
    }

    /**
     *  Method is used to calculate the damage against a wizard.
     * @param wizard opponent champion.
     */
    @Override
    public void attack(final Wizard wizard) {
        // base damage
        float percentageFirst = firstAbility();

        // terrain modifier
        if (getApplyTerrainModifier()) {
            percentageFirst += percentageFirst * getTerrainModifier();
        }

        // race modifier
        percentageFirst *= (getRaceModWizardFirst() - Constants.FLOAT_PRECISION);

        int damageToGive = Math.round(percentageFirst * Math.min(Constants.WIZARD_ABILITY_1_PERCENT
                * wizard.calculateTheoreticalHP(), wizard.getHP()));
        // apply damage to enemy
        wizard.reduceHP(damageToGive);
    }
    /**
     *  Method used to apply the effect of the angel located on the tile.
     * @param angel angel that appeared on the same tile as the champion
     */
    @Override
    public void effectAppliedBy(final Angel angel) {
        angel.applyEffect(this);
    }
}
