package ch.zli.hoeshi.crm.model;

import java.util.List;

public interface Garage {
	public Long getId();
	public String getName();
	public String getOrt();
	public List<Auto> getAutos();
}
