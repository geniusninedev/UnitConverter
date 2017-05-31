package com.nineinfosys.unitconverter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.ListView;


import com.amulyakhare.textdrawable.TextDrawable;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.AngleActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.AreaActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.DataStorageActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.EnergyActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.ForceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.FuelActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.LengthActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.PowerActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.PressureActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.SpeedActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.TempertureActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.TimeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.VolumeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.VolumeDryActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.WeightActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ChargeConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ConductanceConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ConductivityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.CurrentConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ElectricFieldStrengthActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ElectricPotentialActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ElectricResistanceConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ElectricResistivityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.InductanceConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.LinearChargeDensityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.LinearCurrentDensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.SurfaceChargeDensityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.VolumeChargeDensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.AccelerationActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.AccelerationAngularActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.DensityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.MomentOfInertiaActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.MomentofForceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.SpecificVolumeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.TorqueActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.VelocityAngularActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.ConcentrationMolarActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.ConcentrationSolutionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.FlowActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.FlowMassActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.FlowMolarActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.PermeabillityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.SurfaceTensionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.ViscosityDynamicActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Fluids.ViscosityKinematicActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.FuelEfficiencyMassActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.FuelEfficiencyVolumeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.HeatDensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.HeatFluxDensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.HeatTransferCoefficientActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.SpecificHeatCapacityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.TemperatureIntervalActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.ThermalConductivityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.ThermalExpansionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.HeatConverter.ThermalResistanceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Light.DigitalImageResolutionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Light.FrequencyActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Light.IlluminationActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Light.LuminanceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Light.LuminousIntensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Magnetism.MagneticFieldStrengthActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Magnetism.MagneticFluxActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Magnetism.MagneticFluxDensityActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Magnetism.MagnetomotiveForceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.CookingActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.DataTransferConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.HardnessActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.ImageActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.MetricWeightConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.MetrologyUnitConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.PrefixActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.SoundActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.TypographyConversionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.WorkConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Radiology.RadiationAbsorbedDoseActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Radiology.RadiationActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Radiology.RadiationConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Radiology.RadiationExposureActivity;
import com.nineinfosys.unitconverter.Engines.Fluids.MassFluxDensity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements TextWatcher {


    // List view
    private ListView lv;

    private String selectedItem;
    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Search Unit");


        // Listview Data
        String listitem[] = {
                "Meter -m", "Kilometer -km", "Decimeter -dm",
                "Centimeter -cm", "Millimeter -mm", "Micrometer -μm",
                "Nanometer -nm", "Mile -mi,mi(Int)", "Yard -yd",
                "Foot -ft", "Inch -in", "Light year -ly",
                "Exameter -Em", "Petameter -Pm", "Terameter -Tm",
                "Gigameter -Gm", "Megameter -Mm", "Hectometer -hm",
                "Dekameter -dam", "Micron -μ", "Picometer -pm",
                "Femtometer -fm", "Attometer -am", "Megaparsec -Mpc",
                "Kiloparsec -kpc", "Parsec -pc", "Astronomical unit -AU,UA",
                "League -lea", "Nautical league (UK) -n.lea(UK)", "Nautical league (int.) -n.lea",
                "League (statute) -lea(US)", "Nautical mile (UK) -n.mi", "Nautical mile (international) -n.mi",
                "Mile (statute) -mi,mi(US)", "Mile (US survey) -mi,mi(US)", "Mile (Roman)-mile",
                "Kiloyard -kyd", "Furlong -fur", "Furlong (US survey) -fur",
                "Chain -ch", "Chain (US survey) -ch", "Rope -rope",
                "Rod -rd", "Rod (US survey) -rd", "Perch -perch",
                "Pole -pole", "Fathom -fath", "Fathom (US survey) -fath",
                "Ell -ell", "Foot (US survey) -ft", "Link -li",
                "Link (US survey) -li", "Cubit (UK) -cubit", "Hand -hand",
                "Span (cloth) -span", "Finger (cloth) -finger", "Nail (cloth) -nail",
                "Inch (US survey) -in", "Barleycorn -barleycorn", "Mil -mil,thou",
                "Microinch -μ.in", "Angstrom -A", "A.u. of length -a.u.,b", "X-unit -X",
                "Fermi -F,f", "Arpent -Arpent", "Pica -pica", "Point -Point", "Twip  -twip",
                "Aln -aln", "Famn -famn", "Caliber -cl", "Centiinch -cin", "Ken -ken",
                "Russian archin -archin", "Roman actus -actus", "Vara de tarea -v.de.t",
                "Vara conuquera -vc", "Vara castellana -vcas", "Cubit (Greek) -cubit",
                "Long reed -lreed", "Reed -reed", "Long cubit -long cubit",
                "Handbreadth -hb", "Fingerbreadth -fb", "Planck length -Planck",
                "Electron radius (classical) -e-rad", "Bohr radius -b,a.u.:",
                "Earth's equatorial radius -Earth", "Earth's polar radius -Earth", "Earth's distance from sun -Earth",
                "Sun's radius -Sun",

                //weight
                "Kilogram -  kg", "Gram - g", "Milligram - mg",
                "Ton - t", "Pound - lbs", "Ounce - oz", "Carat - ct",
                "Ton short US - ton", "Ton long UK - ton", "Atomic mass unit - u",

                "Exagram -  Eg", "Petagram - Pg", "Teragram - Tg",
                "Gigagram -  Gg", "Megagram - Mg", "Hectogram - hg",
                "Dekagram -  dag", "Decigram - dg", "Centigram - cg",
                "Microgram - μg", "Nanogram  - ng", "Picogram -  pg",
                "Femtogram - fg", "Attogram - ag", "Dalton - dt",
                "Kilogram-energy square second/meter - kg F sq s m- 1", "Kilopound - kip", "Kip - kip ",
                "Slug - slug ", "Pound-energy square second/foot - lb F sq s ft-1 ", "Pound (troy or apothecary) - lb",
                "Poundal - pdl", "Ton (assay) (UK) - AT)", "Ton (assay) (US) - AT)", "Kiloton (metric) - kt",
                "Qunital (metric) -  cwt", "Hundredweight (US) - hwt ", "Hundredweight (UK) - hwt",
                "Quarter (US) - qr ", "Quarter (UK) - qr ", "Stone (US) - st", "Stone (UK) - st",
                "Sonne - t", "Pennyweight - pwt", "Scruple (apothecary)- s.ap", "Grain - gr",
                "Gamma - gamma", "Talent (Biblical Hebrew) - talent ", "Mina (Biblical Hebrew) - mina",
                "Shekal (Biblical Hebrew) - shekal", "Bekan (Biblical Hebrew) - bekan", "Gereh (Biblical Hebrew) - gereh",
                "Talent (Biblical Greek) - talent", "Mina (Biblical Greek) - mina ", "Tetradrachma (Biblical Greek) - tetd",
                "Didrachma (Biblical Greek) - didrachma", "Drachma (Biblical Greek) - drachma ", "Denarius (Biblical Roman) - denarius",
                "Assarion (Biblical Roman) - assarion", "Quadrans (Biblical Roman) -  quadranns","Lepton (Biblical Roman) - lepton",
                "Planck mass - Planck mass", "Electron mass (rest) -  e-","Muon mass - M",
                "Proton mass - p", "Neutron mass - n ", "Deuteron mass - D",
                "Earth's mass - Earth", "Sun mass - Sun",

                //volume
                "Cubic meter - m^3", "Cubic kilometer  - km^3", "Cubic centimeter  - cm^3",
                "Cubic millimeter - mm^3", "Liter - L", "Milliliter  - mL",
                "Gallons(US) - gallon", "Quart(US) - qt", "Pint(US)  - pt", "Cup(US)  - cup",
                "Tablespoon - tblsp", "Teaspoon - tsp", "Cubic mile - mi^3", "Cubic yard - yd^3",
                "Cubic foot - ft^3", "Cubic inch - in^3", "Cubic decimeter - dm^3", "Exaliter - EL",
                "Petaliter - PL", "Teraliter - TL", "Gigaliter - GL", "Megaliter - ML",
                "Kiloliter - kL", "Hectoliter - hL", "Dekaliter - daL", "Deciliter - dL",
                "Centiliter - cL", "Microliter - µL", "Nanoliter - nL", "Picoliter - pL",
                "Femtoliter - fL", "Attoliter - aL", "Cc - cc", "Drop - drop", "Barrel(oil) - bbl",
                "Barrel(US) - bbl", "Barrel(UK) - bbl", "Gallon - gallon", "Quart(UK) - qt",
                "Pint(UK) - pt", "Cup(Metric) - cup", "Cup(UK) - cup", "Fluid ounce(US) - fl oz",
                "Fluid ounce(UK) - fl oz", "Tablespoon(Metric) - tblsp", "Tablespoon(UK) - tblsp",
                "Dessertspoon(US) - dsp", "Dessertspoon(UK) - dsp", "Teaspoon(Metric) - tsp",
                "Teaspoon(UK) - tsp", "Gill(US)  - gi", "Gill(UK)  - gi", "Minim(US)  - min",
                "Minim(UK)  - min", "Ton register - ton reg", "Ccf  - ccf",
                "Hundred-cubic foot - 100 ft^3", "Acre-foot - ac*ft", "Acre-foot(US)  - ac*ft", "Acre-inch - ac*in",
                "Dekastere  - daSt", "Stere  - st", "Decistere  - dSt", "Cord  - cd",
                "Tun  - tun", "Hogshead  - hogshead", "Board foot  - bft", "Dram  - dr", "Cor(Biblical) - cor", "Homer(Biblical) - homer",
                "Bath(Biblical) - bath", "Hin(Biblical) - hin", "Cab(Biblical) - cab", "Log(Biblical) - log", "Taza(Spanish) - taza", "Earth's volume - earth",

                //temperture
                "Celsius - °C", "Fahrenheit - °F",
                "Kelvin - °K", "Rankine - °R",
                "Newton - °N", "Reaumur - °Ré",
                "Romer - °Rø", "Delisle - °D",

                //area
                "Square Meter -  m²", "Square Kilometer - km²", "Square Centimeter - cm²",
                "Square Millimeter -  mm²", "Hectares - ha", "Acre - ac", "Square Mile -  mi²",
                "Square Yard - yd²", "Square Foot - ft²", "Square Inch - in²",
                "Square Micrometer -  μm²", "Square Hectometer - hm²", "Square Dekameter - dam²",
                "Square Decimeter -  dm²", "Nanometer - nm²", "Are - a", "Barn -  b",
                "Square Mile (US survey)", "Square Foot (US survey)", "Circular Inch ",

                "Township", "Section", "Acre(US survey) - ac", "Rood", "Square Chain - ch²",
                "Square rod", "Square rod (US survey)", "Square Perch ", "Square Pole ",
                "Square Mil - mil² ", "Cirular Mil", "Homestead", "Sabin", "Arpent", "Cuerda",
                "Plaza", "Varas Castellanas Cuad", "Varas Conuqueras Cuad", "Electron Cross Section ",

                //pressure
                "Pascal - Pa",
                "Kilopascal - kPa",
                "Bar - b",
                "Psi - psi",
                "Ksi - ksi",
                "Atmosphere - atm",
                "Exapascal - EPa",
                "Petapascal - PPa",
                "Terapascal - TPa",
                "Gigapascal - GPa",
                "Megapascal - MPa",
                "Hectopascal - hPa",
                "Deckapascal - daPa",
                "Decipascal - dPa",
                "Centipascal - cPa",
                "Millipascal - mPa",
                "Micropascal - μPa",
                "Nanopascal - nPa",
                "Picopascal - pPa",
                "Femtopascal - fPa",
                "Attopascal - aPa",
                "Newton/square meter - N/m²",
                "Newton/square centimeter - N/cm²",
                "Newton/square millimeter - N/mm²",
                "Kilonewton/square meter - kN/m²",
                "Millibar - mbar",
                "Microbar - μbar",
                "Dyne/square centimeter - dyn/cm²",
                "Kilogram-energy/square meter - kgf/m²",
                "Kilogram-energy/square cm - kgf/cm²",
                "Kilogram-energy/square mm - kgf/mm²",
                "Gram-energy/square cm - gf/cm²",
                "Ton-energy(short)/sq. foot - tonf/ft²",
                "Ton-energy(short)/sq. inch - tonf/in²",
                "Ton-energy(long)/sq. foot - tonf/ft²",
                "Ton-energy(long)/sq. inch - tonf/in²",
                "Kip-energy/square inch - kipf/in²",
                "Pound-energy/square foot - lbf/ft²",
                "Pound-energy/square inch - lbf/in²",
                "Poundal/square foot - pdl/ft²",
                "Torr - torr",
                "Centimeter mercury(0°C) - cmHg",
                "Millimeter mercury(0°C) - mmHg",
                "Inch mercury(32°F) - inHg",
                "Centimeter water(4°C) - cmAq",
                "Millimeter water(4°C) - mmAq",
                "Inch water(4°C) - inAq",
                "Foot water(4°C) - ftAq",
                "Inch water(60°C) - inAq",
                "Foot water(60°C) - ftAq",
                "Atmosphere technical - at",

                //energy
                "Joule - J",
                "Kilo joule - kJ",
                "Kilo-watt hour - kW*h",
                "Watt-hour - W*h",
                "Calorie (nutritional) - cal(nutritional)",
                "Horsepower (metric) hour - hp*h",
                "Btu(IT) - btu(IT),Btu",
                "Btu(th) - btu(th)",
                "Giga joule - GJ",
                "Mega joule - MJ",
                "Milli joule - mJ",
                "Micro joule - μj",
                "Nano joule - nJ",
                "Atto joule - aJ",
                "Mega electron-volt - MeV",
                "Kilo electron-volt - KeV",
                "Electron-volt - eV",
                "Erg - erg",
                "Giga watt-hour - GW*h",
                "Mega watt-hour - MW*h",
                "Kilo watt-second - kW*s",
                "Watt-second - W*s",
                "Newton meter - N*m",
                "Horse power hour - hp*h",
                "Kilo calorie(IT) - kcal(IT)",
                "Kilo calorie(th) - kcal(th)",
                "Calorie(IT) - cal(IT),cal",
                "Calorie(th) - cal(th)",
                "Mega Btu (IT) - MBtu(IT)",
                "Ton-hour (refrigeration) - ton*h",
                "Fuel oil equivalent @kiloliter - kl",
                "Fuel oil equivalent @barrel (US)  - bbl",
                "Giga ton - Gton",
                "Mega ton - Mton",
                "Kilo ton - kton",
                "Ton (explosives) - ton",
                "Dyne centimeter - dyn*cm",
                "Gram-energy meter - gf*m",
                "Gram-energy centimeter - gf*cm",
                "Kilogram-energy centimeter - kgf*cm",
                "Kilogram-energy meter - kgf*m",
                "Kilo pond meter - kp*m",
                "Pound-energy foot - lbf*ft",
                "Pound-energy inch - lbf*in",
                "Ounce-energy inch - ozf*in",
                "Foot-pound - ft*lbf",
                "Inch-pound - in*lbf",
                "Inch-ounce - in*ozf",
                "Poundal foot - pdl*ft",
                "Therm - therm",
                "Therm(EC) - therm",
                "Therm(US) - therm",
                "Hartree energy - He",
                "Rydberg constant - Rc",

                //power
                "Watt -W",
                "Exawatt -EW",
                "Petawatt -PW",
                "Terawatt -TW",
                "Gigawatt -GW",
                "Megawatt -MW",
                "Kilowatt -kW",
                "Hectowatt -hW",
                "Dekawatt -daW",
                "Deciwatt -dW",
                "Centiwatt -cW",
                "Milliwatt -mW",
                "Microwatt -μW",
                "Nanowatt -nW",
                "Picowatt -pW",
                "Femtowatt -fW",
                "Attowatt -aW",
                "Horsepower -hp,hp(UK)",
                "Horsepower (550 ft*lbf/s) -hp,hp(UK)",
                "Horsepower (metric) -hp(metric)",
                "Horsepower (boiler) -hp(boiler)",
                "Horsepower (electric) -hp(electric)",
                "Horsepower (water) -hp(water)",
                "Pferdestarke (ps) -ps",
                "Btu (IT)/hour -Btu/h",
                "Btu (IT)/minute -Btu/min",
                "Btu (IT)/second -Btu/s",
                "Btu (th)/hour -Btu(th)/h",
                "Btu (th)/minute -Btu(th)/min",
                "Btu (th)/second -Btu(th)/s",
                "MBtu (IT)/hour -MBtu/h",
                "MBH -MBH",
                "Ton (refrigeration) -ton",
                "Kilocalorie (IT)/hour -kcal/h",
                "Kilocalorie (IT)/minute -kcal/min",
                "Kilocalorie (IT)/second -kcal/s",
                "Kilocalorie (th)/hour -kcal(th)/h",
                "Kilocalorie (th)/minute -kcal(th)/min",
                "Kilocalorie (th)/second -kcal(th)/s",
                "Calorie (IT)/hour -cal/h",
                "Calorie (IT)/minute -cal/min",
                "Calorie (IT)/second -cal/s",
                "Calorie (th)/hour -cal(th)/h",
                "Calorie (th)/minute -cal(th)/min",
                "Calorie (th)/second -cal(th)/s",
                "Foot pound-force/hour -lbf*ft/h",
                "Foot pound-force/minute -lbf*ft/min",
                "Foot pound-force/second -lbf*ft/s",
                "Pound-foot/hour -lbf*ft/h",
                "Pound-foot/minute -lbf*ft/min",
                "Pound-foot/second -lbf*ft/s",
                "Erg/second -erg/s",
                "Kilovolt ampere -kV*A",
                "Volt ampere -V*A",
                "Newton meter/second -N*m/s",
                "Joule/second -J/s",
                "Exajoule/second -EJ/s",
                "Petajoule/second -PJ/s",
                "Terajoule/second -TJ/s",
                "Gigajoule/second -GJ/s",
                "Megajoule/second -MJ/s",
                "Kilojoule/second -kJ/s",
                "Hectojoule/second -hJ/s",
                "Dekajoule/second -daJ/s",
                "Decijoule/second -dJ/s",
                "Centijoule/second -CJ/s",
                "Millijoule/second -mJ/s",
                "Microjoule/second -μJ/s",
                "Nanojoule/second -nJ/s",
                "Picojoule/second -pJ/S",
                "Femtojoule/second -fJ/s",
                "Attojoule/second -aJ/s",
                "Joule/hour -J/h",
                "Joule/minute -J/min",
                "Kilojoule/hour -kJ/h",
                "Kilojoule/minute -kJ/min",

                //force
                "Newton - N",
                "Kilonewton - kN",
                "Gram-force - gf",
                "Kilogram-force - kgf",
                "Ton-force(metric) - tf",
                "Exanewton - EN",
                "Petanewton - PT",
                "Teranewton - TN",
                "Giganewton - GN",
                "Meganewton - MN",
                "Hectonewton - hN",
                "Dekanewton - daN",
                "Decinewton - dN",
                "Centinewton - cN",
                "Milinewton - mN",
                "Micronewton - μN",
                "Nanonewton - nN",
                "Piconewton - pN",
                "Femtonewton - fN",
                "Attonewton - aN",
                "Dyne - dyn",
                "Joule/meter - J/m",
                "Joule/centimeter - J/cm",
                "Ton-force(short) - tonf",
                "Ton-force(long) - tonf",
                "Kip-force - kipf",
                "Kilopound-force- kipf",
                "Pound-force - lbf",
                "Ounce-force - ozf",
                "Poundal - pdl(force)",
                "Pound foot/square second - lb*ft/sec²",
                "Pond - p",
                "Kilopond - kp",


                //time
                "Second - s", "Millisecond - ms", "Minute - min", "Hour - h",
                "Day - d", "Week - week", "Month - month", "Year - y", "Decade - decade",
                "Century - century", "Millenium - millenium", "Microsecond - μs",
                "Nanosecond - ns", "Picosecond - ps", "Femtosecond - fs", "Attosecond - as", "Shake - shake",
                "Month(Synodic) - month", "Year(Julian) - y", "Year(leap) - y", "Year(tropical) - y", "Year(sidereal) - y",
                "Day(sidereal) - d", "Hour(sidereal) - h", "Minute(sidereal) - min", "Second(sidereal) - s", "Fortnight - f", "Septennial - s",
                "Octennial - o", "Novennial - n", "Quindecennial - q", "Quinquennial - q", "Plank time - pt",

                //speed
                "Meter/second - m/s",
                "Kilometer/hour - km/h", "Mile/hour - mi/h", "Meter/hour - m/h",
                "Meter/minute - m/min", "Kilometer/minute - km/min", "Kilometer/second - km/s",
                "Centimeter/hour - cm/h", "Centimeter/minute - cm/min", "Centimeter/second - cm/s", "Millimeter/hour - mm/h",
                "Millimeter/minute - mm/min", "Millimeter/second - mm/s", "Foot/hour - ft/h", "Foot/minute - ft/min",
                "Foot/second - ft/s", "Yard/hour - yd/h", "Yard/minute - yd/min", "Yard/second - yd/s",
                "Mile/minute - mi/min", "Mile/second - mi/s", "Knot - knots", "Knot (UK) - knots(UK)",
                "Velocity of light in vacuum - c", "Cosmic velocity - first - hom", "Cosmic velocity - second - cosmic",
                "Cosmic velocity - third - cosmic", "Earth's velocity - earth", "Velocity of sound in pure water - sound", "Velocity of sound in sea water - sound",
                "Mach - mach", "Mach (SI standard) - mach",

                //angle
                "Degree - °", "Radian - rad", "Grad - ^g",
                "Minute - '", "Second -  ″ ", "Gon - gon", "Sign - sign",
                "Mil - mil", "Revolution - r", "Circle - ∅", "Turn - turn",
                "Quadrant - 90°", "Right angle - 90°", "Sextant - 60°",

                //fuel
                "Meter/liter - m/L", "Exameter/liter - Em/L", "Petameter/liter - Pm/L", "Terameter/liter - Tm/L",
                "Gigameter/liter - Gm/L", "Megameter/liter - Mm/L", "Kilometer/liter - km/L", "Hectometer/liter - hm/L", "Dekameter/liter - dam/L", "Centimeter/liter - cm/L",
                "Mile(US)/liter - mi/L", "Nautical mile/liter - n.mile/L", "Nautical mile/gallon(US)  - n.mile/gallon",
                "Kilometer/gallon - km/gallon", "Meter/gallon(US) - m/gallon", "Meter/gallon(UK) - m/gallon", "Mile/gallon(US) - mi/gallon", "Mile/gallon(UK) - mi/gallon",
                "Meter/cubic meter - m/m^3", "Meter/cubic centimeter - m/cm^3", "Meter/cubic yard - m/yd^3", "Meter/cubic foot - m/ft^3", "Meter/cubic inch - m/in^3", "Meter/quart(US) - m/q", "Meter/quart(UK) - m/q",
                "Meter/pint(US) - m/pt", "Meter/pint(UK) - m/pt", "Meter/cup(US) - m/cup", "Meter/cup(UK) - m/cup", "Meter/fluid ounce(US) - m/floz", "Meter/fluid ounce(UK) - m/floz",
                "Liter/meter - L/m", "Liter/100 km - L/100 km", "Gallon(US)/mile - gallon/mi", "Gallon(US)/100 mile - gallon/100 mi",
                "Gallon(UK)/mile - gallon/mi", "Gallon(UK)/100 mile - gallon/100 mi",

                //datastorage
                "Bit - b", "Nibble - n", "Byte - B", "Character - ch",
                "Word - w", "MAPM-word - w", "Quadruple-word - w", "Block - blk",
                "Kilobit - kb", "Kilobyte - kB","Kilobyte (10^3 bytes) - kB", "Megabit - Mb", "Megabyte - MB",
                "Megabyte (10^6 bytes) - MB", "Gigabit - Gb", "Gigabyte - GB", "Gigabyte (10^9 bytes) - GB",
                "Terabit - Tb", "Terabyte - TB", "Terabyte (10^12 bytes) - TB", "Petabit - Pb", "Petabyte - PB",
                "Petabyte (10^15 bytes) - PB", "Exabit - Eb", "Exabyte - EB", "Exabyte (10^18 bytes) - EB", "Floppy disk (3.5″, DD) - floppy", "Floppy disk (3.5″, HD) - floppy",
                "Floppy disk (3.5″, ED) - floppy", "Floppy disk (5.25″, DD) - floppy", "Floppy disk (5.25″, HD) - floppy", "Zip 100 - Zip",
                "Zip 250 - Zip", "Jaz 1GB - Jaz", "Jaz 2GB - Jaz", "CD (74 minute) - CD",
                "CD (80 minute) - CD", "DVD (1 layer, 1 side) - DVD", "DVD (2 layer, 1 side) - DVD",
                "DVD (1 layer, 2 side) - DVD", "DVD (2 layer, 2 side) - DVD",

                //volumedry
                "Liter(volume) - L",
                "Barrel dry(US) - bbl dry",
                "Pint dry(US) - pt dry",
                "Quart dry(US) - qt dry",
                "Peck dry(US) - pk",
                "Peck dry(UK) - pk",
                "Bushel(US) - bu",
                "Bushel(UK) - bu",
                "Cor(Biblical volume) - cor",
                "Homer(Biblical volume) - homer",
                "Ephah(Biblical) - ephah",
                "Seah(Biblical volume) - seah",
                "Omer(Biblical volume) - omer",
                "Cab(Biblical volume) - cab",
                "Log(Biblical volume) - log",

                //engineering accleration
                "Meter/square second -m/s^2",
                "Decimeter/square second -deci/s^2",
                "Kilometer/square second -km/s^2",
                "Hectometer/square second -hec/s^2",
                "Dekameter/square second -deka/s^2",
                "Centimeter/square second -cm/s^2",
                "Millimeter/square second -mm/s^2",
                "Micrometer/square second -μm/s^2",
                "Nanometer/square second -nano/s^2",
                "Picometer/square second -pico/s^2",
                "Femtometer/square second -fem/s^2",
                "Attometer/square second -A/s^2",
                "Gal -Gal",
                "Galileo -Gal",
                "Mile/square second -mi/s^2",
                "Yard/square second -yd/s^2",
                "Foot/square second -ft/s^2",
                "Inch/square second -in/s^2",
                "Acceleration of gravity -g",

                //velocity
                "Radian/second -rad/s",
                "Radian/day -rad/d",
                "Radian/hour -rad/h",
                "Radian/minute -rad/min",
                "Degree/day -°/d",
                "Degree/hour -°/h",
                "Degree/minute -°/min",
                "Degree/second -°/s",
                "Revolution/day -r/d",
                "Revolution/hour -r/h",
                "Revolution/minute -r/min",
                "Revolution/second -r/s",

                //accelerationangular
                "Radian/square second -rad/s^2",
                "Radian/square minute -rad/min^2",
                "Revolution/square second -r/s^2",
                "Revolution/minute/second -r/min/s",
                "Revolution/square minute -r/min^2",

                //density
                "Kilogram/cubic meter -kg/m^3",
                "Gram/cubic centimeter -g/cm^3,g/cc",
                "Kilogram/cubic centimeter -kg/cm^3",
                "Gram/cubic meter -g/m^3",
                "Gram/cubic millimeter -g/mm^3",
                "Milligram/cubic meter -mg/m^3",
                "Milligram/cubic centimeter -mg/cm^3",
                "Milligram/cubic millimeter -mg/mm^3",
                "Exagram/liter -Eg/L",
                "Petagram/liter -Pg/L",
                "Teragram/liter -Tg/L",
                "Gigagram/liter -Gg/L",
                "Megagram/liter -Mg/L",
                "Kilogram/liter -kg/L",
                "Hectogram/liter -hg/L",
                "Dekagram/liter -dag/L",
                "Gram/liter -g/L",
                "Decigram/liter -dg/L",
                "Centigram/liter -cg/L",
                "Milligram/liter -mg/L",
                "Microgram/liter -μg/L",
                "Nanogram/liter -ng/L",
                "Picogram/liter -pg/L",
                "Femtogram/liter -fg/L",
                "Attogram/liter -ag/L",
                "Pound/cubic inch -lb/in^3",
                "Pound/cubic foot -lb/ft^3",
                "Pound/cubic yard -lb/yd^3",
                "Pound/gallon (US) -lb/gal(US)",
                "Pound/gallon (UK) -lb/gal(UK)",
                "Ounce/cubic inch -oz/in^3",
                "Ounce/cubic foot -oz/ft^3",
                "Ounce/gallon (US) -oz/gal(US)",
                "Ounce/gallon (UK) -oz/gal(UK)",
                "Grain/gallon (US) -gr/gal(US)",
                "Grain/gallon (UK) -gr/gal(UK)",
                "Grain/cubic foot -gr/ft^3",
                "Ton (short)/cubic yard -ton/yd^3",
                "Ton (long)/cubic yard -ton/yd^3",
                "Slug/cubic foot -slug/ft^3",
                "Psi/1000 feet -psi/ft",
                "Earth's density (mean) -earth",

                //specific volume
                "Cubic meter/kilogram -M^3/kg",
                "Cubic centimeter/gram -cm^3/g",
                "Liter/kilogram -L/kg",
                "Liter/gram -L/g",
                "Cubic foot/kilogram -ft^3/kg",
                "Cubic foot/pound -ft^3/lb",
                "Gallon (US)/pound -gal(US)",
                "Gallon (UK)/pound -gal(UK)",

                //moment of inertia
                "Kilogram square meter -kg*M^2",
                "Kilogram square centimeter -kg*cm^2",
                "Kilogram square millimeter -kg*mm^2",
                "Gram square centimeter -g*cm^2",

                //moment of force
                "Newton meter -N*m",
                "Kilonewton meter -kN*m",
                "Millinewton meter -mN*m",
                "Micronewton meter -μN*m",

                //torque
                "Newton meter(torque) -N*m",
                "Newton centimeter -N*cm",
                "Newton millimeter -N*mm",
                "Kilonewton meter(torque) -kN*m",
                "Dyne meter -dyn*m",
                "Dyne centimeter -dyn*cm",
                "Dyne millimeter -dyn*mm",
                "Kilogram-force meter -kgf*m",
                "Kilogram-force centimeter -kgf*cm",
                "Kilogram-force millimeter -kgf*mm",
                "Gram-force meter -gf*m",
                "Gram-force centimeter -gf*cm",
                "Gram-force millimeter -gf*mm",
                "Ounce-force foot -ozf*ft",
                "Ounce-force inch -ozf*in",
                "Pound-force foot -lbf*ft",
                "Pound-force inch -lbf*in",

                //light
                //fueleffiency mass
                "Joule/kilogram -J/kg",
                "Kilojoule/kilogram -kJ/kg",
                "Calorie (IT)/gram -cal/g",
                "Calorie (th)/gram -cal(th)/g",
                "Btu (IT)/pound -Btu/lb",
                "Btu (th)/pound -Btu(th)/lb",
                "Kilogram/joule -kg/T",
                "Kilogram/kilojoule -kg/kJ",
                "Gram/calorie (IT) -g/cal",
                "Gram/calorie (th) -g/cal(th)",
                "Pound/Btu (IT) -lb/Btu",
                "Pound/Btu (th) -lb/Btu(th)",
                "Pound/horsepower/hour -lb/hp/h",
                "Gram/horsepower (metric)/hour -g/hp/h",
                "Gram/kilowatt/hour -g/kW/h",

                //fueleffiency voulme
                "Joule/cubic meter -J/m^3",
                "Joule/liter -J/L",
                "Megajoule/cubic meter -mJ/m^3",
                "Kilojoule/cubic meter -kJ/m^3",
                "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3",
                "Calorie (IT)/cubic centimeter -cal(IT)/cm^3",
                "Therm/cubic foot -therm/ft^3",
                "Therm/gallon (UK) -therm/gal",
                "Btu (IT)/cubic foot -Btu/ft^3",
                "Btu (th)/cubic foot -Btu (th)/ft^3",
                "CHU/cubic foot -CHU/ft^3",
                "Cubic meter/joule -m^3/J",
                "Liter/joule -L/J",
                "Gallon (US)/horsepower -gal(US)/hp",
                "Gallon (UK)/horsepower -gal(UK)/hp",

                //heatdensity
                "Joule/square meter -J/m^2",
                "Calorie (th)/square centimeter -cal(th)/cm^2",
                "Langley -lan",
                "Btu (IT)/square foot -Btu(IT)/ft^2",
                "Btu (th)/square foot -Btu(th)/ft^2",

                //heatfluxdensity
                "Watt/square meter -W/m^2",
                "Kilowatt/square meter -kW/m^2",
                "Watt/square centimeter -W/cm^2",
                "Watt/square inch -W/in^2",
                "Joule/second/square meter -Js/m^2",
                "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2",
                "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2",
                "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2",
                "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2",
                "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2",
                "Calorie (th)/second/square centimeter -cal(th)s/cm^2",
                "Calorie (th)/minute/square centimeter -cal(th)min/cm^2",
                "Calorie (th)/hour/square centimeter -cal(th)h/cm^2",
                "Dyne/hour/centimeter -dynh/cm",
                "Erg/hour/square millimeter -ergh/mm^2",
                "Foot pound/minute/square foot -ftlbmin/ft^2",
                "Horsepower/square foot -hp/ft^2",
                "Horsepower (metric)/square foot -hp/ft^2",
                "Btu (IT)/second/square foot -Btu(IT)s/ft^2",
                "Btu (IT)/minute/square foot -Btu(IT)min/ft^2",
                "Btu (IT)/hour/square foot -Btu(IT)h/ft^2",
                "Btu (th)/second/square inch -Btu(th)s/in^2",
                "Btu (th)/second/square foot -Btu(th)s/ft^2",
                "Btu (th)/minute/square foot -Btu(th)min/ft^2",
                "Btu (th)/hour/square foot -Btu(th)h/ft^2",
                "CHU/hour/square foot -CHUh/ft^2",

                //heat transfer
                "Watt/square meter/K -W/m^2/K",
                "Watt/square meter/%b0C -W/m^2/%b0C",
                "Joule/second/square meter/K -J/s/m^2/K",
                "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C",
                "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C",
                "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C",
                "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F",
                "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F",
                "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F",
                "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F",
                "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C",

                //specific heat capacity
                "Joule/kilogram/K -J/(kg*K)",
                "Joule/kilogram/°C -J/(kg*°C)",
                "Joule/gram/°C -J/(g*°C)",
                "Kilojoule/kilogram/K -kJ/(kg*K)",
                "Kilojoule/kilogram/°C -kJ/(kg*°C)",
                "Calorie (IT)/gram/°C -cal(IT)/(g*°C)",
                "Calorie (IT)/gram/°F -cal(IT)/(g*°F)",
                "Calorie (th)/gram/°C -cal(th)/(g*°C)",
                "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)",
                "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)",
                "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)",
                "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)",
                "Kilogram-force meter/kilogram/K -kgfm/(kg*K)",
                "Pound-force foot/pound/°R -lbfft/(lb*°R)",
                "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)",
                "Btu (th)/pound/°F -Btu(th)/(lb*°F)",
                "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)",
                "Btu (th)/pound/°R -Btu(th)/(lb*°R)",
                "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)",
                "CHU/pound/°C -CHU/(lb*°C)",

                //tempertureinterval
                "Kelvin -K",
                "Degree Celsius -°C",
                "Degree centigrade -°C",
                "Degree Fahrenheit -°F",
                "Degree Rankine -°R",
                "Degree Reaumur -°r",

                //thermalconductivity
                "Watt/meter/K -W/(m*K)",
                "Watt/centimeter/°C -W/(cm*°C)",
                "Kilowatt/meter/K -kW/(m*K)",
                "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)",
                "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)",
                "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)",
                "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)",
                "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)",
                "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)",
                "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)",
                "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)",
                "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)",
                "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)",

                //thermal expansion
                "Length/length/kelvin -1/K",
                "Length/length/degree Celsius -1/°C",
                "Length/length/degree Fahrenheit -1/°F",
                "Length/length/degree Rankine -1/R°",
                "Length/length/degree Reaumur -1/r°",

                //thermal resistance
                "Kelvin/watt -K/W",
                "Degree Fahrenheit hour/Btu (IT) -°Fh/Btu(IT)",
                "Degree Fahrenheit hour/Btu (th) -°Fh/Btu(th)",
                "Degree Fahrenheit second/Btu (IT) -°Fs/Btu(IT)",
                "Degree Fahrenheit second/Btu (th) -°Fs/Btu(th)",

                //digital image
                "Dot/meter -dot/m",
                "Dot/millimeter -dot/mm",
                "Dot/inch -dot/in",
                "Pixel/inch -pixel/in",

                //frequency
                "Hertz -Hz",
                "Exahertz -EHz",
                "Petahertz -PHz",
                "Terahertz -THz",
                "Gigahertz -GHz",
                "Megahertz -MHz",
                "Kilohertz -kHz",
                "Hectohertz -hHz",
                "Dekahertz -daHz",
                "Decihertz -dHz",
                "Centihertz -cHz",
                "Millihertz -mHz",
                "Microhertz -μHz",
                "Nanohertz -nHz",
                "Picohertz -pHz",
                "Femtohertz -fHz",
                "Attohertz -aHz",
                "Cycle/second -c/s",
                "Wavelength in exametres -Em",
                "Wavelength in petametres -Pm",
                "Wavelength in terametres -Tm",
                "Wavelength in gigametres -Gm",
                "Wavelength in megametres -Mm",
                "Wavelength in kilometres -km",
                "Wavelength in hectometres -hm",
                "Wavelength in dekametres -dam",
                "Wavelength in metres -m",
                "Wavelength in decimetres -dm",
                "Wavelength in centimetres -cm",
                "Wavelength in millimetres -mm",
                "Wavelength in micrometres -μm",
                "Electron Compton wavelength -e-",
                "Proton Compton wavelength -p",
                "Neutron Compton wavelength -n",

                //illumination
                "Lux -lx",
                "Meter-candle -m*c",
                "Centimeter-candle -cm*c",
                "Foot-candle -ft*c,fc",
                "Flame -fl",

                //luminanacne
                "Candela/square meter -cd/m^2",
                "Candela/square centimeter -cd/cm^2",
                "Candela/square foot -cd/ft^2",
                "Candela/square inch -cd/in^2",
                "Kilocandela/square meter -kcd/m^2",
                "Stilb -sb",
                "Lumen/sq. meter/steradian -l/m^2/srad",
                "Lumen/sq. cm/steradian -l/cm^2/srad",
                "Lumen/square foot/steradian -l/ft^2/srad",
                "Watt/sq. cm/steradian (at 555 nm) -W/cm^2/srad (at 555 nm)",
                "Nit -nt",
                "Millinit -mnt",
                "Lambert -L",
                "Millilambert -mL",
                "Foot-lambert -fL",
                "Apostilb -apo",
                "Blondel -blo",
                "Bril -br",
                "Skot -sk",

                //luminousintensity
                "Candle (international) -cd(international)",
                "Candle (German) -cd(German)",
                "Candle (UK) -cd(UK)",
                "Decimal candle -.cd",
                "Candle (pentane) -cd(pentane)",
                "Pentane candle (10 candle power) -pentane cd(10 cd power)",
                "Hefner candle -he cd",
                "Carcel unit -car u",
                "Bougie decimal -bo.",
                "Lumen/steradian -l/srad",

                //concentration molar
                "Mol/cubic meter -mol/m^3",
                "Mol/liter -mol/L",
                "Mol/cubic centimeter -mol/cm^3",
                "Mol/cubic millimeter -mol/mm^3",
                "Kilomol/cubic meter -kmol/m^3",
                "Kilomol/liter -kmol/L",
                "Kilomol/cubic centimeter -kmol/cm^3",
                "Kilomol/cubic millimeter -kmol/mm^3",
                "Millimol/cubic meter -mmol/m^3",
                "Millimol/liter -mmol/L",
                "Millimol/cubic centimeter -mmol/cm^3",
                "Millimol/cubic millimeter -mmol/mm^3",

                //concentration solution
                "Kilogram/liter(sol) -kg/L",
                "Gram/liter(sol) -g/L",
                "Milligram/liter(sol) -mg/L",
                "Part/million (ppm) -p/m",
                "Grain/gallon (US)(sol) -gr/gal(US)",
                "Grain/gallon (UK)(sol) -gr/gal(UK)",
                "Pound/gallon (US)(sol) -lb/gal(US)",
                "Pound/gallon (UK)(sol) -lb/gal(UK)",
                "Pound/million gallon (US) -lb/mgal(US)",
                "Pound/million gallon (UK) -lb/mgal(UK)",
                "Pound/cubic foot(sol) -lb/ft^3",

                //flow
                "Cubic meter/second -m^3/s",
                "Cubic meter/day -m^3/d",
                "Cubic meter/hour -m^3/h",
                "Cubic meter/minute -m^3/min",
                "Cubic centimeter/day -cm^3/d",
                "Cubic centimeter/hour -cm^3/h",
                "Cubic centimeter/minute -cm^3/min",
                "Cubic centimeter/second -cm^3/s",
                "Liter/day -L/d",
                "Liter/hour -L/h",
                "Liter/minute -L/min",
                "Liter/second -L/s",
                "Milliliter/day -mL/d",
                "Milliliter/hour -mL/h",
                "Milliliter/minute -mL/min",
                "Milliliter/second -mL/s",
                "Gallon (US)/day -gal(US)/d",
                "Gallon (US)/hour -gal(US)/h",
                "Gallon (US)/minute -gal(US)/min",
                "Gallon (US)/second -gal(US)/s",
                "Gallon (UK)/day -gal(UK)/d",
                "Gallon (UK)/hour -gal(UK)/h",
                "Gallon (UK)/minute -gal(UK)/min",
                "Gallon (UK)/second -gal(UK)/s",
                "Kilobarrel (US)/day -kbbl(US)/d",
                "Barrel (US)/day -bbl(US)/d",
                "Barrel (US)/hour -bbl(US)/h",
                "Barrel (US)/minute -bbl(US)/min",
                "Barrel (US)/second -bbl(US)/s",
                "Acre-foot/year -ac*ft/y",
                "Acre-foot/day -ac*ft/d",
                "Acre-foot/hour -ac*ft/h",
                "Hundred-cubic foot/day -ft^3/d",
                "Hundred-cubic foot/hour -ft^3/h",
                "Hundred-cubic foot/minute -ft^3/min",
                "Ounce/hour -oz/h",
                "Ounce/minute -oz/min",
                "Ounce/second -oz/s",
                "Ounce (UK)/hour -oz(UK)/h",
                "Ounce (UK)/minute -oz(UK)/min",
                "Ounce (UK)/second -oz(UK)/s",
                "Cubic yard/hour -yd^3/h",
                "Cubic yard/minute -yd^3/min",
                "Cubic yard/second -yd^3/s",
                "Cubic foot/hour -ft^3/h",
                "Cubic foot/minute -ft^3/min",
                "Cubic foot/second -ft^3/s",
                "Cubic inch/hour -in^3/h",
                "Cubic inch/minute -in^3/min",
                "Cubic inch/second -in^3/s",
                "Pound/second (Gasoline at 15.5%b0C) -lb/s",
                "Pound/minute (Gasoline at 15.5%b0C) -lb/min",
                "Pound/hour (Gasoline at 15.5%b0C) -lb/h",
                "Pound/day (Gasoline at 15.5%b0C) -lb/d",
                "Kilogram/second (Gasoline at 15.5%b0C) -kg/s",
                "Kilogram/minute (Gasoline at 15.5%b0C) -kg/min",
                "Kilogram/hour (Gasoline at 15.5%b0C) -kg/h",
                "Kilogram/day (Gasoline at 15.5%b0C) -kg/d",

                //   flow mass
                "Kilogram/second -kg/s",
                "Gram/second -g/s",
                "Gram/minute -g/min",
                "Gram/hour -g/h",
                "Gram/day -g/d",
                "Milligram/minute -mg/min",
                "Milligram/hour -mg/h",
                "Milligram/day -mg/d",
                "Kilogram/minute -kg/m",
                "Kilogram/hour -kg/h",
                "Kilogram/day -kg/d",
                "Exagram/second -Eg/s",
                "Petagram/second -Pg/s",
                "Teragram/second -Tg/s",
                "Gigagram/second -Gg/s",
                "Megagram/second -Mg/s",
                "Hectogram/second -hg/s",
                "Dekagram/second -dag/s",
                "Decigram/second -dg/s",
                "Centigram/second -cg/s",
                "Milligram/second -mg/s",
                "Microgram/second -μg/s",
                "Ton (metric)/second -t/s",
                "Ton (metric)/minute -t/min",
                "Ton (metric)/hour -t/h",
                "Ton (metric)/day -t/d",
                "Ton (short)/hour -ton(US)/h",
                "Pound/second -lb/s",
                "Pound/minute -lb/min",
                "Pound/hour -lb/h",
                "Pound/day -lb/d",

                //flow molar
                "Mol/second -mol/s",
                "Examol/second -Emol/s",
                "Petamol/second -Pmol/s",
                "Teramol/second -Tmol/s",
                "Gigamol/second -Gmol/s",
                "Megamol/second -Mmol/s",
                "Kilomol/second -kmol/s",
                "Hectomol/second -hmol/s",
                "Dekamol/second -damol/s",
                "Decimol/second -dmol/s",
                "Centimol/second -cmol/s",
                "Millimol/second -mmol/s",
                "Micromol/second -μmol/s",
                "Nanomol/second -nmol/s",
                "Picomol/second -pmol/s",
                "Femtomol/second -fmol/s",
                "Attomol/second -amol/s",
                "Mol/minute -mol/min",
                "Mol/hour -mol/h",
                "Mol/day -mol/d",
                "Millimol/minute -mmol/min",
                "Millimol/hour -mmol/h",
                "Millimol/day -mmol/d",
                "Kilomol/minute -kmol/min",
                "Kilomol/hour -kmol/h",
                "Kilomol/day -kmol/d",

                //mass flux density
                "Gram/second/square meter -gs/m^2",
                "Kilogram/hour/square meter -kgh/m^2",
                "Kilogram/hour/square foot -kgh/ft^2",
                "Kilogram/second/square meter -kgs/m^2",
                "Gram/second/sq. centimeter -gs/cm^2",
                "Pound/hour/square foot -lbh/ft^2",
                "Pound/second/square foot -lbs/ft^2",

                //permeability
                "Kilogram/pascal/second/square meter -kg/Pa/s/m^2",
                "Permeability (0°C) -µ (0°C)",
                "Permeability (23°C) -µ (23°C)",
                "Permeability inches (0°C) -µ in(0°C)",
                "Permeability inches (23°C) -µ in(23°C)",

                //surface tension
                "Newton/meter -N/m",
                "Millinewton/meter -mN/m",
                "Gram-force/centimeter -gf/cm",
                "Dyne/centimeter -dyn/cm",
                "Erg/square centimeter -erg/cm^2",
                "Erg/square millimeter -erg/mm^2",
                "Poundal/inch -lb/in",
                "Pound-force/inch -lbf/in",

                //viscosity
                "Pascal second -Pa*s",
                "Kilogram-force second/square meter -kg-Ns/m^2",
                "Newton second/square meter -N*s/m^2",
                "Millinewton second/sq. meter -mNs/m^2",
                "Dyne second/sq. centimeter -dyns/cm^2",
                "Poise -P",
                "Exapoise -EP",
                "Petapoise -PP",
                "Terapoise -TP",
                "Gigapoise -GP",
                "Megapoise -MP",
                "Kilopoise -kP",
                "Hectopoise -hP",
                "Dekapoise -daP",
                "Decipoise -dP",
                "Centipoise -cP",
                "Millipoise -mP",
                "Micropoise -μP",
                "Nanopoise -nP",
                "Picopoise -pP",
                "Femtopoise -fP",
                "Attopoise -aP",
                "Pound-force second/sq. inch -lb-Ns/in^2",
                "Pound-force second/sq. foot -lb-Ns/ft^2",
                "Poundal second/square foot -lbs/ft^2",
                "Gram/centimeter/second -g/(cm*s)",
                "Slug/foot/second -slug/(ft*s)",
                "Pound/foot/second -lb/(ft*s)",
                "Pound/foot/hour -lb/(ft*h)",

                //viscosity kinetic
                "Square meter/second -m^2/s",
                "Square meter/hour -m^2/h",
                "Square centimeter/second -cm^2/s",
                "Square millimeter/second -mm^2/s",
                "Square foot/second -ft^2/s",
                "Square foot/hour -ft^2/h",
                "Square inch/second -in^2/s",
                "Stokes -St",
                "Exastokes -ESt",
                "Petastokes -PSt",
                "Terastokes -TSt",
                "Gigastokes -GSt",
                "Megastokes -MSt",
                "Kilostokes -kSt",
                "Hectostokes -hSt",
                "Dekastokes -daSt",
                "Decistokes -dSt",
                "Centistokes -cSt",
                "Millistokes -mSt",
                "Microstokes -μSt",
                "Nanostokes -nSt",
                "Picostokes -pSt",
                "Femtostokes -fSt",
                "Attostokes -aSt",

                //magnetism
                "Ampere/meter - A/m",
                "Ampere turn/meter - At/m",
                "Kiloampere/meter - kA/m",
                "Oersted - Oe",

                //magneticflux
                "Weber - Wb",
                "Miliweber - mWb",
                "Microweber - μWb",
                "Volt second - V*s",
                "Unit pole - u",
                "Mega line - megaLine",
                "Kilo line - kiloLine",
                "Line - line",
                "Maxwell - Mx",
                "Tesla square meter - T*m²",
                "Tesla square centimeter - T*cm²",
                "Gauss square meter - gauss*m²",
                "Magnetic flux quantum",

                //magnetic flux density
                "Tesla - T",
                "Weber/square meter - Wb/m²",
                "Weber/square centimeter - Wb/cm²",
                "Weber/square inch - Wb/in²",
                "Maxwell/square meter - Mx/m²",
                "Maxwell/square centimeter - Mx/cm²",
                "Maxwell/square inch - Mx/in²",

                //magnemotive
                "Ampere turn - At",
                "Kiloampere turn - kAt",
                "Milliampere turn - mAt",
                "Abampere turn - abAt",
                "Gilbert - Gi",

                //radiology
                "Rad - rd",
                "Millirad - mrd",
                "Joule/kilogram - J/kg",
                "Joule/gram - J/g",
                "Joule/centigram - J/cg",
                "Joule/milligram - J/mg",
                "Gray - Gy",
                "Exagray - EGy",
                "Petagray - PGy",
                "Teragray - TGy",
                "Gigagray - GGy",
                "Megagray - MGy",
                "Kilogray - kGy",
                "Hectogray - hGy",
                "Dekagray - daGy",
                "Decigray - dGy",
                "Centigray - cGy",
                "Milligray - mGy",
                "Microgray - µGy",
                "Nanogray - nGy",
                "Picogray - pGy",
                "Femtogray - fGy",
                "Attogray - aGy",

                //radiation
                "Becquerel - Bq",
                "Terabecquerel - TBq",
                "Gigabecquerel - GBq",
                "Megabecquerel - MBq",
                "Kilobecquerel - kBq",
                "Millibecquerel - mBq",
                "Curie - Ci",
                "Kilocurie - kCi",
                "Millicurie - mCi",
                "Microcurie - µCi",
                "Nanocurie - nCi",
                "Picocurie - pCi",
                "Rutherford - R",
                "One/second - 1/s",
                "Disintegrations/second - dis/sec",
                "Disintegrations/minute - dis/min",

                //radiationconverteractivity
                "Gray/second - Gy/s",
                "Exagray/second - EGy/s",
                "Petagray/second - PGy/s",
                "Teragray/second - TGy/s",
                "Gigagray/second - GGy/s",
                "Megagray/second - MGy/s",
                "Kilogray/second - kGy/s",
                "Hectogray/second - hGy/s",
                "Dekagray/second - daGy/s",
                "Decigray/second - dGy/s",
                "Centigray/second - cGy/s",
                "Milligray/second - mGy/s",
                "Microgray/second - µGy/s",
                "Nanogray/second - nGy/s",
                "Picogray/second - pGy/s",
                "Femtogray/second - fGy/s",
                "Attogray/second - aGy/s",
                "Rad/second - rd/s",
                "Joule/kilogram/second - J/kg/s",
                "Watt/kilogram - W/kg",
                "Sievert/second - Sv/s",
                "Rem/second - rem/s",

                "Coulomb/kilogram - C/kg",
                "Millicoulomb/kilogram - mC/kg",
                "Microcoulomb/kilogram - μC/kg",
                "Roentgen - R",
                "Tissue roentgen - Tr",
                "Parker - parker",
                "Rep - rep",

                //charge
                "Coulomb - C",
                "Megacoulomb - MC",
                "Kilocoulomb - kC",
                "Millicoulomb - mC",
                "Microcoulomb - µC",
                "Nanocoulomb - nC",
                "Picocoulomb - pC",
                "EMU of charge - e",
                "Statcoulomb - stC",
                "ESU of charge - e",
                "Franklin - Fr",
                "Ampere-hour - A*h",
                "Ampere-minute - A*min",
                "Ampere-second - A*s",
                "Faraday - F",
                "Elementary charge - e",

                //conductance
                "Siemens - S",
                "Megasiemens - MS",
                "Kilosiemens - kS",
                "Milisiemens - mS",
                "Microsiemens - µS",
                "Ampere/volt - A/V",
                "Mho - mho",
                "Gemmho - gemmho",
                "Micromho - µmho",
                "Abmho - abmho",
                "Statmho - stmho",
                "Quantized Hall Conductance - mho",

                //conductivity
                "Siemens/meter - S/m",
                "Picosiemens/meter - pS/m",
                "Mho/meter - mho/m",
                "Mho/centimeter - mho/cm",
                "Abmho/meter - abmho/m",
                "Abmho/centimeter - abmho/cm",
                "Statmho/meter - stmho/m",
                "Statmho/centimeter - st/cm",

                //current
                "Ampere - A",
                "Kiloampere - kA",
                "Milliampere - mA",
                "Biot - Bi",
                "Abampere - abA",
                "EMU of current - emuA",
                "Statampere - stA",
                "ESU of current - esuA",
                "CGS e.m.unit - e.m.unit",
                "CGS e.s.unit - e.s.unit",

                "Volt/meter - V/m",
                "Kilovolt/meter - kV/m",
                "Kilovolt/centimeter - kV/cm",
                "Volt/centimeter - V/cm",
                "Millivolt/meter - mV/m",
                "Microvolt/meter - µ/m",

                "Volt - V",
                "Watt/ampere - W/A",
                "Abvolt - AbV",
                "EMU of electric potential - EMU",
                "Statvolt - stV",
                "ESU of electric potential - ESU",

                //electric resistance
                "Ohm - Ω",
                "Megohm - megohm",
                "Microhm - microhm",
                "Volt/ampere - V/A",
                "Reciprocal siemens - 1/S",
                "Abohm - abΩ",
                "EMU of resistance - EMU",
                "Statohm - stΩ",
                "ESU of resistance - ESU",
                "Quantized Hall resistance - Ω",

                //electric resisitvity
                "Ohm meter - Ωm",
                "Ohm centimeter - Ωcm",
                "Ohm inch - Ωin",
                "Microhm centimeter - µΩcm",
                "Microhm inch -  µΩin",
                "Abohm centimeter - abΩcm",
                "Statohm centimeter - stΩcm",
                "Circular mil ohm/foot - circular mil Ω/ft",

                //electrostatic
                "Farad - F",
                "Exafarad - EF",
                "Petafarad - PF",
                "Terafarad - TF",
                "Gigafarad - GF",
                "Megafarad - MF",
                "Kilofarad - kF",
                "Hectofarad - hF",
                "Dekafarad - dF",
                "Decifarad - dF",
                "Centifarad - cF",
                "Millifarad - mF",
                "Microfarad - µF",
                "Nanofarad - nF",
                "Femtofarad - fF",
                "Attofarad - aF",
                "Coulomb/volt - C/v",
                "Abfarad - abF",
                "EMU of capacitance - EMU",
                "Statfarad - stF",
                "ESU of capacitance - ESU",

                //inductance
                "Henry - H",
                "Exahenry - EH",
                "Terahenry - TH",
                "Petahenry - PH",
                "Gigahenry - GH",
                "Megahenry - MH",
                "Kilohenry - kH",
                "Hectohenry - hH",
                "Dekahenry - daH",
                "Decihenry - dH",
                "Centihenry - cH",
                "Milihenry - mH",
                "Microhenry - µH",
                "Nanohenry - nH",
                "Picohenry - pH",
                "Femtohenry - fH",
                "Attohenery - aH",
                "Weber/ampere - Wb/A",
                "Abhenery - abH",
                "EMU of inductance - EMU",
                "Stathenry - stH",
                "ESU of inductance - ESU",

                //linear charge
                "Coulomb/meter - C/m",
                "Coulomb/centimeter - C/cm",
                "Coulomb/inch - C/in",
                "Abcoulomb/meter - abC/m",
                "Abcoulomb/centimeter - abC/cm",
                "Abcoulomb/inch - abC/in",

                //linear current
                "Ampere/meter(linear) - A/m",
                "Ampere/centimeter - A/cm",
                "Ampere/inch - A/in",
                "Abampere/meter - abA/m",
                "Abampere/centimeter - abA/cm",
                "Abampere/inch - abA/in",
                "Oersted(linear) - Oe",
                "Gilbert/centimeter - Gi/cm",

                //surface charge
                "Coulomb/square meter - C/m²",
                "Coulomb/square centimeter - C/cm²",
                "Coulomb/square inch - C/in²",
                "Abcoulomb/square meter - abC/m²",
                "Abcoulomb/square centimeter - abC/cm²",
                "Abcoulomb/square inch - abC/in²",

                //surface current
                "Ampere/square meter - A/m²",
                "Ampere/square centimeter - A/cm²",
                "Ampere/square inch - A/in²",
                "Ampere/square mil - A/mil²",
                "Ampere/cicular mil - A/mil",
                "Abampere/square centimeter - abA/cm²",

                //volume charge
                "Coulomb/cubic meter - C/m³",
                "Coulomb/cubic centimeter - C/cm³",
                "Coulomb/cubic inch - C/in³",
                "Abcoulomb/cubic meter - abC/m³",
                "Abcoulomb/cubic centimeter - abC/cm³",
                "Abcoulomb/cubic inch - abC/in³",

                //cooking
                "Cup(Euro) - cup",
                "Cup(US) - cup",
                "Gram(cooking) - g",
                "Kilogram - kg",
                "Liter - li",
                "Milliliter - ml",
                "Ounce(cooking) - oz",
                "Fluid Ounce - floz",
                "Pint - pt",
                "Pound - lb",
                "Table Spoon(Euro) - tbsp",
                "Table Spoon(US) - tbsp",
                "Tea Spoon(Euro) - tsp",
                "Tea Spoon(US) - tsp",

                //datatransfer
                "Bit/second - b/s",
                "Byte/second - B/s",
                "Kilobit/second(SI def.)",
                "Kilobyte/second(SI def.)",
                "Kilobit/second - kb/s",
                "Kilobyte/second - kB/s",
                "Megabit/second(SI def.)",
                "Megabyte/second(SI def.)",
                "Megabit/second - Mb/s",
                "Megabyte/second - MB/s",
                "Gigabit/second(SI def.)",
                "Gigabyte/second(SI def.)",
                "Gigabit/second - Gb/s",
                "Gigabyte/second - GB/s",
                "Terabit/second(SI def.)",
                "Terabyte/second(SI def.)",
                "Terabit/second - Tb/s",
                "Terabyte/second - TB/S",
                "Ethernet",
                "Ethernet(fast)",
                "Ethernet(gigabit)",
                "OC1",
                "OC3",
                "OC12",
                "OC24",
                "OC48",
                "OC192",
                "OC768",
                "ISDN (single channel)",
                "ISDN(dual channel)",
                "Modem(110)",
                "Modem(300)",
                "Modem(1200)",
                "Modem(2400)",
                "Modem(9600)",
                "Modem(14.4k)",
                "Modem(28.8k)",
                "Modem(33.6k)",
                "Modem(56k)",
                "SCSI(Async)",
                "SCSI(Sync)",
                "SCSI(Fast)",
                "SCSI(Fast Ultra)",
                "SCSI(Fast Wide)",
                "SCSI(Fast Ultra Wide)",
                "SCSI(Ultra-2)",
                "SCSI(Ultra-3)",
                "SCSI(LVD Ultra 80)",
                "SCSI(LVD Ultra 160)",
                "IDE(PIO mode 0)",
                "IDE(PIO mode 1)",
                "IDE(PIO mode 2)",
                "IDE(PIO mode 3)",
                "IDE(PIO mode 4)",
                "IDE(DMA mode 0)",
                "IDE(DMA mode 1)",
                "IDE(DMA mode 2)",
                "IDE(UDMA mode 0)",
                "IDE(UDMAmode 1)",
                "IDE(UDMA mode 2)",
                "IDE(UDMA mode 3)",
                "IDE(UDMA mode 4)",
                "IDE(UDMA 33)",
                "IDE(UDMA 66)",
                "USB",
                "Firewire(IEEE-1394)",
                "T0(payload)",
                "T0(B8ZS payload)",
                "T1(signal)",
                "T1(payload)",
                "T1Z(payload)",
                "T1C(signal)",
                "T1C(payload)",
                "T2(signal)",
                "T3(signal)",
                "T3(payload)",
                "T3Z(payload)",
                "T4(signal)",
                "E.P.T.A.1(signal)",
                "E.P.T.A.1(payload)",
                "E.P.T.A.2(signal)",
                "E.P.T.A.2(payload)",
                "E.P.T.A.3(signal)",
                "E.P.T.A.3(payload)",
                "H0",
                "H11",
                "Virtual Tributary 1(signal)",
                "Virtual Tributary 1(payload)",
                "Virtual Tributary 2(signal)",
                "Virtual Tributary 2(payload)",
                "Virtual Tributary 6(signal)",
                "Virtual Tributary 6(payload)",
                "STS1(signal)",
                "STS1(payload)",
                "STS3(signal)",
                "STS3(payload)",
                "STS3c(signal)",
                "STS3c(payload)",
                "STS12(signal)",
                "STS24(signal)",
                "STS48(signal)",
                "STS192(signal)",
                "STM-1(signal)",
                "STM-4(signal)",
                "STM-16(signal)",
                "STM-64(signal)",


                //Hardness
                "German Degrees - °g",
                "Parts/million - p/million",
                "American Degrees - °a",
                "Clark Degrees - °c",
                "French Degrees - °f",
                "Millieqv - millieqv",
                "Milli Grams/gallon - mgr/gal",

                //ImageActivity
                "Twip - twip",
                "Meter - m",
                "Centimeter - cm",
                "Millimeter - mm",
                "Inch - in",
                "Pixel(X) - pixel(x)",
                "Pixel(Y) - pixel(y)",
                "Character(X) - character(x)",
                "Character(Y) - character(y)",
                "Pica - P",
                "Point - pt",
                "En - en",

                //metric weight
                "Microgram - µg",
                "Milligram(metric weight) - mg",
                "Centigram(metric weight) - cg",
                "Decigram(metric weight) - dg",
                "Gram(metric weight) - g",
                "Dekagram(metric weight) - dag",
                "Hectogram(metric weight) - hg",
                "Kilogram(metric weight) - kg",
                "Metricton(metric weight) - metricton",

                //metrology
                "Angstrom - angstrom",
                "Surface Microinch - µin",
                "Surface microns - microns",
                "Light bands - lightbands",
                "Precision tenths - precision tenths",
                "Close tol.thousands - closetolthousands",
                "Metric millimeters - metric mm",
                "U.S.Inches - usInches",

                //prefix
                "None - none",
                "Yotta - Y",
                "Zetta - Z",
                "Exa - E",
                "Peta - P",
                "Tera - T",
                "Giga - G",
                "Mega - M",
                "Kilo - k",
                "Hecto - h",
                "Deka - da",
                "Deci - d",
                "Centi - c",
                "Milli - m",
                "Micro - µ",
                "Nano - n",
                "Pico - p",
                "Femto - f",
                "Atto - a",
                "Zepto - z",
                "Yocto - y",

                //sound
                "Bel - B",
                "Decible - dB",
                "Neper - Np",

                //typography
                "Twip(typography) - twip",
                "Meter(typography) - m",
                "Centimeter(typography) - cm",
                "Millimeter(typography) - mm",
                "Character(X)(typography) - character(x)",
                "Character(Y)(typography) - character(y)",
                "Pixel(X)(typography) - pixel(x)",
                "Pixel(Y)(typography) - pixel(y)",
                "Inch(typography) - in",
                "Pica(Computer) - pica",
                "Pica(Printer) - pica",
                "PostScript point - psp",
                "Point(Computer) - pt",
                "Point(Printer) - pt",
                "En(typography) - en",

                //voulme lumber
                "Cubic meter - m³",
                "Cubic foot - ft³",
                "Cubic inch - in³",
                "Board feet - boardfeet",
                "Thousand board feet - thousand board feet",
                "Cord - cord",
                "Cord(80 cubic ft) - cord",
                "Cord feet - cordfeet",
                "Cunit - cunit",
                "Pallet - pallet",
                "Cross tie - crosstie",
                "Switch tie - switchtie",
                "Thousand square feet (1/8inch panels) - ft²",
                "Thousand square feet (1/4inch panels) - ft²",
                "Thousand square feet (3/8inch panels) - ft²",
                "Thousand square feet (1/2inch panels) - ft²",
                "Thousand square feet (3/4inch panels) - ft²",

                //work
                "Joule(work) - J",
                "Kilojoule - kJ",
                "Calorie - cal",
                "Kilocalorie - kcal",
                "Kilowatt hour - kw*h",
                "Kilogram force meter - kgf*m",
                "Inch pound - in*lbf",
                "Foot pound - ft*lbf",
                "Btu - btu"

        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, listitem);
        lv.setAdapter(adapter);

        /*Collections.sort(lv, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });*/

        inputSearch.addTextChangedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                //Do some more stuff here and launch new activity
                selectedItem = (String)adapterView.getItemAtPosition(position);
                //  Toast.makeText(SearchActivity.this,"Position"+selectedItem,Toast.LENGTH_LONG).show();
                switch(selectedItem)
                {
                    //Length
                    case  "Meter -m":
                        length();
                        break;
                    case  "Kilometer -km":
                        length();
                        break;
                    case  "Decimeter -dm":
                        length();
                        break;
                    case  "Centimeter -cm":
                        length();
                        break;
                    case  "Millimeter -mm":
                        length();
                        break;
                    case  "Micrometer -μm":
                        length();
                        break;
                    case  "Nanometer -nm":
                        length();
                        break;
                    case  "Mile -mi,mi(Int)":
                        length();
                        break;
                    case  "Yard -yd":
                        length();
                        break;
                    case  "Foot -ft":
                        length();
                        break;
                    case  "Inch -in":
                        length();
                        break;
                    case  "Light year -ly":
                        length();
                        break;
                    case  "Exameter -Em":
                        length();
                        break;
                    case  "Petameter -Pm":
                        length();
                        break;
                    case  "Terameter -Tm":
                        length();
                        break;
                    case  "Gigameter -Gm":
                        length();
                        break;
                    case  "Megameter -Mm":
                        length();
                        break;
                    case  "Hectometer -hm":
                        length();
                        break;
                    case  "Dekameter -dam":
                        length();
                        break;
                    case  "Micron -μ":
                        length();
                        break;
                    case  "Picometer -pm":
                        length();
                        break;
                    case  "Femtometer -fm":
                        length();
                        break;
                    case  "Attometer -am":
                        length();
                        break;
                    case  "Megaparsec -Mpc":
                        length();
                        break;
                    case  "Kiloparsec -kpc":
                        length();
                        break;
                    case  "Parsec -pc":
                        length();
                        break;
                    case  "Astronomical unit -AU,UA":
                        length();
                        break;
                    case  "League -lea":
                        length();
                        break;
                    case  "Nautical league (UK) -n.lea(UK)":
                        length();
                        break;
                    case  "Nautical league (int.) -n.lea":
                        length();
                        break;
                    case  "League (statute) -lea(US)":
                        length();
                        break;
                    case  "Nautical mile (UK) -n.mi":
                        length();
                        break;
                    case  "Nautical mile (international) -n.mi":
                        length();
                        break;
                    case  "Mile (statute) -mi,mi(US)":
                        length();
                        break;
                    case  "Mile (US survey) -mi,mi(US)":
                        length();
                        break;
                    case  "Mile (Roman)-mile":
                        length();
                        break;
                    case  "Kiloyard -kyd":
                        length();
                        break;
                    case  "Furlong -fur":
                        length();
                        break;
                    case  "Furlong (US survey) -fur":
                        length();
                        break;
                    case  "Chain -ch":
                        length();
                        break;
                    case  "Chain (US survey) -ch":
                        length();
                        break;
                    case  "Rope -rope":
                        length();
                        break;
                    case  "Rod -rd":
                        length();
                        break;
                    case  "Rod (US survey) -rd":
                        length();
                        break;
                    case  "Perch -perch":
                        length();
                        break;
                    case  "Pole -pole":
                        length();
                        break;
                    case  "Fathom -fath":
                        length();
                        break;
                    case  "Fathom (US survey) -fath":
                        length();
                        break;
                    case  "Ell -ell":
                        length();
                        break;
                    case  "Foot (US survey) -ft":
                        length();
                        break;
                    case  "Link -li":
                        length();
                        break;
                    case  "Link (US survey) -li":
                        length();
                        break;
                    case  "Cubit (UK) -cubit":
                        length();
                        break;
                    case  "Hand -hand":
                        length();
                        break;
                    case  "Span (cloth) -span":
                        length();
                        break;
                    case  "Finger (cloth) -finger":
                        length();
                        break;
                    case  "Nail (cloth) -nail":
                        length();
                        break;
                    case  "Inch (US survey) -in":
                        length();
                        break;
                    case  "Barleycorn -barleycorn":
                        length();
                        break;
                    case  "Mil -mil,thou":
                        length();
                        break;
                    case  "Microinch -μ.in":
                        length();
                        break;
                    case  "Angstrom -A":
                        length();
                        break;
                    case  "A.u. of length -a.u.,b":
                        length();
                        break;
                    case  "X-unit -X":
                        length();
                        break;
                    case  "Fermi -F,f":
                        length();
                        break;
                    case  "Arpent -Arpent":
                        length();
                        break;
                    case  "Pica -pica":
                        length();
                        break;
                    case  "Point -Point":
                        length();
                        break;
                    case  "Twip  -twip":
                        length();
                        break;
                    case  "Aln -aln":
                        length();
                        break;
                    case  "Famn -famn":
                        length();
                        break;
                    case  "Caliber -cl":
                        length();
                        break;
                    case  "Centiinch -cin":
                        length();
                        break;
                    case  "Ken -ken":
                        length();
                        break;
                    case  "Russian archin -archin":
                        length();
                        break;
                    case  "Roman actus -actus":
                        length();
                        break;
                    case  "Vara de tarea -v.de.t":
                        length();
                        break;
                    case  "Vara conuquera -vc":
                        length();
                        break;
                    case  "Vara castellana -vcas":
                        length();
                        break;
                    case  "Cubit (Greek) -cubit":
                        length();
                        break;
                    case  "Long reed -lreed": length();
                        break;
                    case  "Reed -reed": length();
                        break;
                    case  "Long cubit -long cubit": length();
                        break;
                    case  "Handbreadth -hb": length();
                        break;
                    case  "Fingerbreadth -fb": length();
                        break;
                    case  "Planck length -Planck": length();
                        break;
                    case  "Electron radius (classical) -e-rad": length();
                        break;
                    case  "Bohr radius -b,a.u.": length();
                        break;
                    case  "Earth's equatorial radius -Earth": length();
                        break;
                    case  "Earth's polar radius -Earth": length();
                        break;
                    case  "Earth's distance from sun -Earth": length();
                        break;
                    case  "Sun's radius -Sun": length();
                        break;


                    //weight
                    case "Kilogram -  kg" :
                        weight();
                        break;
                    case "Gram - g" :
                        weight();
                        break;
                    case "Milligram - mg" :
                        weight();
                        break;
                    case "Ton - t" :
                        weight();
                        break;
                    case "Pound - lbs" :
                        weight();
                        break;
                    case "Ounce - oz" :
                        weight();
                        break;
                    case "Carat - ct" :
                        weight();
                        break;
                    case "Ton short US - ton" :
                        weight();
                        break;
                    case "Ton long UK - ton" :
                        weight();
                        break;
                    case "Atomic mass unit - u" :
                        weight();
                        break;

                    case "Exagram -  Eg" :
                        weight();
                        break;
                    case "Petagram - Pg" :
                        weight();
                        break;
                    case "Teragram - Tg" :
                        weight();
                        break;
                    case "Gigagram -  Gg" :
                        weight();
                        break;
                    case "Megagram - Mg" :
                        weight();
                        break;
                    case "Hectogram - hg" :
                        weight();
                        break;
                    case "Dekagram -  dag" :
                        weight();
                        break;
                    case "Decigram - dg" :
                        weight();
                        break;
                    case "Centigram - cg" :
                        weight();
                        break;
                    case "Microgram - μg" :
                        weight();
                        break;

                    case "Nanogram  - ng" :
                        weight();
                        break;
                    case "Picogram -  pg" :
                        weight();
                        break;
                    case "Femtogram - fg" :
                        weight();
                        break;
                    case "Attogram - ag" :
                        weight();
                        break;
                    case "Dalton - dt" :
                        weight();
                        break;
                    case "Kilogram-energy square second/meter - kg F sq s m- 1" :
                        weight();
                        break;
                    case "Kilopound - kip" :
                        weight();
                        break;
                    case "Kip - kip " :
                        weight();
                        break;
                    case "Slug - slug " :
                        weight();
                        break;
                    case "Pound-energy square second/foot - lb F sq s ft-1 " :
                        weight();
                        break;

                    case "Pound (troy or apothecary) - lb" :
                        weight();
                        break;
                    case "Poundal - pdl" :
                        weight();
                        break;
                    case "Ton (assay) (UK) - AT)" :
                        weight();
                        break;
                    case "Ton (assay) (US) - AT)" :
                        weight();
                        break;
                    case "Kiloton (metric) - kt" :
                        weight();
                        break;
                    case "Qunital (metric) -  cwt" :
                        weight();                         break;
                    case "Hundredweight (US) - hwt " : weight();                         break;
                    case "Hundredweight (UK) - hwt" : weight();                         break;
                    case "Quarter (US) - qr " : weight();                         break;

                    case "Quarter (UK) - qr " : weight();                         break;
                    case "Stone (US) - st" : weight();                         break;
                    case "Stone (UK) - st" : weight();                         break;
                    case "Sonne - t" : weight();                         break;
                    case "Pennyweight - pwt" : weight();                         break;
                    case "Scruple (apothecary)- s.ap" : weight();                         break;
                    case "Grain - gr" : weight();                         break;
                    case "Gamma - gamma" : weight();                         break;
                    case "Talent (Biblical Hebrew) - talent " : weight();                         break;

                    case "Mina (Biblical Hebrew) - mina" : weight();                         break;
                    case "Shekal (Biblical Hebrew) - shekal" : weight();                         break;
                    case "Bekan (Biblical Hebrew) - bekan" : weight();                         break;
                    case "Gereh (Biblical Hebrew) - gereh" : weight();                         break;
                    case "Talent (Biblical Greek) - talent" : weight();                         break;
                    case "Mina (Biblical Greek) - mina " : weight();                         break;
                    case "Tetradrachma (Biblical Greek) - tetd" : weight();                         break;
                    case "Didrachma (Biblical Greek) - didrachma" : weight();                         break;
                    case "Drachma (Biblical Greek) - drachma " : weight();                         break;

                    case "Denarius (Biblical Roman) - denarius" : weight();                         break;
                    case "Assarion (Biblical Roman) - assarion" : weight();                         break;
                    case "Quadrans (Biblical Roman) -  quadranns" : weight();                         break;
                    case "Lepton (Biblical Roman) - lepton" : weight();                         break;
                    case "Planck mass - Planck mass" : weight();                         break;
                    case "Electron mass (rest) -  e-" : weight();                         break;
                    case "Muon mass - M" : weight();                         break;
                    case "Proton mass - p" : weight();                         break;
                    case "Neutron mass - n " : weight();                         break;

                    case "Deuteron mass - D" : weight();                         break;
                    case "Earth's mass - Earth" : weight();                         break;
                    case "Sun mass - Sun" :
                        weight();
                        break;


                    //volume
                    case "Cubic meter - m^3":volume();break;
                    case "Cubic kilometer  - km^3" : volume();                         break;
                    case "Cubic centimeter  - cm^3" : volume();                         break;
                    case "Cubic millimeter - mm^3" : volume();                         break;
                    case "Liter - L" : volume();                         break;
                    case "Milliliter  - mL" : volume();                         break;
                    case "Gallons(US) - gallon" : volume();                         break;
                    case "Quart(US) - qt" : volume();                         break;
                    case "Pint(US)  - pt" : volume();                         break;
                    case "Cup(US)  - cup" : volume();                         break;
                    case "Tablespoon - tblsp" : volume();                         break;
                    case "Teaspoon - tsp" : volume();                         break;
                    case "Cubic mile - mi^3" : volume();                         break;
                    case "Cubic yard - yd^3" : volume();                         break;
                    case "Cubic foot - ft^3" : volume();                         break;
                    case "Cubic inch - in^3" : volume();                         break;
                    case "Cubic decimeter - dm^3" : volume();                         break;
                    case "Exaliter - EL" : volume();                         break;
                    case "Petaliter - PL" : volume();                         break;
                    case "Teraliter - TL" : volume();                         break;
                    case "Gigaliter - GL" : volume();                         break;
                    case "Megaliter - ML" : volume();                         break;
                    case "Kiloliter - kL" : volume();                         break;
                    case "Hectoliter - hL" : volume();                         break;
                    case "Dekaliter - daL" : volume();                         break;
                    case "Deciliter - dL" : volume();                         break;
                    case "Centiliter - cL" : volume();                         break;
                    case "Microliter - µL" : volume();                         break;
                    case "Nanoliter - nL" : volume();                         break;
                    case "Picoliter - pL" : volume();                         break;
                    case "Femtoliter - fL" : volume();                         break;
                    case "Attoliter - aL" : volume();                         break;
                    case "Cc - cc" : volume();                         break;
                    case "Drop - drop" : volume();                         break;
                    case "Barrel(oil) - bbl" : volume();                         break;
                    case "Barrel(US) - bbl" : volume();                         break;
                    case "Barrel(UK) - bbl" : volume();                         break;
                    case "Gallon - gallon" : volume();                         break;
                    case "Quart(UK) - qt" : volume();                         break;
                    case "Pint(UK) - pt" : volume();                         break;
                    case "Cup(Metric) - cup" : volume();                         break;
                    case "Cup(UK) - cup" : volume();                         break;
                    case "Fluid ounce(US) - fl oz" : volume();                         break;
                    case "Fluid ounce(UK) - fl oz" : volume();                         break;
                    case "Tablespoon(Metric) - tblsp" : volume();                         break;
                    case "Tablespoon(UK) - tblsp" : volume();                         break;
                    case "Dessertspoon(US) - dsp" : volume();                         break;
                    case "Dessertspoon(UK) - dsp" : volume();                         break;
                    case "Teaspoon(Metric) - tsp" : volume();                         break;
                    case "Teaspoon(UK) - tsp" : volume();                         break;
                    case "Gill(US)  - gi" : volume();                         break;
                    case "Gill(UK)  - gi" : volume();                         break;
                    case "Minim(US)  - min" : volume();                         break;
                    case "Minim(UK)  - min" : volume();                         break;
                    case "Ton register - ton reg" : volume();                         break;
                    case "Ccf  - ccf" : volume();                         break;
                    case "Hundred-cubic foot - 100 ft^3" : volume();                         break;
                    case "Acre-foot - ac*ft" : volume();                         break;
                    case "Acre-foot(US)  - ac*ft" : volume();                         break;
                    case "Acre-inch - ac*in" : volume();                         break;
                    case "Dekastere  - daSt" : volume();                         break;
                    case "Stere  - st" : volume();                         break;
                    case "Decistere  - dSt" : volume();                         break;
                    case "Cord  - cd" : volume();                         break;
                    case "Tun  - tun" : volume();                         break;
                    case "Hogshead  - hogshead" : volume();                         break;
                    case "Board foot  - bft" : volume();                         break;
                    case "Dram  - dr" : volume();                         break;
                    case "Cor(Biblical) - cor" : volume();                         break;
                    case "Homer(Biblical) - homer" : volume();                         break;
                    case "Bath(Biblical) - bath" : volume();                         break;
                    case "Hin(Biblical) - hin" : volume();                         break;
                    case "Cab(Biblical) - cab" : volume();                   break;
                    case "Log(Biblical) - log" : volume();                         break;
                    case "Taza(Spanish) - taza" : volume();                         break;
                    case "Earth's volume - earth"  : volume();                         break;
                    //temperture
                    case "Celsius - °C":
                        temperture();
                        break;
                    case "Fahrenheit - °F":
                        temperture();
                        break;
                    case "Kelvin - °K":
                        temperture();
                        break;
                    case "Rankine - °R":
                        temperture();
                        break;
                    case "Newton - °N":
                        temperture();
                        break;
                    case "Reaumur - °Ré":
                        temperture();
                        break;
                    case "Romer - °Rø":
                        temperture();
                        break;
                    case "Delisle - °D":
                        temperture();
                        break;


                    //area
                    case "Square Meter -  m²": area();  break;
                    case "Square Kilometer - km²": area();  break;
                    case "Square Centimeter - cm²": area();  break;
                    case "Square Millimeter -  mm²": area();  break;
                    case "Hectares - ha": area();  break;
                    case "Acre - ac": area();  break;
                    case "Square Mile -  mi²": area();  break;
                    case "Square Yard - yd²": area();  break;
                    case "Square Foot - ft²": area();  break;
                    case "Square Inch - in²": area();  break;

                    case "Square Micrometer -  μm²": area();  break;
                    case "Square Hectometer - hm²": area();  break;
                    case "Square Dekameter - dam²": area();  break;
                    case "Square Decimeter -  dm²": area();  break;
                    case "Nanometer - nm²": area();  break;
                    case "Are - a": area();  break;
                    case "Barn -  b": area();  break;
                    case "Square Mile (US survey)": area();  break;
                    case "Square Foot (US survey)": area();  break;
                    case "Circular Inch ": area();  break;

                    case "Township": area();  break;
                    case "Section": area();  break;
                    case "Acre(US survey) - ac": area();  break;
                    case "Rood": area();  break;
                    case "Square Chain - ch²": area();  break;
                    case "Square rod": area();  break;
                    case "Square rod (US survey)": area();  break;
                    case "Square Perch ": area();  break;
                    case "Square Pole ": area();  break;
                    case "Square Mil - mil² ": area();  break;

                    case "Cirular Mil": area();  break;
                    case "Homestead": area();  break;
                    case "Sabin": area();  break;
                    case "Arpent": area();  break;
                    case "Cuerda": area();  break;
                    case "Plaza": area();  break;
                    case "Varas Castellanas Cuad": area();  break;
                    case "Varas Conuqueras Cuad": area();  break;
                    case "Electron Cross Section ": area();  break;

                    //pressure
                    case "Pascal - Pa": pressure();  break;
                    case "Kilopascal - kPa": pressure();  break;
                    case "Bar - b": pressure();  break;
                    case "Psi - psi": pressure();  break;
                    case "Ksi - ksi": pressure();  break;
                    case "Atmosphere - atm": pressure();  break;
                    case "Exapascal - EPa": pressure();  break;
                    case "Petapascal - PPa": pressure();  break;
                    case "Terapascal - TPa": pressure();  break;
                    case "Gigapascal - GPa": pressure();  break;
                    case "Megapascal - MPa": pressure();  break;
                    case "Hectopascal - hPa": pressure();  break;
                    case "Deckapascal - daPa": pressure();  break;
                    case "Decipascal - dPa": pressure();  break;
                    case "Centipascal - cPa": pressure();  break;
                    case "Millipascal - mPa": pressure();  break;
                    case "Micropascal - μPa": pressure();  break;
                    case "Nanopascal - nPa": pressure();  break;
                    case "Picopascal - pPa": pressure();  break;
                    case "Femtopascal - fPa": pressure();  break;
                    case "Attopascal - aPa": pressure();  break;
                    case "Newton/square meter - N/m²": pressure();  break;
                    case "Newton/square centimeter - N/cm²": pressure();  break;
                    case "Newton/square millimeter - N/mm²": pressure();  break;
                    case "Kilonewton/square meter - kN/m²": pressure();  break;
                    case "Millibar - mbar": pressure();  break;
                    case "Microbar - μbar": pressure();  break;
                    case "Dyne/square centimeter - dyn/cm²": pressure();  break;
                    case "Kilogram-energy/square meter - kgf/m²": pressure();  break;
                    case "Kilogram-energy/square cm - kgf/cm²": pressure();  break;
                    case "Kilogram-energy/square mm - kgf/mm²": pressure();  break;
                    case "Gram-energy/square cm - gf/cm²": pressure();  break;
                    case "Ton-energy(short)/sq. foot - tonf/ft²": pressure();  break;
                    case "Ton-energy(short)/sq. inch - tonf/in²": pressure();  break;
                    case "Ton-energy(long)/sq. foot - tonf/ft²": pressure();  break;
                    case "Ton-energy(long)/sq. inch - tonf/in²": pressure();  break;
                    case "Kip-energy/square inch - kipf/in²": pressure();  break;
                    case "Pound-energy/square foot - lbf/ft²": pressure();  break;
                    case "Pound-energy/square inch - lbf/in²": pressure();  break;
                    case "Poundal/square foot - pdl/ft²": pressure();  break;
                    case "Torr - torr": pressure();  break;
                    case "Centimeter mercury(0°C) - cmHg": pressure();  break;
                    case "Millimeter mercury(0°C) - mmHg": pressure();  break;
                    case "Inch mercury(32°F) - inHg": pressure();  break;
                    case "Centimeter water(4°C) - cmAq": pressure();  break;
                    case "Millimeter water(4°C) - mmAq": pressure();  break;
                    case "Inch water(4°C) - inAq": pressure();  break;
                    case "Foot water(4°C) - ftAq": pressure();  break;
                    case "Inch water(60°C) - inAq": pressure();  break;
                    case "Foot water(60°C) - ftAq": pressure();  break;
                    case "Atmosphere technical - at": pressure();  break;

                    //energy
                    case "Joule - J" : energy(); break;
                    case "Kilo joule - kJ" : energy(); break;
                    case "Kilo-watt hour - kW*h" : energy(); break;
                    case "Watt-hour - W*h" : energy(); break;
                    case "Calorie (nutritional) - cal(nutritional)" : energy(); break;
                    case "Horsepower (metric) hour - hp*h" : energy(); break;
                    case "Btu(IT) - btu(IT),Btu" : energy(); break;
                    case "Btu(th) - btu(th)" : energy(); break;
                    case "Giga joule - GJ" : energy(); break;
                    case "Mega joule - MJ" : energy(); break;
                    case "Milli joule - mJ" : energy(); break;
                    case "Micro joule - μj" : energy(); break;
                    case "Nano joule - nJ" : energy(); break;
                    case "Atto joule - aJ" : energy(); break;
                    case "Mega electron-volt - MeV" : energy(); break;
                    case "Kilo electron-volt - KeV" : energy(); break;
                    case "Electron-volt - eV" : energy(); break;
                    case "Erg - erg" : energy(); break;
                    case "Giga watt-hour - GW*h" : energy(); break;
                    case "Mega watt-hour - MW*h" : energy(); break;
                    case "Kilo watt-second - kW*s" : energy(); break;
                    case "Watt-second - W*s" : energy(); break;
                    case "Newton meter - N*m" : energy(); break;
                    case "Horse power hour - hp*h" : energy(); break;
                    case "Kilo calorie(IT) - kcal(IT)" : energy(); break;
                    case "Kilo calorie(th) - kcal(th)" : energy(); break;
                    case "Calorie(IT) - cal(IT),cal" : energy(); break;
                    case "Calorie(th) - cal(th)" : energy(); break;
                    case "Mega Btu (IT) - MBtu(IT)" : energy(); break;
                    case "Ton-hour (refrigeration) - ton*h" : energy(); break;
                    case "Fuel oil equivalent @kiloliter - kl" : energy(); break;
                    case "Fuel oil equivalent @barrel (US)  - bbl" : energy(); break;
                    case "Giga ton - Gton" : energy(); break;
                    case "Mega ton - Mton" : energy(); break;
                    case "Kilo ton - kton" : energy(); break;
                    case "Ton (explosives) - ton" : energy(); break;
                    case "Dyne centimeter - dyn*cm" : energy(); break;
                    case "Gram-energy meter - gf*m" : energy(); break;
                    case "Gram-energy centimeter - gf*cm" : energy(); break;
                    case "Kilogram-energy centimeter - kgf*cm" : energy(); break;
                    case "Kilogram-energy meter - kgf*m" : energy(); break;
                    case "Kilo pond meter - kp*m" : energy(); break;
                    case "Pound-energy foot - lbf*ft" : energy(); break;
                    case "Pound-energy inch - lbf*in" : energy(); break;
                    case "Ounce-energy inch - ozf*in" : energy(); break;
                    case "Foot-pound - ft*lbf" : energy(); break;
                    case "Inch-pound - in*lbf" : energy(); break;
                    case "Inch-ounce - in*ozf" : energy(); break;
                    case "Poundal foot - pdl*ft" : energy(); break;
                    case "Therm - therm" : energy(); break;
                    case "Therm(EC) - therm" : energy(); break;
                    case "Therm(US) - therm" : energy(); break;
                    case "Hartree energy - He" : energy(); break;
                    case "Rydberg constant - Rc" : energy(); break;

                    //power
                    case "Watt -W": power(); break;
                    case "Exawatt -EW": power(); break;
                    case "Petawatt -PW": power(); break;
                    case "Terawatt -TW": power(); break;
                    case "Gigawatt -GW": power(); break;
                    case "Megawatt -MW": power(); break;
                    case "Kilowatt -kW": power(); break;
                    case "Hectowatt -hW": power(); break;
                    case "Dekawatt -daW": power(); break;
                    case "Deciwatt -dW": power(); break;
                    case "Centiwatt -cW": power(); break;
                    case "Milliwatt -mW": power(); break;
                    case "Microwatt -μW": power(); break;
                    case "Nanowatt -nW": power(); break;
                    case "Picowatt -pW": power(); break;
                    case "Femtowatt -fW": power(); break;
                    case "Attowatt -aW": power(); break;
                    case "Horsepower -hp,hp(UK)": power(); break;
                    case "Horsepower (550 ft*lbf/s) -hp,hp(UK)": power(); break;
                    case "Horsepower (metric) -hp(metric)": power(); break;
                    case "Horsepower (boiler) -hp(boiler)": power(); break;
                    case "Horsepower (electric) -hp(electric)": power(); break;
                    case "Horsepower (water) -hp(water)": power(); break;
                    case "Pferdestarke (ps) -ps": power(); break;
                    case "Btu (IT)/hour -Btu/h": power(); break;
                    case "Btu (IT)/minute -Btu/min": power(); break;
                    case "Btu (IT)/second -Btu/s": power(); break;
                    case "Btu (th)/hour -Btu(th)/h": power(); break;
                    case "Btu (th)/minute -Btu(th)/min": power(); break;
                    case "Btu (th)/second -Btu(th)/s": power(); break;
                    case "MBtu (IT)/hour -MBtu/h": power(); break;
                    case "MBH -MBH": power(); break;
                    case "Ton (refrigeration) -ton": power(); break;
                    case "Kilocalorie (IT)/hour -kcal/h": power(); break;
                    case "Kilocalorie (IT)/minute -kcal/min": power(); break;
                    case "Kilocalorie (IT)/second -kcal/s": power(); break;
                    case "Kilocalorie (th)/hour -kcal(th)/h": power(); break;
                    case "Kilocalorie (th)/minute -kcal(th)/min": power(); break;
                    case "Kilocalorie (th)/second -kcal(th)/s": power(); break;
                    case "Calorie (IT)/hour -cal/h": power(); break;
                    case "Calorie (IT)/minute -cal/min": power(); break;
                    case "Calorie (IT)/second -cal/s": power(); break;
                    case "Calorie (th)/hour -cal(th)/h": power(); break;
                    case "Calorie (th)/minute -cal(th)/min": power(); break;
                    case "Calorie (th)/second -cal(th)/s": power(); break;
                    case "Foot pound-force/hour -lbf*ft/h": power(); break;
                    case "Foot pound-force/minute -lbf*ft/min": power(); break;
                    case "Foot pound-force/second -lbf*ft/s": power(); break;
                    case "Pound-foot/hour -lbf*ft/h": power(); break;
                    case "Pound-foot/minute -lbf*ft/min": power(); break;
                    case "Pound-foot/second -lbf*ft/s": power(); break;
                    case "Erg/second -erg/s": power(); break;
                    case "Kilovolt ampere -kV*A": power(); break;
                    case "Volt ampere -V*A": power(); break;
                    case "Newton meter/second -N*m/s": power(); break;
                    case "Joule/second -J/s": power(); break;
                    case "Exajoule/second -EJ/s" : power(); break;
                    case "Petajoule/second -PJ/s" : power(); break;
                    case "Terajoule/second -TJ/s" : power(); break;
                    case "Gigajoule/second -GJ/s" : power(); break;
                    case "Megajoule/second -MJ/s" : power(); break;
                    case "Kilojoule/second -kJ/s" : power(); break;
                    case "Hectojoule/second -hJ/s" : power(); break;
                    case "Dekajoule/second -daJ/s" : power(); break;
                    case "Decijoule/second -dJ/s" : power(); break;
                    case "Centijoule/second -CJ/s" : power(); break;
                    case "Millijoule/second -mJ/s" : power(); break;
                    case "Microjoule/second -μJ/s" : power(); break;
                    case "Nanojoule/second -nJ/s" : power(); break;
                    case "Picojoule/second -pJ/S" : power(); break;
                    case "Femtojoule/second -fJ/s" : power(); break;
                    case "Attojoule/second -aJ/s" : power(); break;
                    case "Joule/hour -J/h" : power(); break;
                    case "Joule/minute -J/min" : power(); break;
                    case "Kilojoule/hour -kJ/h" : power(); break;
                    case "Kilojoule/minute -kJ/min" : power(); break;

                    //force
                    case "Newton - N" : force(); break;
                    case "Kilonewton - kN" : force(); break;
                    case "Gram-force - gf" : force(); break;
                    case "Kilogram-force - kgf" : force(); break;
                    case "Ton-force(metric) - tf" : force(); break;
                    case "Exanewton - EN" : force(); break;
                    case "Petanewton - PT" : force(); break;
                    case "Teranewton - TN" : force(); break;
                    case "Giganewton - GN" : force(); break;
                    case "Meganewton - MN" : force(); break;
                    case "Hectonewton - hN" : force(); break;
                    case "Dekanewton - daN" : force(); break;
                    case "Decinewton - dN" : force(); break;
                    case "Centinewton - cN" : force(); break;
                    case "Milinewton - mN" : force(); break;
                    case "Micronewton - μN" : force(); break;
                    case "Nanonewton - nN" : force(); break;
                    case "Piconewton - pN" : force(); break;
                    case "Femtonewton - fN" : force(); break;
                    case "Attonewton - aN" : force(); break;
                    case "Dyne - dyn" : force(); break;
                    case "Joule/meter - J/m" : force(); break;
                    case "Joule/centimeter - J/cm" : force(); break;
                    case "Ton-force(short) - tonf" : force(); break;
                    case "Ton-force(long) - tonf" : force(); break;
                    case "Kip-force - kipf" : force(); break;
                    case "Kilopound-force- kipf" : force(); break;
                    case "Pound-force - lbf" : force(); break;
                    case "Ounce-force - ozf" : force(); break;
                    case "Poundal - pdl(force)" : force(); break;
                    case "Pound foot/square second - lb*ft/sec²" : force(); break;
                    case "Pond - p" : force(); break;
                    case "Kilopond - kp" : force(); break;

                    //time
                    case "Second - s" : time(); break;
                    case "Millisecond - ms" : time(); break;
                    case "Minute - min" : time(); break;
                    case "Hour - h" : time(); break;
                    case "Day - d" : time(); break;
                    case "Week - week" : time(); break;
                    case "Month - month" : time(); break;
                    case "Year - y" : time(); break;
                    case "Decade - decade" : time(); break;
                    case "Century - century" : time(); break;
                    case "Millenium - millenium" : time(); break;
                    case "Microsecond - μs" : time(); break;
                    case "Nanosecond - ns" : time(); break;
                    case "Picosecond - ps" : time(); break;
                    case "Femtosecond - fs" : time(); break;
                    case "Attosecond - as" : time(); break;
                    case "Shake - shake" : time(); break;
                    case "Month(Synodic) - month" : time(); break;
                    case "Year(Julian) - y" : time(); break;
                    case "Year(leap) - y" : time(); break;
                    case "Year(tropical) - y" : time(); break;
                    case "Year(sidereal) - y" : time(); break;
                    case "Day(sidereal) - d" : time(); break;
                    case "Hour(sidereal) - h" : time(); break;
                    case "Minute(sidereal) - min" : time(); break;
                    case "Second(sidereal) - s" : time(); break;
                    case "Fortnight - f" : time(); break;
                    case "Septennial - s" : time(); break;
                    case "Octennial - o" : time(); break;
                    case "Novennial - n" : time(); break;
                    case "Quindecennial - q" : time(); break;
                    case "Quinquennial - q" : time(); break;
                    case "Plank time - pt" : time(); break;

                    //speed
                    case "Meter/second - m/s" : speed(); break;
                    case "Kilometer/hour - km/h" : speed(); break;
                    case "Mile/hour - mi/h" : speed(); break;
                    case "Meter/hour - m/h" : speed(); break;
                    case "Meter/minute - m/min" : speed(); break;
                    case "Kilometer/minute - km/min" : speed(); break;
                    case "Kilometer/second - km/s" : speed(); break;
                    case "Centimeter/hour - cm/h" : speed(); break;
                    case "Centimeter/minute - cm/min" : speed(); break;
                    case "Centimeter/second - cm/s" : speed(); break;
                    case "Millimeter/hour - mm/h" : speed(); break;
                    case "Millimeter/minute - mm/min" : speed(); break;
                    case "Millimeter/second - mm/s" : speed(); break;
                    case "Foot/hour - ft/h" : speed(); break;
                    case "Foot/minute - ft/min" : speed(); break;
                    case "Foot/second - ft/s" : speed(); break;
                    case "Yard/hour - yd/h" : speed(); break;
                    case "Yard/minute - yd/min" : speed(); break;
                    case "Yard/second - yd/s" : speed(); break;
                    case "Mile/minute - mi/min" : speed(); break;
                    case "Mile/second - mi/s" : speed(); break;
                    case "Knot - knots" : speed(); break;
                    case "Knot (UK) - knots(UK)" : speed(); break;
                    case "Velocity of light in vacuum - c" : speed(); break;
                    case "Cosmic velocity - first - hom" : speed(); break;
                    case "Cosmic velocity - second - cosmic" : speed(); break;
                    case "Cosmic velocity - third - cosmic" : speed(); break;
                    case "Earth's velocity - earth" : speed(); break;
                    case "Velocity of sound in pure water - sound" : speed(); break;
                    case "Velocity of sound in sea water - sound" : speed(); break;
                    case "Mach - mach" : speed(); break;
                    case "Mach (SI standard) - mach" : speed(); break;

                    //angle
                    case "Degree - °" : angle(); break;
                    case "Radian - rad" : angle(); break;
                    case "Grad - ^g" : angle(); break;
                    case "Minute - '" : angle(); break;
                    case "Second -  ″ " : angle(); break;
                    case "Gon - gon" : angle(); break;
                    case "Sign - sign" : angle(); break;
                    case "Mil - mil" : angle(); break;
                    case "Revolution - r" : angle(); break;
                    case "Circle - ∅" : angle(); break;
                    case "Turn - turn" : angle(); break;
                    case "Quadrant - 90°" : angle(); break;
                    case "Right angle - 90°" : angle(); break;
                    case "Sextant - 60°" : angle(); break;

                    //fuel
                    case "Meter/liter - m/L" : fuel(); break;
                    case "Exameter/liter - Em/L" : fuel(); break;
                    case "Petameter/liter - Pm/L" : fuel(); break;
                    case "Terameter/liter - Tm/L" : fuel(); break;
                    case "Gigameter/liter - Gm/L" : fuel(); break;
                    case "Megameter/liter - Mm/L" : fuel(); break;
                    case "Kilometer/liter - km/L" : fuel(); break;
                    case "Hectometer/liter - hm/L" : fuel(); break;
                    case "Dekameter/liter - dam/L" : fuel(); break;
                    case "Centimeter/liter - cm/L" : fuel(); break;
                    case "Mile(US)/liter - mi/L" : fuel(); break;
                    case "Nautical mile/liter - n.mile/L" : fuel(); break;
                    case "Nautical mile/gallon(US)  - n.mile/gallon" : fuel(); break;
                    case "Kilometer/gallon - km/gallon" : fuel(); break;
                    case "Meter/gallon(US) - m/gallon" : fuel(); break;
                    case "Meter/gallon(UK) - m/gallon" : fuel(); break;
                    case "Mile/gallon(US) - mi/gallon" : fuel(); break;
                    case "Mile/gallon(UK) - mi/gallon" : fuel(); break;
                    case "Meter/cubic meter - m/m^3" : fuel(); break;
                    case "Meter/cubic centimeter - m/cm^3" : fuel(); break;
                    case "Meter/cubic yard - m/yd^3" : fuel(); break;
                    case "Meter/cubic foot - m/ft^3" : fuel(); break;
                    case "Meter/cubic inch - m/in^3" : fuel(); break;
                    case "Meter/quart(US) - m/q" : fuel(); break;
                    case "Meter/quart(UK) - m/q" : fuel(); break;
                    case "Meter/pint(US) - m/pt" : fuel(); break;
                    case "Meter/pint(UK) - m/pt" : fuel(); break;
                    case "Meter/cup(US) - m/cup" : fuel(); break;
                    case "Meter/cup(UK) - m/cup" : fuel(); break;
                    case "Meter/fluid ounce(US) - m/floz" : fuel(); break;
                    case "Meter/fluid ounce(UK) - m/floz" : fuel(); break;
                    case "Liter/meter - L/m" : fuel(); break;
                    case "Liter/100 km - L/100 km" : fuel(); break;
                    case "Gallon(US)/mile - gallon/mi" : fuel(); break;
                    case "Gallon(US)/100 mile - gallon/100 mi" : fuel(); break;
                    case "Gallon(UK)/mile - gallon/mi" : fuel(); break;
                    case "Gallon(UK)/100 mile - gallon/100 mi" : fuel(); break;

                    //datastorage

                    case "Bit - b" : datastorage(); break;
                    case "Nibble - n" : datastorage(); break;
                    case "Byte - B" : datastorage(); break;
                    case "Character - ch" : datastorage(); break;
                    case "Word - w" : datastorage(); break;
                    case "MAPM-word - w" : datastorage(); break;
                    case "Quadruple-word - w" : datastorage(); break;
                    case "Block - blk" : datastorage(); break;
                    case "Kilobit - kb" : datastorage(); break;
                    case "Kilobyte - kB" : datastorage(); break;
                    case "Kilobyte (10^3 bytes) - kB" : datastorage(); break;
                    case "Megabit - Mb" : datastorage(); break;
                    case "Megabyte - MB" : datastorage(); break;
                    case "Megabyte (10^6 bytes) - MB" : datastorage(); break;
                    case "Gigabit - Gb" : datastorage(); break;
                    case "Gigabyte - GB" : datastorage(); break;
                    case "Gigabyte (10^9 bytes) - GB" : datastorage(); break;
                    case "Terabit - Tb" : datastorage(); break;
                    case "Terabyte - TB" : datastorage(); break;
                    case "Terabyte (10^12 bytes) - TB" : datastorage(); break;
                    case "Petabit - Pb" : datastorage(); break;
                    case "Petabyte - PB" : datastorage(); break;
                    case "Petabyte (10^15 bytes) - PB" : datastorage(); break;
                    case "Exabit - Eb" : datastorage(); break;
                    case "Exabyte - EB" : datastorage(); break;
                    case "Exabyte (10^18 bytes) - EB" : datastorage(); break;
                    case "Floppy disk (3.5″, DD) - floppy" : datastorage(); break;
                    case "Floppy disk (3.5″, HD) - floppy" : datastorage(); break;
                    case "Floppy disk (3.5″, ED) - floppy" : datastorage(); break;
                    case "Floppy disk (5.25″, DD) - floppy" : datastorage(); break;
                    case "Floppy disk (5.25″, HD) - floppy" : datastorage(); break;
                    case "Zip 100 - Zip" : datastorage(); break;
                    case "Zip 250 - Zip" : datastorage(); break;
                    case "Jaz 1GB - Jaz" : datastorage(); break;
                    case "Jaz 2GB - Jaz" : datastorage(); break;
                    case "CD (74 minute) - CD" : datastorage(); break;
                    case "CD (80 minute) - CD" : datastorage(); break;
                    case "DVD (1 layer, 1 side) - DVD" : datastorage(); break;
                    case "DVD (2 layer, 1 side) - DVD" : datastorage(); break;
                    case "DVD (1 layer, 2 side) - DVD" : datastorage(); break;
                    case "DVD (2 layer, 2 side) - DVD" : datastorage(); break;

                    //volumedry
                    case "Liter(volume) - L" : volumedry(); break;
                    case "Barrel dry(US) - bbl dry" : volumedry(); break;
                    case "Pint dry(US) - pt dry" : volumedry(); break;
                    case "Quart dry(US) - qt dry" : volumedry(); break;
                    case "Peck dry(US) - pk" : volumedry(); break;
                    case "Peck dry(UK) - pk" : volumedry(); break;
                    case "Bushel(US) - bu" : volumedry(); break;
                    case "Bushel(UK) - bu" : volumedry(); break;
                    case "Cor(Biblical volume) - cor" : volumedry(); break;
                    case "Homer(Biblical volume) - homer" : volumedry(); break;
                    case "Ephah(Biblical) - ephah" : volumedry(); break;
                    case "Seah(Biblical volume) - seah" : volumedry(); break;
                    case "Omer(Biblical volume) - omer" : volumedry(); break;
                    case "Cab(Biblical volume) - cab" : volumedry(); break;
                    case "Log(Biblical volume) - log" : volumedry(); break;


                    //velocity angular
                    case "Meter/square second -m/s^2" : accleration(); break;
                    case "Decimeter/square second -deci/s^2" : accleration(); break;
                    case "Kilometer/square second -km/s^2" : accleration(); break;
                    case "Hectometer/square second -hec/s^2" : accleration(); break;
                    case "Dekameter/square second -deka/s^2" : accleration(); break;
                    case "Centimeter/square second -cm/s^2" : accleration(); break;
                    case "Millimeter/square second -mm/s^2" : accleration(); break;
                    case "Micrometer/square second -μm/s^2" : accleration(); break;
                    case "Nanometer/square second -nano/s^2" : accleration(); break;
                    case "Picometer/square second -pico/s^2" : accleration(); break;
                    case "Femtometer/square second -fem/s^2" : accleration(); break;
                    case "Attometer/square second -A/s^2" : accleration(); break;
                    case "Gal -Gal" : accleration(); break;
                    case "Galileo -Gal" : accleration(); break;
                    case "Mile/square second -mi/s^2" : accleration(); break;
                    case "Yard/square second -yd/s^2" : accleration(); break;
                    case "Foot/square second -ft/s^2" : accleration(); break;
                    case "Inch/square second -in/s^2" : accleration(); break;
                    case "Acceleration of gravity -g" : accleration(); break;

                    //velocity angular
                    case "Radian/second -rad/s" : velocityangular(); break;
                    case "Radian/day -rad/d" : velocityangular(); break;
                    case "Radian/hour -rad/h" : velocityangular(); break;
                    case "Radian/minute -rad/min" : velocityangular(); break;
                    case "Degree/day -°/d" : velocityangular(); break;
                    case "Degree/hour -°/h" : velocityangular(); break;
                    case "Degree/minute -°/min" : velocityangular(); break;
                    case "Degree/second -°/s" : velocityangular(); break;
                    case "Revolution/day -r/d" : velocityangular(); break;
                    case "Revolution/hour -r/h" : velocityangular(); break;
                    case "Revolution/minute -r/min" : velocityangular(); break;
                    case "Revolution/second -r/s" : velocityangular(); break;

                    //accelerationangular
                    case "Radian/square second -rad/s^2" : accelerationangular(); break;
                    case "Radian/square minute -rad/min^2" : accelerationangular(); break;
                    case "Revolution/square second -r/s^2" : accelerationangular(); break;
                    case "Revolution/minute/second -r/min/s" : accelerationangular(); break;
                    case "Revolution/square minute -r/min^2" : accelerationangular(); break;

                    //density
                    case "Kilogram/cubic meter -kg/m^3" : density(); break;
                    case "Gram/cubic centimeter -g/cm^3,g/cc" : density(); break;
                    case "Kilogram/cubic centimeter -kg/cm^3" : density(); break;
                    case "Gram/cubic meter -g/m^3" : density(); break;
                    case "Gram/cubic millimeter -g/mm^3" : density(); break;
                    case "Milligram/cubic meter -mg/m^3" : density(); break;
                    case "Milligram/cubic centimeter -mg/cm^3" : density(); break;
                    case "Milligram/cubic millimeter -mg/mm^3" : density(); break;
                    case "Exagram/liter -Eg/L" : density(); break;
                    case "Petagram/liter -Pg/L" : density(); break;
                    case "Teragram/liter -Tg/L" : density(); break;
                    case "Gigagram/liter -Gg/L" : density(); break;
                    case "Megagram/liter -Mg/L" : density(); break;
                    case "Kilogram/liter -kg/L" : density(); break;
                    case "Hectogram/liter -hg/L" : density(); break;
                    case "Dekagram/liter -dag/L" : density(); break;
                    case "Gram/liter -g/L" : density(); break;
                    case "Decigram/liter -dg/L" : density(); break;
                    case "Centigram/liter -cg/L" : density(); break;
                    case "Milligram/liter -mg/L" : density(); break;
                    case "Microgram/liter -μg/L" : density(); break;
                    case "Nanogram/liter -ng/L" : density(); break;
                    case "Picogram/liter -pg/L" : density(); break;
                    case "Femtogram/liter -fg/L" : density(); break;
                    case "Attogram/liter -ag/L" : density(); break;
                    case "Pound/cubic inch -lb/in^3" : density(); break;
                    case "Pound/cubic foot -lb/ft^3" : density(); break;
                    case "Pound/cubic yard -lb/yd^3" : density(); break;
                    case "Pound/gallon (US) -lb/gal(US)" : density(); break;
                    case "Pound/gallon (UK) -lb/gal(UK)" : density(); break;
                    case "Ounce/cubic inch -oz/in^3" : density(); break;
                    case "Ounce/cubic foot -oz/ft^3" : density(); break;
                    case "Ounce/gallon (US) -oz/gal(US)" : density(); break;
                    case "Ounce/gallon (UK) -oz/gal(UK)" : density(); break;
                    case "Grain/gallon (US) -gr/gal(US)" : density(); break;
                    case "Grain/gallon (UK) -gr/gal(UK)" : density(); break;
                    case "Grain/cubic foot -gr/ft^3" : density(); break;
                    case "Ton (short)/cubic yard -ton/yd^3" : density(); break;
                    case "Ton (long)/cubic yard -ton/yd^3" : density(); break;
                    case "Slug/cubic foot -slug/ft^3" : density(); break;
                    case "Psi/1000 feet -psi/ft" : density(); break;
                    case "Earth's density (mean) -earth" : density(); break;

                    //specific volume
                    case "Cubic meter/kilogram -M^3/kg" : specificvolume(); break;
                    case "Cubic centimeter/gram -cm^3/g" : specificvolume(); break;
                    case "Liter/kilogram -L/kg" : specificvolume(); break;
                    case "Liter/gram -L/g" : specificvolume(); break;
                    case "Cubic foot/kilogram -ft^3/kg" : specificvolume(); break;
                    case "Cubic foot/pound -ft^3/lb" : specificvolume(); break;
                    case "Gallon (US)/pound -gal(US)" : specificvolume(); break;
                    case "Gallon (UK)/pound -gal(UK)" : specificvolume(); break;

                    //momentofintertia
                    case "Kilogram square meter -kg*M^2" : momentofinertia(); break;
                    case "Kilogram square centimeter -kg*cm^2" : momentofinertia(); break;
                    case "Kilogram square millimeter -kg*mm^2" : momentofinertia(); break;
                    case "Gram square centimeter -g*cm^2" : momentofinertia(); break;


                    //moment of force
                    case "Newton meter -N*m" : momentofforce(); break;
                    case "Kilonewton meter -kN*m" : momentofforce(); break;
                    case "Millinewton meter -mN*m" : momentofforce(); break;
                    case "Micronewton meter -μN*m" : momentofforce(); break;

                    //torque
                    case "Newton meter(torque) -N*m" : torque(); break;
                    case "Newton centimeter -N*cm" : torque(); break;
                    case "Newton millimeter -N*mm" : torque(); break;
                    case "Kilonewton meter(torque) -kN*m" : torque(); break;
                    case "Dyne meter -dyn*m" : torque(); break;
                    case "Dyne centimeter -dyn*cm" : torque(); break;
                    case "Dyne millimeter -dyn*mm" : torque(); break;
                    case "Kilogram-force meter -kgf*m" : torque(); break;
                    case "Kilogram-force centimeter -kgf*cm" : torque(); break;
                    case "Kilogram-force millimeter -kgf*mm" : torque(); break;
                    case "Gram-force meter -gf*m" : torque(); break;
                    case "Gram-force centimeter -gf*cm" : torque(); break;
                    case "Gram-force millimeter -gf*mm" : torque(); break;
                    case "Ounce-force foot -ozf*ft" : torque(); break;
                    case "Ounce-force inch -ozf*in" : torque(); break;
                    case "Pound-force foot -lbf*ft" : torque(); break;
                    case "Pound-force inch -lbf*in" : torque(); break;

                    //heat
                    //fueleffiency mass
                    case "Joule/kilogram -J/kg" : fueleffiency(); break;
                    case "Kilojoule/kilogram -kJ/kg" : fueleffiency(); break;
                    case "Calorie (IT)/gram -cal/g" : fueleffiency(); break;
                    case "Calorie (th)/gram -cal(th)/g" : fueleffiency(); break;
                    case "Btu (IT)/pound -Btu/lb" : fueleffiency(); break;
                    case "Btu (th)/pound -Btu(th)/lb" : fueleffiency(); break;
                    case "Kilogram/joule -kg/T" : fueleffiency(); break;
                    case "Kilogram/kilojoule -kg/kJ" : fueleffiency(); break;
                    case "Gram/calorie (IT) -g/cal" : fueleffiency(); break;
                    case "Gram/calorie (th) -g/cal(th)" : fueleffiency(); break;
                    case "Pound/Btu (IT) -lb/Btu" : fueleffiency(); break;
                    case "Pound/Btu (th) -lb/Btu(th)" : fueleffiency(); break;
                    case "Pound/horsepower/hour -lb/hp/h" : fueleffiency(); break;
                    case "Gram/horsepower (metric)/hour -g/hp/h" : fueleffiency(); break;
                    case "Gram/kilowatt/hour -g/kW/h" : fueleffiency(); break;

                    //fuel effiency volume
                    case "Joule/cubic meter -J/m^3" : fueleffiencyvolume(); break;
                    case "Joule/liter -J/L" : fueleffiencyvolume(); break;
                    case "Megajoule/cubic meter -mJ/m^3" : fueleffiencyvolume(); break;
                    case "Kilojoule/cubic meter -kJ/m^3" : fueleffiencyvolume(); break;
                    case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3" : fueleffiencyvolume(); break;
                    case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3" : fueleffiencyvolume(); break;
                    case "Therm/cubic foot -therm/ft^3" : fueleffiencyvolume(); break;
                    case "Therm/gallon (UK) -therm/gal" : fueleffiencyvolume(); break;
                    case "Btu (IT)/cubic foot -Btu/ft^3" : fueleffiencyvolume(); break;
                    case "Btu (th)/cubic foot -Btu (th)/ft^3" : fueleffiencyvolume(); break;
                    case "CHU/cubic foot -CHU/ft^3" : fueleffiencyvolume(); break;
                    case "Cubic meter/joule -m^3/J" : fueleffiencyvolume(); break;
                    case "Liter/joule -L/J" : fueleffiencyvolume(); break;
                    case "Gallon (US)/horsepower -gal(US)/hp" : fueleffiencyvolume(); break;
                    case "Gallon (UK)/horsepower -gal(UK)/hp" : fueleffiencyvolume(); break;

                    //heat density
                    case "Joule/square meter -J/m^2" : heatdensity(); break;
                    case "Calorie (th)/square centimeter -cal(th)/cm^2" : heatdensity(); break;
                    case "Langley -lan" : heatdensity(); break;
                    case "Btu (IT)/square foot -Btu(IT)/ft^2" : heatdensity(); break;
                    case "Btu (th)/square foot -Btu(th)/ft^2" : heatdensity(); break;

                    //haetflux density
                    case "Watt/square meter -W/m^2" : heatfluxdensity(); break;
                    case "Kilowatt/square meter -kW/m^2" : heatfluxdensity(); break;
                    case "Watt/square centimeter -W/cm^2" : heatfluxdensity(); break;
                    case "Watt/square inch -W/in^2" : heatfluxdensity(); break;
                    case "Joule/second/square meter -Js/m^2" : heatfluxdensity(); break;
                    case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2" : heatfluxdensity(); break;
                    case "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/second/square centimeter -cal(th)s/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2" : heatfluxdensity(); break;
                    case "Dyne/hour/centimeter -dynh/cm" : heatfluxdensity(); break;
                    case "Erg/hour/square millimeter -ergh/mm^2" : heatfluxdensity(); break;
                    case "Foot pound/minute/square foot -ftlbmin/ft^2" : heatfluxdensity(); break;
                    case "Horsepower/square foot -hp/ft^2" : heatfluxdensity(); break;
                    case "Horsepower (metric)/square foot -hp/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/second/square foot -Btu(IT)s/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/second/square inch -Btu(th)s/in^2" : heatfluxdensity(); break;
                    case "Btu (th)/second/square foot -Btu(th)s/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/minute/square foot -Btu(th)min/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/hour/square foot -Btu(th)h/ft^2" : heatfluxdensity(); break;
                    case "CHU/hour/square foot -CHUh/ft^2" : heatfluxdensity(); break;

                    //heat transfer
                    case "Watt/square meter/K -W/m^2/K" : heattransfer(); break;
                    case "Watt/square meter/%b0C -W/m^2/%b0C" : heattransfer(); break;
                    case "Joule/second/square meter/K -J/s/m^2/K" : heattransfer(); break;
                    case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C" : heattransfer(); break;
                    case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C" : heattransfer(); break;
                    case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C" : heattransfer(); break;
                    case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F" : heattransfer(); break;
                    case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C" : heattransfer(); break;

                    //specific heat
                    case "Joule/kilogram/K -J/(kg*K)" : specificheat(); break;
                    case "Joule/kilogram/°C -J/(kg*°C)" : specificheat(); break;
                    case "Joule/gram/°C -J/(g*°C)" : specificheat(); break;
                    case "Kilojoule/kilogram/K -kJ/(kg*K)" : specificheat(); break;
                    case "Kilojoule/kilogram/°C -kJ/(kg*°C)" : specificheat(); break;
                    case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)" : specificheat(); break;
                    case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)" : specificheat(); break;
                    case "Calorie (th)/gram/°C -cal(th)/(g*°C)" : specificheat(); break;
                    case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)" : specificheat(); break;
                    case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)" : specificheat(); break;
                    case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)" : specificheat(); break;
                    case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)" : specificheat(); break;
                    case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)" : specificheat(); break;
                    case "Pound-force foot/pound/°R -lbfft/(lb*°R)" : specificheat(); break;
                    case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)" : specificheat(); break;
                    case "Btu (th)/pound/°F -Btu(th)/(lb*°F)" : specificheat(); break;
                    case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)" : specificheat(); break;
                    case "Btu (th)/pound/°R -Btu(th)/(lb*°R)" : specificheat(); break;
                    case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)" : specificheat(); break;
                    case "CHU/pound/°C -CHU/(lb*°C)" : specificheat(); break;

                    //temperture interbval
                    case "Kelvin -K" : tempertureinterval(); break;
                    case "Degree Celsius -°C" : tempertureinterval(); break;
                    case "Degree centigrade -°C" : tempertureinterval(); break;
                    case "Degree Fahrenheit -°F" : tempertureinterval(); break;
                    case "Degree Rankine -°R" : tempertureinterval(); break;
                    case "Degree Reaumur -°r" : tempertureinterval(); break;

                    //thermal conducutivyt
                    case "Watt/meter/K -W/(m*K)" : thermalconducitivity(); break;
                    case "Watt/centimeter/°C -W/(cm*°C)" : thermalconducitivity(); break;
                    case "Kilowatt/meter/K -kW/(m*K)" : thermalconducitivity(); break;
                    case "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)" : thermalconducitivity(); break;
                    case "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)" : thermalconducitivity(); break;
                    case "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)" : thermalconducitivity(); break;
                    case "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)" : thermalconducitivity(); break;
                    case "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)" : thermalconducitivity(); break;

                    //thermal expansion
                    case "Length/length/kelvin -1/K" : thermalexpansion(); break;
                    case "Length/length/degree Celsius -1/°C" : thermalexpansion(); break;
                    case "Length/length/degree Fahrenheit -1/°F" : thermalexpansion(); break;
                    case "Length/length/degree Rankine -1/R°" : thermalexpansion(); break;
                    case "Length/length/degree Reaumur -1/r°" : thermalexpansion(); break;

                    //thermal resistance
                    case "Kelvin/watt -K/W" : thermalresistance(); break;
                    case "Degree Fahrenheit hour/Btu (IT) -°Fh/Btu(IT)" : thermalresistance(); break;
                    case "Degree Fahrenheit hour/Btu (th) -°Fh/Btu(th)" : thermalresistance(); break;
                    case "Degree Fahrenheit second/Btu (IT) -°Fs/Btu(IT)" : thermalresistance(); break;
                    case "Degree Fahrenheit second/Btu (th) -°Fs/Btu(th)" : thermalresistance(); break;

                    //digital image
                    case "Dot/meter -dot/m" : digitalimage(); break;
                    case "Dot/millimeter -dot/mm" : digitalimage(); break;
                    case "Dot/inch -dot/in" : digitalimage(); break;
                    case "Pixel/inch -pixel/in" : digitalimage(); break;

                    //frequency
                    case "Hertz -Hz" : frequency(); break;
                    case "Exahertz -EHz" : frequency(); break;
                    case "Petahertz -PHz" : frequency(); break;
                    case "Terahertz -THz" : frequency(); break;
                    case "Gigahertz -GHz" : frequency(); break;
                    case "Megahertz -MHz" : frequency(); break;
                    case "Kilohertz -kHz" : frequency(); break;
                    case "Hectohertz -hHz" : frequency(); break;
                    case "Dekahertz -daHz" : frequency(); break;
                    case "Decihertz -dHz" : frequency(); break;
                    case "Centihertz -cHz" : frequency(); break;
                    case "Millihertz -mHz" : frequency(); break;
                    case "Microhertz -μHz" : frequency(); break;
                    case "Nanohertz -nHz" : frequency(); break;
                    case "Picohertz -pHz" : frequency(); break;
                    case "Femtohertz -fHz" : frequency(); break;
                    case "Attohertz -aHz" : frequency(); break;
                    case "Cycle/second -c/s" : frequency(); break;
                    case "Wavelength in exametres -Em" : frequency(); break;
                    case "Wavelength in petametres -Pm" : frequency(); break;
                    case "Wavelength in terametres -Tm" : frequency(); break;
                    case "Wavelength in gigametres -Gm" : frequency(); break;
                    case "Wavelength in megametres -Mm" : frequency(); break;
                    case "Wavelength in kilometres -km" : frequency(); break;
                    case "Wavelength in hectometres -hm" : frequency(); break;
                    case "Wavelength in dekametres -dam" : frequency(); break;
                    case "Wavelength in metres -m" : frequency(); break;
                    case "Wavelength in decimetres -dm" : frequency(); break;
                    case "Wavelength in centimetres -cm" : frequency(); break;
                    case "Wavelength in millimetres -mm" : frequency(); break;
                    case "Wavelength in micrometres -μm" : frequency(); break;
                    case "Electron Compton wavelength -e-" : frequency(); break;
                    case "Proton Compton wavelength -p" : frequency(); break;
                    case "Neutron Compton wavelength -n" : frequency(); break;

                    //illumination
                    case "Lux -lx" : illumination(); break;
                    case "Meter-candle -m*c" : illumination(); break;
                    case "Centimeter-candle -cm*c" : illumination(); break;
                    case "Foot-candle -ft*c,fc" : illumination(); break;
                    case "Flame -fl" : illumination(); break;

                    //luminnance
                    case "Candela/square meter -cd/m^2" : luminanace(); break;
                    case "Candela/square centimeter -cd/cm^2" : luminanace(); break;
                    case "Candela/square foot -cd/ft^2" : luminanace(); break;
                    case "Candela/square inch -cd/in^2" : luminanace(); break;
                    case "Kilocandela/square meter -kcd/m^2" : luminanace(); break;
                    case "Stilb -sb" : luminanace(); break;
                    case "Lumen/sq. meter/steradian -l/m^2/srad" : luminanace(); break;
                    case "Lumen/sq. cm/steradian -l/cm^2/srad" : luminanace(); break;
                    case "Lumen/square foot/steradian -l/ft^2/srad" : luminanace(); break;
                    case "Watt/sq. cm/steradian (at 555 nm) -W/cm^2/srad (at 555 nm)" : luminanace(); break;
                    case "Nit -nt" : luminanace(); break;
                    case "Millinit -mnt" : luminanace(); break;
                    case "Lambert -L" : luminanace(); break;
                    case "Millilambert -mL" : luminanace(); break;
                    case "Foot-lambert -fL" : luminanace(); break;
                    case "Apostilb -apo" : luminanace(); break;
                    case "Blondel -blo" : luminanace(); break;
                    case "Bril -br" : luminanace(); break;
                    case "Skot -sk" : luminanace(); break;

                    //luminousintensity
                    case "Candle (international) -cd(international)" : luminousintensity(); break;
                    case "Candle (German) -cd(German)" : luminousintensity(); break;
                    case "Candle (UK) -cd(UK)" : luminousintensity(); break;
                    case "Decimal candle -.cd" : luminousintensity(); break;
                    case "Candle (pentane) -cd(pentane)" : luminousintensity(); break;
                    case "Pentane candle (10 candle power) -pentane cd(10 cd power)" : luminousintensity(); break;
                    case "Hefner candle -he cd" : luminousintensity(); break;
                    case "Carcel unit -car u" : luminousintensity(); break;
                    case "Bougie decimal -bo." : luminousintensity(); break;
                    case "Lumen/steradian -l/srad" : luminousintensity(); break;

                    //fluid
                    //concentration molar
                    case "Mol/cubic meter -mol/m^3" : concentrationmolar(); break;
                    case "Mol/liter -mol/L" : concentrationmolar(); break;
                    case "Mol/cubic centimeter -mol/cm^3" : concentrationmolar(); break;
                    case "Mol/cubic millimeter -mol/mm^3" : concentrationmolar(); break;
                    case "Kilomol/cubic meter -kmol/m^3" : concentrationmolar(); break;
                    case "Kilomol/liter -kmol/L" : concentrationmolar(); break;
                    case "Kilomol/cubic centimeter -kmol/cm^3" : concentrationmolar(); break;
                    case "Kilomol/cubic millimeter -kmol/mm^3" : concentrationmolar(); break;
                    case "Millimol/cubic meter -mmol/m^3" : concentrationmolar(); break;
                    case "Millimol/liter -mmol/L" : concentrationmolar(); break;
                    case "Millimol/cubic centimeter -mmol/cm^3" : concentrationmolar(); break;
                    case "Millimol/cubic millimeter -mmol/mm^3" : concentrationmolar(); break;

                    //concentration solution
                    case "Kilogram/liter(sol) -kg/L" : concentrationsolution(); break;
                    case "Gram/liter(sol) -g/L" : concentrationsolution(); break;
                    case "Milligram/liter(sol) -mg/L" : concentrationsolution(); break;
                    case "Part/million (ppm) -p/m" : concentrationsolution(); break;
                    case "Grain/gallon (US)(sol) -gr/gal(US)" : concentrationsolution(); break;
                    case "Grain/gallon (UK)(sol) -gr/gal(UK)" : concentrationsolution(); break;
                    case "Pound/gallon (US)(sol) -lb/gal(US)" : concentrationsolution(); break;
                    case "Pound/gallon (UK)(sol) -lb/gal(UK)" : concentrationsolution(); break;
                    case "Pound/million gallon (US) -lb/mgal(US)" : concentrationsolution(); break;
                    case "Pound/million gallon (UK) -lb/mgal(UK)" : concentrationsolution(); break;
                    case "Pound/cubic foot(sol) -lb/ft^3" : concentrationsolution(); break;

                    //flow
                    case "Cubic meter/second -m^3/s" : flow(); break;
                    case "Cubic meter/day -m^3/d" : flow(); break;
                    case "Cubic meter/hour -m^3/h" : flow(); break;
                    case "Cubic meter/minute -m^3/min" : flow(); break;
                    case "Cubic centimeter/day -cm^3/d" : flow(); break;
                    case "Cubic centimeter/hour -cm^3/h" : flow(); break;
                    case "Cubic centimeter/minute -cm^3/min" : flow(); break;
                    case "Cubic centimeter/second -cm^3/s" : flow(); break;
                    case "Liter/day -L/d" : flow(); break;
                    case "Liter/hour -L/h" : flow(); break;
                    case "Liter/minute -L/min" : flow(); break;
                    case "Liter/second -L/s" : flow(); break;
                    case "Milliliter/day -mL/d" : flow(); break;
                    case "Milliliter/hour -mL/h" : flow(); break;
                    case "Milliliter/minute -mL/min" : flow(); break;
                    case "Milliliter/second -mL/s" : flow(); break;
                    case "Gallon (US)/day -gal(US)/d" : flow(); break;
                    case "Gallon (US)/hour -gal(US)/h" : flow(); break;
                    case "Gallon (US)/minute -gal(US)/min" : flow(); break;
                    case "Gallon (US)/second -gal(US)/s" : flow(); break;
                    case "Gallon (UK)/day -gal(UK)/d" : flow(); break;
                    case "Gallon (UK)/hour -gal(UK)/h" : flow(); break;
                    case "Gallon (UK)/minute -gal(UK)/min" : flow(); break;
                    case "Gallon (UK)/second -gal(UK)/s" : flow(); break;
                    case "Kilobarrel (US)/day -kbbl(US)/d" : flow(); break;
                    case "Barrel (US)/day -bbl(US)/d" : flow(); break;
                    case "Barrel (US)/hour -bbl(US)/h" : flow(); break;
                    case "Barrel (US)/minute -bbl(US)/min" : flow(); break;
                    case "Barrel (US)/second -bbl(US)/s" : flow(); break;
                    case "Acre-foot/year -ac*ft/y" : flow(); break;
                    case "Acre-foot/day -ac*ft/d" : flow(); break;
                    case "Acre-foot/hour -ac*ft/h" : flow(); break;
                    case "Hundred-cubic foot/day -ft^3/d" : flow(); break;
                    case "Hundred-cubic foot/hour -ft^3/h" : flow(); break;
                    case "Hundred-cubic foot/minute -ft^3/min" : flow(); break;
                    case "Ounce/hour -oz/h" : flow(); break;
                    case "Ounce/minute -oz/min" : flow(); break;
                    case "Ounce/second -oz/s" : flow(); break;
                    case "Ounce (UK)/hour -oz(UK)/h" : flow(); break;
                    case "Ounce (UK)/minute -oz(UK)/min" : flow(); break;
                    case "Ounce (UK)/second -oz(UK)/s" : flow(); break;
                    case "Cubic yard/hour -yd^3/h" : flow(); break;
                    case "Cubic yard/minute -yd^3/min" : flow(); break;
                    case "Cubic yard/second -yd^3/s" : flow(); break;
                    case "Cubic foot/hour -ft^3/h" : flow(); break;
                    case "Cubic foot/minute -ft^3/min" : flow(); break;
                    case "Cubic foot/second -ft^3/s" : flow(); break;
                    case "Cubic inch/hour -in^3/h" : flow(); break;
                    case "Cubic inch/minute -in^3/min" : flow(); break;
                    case "Cubic inch/second -in^3/s" : flow(); break;
                    case "Pound/second (Gasoline at 15.5%b0C) -lb/s" : flow(); break;
                    case "Pound/minute (Gasoline at 15.5%b0C) -lb/min" : flow(); break;
                    case "Pound/hour (Gasoline at 15.5%b0C) -lb/h" : flow(); break;
                    case "Pound/day (Gasoline at 15.5%b0C) -lb/d" : flow(); break;
                    case "Kilogram/second (Gasoline at 15.5%b0C) -kg/s" : flow(); break;
                    case "Kilogram/minute (Gasoline at 15.5%b0C) -kg/min" : flow(); break;
                    case "Kilogram/hour (Gasoline at 15.5%b0C) -kg/h" : flow(); break;
                    case "Kilogram/day (Gasoline at 15.5%b0C) -kg/d" : flow(); break;

                    //flow mass
                    case "Kilogram/second -kg/s" : flowmass(); break;
                    case "Gram/second -g/s" : flowmass(); break;
                    case "Gram/minute -g/min" : flowmass(); break;
                    case "Gram/hour -g/h" : flowmass(); break;
                    case "Gram/day -g/d" : flowmass(); break;
                    case "Milligram/minute -mg/min" : flowmass(); break;
                    case "Milligram/hour -mg/h" : flowmass(); break;
                    case "Milligram/day -mg/d" : flowmass(); break;
                    case "Kilogram/minute -kg/m" : flowmass(); break;
                    case "Kilogram/hour -kg/h" : flowmass(); break;
                    case "Kilogram/day -kg/d" : flowmass(); break;
                    case "Exagram/second -Eg/s" : flowmass(); break;
                    case "Petagram/second -Pg/s" : flowmass(); break;
                    case "Teragram/second -Tg/s" : flowmass(); break;
                    case "Gigagram/second -Gg/s" : flowmass(); break;
                    case "Megagram/second -Mg/s" : flowmass(); break;
                    case "Hectogram/second -hg/s" : flowmass(); break;
                    case "Dekagram/second -dag/s" : flowmass(); break;
                    case "Decigram/second -dg/s" : flowmass(); break;
                    case "Centigram/second -cg/s" : flowmass(); break;
                    case "Milligram/second -mg/s" : flowmass(); break;
                    case "Microgram/second -μg/s" : flowmass(); break;
                    case "Ton (metric)/second -t/s" : flowmass(); break;
                    case "Ton (metric)/minute -t/min" : flowmass(); break;
                    case "Ton (metric)/hour -t/h" : flowmass(); break;
                    case "Ton (metric)/day -t/d" : flowmass(); break;
                    case "Ton (short)/hour -ton(US)/h" : flowmass(); break;
                    case "Pound/second -lb/s" : flowmass(); break;
                    case "Pound/minute -lb/min" : flowmass(); break;
                    case "Pound/hour -lb/h" : flowmass(); break;
                    case "Pound/day -lb/d" : flowmass(); break;

                    //flow molar
                    case "Mol/second -mol/s" : flowmolar(); break;
                    case "Examol/second -Emol/s" : flowmolar(); break;
                    case "Petamol/second -Pmol/s" : flowmolar(); break;
                    case "Teramol/second -Tmol/s" : flowmolar(); break;
                    case "Gigamol/second -Gmol/s" : flowmolar(); break;
                    case "Megamol/second -Mmol/s" : flowmolar(); break;
                    case "Kilomol/second -kmol/s" : flowmolar(); break;
                    case "Hectomol/second -hmol/s" : flowmolar(); break;
                    case "Dekamol/second -damol/s" : flowmolar(); break;
                    case "Decimol/second -dmol/s" : flowmolar(); break;
                    case "Centimol/second -cmol/s" : flowmolar(); break;
                    case "Millimol/second -mmol/s" : flowmolar(); break;
                    case "Micromol/second -μmol/s" : flowmolar(); break;
                    case "Nanomol/second -nmol/s" : flowmolar(); break;
                    case "Picomol/second -pmol/s" : flowmolar(); break;
                    case "Femtomol/second -fmol/s" : flowmolar(); break;
                    case "Attomol/second -amol/s" : flowmolar(); break;
                    case "Mol/minute -mol/min" : flowmolar(); break;
                    case "Mol/hour -mol/h" : flowmolar(); break;
                    case "Mol/day -mol/d" : flowmolar(); break;
                    case "Millimol/minute -mmol/min" : flowmolar(); break;
                    case "Millimol/hour -mmol/h" : flowmolar(); break;
                    case "Millimol/day -mmol/d" : flowmolar(); break;
                    case "Kilomol/minute -kmol/min" : flowmolar(); break;
                    case "Kilomol/hour -kmol/h" : flowmolar(); break;
                    case "Kilomol/day -kmol/d" : flowmolar(); break;

                    //mass flux
                    case "Gram/second/square meter -gs/m^2" : massflux(); break;
                    case "Kilogram/hour/square meter -kgh/m^2" : massflux(); break;
                    case "Kilogram/hour/square foot -kgh/ft^2" : massflux(); break;
                    case "Kilogram/second/square meter -kgs/m^2" : massflux(); break;
                    case "Gram/second/sq. centimeter -gs/cm^2" : massflux(); break;
                    case "Pound/hour/square foot -lbh/ft^2" : massflux(); break;
                    case "Pound/second/square foot -lbs/ft^2" : massflux(); break;

                    case "Kilogram/pascal/second/square meter -kg/Pa/s/m^2" : permeabiltiy(); break;
                    case "Permeability (0°C) -µ (0°C)" : permeabiltiy(); break;
                    case "Permeability (23°C) -µ (23°C)" : permeabiltiy(); break;
                    case "Permeability inches (0°C) -µ in(0°C)" : permeabiltiy(); break;
                    case "Permeability inches (23°C) -µ in(23°C)" : permeabiltiy(); break;

                    //surface tension
                    case "Newton/meter -N/m" : surfacetension(); break;
                    case "Millinewton/meter -mN/m" : surfacetension(); break;
                    case "Gram-force/centimeter -gf/cm" : surfacetension(); break;
                    case "Dyne/centimeter -dyn/cm" : surfacetension(); break;
                    case "Erg/square centimeter -erg/cm^2" : surfacetension(); break;
                    case "Erg/square millimeter -erg/mm^2" : surfacetension(); break;
                    case "Poundal/inch -lb/in" : surfacetension(); break;
                    case "Pound-force/inch -lbf/in" : surfacetension(); break;

                    //visosity
                    case "Pascal second -Pa*s" : viscositydynamic(); break;
                    case "Kilogram-force second/square meter -kg-Ns/m^2" : viscositydynamic(); break;
                    case "Newton second/square meter -N*s/m^2" : viscositydynamic(); break;
                    case "Millinewton second/sq. meter -mNs/m^2" : viscositydynamic(); break;
                    case "Dyne second/sq. centimeter -dyns/cm^2" : viscositydynamic(); break;
                    case "Poise -P" : viscositydynamic(); break;
                    case "Exapoise -EP" : viscositydynamic(); break;
                    case "Petapoise -PP" : viscositydynamic(); break;
                    case "Terapoise -TP" : viscositydynamic(); break;
                    case "Gigapoise -GP" : viscositydynamic(); break;
                    case "Megapoise -MP" : viscositydynamic(); break;
                    case "Kilopoise -kP" : viscositydynamic(); break;
                    case "Hectopoise -hP" : viscositydynamic(); break;
                    case "Dekapoise -daP" : viscositydynamic(); break;
                    case "Decipoise -dP" : viscositydynamic(); break;
                    case "Centipoise -cP" : viscositydynamic(); break;
                    case "Millipoise -mP" : viscositydynamic(); break;
                    case "Micropoise -μP" : viscositydynamic(); break;
                    case "Nanopoise -nP" : viscositydynamic(); break;
                    case "Picopoise -pP" : viscositydynamic(); break;
                    case "Femtopoise -fP" : viscositydynamic(); break;
                    case "Attopoise -aP" : viscositydynamic(); break;
                    case "Pound-force second/sq. inch -lb-Ns/in^2" : viscositydynamic(); break;
                    case "Pound-force second/sq. foot -lb-Ns/ft^2" : viscositydynamic(); break;
                    case "Poundal second/square foot -lbs/ft^2" : viscositydynamic(); break;
                    case "Gram/centimeter/second -g/(cm*s)" : viscositydynamic(); break;
                    case "Slug/foot/second -slug/(ft*s)" : viscositydynamic(); break;
                    case "Pound/foot/second -lb/(ft*s)" : viscositydynamic(); break;
                    case "Pound/foot/hour -lb/(ft*h)" : viscositydynamic(); break;


                    case "Square meter/second -m^2/s" : viscositykinematic(); break;
                    case "Square meter/hour -m^2/h" : viscositykinematic(); break;
                    case "Square centimeter/second -cm^2/s" : viscositykinematic(); break;
                    case "Square millimeter/second -mm^2/s" : viscositykinematic(); break;
                    case "Square foot/second -ft^2/s" : viscositykinematic(); break;
                    case "Square foot/hour -ft^2/h" : viscositykinematic(); break;
                    case "Square inch/second -in^2/s" : viscositykinematic(); break;
                    case "Stokes -St" : viscositykinematic(); break;
                    case "Exastokes -ESt" : viscositykinematic(); break;
                    case "Petastokes -PSt" : viscositykinematic(); break;
                    case "Terastokes -TSt" : viscositykinematic(); break;
                    case "Gigastokes -GSt" : viscositykinematic(); break;
                    case "Megastokes -MSt" : viscositykinematic(); break;
                    case "Kilostokes -kSt" : viscositykinematic(); break;
                    case "Hectostokes -hSt" : viscositykinematic(); break;
                    case "Dekastokes -daSt" : viscositykinematic(); break;
                    case "Decistokes -dSt" : viscositykinematic(); break;
                    case "Centistokes -cSt" : viscositykinematic(); break;
                    case "Millistokes -mSt" : viscositykinematic(); break;
                    case "Microstokes -μSt" : viscositykinematic(); break;
                    case "Nanostokes -nSt" : viscositykinematic(); break;
                    case "Picostokes -pSt" : viscositykinematic(); break;
                    case "Femtostokes -fSt" : viscositykinematic(); break;
                    case "Attostokes -aSt" : viscositykinematic(); break;


                    //magnetism field strength
                    case "Ampere/meter - A/m" : magneticfieldstrenght(); break;
                    case "Ampere turn/meter - At/m" : magneticfieldstrenght(); break;
                    case "Kiloampere/meter - kA/m" : magneticfieldstrenght(); break;
                    case "Oersted - Oe" : magneticfieldstrenght(); break;

                    //magnetic flux
                    case "Weber - Wb" : magneticflux(); break;
                    case "Miliweber - mWb" : magneticflux(); break;
                    case "Microweber - μWb" : magneticflux(); break;
                    case "Volt second - V*s" : magneticflux(); break;
                    case "Unit pole - u" : magneticflux(); break;
                    case "Mega line - megaLine" : magneticflux(); break;
                    case "Kilo line - kiloLine" : magneticflux(); break;
                    case "Line - line" : magneticflux(); break;
                    case "Maxwell - Mx" : magneticflux(); break;
                    case "Tesla square meter - T*m²" : magneticflux(); break;
                    case "Tesla square centimeter - T*cm²" : magneticflux(); break;
                    case "Gauss square meter - gauss*m²" : magneticflux(); break;
                    case "Magnetic flux quantum" : magneticflux(); break;

                    //magnetic flux density
                    case "Tesla - T" : magneticfluxdensity(); break;
                    case "Weber/square meter - Wb/m²" : magneticfluxdensity(); break;
                    case "Weber/square centimeter - Wb/cm²" : magneticfluxdensity(); break;
                    case "Weber/square inch - Wb/in²" : magneticfluxdensity(); break;
                    case "Maxwell/square meter - Mx/m²" : magneticfluxdensity(); break;
                    case "Maxwell/square centimeter - Mx/cm²" : magneticfluxdensity(); break;
                    case "Maxwell/square inch - Mx/in²" : magneticfluxdensity(); break;

                    //magnomotive
                    case "Ampere turn - At" : magnemotive(); break;
                    case "Kiloampere turn - kAt" : magnemotive(); break;
                    case "Milliampere turn - mAt" : magnemotive(); break;
                    case "Abampere turn - abAt" : magnemotive(); break;
                    case "Gilbert - Gi" : magnemotive(); break;

                    //radiology
                    case "Rad - rd" : radionabosrved(); break;
                    case "Millirad - mrd" : radionabosrved(); break;
                    case "Joule/kilogram - J/kg" : radionabosrved(); break;
                    case "Joule/gram - J/g" : radionabosrved(); break;
                    case "Joule/centigram - J/cg" : radionabosrved(); break;
                    case "Joule/milligram - J/mg" : radionabosrved(); break;
                    case "Gray - Gy" : radionabosrved(); break;
                    case "Exagray - EGy" : radionabosrved(); break;
                    case "Petagray - PGy" : radionabosrved(); break;
                    case "Teragray - TGy" : radionabosrved(); break;
                    case "Gigagray - GGy" : radionabosrved(); break;
                    case "Megagray - MGy" : radionabosrved(); break;
                    case "Kilogray - kGy" : radionabosrved(); break;
                    case "Hectogray - hGy" : radionabosrved(); break;
                    case "Dekagray - daGy" : radionabosrved(); break;
                    case "Decigray - dGy" : radionabosrved(); break;

                    case "Centigray - cGy" : radionabosrved(); break;
                    case "Milligray - mGy" : radionabosrved(); break;

                    case "Microgray - µGy" : radionabosrved(); break;
                    case "Nanogray - nGy" : radionabosrved(); break;

                    case "Picogray - pGy" : radionabosrved(); break;
                    case "Femtogray - fGy" : radionabosrved(); break;

                    case "Attogray - aGy" : radionabosrved(); break;

                    //radiation
                    case "Becquerel - Bq" : radiation(); break;
                    case "Terabecquerel - TBq" : radiation(); break;
                    case "Gigabecquerel - GBq" : radiation(); break;
                    case "Megabecquerel - MBq" : radiation(); break;
                    case "Kilobecquerel - kBq" : radiation(); break;
                    case "Millibecquerel - mBq" : radiation(); break;
                    case "Curie - Ci" : radiation(); break;
                    case "Kilocurie - kCi" : radiation(); break;
                    case "Millicurie - mCi" : radiation(); break;
                    case "Microcurie - µCi" : radiation(); break;
                    case "Nanocurie - nCi" : radiation(); break;
                    case "Picocurie - pCi" : radiation(); break;
                    case "Rutherford - R" : radiation(); break;
                    case "One/second - 1/s" : radiation(); break;
                    case "Disintegrations/second - dis/sec" : radiation(); break;
                    case "Disintegrations/minute - dis/min" : radiation(); break;


                    case "Gray/second - Gy/s" : radiationativity(); break;
                    case "Exagray/second - EGy/s" : radiationativity(); break;
                    case "Petagray/second - PGy/s" : radiationativity(); break;
                    case "Teragray/second - TGy/s" : radiationativity(); break;
                    case "Gigagray/second - GGy/s" : radiationativity(); break;
                    case "Megagray/second - MGy/s" : radiationativity(); break;
                    case "Kilogray/second - kGy/s" : radiationativity(); break;
                    case "Hectogray/second - hGy/s" : radiationativity(); break;
                    case "Dekagray/second - daGy/s" : radiationativity(); break;
                    case "Decigray/second - dGy/s" : radiationativity(); break;
                    case "Centigray/second - cGy/s" : radiationativity(); break;
                    case "Milligray/second - mGy/s" : radiationativity(); break;
                    case "Microgray/second - µGy/s" : radiationativity(); break;
                    case "Nanogray/second - nGy/s" : radiationativity(); break;
                    case "Picogray/second - pGy/s" : radiationativity(); break;
                    case "Femtogray/second - fGy/s" : radiationativity(); break;
                    case "Attogray/second - aGy/s" : radiationativity(); break;
                    case "Rad/second - rd/s" : radiationativity(); break;
                    case "Joule/kilogram/second - J/kg/s" : radiationativity(); break;
                    case "Watt/kilogram - W/kg" : radiationativity(); break;
                    case "Sievert/second - Sv/s" : radiationativity(); break;
                    case "Rem/second - rem/s" : radiationativity(); break;

                    //radiation exposure
                    case "Coulomb/kilogram - C/kg" : radiationexposure(); break;
                    case "Millicoulomb/kilogram - mC/kg" : radiationexposure(); break;
                    case "Microcoulomb/kilogram - μC/kg" : radiationexposure(); break;
                    case "Roentgen - R" : radiationexposure(); break;
                    case "Tissue roentgen - Tr" : radiationexposure(); break;
                    case "Parker - parker" : radiationexposure(); break;
                    case "Rep - rep" : radiationexposure(); break;


                    //electricity charge
                    case "Coulomb - C" : charge(); break;
                    case "Megacoulomb - MC" : charge(); break;
                    case "Kilocoulomb - kC" : charge(); break;
                    case "Millicoulomb - mC" : charge(); break;
                    case "Microcoulomb - µC" : charge(); break;
                    case "Nanocoulomb - nC" : charge(); break;
                    case "Picocoulomb - pC" : charge(); break;
                    case "EMU of charge - e" : charge(); break;
                    case "Statcoulomb - stC" : charge(); break;
                    case "ESU of charge - e" : charge(); break;
                    case "Franklin - Fr" : charge(); break;
                    case "Ampere-hour - A*h" : charge(); break;
                    case "Ampere-minute - A*min" : charge(); break;
                    case "Ampere-second - A*s" : charge(); break;
                    case "Faraday - F" : charge(); break;
                    case "Elementary charge - e" : charge(); break;

                    //conducatnce
                    case "Siemens - S" : conducatnce(); break;
                    case "Megasiemens - MS" : conducatnce(); break;
                    case "Kilosiemens - kS" : conducatnce(); break;
                    case "Milisiemens - mS" : conducatnce(); break;
                    case "Microsiemens - µS" : conducatnce(); break;
                    case "Ampere/volt - A/V" : conducatnce(); break;
                    case "Mho - mho" : conducatnce(); break;
                    case "Gemmho - gemmho" : conducatnce(); break;
                    case "Micromho - µmho" : conducatnce(); break;
                    case "Abmho - abmho" : conducatnce(); break;
                    case "Statmho - stmho" : conducatnce(); break;
                    case "Quantized Hall Conductance - mho" : conducatnce(); break;

                    //conductivity
                    case "Siemens/meter - S/m" : conductivity(); break;
                    case "Picosiemens/meter - pS/m" : conductivity(); break;
                    case "Mho/meter - mho/m" : conductivity(); break;
                    case "Mho/centimeter - mho/cm" : conductivity(); break;
                    case "Abmho/meter - abmho/m" : conductivity(); break;
                    case "Abmho/centimeter - abmho/cm" : conductivity(); break;
                    case "Statmho/meter - stmho/m" : conductivity(); break;
                    case "Statmho/centimeter - st/cm" : conductivity(); break;

                    case "Ampere - A" : electriccurrent(); break;
                    case "Kiloampere - kA" : electriccurrent(); break;
                    case "Milliampere - mA" : electriccurrent(); break;
                    case "Biot - Bi" : electriccurrent(); break;
                    case "Abampere - abA" : electriccurrent(); break;
                    case "EMU of current - emuA" : electriccurrent(); break;
                    case "Statampere - stA" : electriccurrent(); break;
                    case "ESU of current - esuA" : electriccurrent(); break;
                    case "CGS e.m.unit - e.m.unit" : electriccurrent(); break;
                    case "CGS e.s.unit - e.s.unit" : electriccurrent(); break;

                    //eelctric field
                    case "Volt/meter - V/m" : electricfield(); break;
                    case "Kilovolt/meter - kV/m" : electricfield(); break;
                    case "Kilovolt/centimeter - kV/cm" : electricfield(); break;
                    case "Volt/centimeter - V/cm" : electricfield(); break;
                    case "Millivolt/meter - mV/m" : electricfield(); break;
                    case "Microvolt/meter - µ/m" : electricfield(); break;

                    //electric potential
                    case "Volt - V" : electricpotential(); break;
                    case "Watt/ampere - W/A" : electricpotential(); break;
                    case "Abvolt - AbV" : electricpotential(); break;
                    case "EMU of electric potential - EMU" : electricpotential(); break;
                    case "Statvolt - stV" : electricpotential(); break;
                    case "ESU of electric potential - ESU" : electricpotential(); break;

                    //electric resistance
                    case "Ohm - Ω" : electricResistance(); break;
                    case "Megohm - megohm" : electricResistance(); break;
                    case "Microhm - microhm" : electricResistance(); break;
                    case "Volt/ampere - V/A" : electricResistance(); break;
                    case "Reciprocal siemens - 1/S" : electricResistance(); break;
                    case "Abohm - abΩ" : electricResistance(); break;
                    case "EMU of resistance - EMU" : electricResistance(); break;
                    case "Statohm - stΩ" : electricResistance(); break;
                    case "ESU of resistance - ESU" : electricResistance(); break;
                    case "Quantized Hall resistance - Ω" : electricResistance(); break;

                    //electric resistivity
                    case "Ohm meter - Ωm" : electricResistivity(); break;
                    case "Ohm centimeter - Ωcm" : electricResistivity(); break;
                    case "Ohm inch - Ωin" : electricResistivity(); break;
                    case "Microhm centimeter - µΩcm" : electricResistivity(); break;
                    case "Microhm inch -  µΩin" : electricResistivity(); break;
                    case "Abohm centimeter - abΩcm" : electricResistivity(); break;
                    case "Statohm centimeter - stΩcm" : electricResistivity(); break;
                    case "Circular mil ohm/foot - circular mil Ω/ft" : electricResistivity(); break;


                    //electrostatic
                    case "Farad - F" : electrostatic(); break;
                    case "Exafarad - EF" : electrostatic(); break;
                    case "Petafarad - PF" : electrostatic(); break;
                    case "Terafarad - TF" : electrostatic(); break;
                    case "Gigafarad - GF" : electrostatic(); break;
                    case "Megafarad - MF" : electrostatic(); break;
                    case "Kilofarad - kF" : electrostatic(); break;
                    case "Hectofarad - hF" : electrostatic(); break;
                    case "Dekafarad - dF" : electrostatic(); break;
                    case "Decifarad - dF" : electrostatic(); break;
                    case "Centifarad - cF" : electrostatic(); break;
                    case "Millifarad - mF" : electrostatic(); break;
                    case "Microfarad - µF" : electrostatic(); break;
                    case "Nanofarad - nF" : electrostatic(); break;
                    case "Femtofarad - fF" : electrostatic(); break;
                    case "Attofarad - aF" : electrostatic(); break;
                    case "Coulomb/volt - C/v" : electrostatic(); break;
                    case "Abfarad - abF" : electrostatic(); break;
                    case "EMU of capacitance - EMU" : electrostatic(); break;
                    case "Statfarad - stF" : electrostatic(); break;
                    case "ESU of capacitance - ESU" : electrostatic(); break;

                    //inductance
                    case "Henry - H" : inductance(); break;
                    case "Exahenry - EH" : inductance(); break;
                    case "Terahenry - TH" : inductance(); break;
                    case "Petahenry - PH" : inductance(); break;
                    case "Gigahenry - GH" : inductance(); break;
                    case "Megahenry - MH" : inductance(); break;
                    case "Kilohenry - kH" : inductance(); break;
                    case "Hectohenry - hH" : inductance(); break;
                    case "Dekahenry - daH" : inductance(); break;
                    case "Decihenry - dH" : inductance(); break;
                    case "Centihenry - cH" : inductance(); break;
                    case "Milihenry - mH" : inductance(); break;
                    case "Microhenry - µH" : inductance(); break;
                    case "Nanohenry - nH" : inductance(); break;
                    case "Picohenry - pH" : inductance(); break;
                    case "Femtohenry - fH" : inductance(); break;
                    case "Attohenery - aH" : inductance(); break;
                    case "Weber/ampere - Wb/A" : inductance(); break;
                    case "Abhenery - abH" : inductance(); break;
                    case "EMU of inductance - EMU" : inductance(); break;
                    case "Stathenry - stH" : inductance(); break;
                    case "ESU of inductance - ESU" : inductance(); break;

                    //linear charge
                    case "Coulomb/meter - C/m" : linearcharge(); break;
                    case "Coulomb/centimeter - C/cm" : linearcharge(); break;
                    case "Coulomb/inch - C/in" : linearcharge(); break;
                    case "Abcoulomb/meter - abC/m" : linearcharge(); break;
                    case "Abcoulomb/centimeter - abC/cm" : linearcharge(); break;
                    case "Abcoulomb/inch - abC/in" : linearcharge(); break;

                    //linear current
                    case "Ampere/meter(linear) - A/m" : linearurrent(); break;
                    case "Ampere/centimeter - A/cm" : linearurrent(); break;
                    case "Ampere/inch - A/in" : linearurrent(); break;
                    case "Abampere/meter - abA/m" : linearurrent(); break;
                    case "Abampere/centimeter - abA/cm" : linearurrent(); break;
                    case "Abampere/inch - abA/in" : linearurrent(); break;
                    case "Oersted(linear) - Oe" : linearurrent(); break;
                    case "Gilbert/centimeter - Gi/cm" : linearurrent(); break;

                    //surface charge
                    case "Coulomb/square meter - C/m²" : surfacecharge(); break;
                    case "Coulomb/square centimeter - C/cm²" : surfacecharge(); break;
                    case "Coulomb/square inch - C/in²" : surfacecharge(); break;
                    case "Abcoulomb/square meter - abC/m²" : surfacecharge(); break;
                    case "Abcoulomb/square centimeter - abC/cm²" : surfacecharge(); break;
                    case "Abcoulomb/square inch - abC/in²" : surfacecharge(); break;

                    //surface current
                    case "Ampere/square meter - A/m²" : surfacecurrent(); break;
                    case "Ampere/square centimeter - A/cm²" : surfacecurrent(); break;
                    case "Ampere/square inch - A/in²" : surfacecurrent(); break;
                    case "Ampere/square mil - A/mil²" : surfacecurrent(); break;
                    case "Ampere/cicular mil - A/mil" : surfacecurrent(); break;
                    case "Abampere/square centimeter - abA/cm²" : surfacecurrent(); break;

                    //volumecharge
                    case "Coulomb/cubic meter - C/m³" : voulmecharge(); break;
                    case "Coulomb/cubic centimeter - C/cm³" : voulmecharge(); break;
                    case "Coulomb/cubic inch - C/in³" : voulmecharge(); break;
                    case "Abcoulomb/cubic meter - abC/m³" : voulmecharge(); break;
                    case "Abcoulomb/cubic centimeter - abC/cm³" : voulmecharge(); break;
                    case "Abcoulomb/cubic inch - abC/in³" : voulmecharge(); break;

                    default: other();

                }
            }
        });
    }
    private  void other()
    {
        switch(selectedItem) {
            //cooking
            case "Cup(Euro) - cup":
                cooking();
                break;
            case "Cup(US) - cup":
                cooking();
                break;
            case "Gram(cooking) - g":
                cooking();
                break;
            case "Kilogram - kg":
                cooking();
                break;
            case "Liter - li":
                cooking();
                break;
            case "Milliliter - ml":
                cooking();
                break;
            case "Ounce(cooking) - oz":
                cooking();
                break;
            case "Fluid Ounce - floz":
                cooking();
                break;
            case "Pint - pt":
                cooking();
                break;
            case "Pound - lb":
                cooking();
                break;
            case "Table Spoon(Euro) - tbsp":
                cooking();
                break;
            case "Table Spoon(US) - tbsp":
                cooking();
                break;
            case "Tea Spoon(Euro) - tsp":
                cooking();
                break;
            case "Tea Spoon(US) - tsp":
                cooking();
                break;

            //data transfer
            case "Bit/second - b/s":
                datatransfer();
                break;
            case "Byte/second - B/s":
                datatransfer();
                break;
            case "Kilobit/second(SI def.)":
                datatransfer();
                break;
            case "Kilobyte/second(SI def.)":
                datatransfer();
                break;
            case "Kilobit/second - kb/s":
                datatransfer();
                break;
            case "Kilobyte/second - kB/s":
                datatransfer();
                break;
            case "Megabit/second(SI def.)":
                datatransfer();
                break;
            case "Megabyte/second(SI def.)":
                datatransfer();
                break;
            case "Megabit/second - Mb/s":
                datatransfer();
                break;
            case "Megabyte/second - MB/s":
                datatransfer();
                break;
            case "Gigabit/second(SI def.)":
                datatransfer();
                break;
            case "Gigabyte/second(SI def.)":
                datatransfer();
                break;
            case "Gigabit/second - Gb/s":
                datatransfer();
                break;
            case "Gigabyte/second - GB/s":
                datatransfer();
                break;
            case "Terabit/second(SI def.)":
                datatransfer();
                break;
            case "Terabyte/second(SI def.)":
                datatransfer();
                break;
            case "Terabit/second - Tb/s":
                datatransfer();
                break;
            case "Terabyte/second - TB/S":
                datatransfer();
                break;
            case "Ethernet":
                datatransfer();
                break;
            case "Ethernet(fast)":
                datatransfer();
                break;
            case "Ethernet(gigabit)":
                datatransfer();
                break;
            case "OC1":
                datatransfer();
                break;
            case "OC3":
                datatransfer();
                break;
            case "OC12":
                datatransfer();
                break;
            case "OC24":
                datatransfer();
                break;
            case "OC48":
                datatransfer();
                break;
            case "OC192":
                datatransfer();
                break;
            case "OC768":
                datatransfer();
                break;
            case "ISDN (single channel)":
                datatransfer();
                break;
            case "ISDN(dual channel)":
                datatransfer();
                break;
            case "Modem(110)":
                datatransfer();
                break;
            case "Modem(300)":
                datatransfer();
                break;
            case "Modem(1200)":
                datatransfer();
                break;
            case "Modem(2400)":
                datatransfer();
                break;
            case "Modem(9600)":
                datatransfer();
                break;
            case "Modem(14.4k)":
                datatransfer();
                break;
            case "Modem(28.8k)":
                datatransfer();
                break;
            case "Modem(33.6k)":
                datatransfer();
                break;
            case "Modem(56k)":
                datatransfer();
                break;
            case "SCSI(Async)":
                datatransfer();
                break;
            case "SCSI(Sync)":
                datatransfer();
                break;
            case "SCSI(Fast)":
                datatransfer();
                break;
            case "SCSI(Fast Ultra)":
                datatransfer();
                break;
            case "SCSI(Fast Wide)":
                datatransfer();
                break;
            case "SCSI(Fast Ultra Wide)":
                datatransfer();
                break;
            case "SCSI(Ultra-2)":
                datatransfer();
                break;
            case "SCSI(Ultra-3)":
                datatransfer();
                break;
            case "SCSI(LVD Ultra 80)":
                datatransfer();
                break;
            case "SCSI(LVD Ultra 160)":
                datatransfer();
                break;
            case "IDE(PIO mode 0)":
                datatransfer();
                break;
            case "IDE(PIO mode 1)":
                datatransfer();
                break;
            case "IDE(PIO mode 2)":
                datatransfer();
                break;
            case "IDE(PIO mode 3)":
                datatransfer();
                break;
            case "IDE(PIO mode 4)":
                datatransfer();
                break;
            case "IDE(DMA mode 0)":
                datatransfer();
                break;
            case "IDE(DMA mode 1)":
                datatransfer();
                break;
            case "IDE(DMA mode 2)":
                datatransfer();
                break;
            case "IDE(UDMA mode 0)":
                datatransfer();
                break;
            case "IDE(UDMAmode 1)":
                datatransfer();
                break;
            case "IDE(UDMA mode 2)":
                datatransfer();
                break;
            case "IDE(UDMA mode 3)":
                datatransfer();
                break;
            case "IDE(UDMA mode 4)":
                datatransfer();
                break;
            case "IDE(UDMA 33)":
                datatransfer();
                break;
            case "IDE(UDMA 66)":
                datatransfer();
                break;
            case "USB":
                datatransfer();
                break;
            case "Firewire(IEEE-1394)":
                datatransfer();
                break;
            case "T0(payload)":
                datatransfer();
                break;
            case "T0(B8ZS payload)":
                datatransfer();
                break;
            case "T1(signal)":
                datatransfer();
                break;
            case "T1(payload)":
                datatransfer();
                break;
            case "T1Z(payload)":
                datatransfer();
                break;
            case "T1C(signal)":
                datatransfer();
                break;
            case "T1C(payload)":
                datatransfer();
                break;
            case "T2(signal)":
                datatransfer();
                break;
            case "T3(signal)":
                datatransfer();
                break;
            case "T3(payload)":
                datatransfer();
                break;
            case "T3Z(payload)":
                datatransfer();
                break;
            case "T4(signal)":
                datatransfer();
                break;
            case "E.P.T.A.1(signal)":
                datatransfer();
                break;
            case "E.P.T.A.1(payload)":
                datatransfer();
                break;
            case "E.P.T.A.2(signal)":
                datatransfer();
                break;
            case "E.P.T.A.2(payload)":
                datatransfer();
                break;
            case "E.P.T.A.3(signal)":
                datatransfer();
                break;
            case "E.P.T.A.3(payload)":
                datatransfer();
                break;
            case "H0":
                datatransfer();
                break;
            case "H11":
                datatransfer();
                break;
            case "Virtual Tributary 1(signal)":
                datatransfer();
                break;
            case "Virtual Tributary 1(payload)":
                datatransfer();
                break;
            case "Virtual Tributary 2(signal)":
                datatransfer();
                break;
            case "Virtual Tributary 2(payload)":
                datatransfer();
                break;
            case "Virtual Tributary 6(signal)":
                datatransfer();
                break;
            case "Virtual Tributary 6(payload)":
                datatransfer();
                break;
            case "STS1(signal)":
                datatransfer();
                break;
            case "STS1(payload)":
                datatransfer();
                break;
            case "STS3(signal)":
                datatransfer();
                break;
            case "STS3(payload)":
                datatransfer();
                break;
            case "STS3c(signal)":
                datatransfer();
                break;
            case "STS3c(payload)":
                datatransfer();
                break;
            case "STS12(signal)":
                datatransfer();
                break;
            case "STS24(signal)":
                datatransfer();
                break;
            case "STS48(signal)":
                datatransfer();
                break;
            case "STS192(signal)":
                datatransfer();
                break;
            case "STM-1(signal)":
                datatransfer();
                break;
            case "STM-4(signal)":
                datatransfer();
                break;
            case "STM-16(signal)":
                datatransfer();
                break;
            case "STM-64(signal)":
                datatransfer();
                break;

            //hardness
            case "German Degrees - °g":
                hardness();
                break;
            case "Parts/million - p/million":
                hardness();
                break;
            case "American Degrees - °a":
                hardness();
                break;
            case "Clark Degrees - °c":
                hardness();
                break;
            case "French Degrees - °f":
                hardness();
                break;
            case "Millieqv - millieqv":
                hardness();
                break;
            case "Milli Grams/gallon - mgr/gal":
                hardness();
                break;

            //image actiivyt
            case "Twip - twip":
                imageactivity();
                break;
            case "Meter - m":
                imageactivity();
                break;
            case "Centimeter - cm":
                imageactivity();
                break;
            case "Millimeter - mm":
                imageactivity();
                break;
            case "Inch - in":
                imageactivity();
                break;
            case "Pixel(X) - pixel(x)":
                imageactivity();
                break;
            case "Pixel(Y) - pixel(y)":
                imageactivity();
                break;
            case "Character(X) - character(x)":
                imageactivity();
                break;
            case "Character(Y) - character(y)":
                imageactivity();
                break;
            case "Pica - P":
                imageactivity();
                break;
            case "Point - pt":
                imageactivity();
                break;
            case "En - en":
                imageactivity();
                break;

            //metric weight
            case "Microgram - µg":
                metricweight();
                break;
            case "Milligram(metric weight) - mg":
                metricweight();
                break;
            case "Centigram(metric weight) - cg":
                metricweight();
                break;
            case "Decigram(metric weight) - dg":
                metricweight();
                break;
            case "Gram(metric weight) - g":
                metricweight();
                break;
            case "Dekagram(metric weight) - dag":
                metricweight();
                break;
            case "Hectogram(metric weight) - hg":
                metricweight();
                break;
            case "Kilogram(metric weight) - kg":
                metricweight();
                break;
            case "Metricton(metric weight) - metricton":
                metricweight();
                break;


            //metrology
            case "Angstrom - angstrom":
                metrology();
                break;
            case "Surface Microinch - µin":
                metrology();
                break;
            case "Surface microns - microns":
                metrology();
                break;
            case "Light bands - lightbands":
                metrology();
                break;
            case "Precision tenths - precision tenths":
                metrology();
                break;
            case "Close tol.thousands - closetolthousands":
                metrology();
                break;
            case "Metric millimeters - metric mm":
                metrology();
                break;
            case "U.S.Inches - usInches":
                metrology();
                break;

            //prefix
            case "None - none":
                prefix();
                break;
            case "Yotta - Y":
                prefix();
                break;
            case "Zetta - Z":
                prefix();
                break;
            case "Exa - E":
                prefix();
                break;
            case "Peta - P":
                prefix();
                break;
            case "Tera - T":
                prefix();
                break;
            case "Giga - G":
                prefix();
                break;
            case "Mega - M":
                prefix();
                break;
            case "Kilo - k":
                prefix();
                break;
            case "Hecto - h":
                prefix();
                break;
            case "Deka - da":
                prefix();
                break;
            case "Deci - d":
                prefix();
                break;
            case "Centi - c":
                prefix();
                break;
            case "Milli - m":
                prefix();
                break;
            case "Micro - µ":
                prefix();
                break;
            case "Nano - n":
                prefix();
                break;
            case "Pico - p":
                prefix();
                break;
            case "Femto - f":
                prefix();
                break;
            case "Atto - a":
                prefix();
                break;
            case "Zepto - z":
                prefix();
                break;
            case "Yocto - y":
                prefix();
                break;

            //sound
            case "Bel - B":
                sound();
                break;
            case "Decible - dB":
                sound();
                break;
            case "Neper - Np":
                sound();
                break;

            //typographic
            case "Twip(typography) - twip":
                typography();
                break;
            case "Meter(typography) - m":
                typography();
                break;
            case "Centimeter(typography) - cm":
                typography();
                break;
            case "Millimeter(typography) - mm":
                typography();
                break;
            case "Character(X)(typography) - character(x)":
                typography();
                break;
            case "Character(Y)(typography) - character(y)":
                typography();
                break;
            case "Pixel(X)(typography) - pixel(x)":
                typography();
                break;
            case "Pixel(Y)(typography) - pixel(y)":
                typography();
                break;
            case "Inch(typography) - in":
                typography();
                break;
            case "Pica(Computer) - pica":
                typography();
                break;
            case "Pica(Printer) - pica":
                typography();
                break;
            case "PostScript point - psp":
                typography();
                break;
            case "Point(Computer) - pt":
                typography();
                break;
            case "Point(Printer) - pt":
                typography();
                break;
            case "En(typography) - en":
                typography();
                break;

            //voulmelumber
            case "Cubic meter - m³":
                volumelumber();
                break;
            case "Cubic foot - ft³":
                volumelumber();
                break;
            case "Cubic inch - in³":
                volumelumber();
                break;
            case "Board feet - boardfeet":
                volumelumber();
                break;
            case "Thousand board feet - thousand board feet":
                volumelumber();
                break;
            case "Cord - cord":
                volumelumber();
                break;
            case "Cord(80 cubic ft) - cord":
                volumelumber();
                break;
            case "Cord feet - cordfeet":
                volumelumber();
                break;
            case "Cunit - cunit":
                volumelumber();
                break;
            case "Pallet - pallet":
                volumelumber();
                break;
            case "Cross tie - crosstie":
                volumelumber();
                break;
            case "Switch tie - switchtie":
                volumelumber();
                break;
            case "Thousand square feet (1/8inch panels) - ft²":
                volumelumber();
                break;
            case "Thousand square feet (1/4inch panels) - ft²":
                volumelumber();
                break;
            case "Thousand square feet (3/8inch panels) - ft²":
                volumelumber();
                break;
            case "Thousand square feet (1/2inch panels) - ft²":
                volumelumber();
                break;
            case "Thousand square feet (3/4inch panels) - ft²":
                volumelumber();
                break;

            //work
            case "Joule(work) - J":
                work();
                break;
            case "Kilojoule - kJ":
                work();
                break;
            case "Calorie - cal":
                work();
                break;
            case "Kilocalorie - kcal":
                work();
                break;
            case "Kilowatt hour - kw*h":
                work();
                break;
            case "Kilogram force meter - kgf*m":
                work();
                break;
            case "Inch pound - in*lbf":
                work();
                break;
            case "Foot pound - ft*lbf":
                work();
                break;
            case "Btu - btu":
                work();
                break;
        }
    }
    private void work() {
        Intent i7=new Intent(SearchActivity.this,WorkConverterActivity.class);
        startActivity(i7);
    }
    private void volumelumber() {
        Intent i7=new Intent(SearchActivity.this,TypographyConversionActivity.class);
        startActivity(i7);
    }
    private void typography() {
        Intent i7=new Intent(SearchActivity.this,TypographyConversionActivity.class);
        startActivity(i7);
    }
    private void sound() {
        Intent i7=new Intent(SearchActivity.this,SoundActivity.class);
        startActivity(i7);
    }
    private void prefix() {
        Intent i7=new Intent(SearchActivity.this,PrefixActivity.class);
        startActivity(i7);
    }
    private void metrology() {
        Intent i7=new Intent(SearchActivity.this,MetrologyUnitConverterActivity.class);
        startActivity(i7);
    }
    private void metricweight() {
        Intent i7=new Intent(SearchActivity.this,MetricWeightConverterActivity.class);
        startActivity(i7);
    }
    private void imageactivity() {
        Intent i7=new Intent(SearchActivity.this,ImageActivity.class);
        startActivity(i7);
    }
    private void hardness() {
        Intent i7=new Intent(SearchActivity.this,HardnessActivity.class);
        startActivity(i7);
    }
    private void datatransfer() {
        Intent i7=new Intent(SearchActivity.this,DataTransferConverterActivity.class);
        startActivity(i7);
    }
    private void cooking() {
        Intent i7=new Intent(SearchActivity.this,CookingActivity.class);
        startActivity(i7);
    }
    private void voulmecharge() {
        Intent i7=new Intent(SearchActivity.this,VolumeChargeDensityActivity.class);
        startActivity(i7);
    }
    private void surfacecurrent() {
        Intent i7=new Intent(SearchActivity.this,SurfaceChargeDensityConverterActivity.class);
        startActivity(i7);
    }
    private void surfacecharge() {
        Intent i7=new Intent(SearchActivity.this,SurfaceChargeDensityConverterActivity.class);
        startActivity(i7);
    }
    private void linearurrent() {
        Intent i7=new Intent(SearchActivity.this,LinearCurrentDensityActivity.class);
        startActivity(i7);
    }
    private void linearcharge() {
        Intent i7=new Intent(SearchActivity.this,LinearChargeDensityConverterActivity.class);
        startActivity(i7);
    }
    private void inductance() {
        Intent i7=new Intent(SearchActivity.this,InductanceConverterActivity.class);
        startActivity(i7);
    }
    private void electrostatic() {
        Intent i7=new Intent(SearchActivity.this,ElectricResistivityConverterActivity.class);
        startActivity(i7);
    }
    private void electricResistivity() {
        Intent i7=new Intent(SearchActivity.this,ElectricResistivityConverterActivity.class);
        startActivity(i7);
    }
    private void electricResistance() {
        Intent i7=new Intent(SearchActivity.this,ElectricResistanceConverterActivity.class);
        startActivity(i7);
    }
    private void electricpotential() {
        Intent i7=new Intent(SearchActivity.this,ElectricPotentialActivity.class);
        startActivity(i7);
    }
    private void electricfield() {
        Intent i7=new Intent(SearchActivity.this,ElectricFieldStrengthActivity.class);
        startActivity(i7);
    }

    private void electriccurrent() {
        Intent i7=new Intent(SearchActivity.this,CurrentConverterActivity.class);
        startActivity(i7);
    }


    private void conductivity() {
        Intent i7=new Intent(SearchActivity.this,ConductivityConverterActivity.class);
        startActivity(i7);
    }

    private void conducatnce() {
        Intent i7=new Intent(SearchActivity.this,ConductanceConverterActivity.class);
        startActivity(i7);
    }

    private void charge() {
        Intent i7=new Intent(SearchActivity.this,ChargeConverterActivity.class);
        startActivity(i7);
    }

    private void radiationexposure() {
        Intent i7=new Intent(SearchActivity.this,RadiationExposureActivity.class);
        startActivity(i7);
    }

    private void radiationativity() {
        Intent i7=new Intent(SearchActivity.this,RadiationConverterActivity.class);
        startActivity(i7);
    }

    private void radiation() {
        Intent i7=new Intent(SearchActivity.this,RadiationActivity.class);
        startActivity(i7);
    }

    private void radionabosrved() {
        Intent i7=new Intent(SearchActivity.this,RadiationAbsorbedDoseActivity.class);
        startActivity(i7);
    }

    private void magnemotive() {
        Intent i7=new Intent(SearchActivity.this,MagnetomotiveForceActivity.class);
        startActivity(i7);
    }

    private void magneticfluxdensity() {
        Intent i7=new Intent(SearchActivity.this,MagneticFluxDensityActivity.class);
        startActivity(i7);
    }

    private void magneticflux() {
        Intent i7=new Intent(SearchActivity.this,MagneticFluxActivity.class);
        startActivity(i7);
    }

    private void magneticfieldstrenght() {
        Intent i7=new Intent(SearchActivity.this,MagneticFieldStrengthActivity.class);
        startActivity(i7);
    }

    private void viscositykinematic() {
        Intent i7=new Intent(SearchActivity.this,ViscosityKinematicActivity.class);
        startActivity(i7);
    }

    private void viscositydynamic() {
        Intent i7=new Intent(SearchActivity.this,ViscosityDynamicActivity.class);
        startActivity(i7);
    }

    private void surfacetension() {
        Intent i7=new Intent(SearchActivity.this,SurfaceTensionActivity.class);
        startActivity(i7);
    }

    private void permeabiltiy() {
        Intent i7=new Intent(SearchActivity.this,PermeabillityActivity.class);
        startActivity(i7);
    }

    private void massflux() {
        Intent i7=new Intent(SearchActivity.this,MassFluxDensity.class);
        startActivity(i7);
    }

    private void flowmolar() {
        Intent i7=new Intent(SearchActivity.this,FlowMolarActivity.class);
        startActivity(i7);
    }

    private void flowmass() {
        Intent i7=new Intent(SearchActivity.this,FlowMassActivity.class);
        startActivity(i7);
    }

    private void flow() {
        Intent i7=new Intent(SearchActivity.this,FlowActivity.class);
        startActivity(i7);
    }

    private void concentrationsolution() {
        Intent i7=new Intent(SearchActivity.this,ConcentrationSolutionActivity.class);
        startActivity(i7);
    }

    private void concentrationmolar() {
        Intent i7=new Intent(SearchActivity.this,ConcentrationMolarActivity.class);
        startActivity(i7);
    }

    private void luminousintensity() {
        Intent i7=new Intent(SearchActivity.this,LuminousIntensityActivity.class);
        startActivity(i7);
    }

    private void luminanace() {
        Intent i7=new Intent(SearchActivity.this,LuminanceActivity.class);
        startActivity(i7);
    }

    private void illumination() {
        Intent i7=new Intent(SearchActivity.this,IlluminationActivity.class);
        startActivity(i7);
    }

    private void frequency() {
        Intent i7=new Intent(SearchActivity.this, FrequencyActivity.class);
        startActivity(i7);
    }

    private void digitalimage() {
        Intent i7=new Intent(SearchActivity.this, DigitalImageResolutionActivity.class);
        startActivity(i7);
    }

    private void thermalresistance() {
        Intent i7=new Intent(SearchActivity.this, ThermalResistanceActivity.class);
        startActivity(i7);
    }

    private void thermalexpansion() {
    }

    private void thermalconducitivity() {
        Intent i7=new Intent(SearchActivity.this, ThermalExpansionActivity.class);
        startActivity(i7);
    }


    private void tempertureinterval() {
        Intent i7=new Intent(SearchActivity.this, TemperatureIntervalActivity.class);
        startActivity(i7);
    }

    private void specificheat() {
        Intent i7=new Intent(SearchActivity.this, SpecificHeatCapacityActivity.class);
        startActivity(i7);
    }

    private void heattransfer() {
        Intent i7=new Intent(SearchActivity.this, HeatTransferCoefficientActivity.class);
        startActivity(i7);
    }

    private void heatfluxdensity() {
        Intent i7=new Intent(SearchActivity.this, HeatFluxDensityActivity.class);
        startActivity(i7);
    }

    private void heatdensity() {
        Intent i7=new Intent(SearchActivity.this, HeatDensityActivity.class);
        startActivity(i7);
    }

    private void fueleffiencyvolume() {
        Intent i7=new Intent(SearchActivity.this, FuelEfficiencyVolumeActivity.class);
        startActivity(i7);
    }

    private void fueleffiency() {
        Intent i7=new Intent(SearchActivity.this, FuelEfficiencyMassActivity.class);
        startActivity(i7);
    }

    private void torque() {
        Intent i7=new Intent(SearchActivity.this, TorqueActivity.class);
        startActivity(i7);
    }

    private void momentofforce() {
        Intent i7=new Intent(SearchActivity.this, MomentofForceActivity.class);
        startActivity(i7);
    }

    private void momentofinertia() {
        Intent i7=new Intent(SearchActivity.this, MomentOfInertiaActivity.class);
        startActivity(i7);
    }

    private void specificvolume() {
        Intent i7=new Intent(SearchActivity.this, SpecificVolumeActivity.class);
        startActivity(i7);
    }

    private void density() {
        Intent i7=new Intent(SearchActivity.this, DensityConverterActivity.class);
        startActivity(i7);
    }

    private void accelerationangular() {
        Intent i7=new Intent(SearchActivity.this, AccelerationAngularActivity.class);
        startActivity(i7);
    }

    private void velocityangular() {
        Intent i7=new Intent(SearchActivity.this, VelocityAngularActivity.class);
        startActivity(i7);
    }

    private void accleration() {
        Intent i7=new Intent(SearchActivity.this, AccelerationActivity.class);
        startActivity(i7);
    }

    private void volumedry() {
        Intent i7=new Intent(SearchActivity.this, VolumeDryActivity.class);
        startActivity(i7);
    }

    private void datastorage() {
        Intent i7=new Intent(SearchActivity.this, DataStorageActivity.class);
        startActivity(i7);
    }

    private void fuel() {
        Intent i7=new Intent(SearchActivity.this, FuelActivity.class);
        startActivity(i7);
    }

    private void angle() {
        Intent i7=new Intent(SearchActivity.this, AngleActivity.class);
        startActivity(i7);
    }

    private void speed() {
        Intent i7=new Intent(SearchActivity.this, SpeedActivity.class);
        startActivity(i7);
    }

    private void time() {
        Intent i7=new Intent(SearchActivity.this, TimeActivity.class);
        startActivity(i7);
    }

    private void force() {
        Intent i7=new Intent(SearchActivity.this, ForceActivity.class);
        startActivity(i7);
    }

    private void power() {
        Intent i7=new Intent(SearchActivity.this, PowerActivity.class);
        startActivity(i7);
    }

    private void energy() {
        Intent i7=new Intent(SearchActivity.this, EnergyActivity.class);
        startActivity(i7);
    }

    private void pressure() {
        Intent i7=new Intent(SearchActivity.this, PressureActivity.class);
        startActivity(i7);
    }

    private void area() {
        Intent i7=new Intent(SearchActivity.this, AreaActivity.class);
        startActivity(i7);
    }

    private void volume() {
        Intent i7=new Intent(SearchActivity.this, VolumeActivity.class);
        startActivity(i7);
    }

    private void weight() {
        Intent i7=new Intent(SearchActivity.this, WeightActivity.class);
        startActivity(i7);
    }

    private void temperture() {
        Intent i7=new Intent(SearchActivity.this, TempertureActivity.class);
        startActivity(i7);
    }

    private void length() {
        Intent i=new Intent(SearchActivity.this, LengthActivity.class);
        startActivity(i);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SearchActivity.this.adapter.getFilter().filter(s);

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}



