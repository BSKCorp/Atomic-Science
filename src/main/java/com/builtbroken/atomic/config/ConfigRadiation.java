package com.builtbroken.atomic.config;

/**
 * Main config for the mod
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/18/2018.
 */
public class ConfigRadiation
{
    //-------------------------------------------------------------------------------
    //--------- Data for generating config values -----------------------------------
    //-------------------------------------------------------------------------------
    //Value used to convert Mev to 1 RAD (should be equal to Mev / 624151 * 100)
    //1 erg = 624151 Mev
    //1 rad = 100 erg
    public static final double MeV_per_RAD = 6.24E7;

    //Mega eV per gram of material
    public static float MEV_GRAM_U238 = 4.267f; //https://en.wikipedia.org/wiki/Uranium-238
    public static float MEV_GRAM_U235 = 4.679f; //https://en.wikipedia.org/wiki/Uranium-235

    //mass in grams of sample items % of material
    public static float MASS_U238_SAMPLE = 100;
    public static float MASS_U235_SAMPLE = 100;

    //Activity (number of decays per tick)
    public static float ACTIVITY_U238 = 100; //TODO get actual numbers, then scale
    public static float ACTIVITY_U235 = 100; //TODO get actual numbers, then scale
    //-------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------
    //Start of configs
    //-------------------------------------------------------------------------------

    /** Amount of rads required to kill the player */
    public static float RADIATION_DEATH_POINT = 1000;

    //Scale value to convert RADs to REMs
    //RBE -> relative biological effectiveness (how each type relates to xray & gamma)
    //https://community.dur.ac.uk/ian.terry/teaching/nplab/dose_test.htm
    public static float RBE_XRAY_RADIATION = 1; //will go through entity
    public static float RBE_GAMMA_RADIATION = 1; //will go through entity
    public static float RBE_NEURTONS_FAST = 10; //will go through entity
    public static float RBE_NEURTONS_SLOW = 5; //will go through entity
    public static float RBE_ALPHA_RADIATION = 20; //stopped by anything
    public static float RBE_BETA_RADIATION = 10; //stopped by entity

    //Radiation per hour (mass * energy * decay_rate / MeV to rad
    public static float RAD_U235 = (float) (MASS_U235_SAMPLE * MEV_GRAM_U235 * ACTIVITY_U235 / MeV_per_RAD); //alpha radiation TODO CONFIG
    public static float RAD_U238 = (float) (MASS_U238_SAMPLE * MEV_GRAM_U238 * ACTIVITY_U238 / MeV_per_RAD); //alpha radiation TODO CONFIG
}
