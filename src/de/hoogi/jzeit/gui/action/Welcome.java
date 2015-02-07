package de.hoogi.jzeit.gui.action;

import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.util.ApplicationException;

/**
 * Action for the welcome screen.
 */
public class Welcome implements Action
{
	/**
	 * @see de.willuhn.jameica.gui.Action#handleAction(java.lang.Object)
	 */
	public void handleAction(Object context) throws ApplicationException
	{
		GUI.startView(de.hoogi.jzeit.gui.view.Welcome.class.getName(),null);
	}

}
