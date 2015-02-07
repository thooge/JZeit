package de.hoogi.jzeit.rmi;

import java.rmi.RemoteException;

import de.willuhn.datasource.rmi.DBObject;

public  interface Version extends DBObject {

  public int getVersion() throws RemoteException;
  public void setVersion(int version) throws RemoteException;

}
