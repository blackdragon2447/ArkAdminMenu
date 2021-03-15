package com.blackdragon2447.AAM.util;

import javax.swing.LookAndFeel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

public enum Themes {
	
	FlatLight,
	FlatDark,
	FlatIntelliJ,
	FlatDarcula,
	ArkOrange,
	OneDark,
	CyanLight,
	DarkPurple,
	MaterialLighter,
	MaterialDarker,
	SolarizedLight,
	SolarizedDark,
	Carbon;

	
	public static LookAndFeel getLookAndFeel(int i) {
		switch (i) {
		case 0:
			return new FlatLightLaf();
		case 1:
			return new FlatDarkLaf();
		case 2:
			return new FlatIntelliJLaf();
		case 3:
			return new FlatDarculaLaf();
		case 4:
			return new FlatArcOrangeIJTheme();
		case 5:
			return new FlatOneDarkIJTheme();
		case 6:
			return new FlatCyanLightIJTheme();
		case 7:
			return new FlatDarkPurpleIJTheme();
		case 8:
			return new FlatMaterialLighterIJTheme();
		case 9:
			return new FlatMaterialDarkerIJTheme();
		case 10:
			return new FlatSolarizedLightIJTheme();
		case 11:
			return new FlatSolarizedDarkIJTheme();
		case 12:
			return new FlatCarbonIJTheme();
		default:
			return new FlatLightLaf();
		}
	}

}
