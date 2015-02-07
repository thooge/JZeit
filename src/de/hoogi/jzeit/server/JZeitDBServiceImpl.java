package de.hoogi.jzeit.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.rmi.RemoteException;

import de.hoogi.jzeit.JZeitPlugin;
import de.hoogi.jzeit.rmi.DBSupport;
import de.hoogi.jzeit.rmi.JZeitDBService;
import de.hoogi.jzeit.server.DBSupportH2Impl;

import de.willuhn.datasource.db.DBServiceImpl;
import de.willuhn.jameica.plugin.Version;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;
import de.willuhn.sql.ScriptExecutor;
import de.willuhn.util.ProgressMonitor;

public class JZeitDBServiceImpl extends DBServiceImpl implements JZeitDBService
{
	private static final long serialVersionUID = 1L;

	private DBSupport driver = null;

	/**
	 * @throws RemoteException
	 */
	public JZeitDBServiceImpl() throws RemoteException
	{
		this(SETTINGS.getString("database.driver", DBSupportH2Impl.class.getName()));
	}

	/**
	 * Konstruktor mit expliziter Angabe des Treibers.
	 * 
	 * @param driverClass der zu verwendende Treiber.
	 * @throws RemoteException
	 */
	protected JZeitDBServiceImpl(String driverClass) throws RemoteException
	{
		super();
		this.setClassloader(Application.getClassLoader());
		this.setClassFinder(Application.getClassLoader().getClassFinder());
		if (driverClass == null)
			throw new RemoteException("no driver given");
		Logger.info("loading database driver: " + driverClass);
		try
		{
			Class<?> c = Application.getClassLoader().load(driverClass);
			this.driver = (DBSupport) c.newInstance();
		}
		catch (Throwable t)
		{
			throw new RemoteException("unable to load database driver " + driverClass, t);
		}
	}

	@Override
	public String getName()
	{
		return "Datenbank-Service für JMiniPlugin";
	}

	@Override
	protected boolean getAutoCommit() throws RemoteException
	{
		return SETTINGS.getBoolean("autocommit", super.getAutoCommit());
	}

	@Override
	protected String getJdbcDriver()
	{
		return this.driver.getJdbcDriver();
	}

	@Override
	protected String getJdbcPassword()
	{
		return this.driver.getJdbcPassword();
	}

	@Override
	protected String getJdbcUrl()
	{
		return this.driver.getJdbcUrl();
	}

	@Override
	protected String getJdbcUsername()
	{
		return this.driver.getJdbcUsername();
	}

	@Override
	public void install() throws RemoteException
	{
		ProgressMonitor monitor = Application.getCallback().getStartupMonitor();
		monitor.setStatusText("Installiere JZeitPlugin");
		try
		{
			// Die Create Statements werden aus einer Datei einlesen
			String appdir = Application.getPluginLoader().getManifest(JZeitPlugin.class).getPluginDir();
			File create = new File(appdir + File.separator + "sql" + File.separator + driver.getScriptPrefix() + "-create.sql");
			Reader r = new InputStreamReader(new FileInputStream(create), DBSupport.ENCODING_SQL);
			ScriptExecutor.execute(r, getConnection(), monitor);
		}
		catch (Exception e)
		{
			throw new RemoteException(e.getMessage());
		}
	  }

	@Override
	public void update(Version oldVersion, Version newVersion)
	{
		// Bisher noch keine Update-Routine
	}

}
