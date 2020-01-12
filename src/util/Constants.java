package util;

public final class Constants {
    private Constants() { }
    public static final int CHAMPION_TYPE = 0;
    public static final int CHAMPION_POS_X = 1;
    public static final int CHAMPION_POS_Y = 2;

    public static final float MODIFIER_0 = 1f;
    public static final float MODIFIER_5_POS = 1.05f;
    public static final float MODIFIER_10_POS = 1.1f;
    public static final float MODIFIER_15_POS = 1.15f;
    public static final float MODIFIER_20_POS = 1.2f;
    public static final float MODIFIER_25_POS = 1.25f;
    public static final float MODIFIER_30_POS = 1.3f;
    public static final float MODIFIER_40_POS = 1.4f;

    public static final float MODIFIER_10_NEG = 0.9f;
    public static final float MODIFIER_20_NEG = 0.8f;

    public static final int XP_INDICATOR = 200;
    public static final int XP_MULTIPLIER = 40;
    public static final int LEVEL_UP_XP = 250;
    public static final int LEVEL_UP_XP_GROWTH = 50;
    public static final int NAME_INDEX = 9;

    public static final int KNIGHT_HP = 900;
    public static final int KNIGHT_HP_GROWTH = 80;
    public static final float KNIGHT_TERRAIN_MODIFIER = 0.15f;
    public static final char KNIGHT_PREFERRED_TERRAIN = 'L';
    public static final float KNIGHT_ABILITY_1_BASE = 200f;
    public static final float KNIGHT_ABILITY_1_GROWTH = 30f;
    public static final float KNIGHT_ABILITY_2_BASE = 100f;
    public static final float KNIGHT_ABILITY_2_GROWTH = 40f;
    public static final float KNIGHT_HP_PERCENT_INITIAL = 0.2f;
    public static final float KNIGHT_HP_PERCENT_GROWTH = 0.01f;
    public static final float KNIGHT_HP_PERCENT_CAP = 0.4f;
    public static final int KNIGHT_INCAPACITATION_ROUNDS = 1;

    public static final int PYROMANCER_HP = 500;
    public static final int PYROMANCER_HP_GROWTH = 50;
    public static final float PYRO_TERRAIN_MODIFIER = 0.25f;
    public static final char PYRO_PREFERRED_TERRAIN = 'V';
    public static final float PYRO_ABILITY_1_BASE = 350f;
    public static final float PYRO_ABILITY_1_GROWTH = 50f;
    public static final float PYRO_ABILITY_2_BASE = 150f;
    public static final float PYRO_ABILITY_2_GROWTH = 20f;
    public static final float PYRO_OVERTIME_BASE = 50f;
    public static final float PYRO_OVERTIME_GROWTH = 30f;
    public static final int PYRO_OVERTIME_ROUNDS = 2;

    public static final int ROGUE_HP = 600;
    public static final int ROGUE_HP_GROWTH = 40;
    public static final float ROGUE_TERRAIN_MODIFIER = 0.15f;
    public static final char ROGUE_PREFERRED_TERRAIN = 'W';
    public static final float ROGUE_ABILITY_1_BASE = 200f;
    public static final float ROGUE_ABILITY_1_GROWTH = 20f;
    public static final float ROGUE_ABILITY_2_BASE = 40f;
    public static final float ROGUE_ABILITY_2_GROWTH = 10f;
    public static final int ROGUE_OVERTIME_ROUNDS = 3;
    public static final int ROGUE_OVERTIME_ROUNDS_WOODS = 6;
    public static final float ROGUE_CRITICAL_HIT_MULTIPLIER = 1.5f;
    public static final int ROGUE_CRITICAL_HIT_CHANCE = 3;

    public static final int WIZARD_HP = 400;
    public static final int WIZARD_HP_GROWTH = 30;
    public static final float WIZARD_TERRAIN_MODIFIER = 0.1f;
    public static final char WIZARD_PREFERRED_TERRAIN = 'D';
    public static final float WIZARD_ABILITY_1_BASE = 0.2f;
    public static final float WIZARD_ABILITY_1_GROWTH = 0.05f;
    public static final float WIZARD_ABILITY_1_PERCENT = 0.3f;
    public static final float WIZARD_ABILITY_2_BASE = 0.35f;
    public static final float WIZARD_ABILITY_2_GROWTH = 0.02f;
    public static final float WIZARD_ABILITY_2_CAP = 0.7f;

    public static final float DAMAGE_MOD_5 = 0.05f;
    public static final float DAMAGE_MOD_10 = 0.1f;
    public static final float DAMAGE_MOD_15 = 0.15f;
    public static final float DAMAGE_MOD_20 = 0.2f;
    public static final float DAMAGE_MOD_25 = 0.25f;
    public static final float DAMAGE_MOD_30 = 0.30f;
    public static final float DAMAGE_MOD_40 = 0.4f;
    public static final float DAMAGE_MOD_50 = 0.5f;
    public static final float DAMAGE_MOD_60 = 0.6f;
    public static final float DAMAGE_MOD_70 = 0.7f;

    public static final int HP_MOD_10 = 10;
    public static final int HP_MOD_15 = 15;
    public static final int HP_MOD_20 = 20;
    public static final int HP_MOD_25 = 25;
    public static final int HP_MOD_30 = 30;
    public static final int HP_MOD_35 = 35;
    public static final int HP_MOD_40 = 40;
    public static final int HP_MOD_50 = 50;
    public static final int HP_MOD_60 = 60;
    public static final int HP_MOD_80 = 80;
    public static final int HP_MOD_90 = 90;
    public static final int HP_MOD_100 = 100;
    public static final int HP_MOD_120 = 120;
    public static final int HP_MOD_150 = 150;
    public static final int HP_MOD_180 = 180;
    public static final int HP_MOD_200 = 200;

    public static final int XP_40 = 40;
    public static final int XP_45 = 45;
    public static final int XP_50 = 50;
    public static final int XP_60 = 60;
    public static final int KNIGHT_STRATEGY_HP_LOSS = 5;
    public static final int PYROMANCER_STRATEGY_HP_LOSS = 4;
    public static final int ROGUE_STRATEGY_HP_LOSS = 7;
    public static final int WIZARD_STRATEGY_HP_LOSS = 10;
    public static final int KNIGHT_DEFENSIVE = 4;
    public static final int PYROMANCER_DEFENSIVE = 3;
    public static final int ROGUE_DEFENSIVE = 2;
    public static final int WIZARD_DEFENSIVE = 5;
    public static final int KNIGHT_HP_LOW = 3;
    public static final int KNIGHT_HP_HIGH = 2;
    public static final int PYROMANCER_HP_LOW = 4;
    public static final int PYROMANCER_HP_HIGH = 3;
    public static final int ROGUE_HP_LOW = 7;
    public static final int ROGUE_HP_HIGH = 5;
    public static final int WIZARD_HP_LOW = 4;
    public static final int WIZARD_HP_HIGH = 2;
    public static final float FLOAT_PRECISION = 0.00001f;
}
