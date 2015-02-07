package de.hoogi.jzeit.server;

import java.io.File;
import java.rmi.RemoteException;
import java.sql.Connection;

import de.hoogi.jzeit.rmi.DBSupport;

public abstract class AbstractDBSupportImpl implements DBSupport
{
	private static final long serialVersionUID = 1L;

	@Override
	public void install() throws RemoteException {
		// Do nothing by default
	}

	@Override
	public void execute(Connection conn, File sqlScript) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getScriptPrefix() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQLTimestamp(String content) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getInsertWithID() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTransactionIsolationLevel() throws RemoteException {
		return -1;
	}

}
