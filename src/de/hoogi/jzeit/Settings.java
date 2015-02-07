package de.hoogi.jzeit;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.DecimalFormat;

import de.hoogi.jzeit.rmi.JZeitDBService;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;
import de.willuhn.util.I18N;

/**
 * Verwaltet die Einstellungen des Plugins.
 * @author thooge
 */
public class Settings {

	private static JZeitDBService db = null;
	private static I18N i18n;

	/**
	 * Our DateFormatter.
	 */
	public final static DateFormat DATEFORMAT = DateFormat.getDateInstance(DateFormat.DEFAULT, Application.getConfig().getLocale());
	
	/**
	 * Our decimal formatter.
	 */
	public final static DecimalFormat DECIMALFORMAT = (DecimalFormat) DecimalFormat.getInstance(Application.getConfig().getLocale());

	/**
	 * Our currency name.
	 */
	public final static String CURRENCY = "EUR";

	static
	{
		DECIMALFORMAT.setMinimumFractionDigits(2);
		DECIMALFORMAT.setMaximumFractionDigits(2);
	}

	/**
	 * Small helper function to get the translator.
	 * @return translator.
	 */
	public static I18N i18n()
	{
		if (i18n != null)
			return i18n;
		i18n = Application.getPluginLoader().getPlugin(JZeitPlugin.class).getResources().getI18N();
		return i18n; 
	}

	/**
	 * Liefert den Datenbank-Service.
	 * @return Datenbank.
	 * @throws RemoteException
	 */
	private static JZeitDBService getInternalDBService() throws RemoteException
	{
		if (db == null)
		{
			try
			{
				db = (JZeitDBService) Application.getServiceFactory().lookup(JZeitPlugin.class, "jzeitdb");
			}
			catch (RemoteException e)
			{
				throw e;
			}
			catch (Exception e2)
			{
				Logger.error("unable to load database service", e2);
				throw new RemoteException("Fehler beim Laden des Datenbank-Service", e2);
			}
		}
		return db;
	}

	/**
	 * Liefert den Datenbank-Service.
	 * @return Datenbank.
	 * @throws RemoteException
	 */
	public static JZeitDBService getDBService() throws RemoteException
	{
		db = getInternalDBService();
		return db;
	}

}
