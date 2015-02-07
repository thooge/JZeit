package de.hoogi.jzeit;

import java.rmi.RemoteException;

import de.willuhn.jameica.plugin.AbstractPlugin;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

import de.hoogi.jzeit.rmi.JZeitDBService;
import de.hoogi.jzeit.server.JZeitDBServiceImpl;

public class JZeitPlugin extends AbstractPlugin {

  /**
   * @see de.willuhn.jameica.plugin.AbstractPlugin#init()
   */
  public void init() throws ApplicationException
  {
    Logger.info("starting init process for jzeit");
  }

}
