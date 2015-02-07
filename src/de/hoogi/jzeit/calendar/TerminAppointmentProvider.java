package de.hoogi.jzeit.calendar;

import java.util.Date;
import java.util.List;

import de.willuhn.jameica.gui.calendar.Appointment;
import de.willuhn.jameica.gui.calendar.AppointmentProvider;

public class TerminAppointmentProvider implements AppointmentProvider
{

	@Override
	public String getName() {
		return "Termine";
	}

	@Override
	public List<Appointment> getAppointments(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
