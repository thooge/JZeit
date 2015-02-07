package de.hoogi.jzeit.server;

import java.rmi.RemoteException;

import de.hoogi.jzeit.rmi.Version;
import de.willuhn.datasource.db.AbstractDBObject;

public class VersionImpl  extends AbstractDBObject implements Version
{

  private static final long serialVersionUID = 1L;

  public VersionImpl() throws RemoteException
  {
    super();
  }

  @Override
  protected String getTableName()
  {
    return "version";
  }

  @Override
  public String getPrimaryAttribute()
  {
    return "id";
  }

  @Override
  public int getVersion() throws RemoteException
  {
    Integer i = (Integer) getAttribute("version");
    return i.intValue();
  }
  @Override
  public void setVersion(int version) throws RemoteException
  {
    setAttribute("version", version);
  }

}
