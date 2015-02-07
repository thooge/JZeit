package de.hoogi.jzeit.rmi;

import java.rmi.RemoteException;

import de.willuhn.datasource.rmi.DBService;
import de.willuhn.jameica.plugin.Version;
import de.willuhn.jameica.system.Settings;

public interface JZeitDBService extends DBService
{
	/**
	 * Einstellungen fuer die DB-Services.
	 */
	public final static Settings SETTINGS = new Settings(JZeitDBService.class);

	/**
	 * Datenbank installieren
	 * @throws RemoteException Wenn beim Initialisieren ein Fehler auftrat.
	 */
	public void install() throws RemoteException;

	/**
	 * Aktualisiert die Datenbank.
	 * @throws RemoteException Wenn beim Update ein Fehler auftrat.
	 */
	public void update(Version oldVersion, Version newVersion) throws RemoteException;

}
