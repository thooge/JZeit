package de.hoogi.jzeit.gui.view;

import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.util.LabelGroup;
import de.willuhn.util.ApplicationException;

/**
 * Welcome screen of the jzeit plugin.
 * @author thooge
 */
public class Welcome extends AbstractView
{

	/**
	 * this method will be invoked when starting the view.
	 * @see de.willuhn.jameica.gui.AbstractView#bind()
	 */
	public void bind() throws Exception
	{
		GUI.getView().setTitle("JZeit plugin");

		LabelGroup group = new LabelGroup(this.getParent(), "Willkommen");

		group.addText("Dieses Plugin dient der Zeiterfassung.", false);
		group.addText("Im Hintergrund wurde eine H2-Datenbank angelegt.", false);

	}

	/**
	 *this method will be executed when exiting the view.
	 * You don't need to dispose your widgets, the GUI controller will
	 * do this in a recursive way for you.
	 * @see de.willuhn.jameica.gui.AbstractView#unbind()
	 */
	public void unbind() throws ApplicationException
	{
		// Nix zu sehen hier...
	}

}
