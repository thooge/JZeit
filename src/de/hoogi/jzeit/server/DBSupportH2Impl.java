package de.hoogi.jzeit.server;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

import de.hoogi.jzeit.server.AbstractDBSupportImpl;
import de.hoogi.jzeit.JZeitPlugin;
import de.hoogi.jzeit.server.JZeitDBServiceImpl;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;

public class DBSupportH2Impl extends AbstractDBSupportImpl
{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public DBSupportH2Impl()
	{
		// Die H2-Datenbank verwendet Identifier in Großbuchstaben
		Logger.info("switching dbservice to uppercase");
		System.setProperty(JZeitDBServiceImpl.class.getName() + ".uppercase", "true");
		try
		{
			Method m = Application.getClassLoader().load("org.h2.engine.Constants")
				.getMethod("getVersion", (Class<?>[]) null);
			Logger.info("h2 version: " + m.invoke(null, (Object[]) null));
		}
		catch (Throwable t)
		{
			Logger.warn("unable to determine h2 version");
		}
	}

	@Override
	public String getJdbcDriver()
	{
		return "org.h2.Driver";
	}

	@Override
	public String getScriptPrefix() throws RemoteException {
		return "h2";
	}

	@Override
	public String getJdbcUrl()
	{
		String url = "jdbc:h2:" 
			+ Application.getPluginLoader().getPlugin(JZeitPlugin.class).getResources().getWorkPath()
			+ "/h2db/jminiplugin";
		return url;
	}

	@Override
	public String getJdbcUsername()
	{
		return "jzeit";
	}

	@Override
	public String getJdbcPassword()
	{
		return "jzeit";
	}

}
