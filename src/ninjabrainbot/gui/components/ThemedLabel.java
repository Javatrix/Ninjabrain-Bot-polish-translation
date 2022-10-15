package ninjabrainbot.gui.components;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ninjabrainbot.gui.style.SizePreference;
import ninjabrainbot.gui.style.StyleManager;
import ninjabrainbot.gui.style.Theme;

public class ThemedLabel extends JLabel implements ThemedComponent, ILabel {

	private static final long serialVersionUID = 1363577008580584264L;
	public boolean bold;

	public ThemedLabel(StyleManager styleManager) {
		this(styleManager, "");
	}

	public ThemedLabel(StyleManager styleManager, boolean centered) {
		this(styleManager, "", false, centered);
	}

	public ThemedLabel(StyleManager styleManager, String text) {
		this(styleManager, text, false);
	}

	public ThemedLabel(StyleManager styleManager, String text, boolean bold) {
		this(styleManager, text, bold, false);
	}

	public ThemedLabel(StyleManager styleManager, String text, boolean bold, boolean centered) {
		super(text);
		styleManager.registerThemedComponent(this);
		this.bold = bold;
		setHorizontalAlignment(centered ? SwingConstants.CENTER : SwingConstants.LEFT);
	}

	public void updateSize(StyleManager styleManager) {
		setFont(styleManager.fontSize(getTextSize(styleManager.size), !bold));
	}

	public void updateColors(StyleManager styleManager) {
		Color bg = getBackgroundColor(styleManager.theme);
		if (bg != null)
			setBackground(bg);
		Color fg = getForegroundColor(styleManager.theme);
		if (fg != null)
			setForeground(fg);
	}

	public int getTextSize(SizePreference p) {
		return p.TEXT_SIZE_MEDIUM;
	}

	public Color getBackgroundColor(Theme theme) {
		return null;
	}

	public Color getForegroundColor(Theme theme) {
		return theme.TEXT_COLOR_STRONG;
	}

}
