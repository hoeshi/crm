package ch.zli.hoeshi.crm.controller;

import ch.zli.hoeshi.crm.model.Auto;

public class AutoDto {
		public Long id;
		public final String name;
		public Integer kennzeichen;
		
	public AutoDto(Auto auto) {
		this.id = auto.getID();
		this.name = auto.getName();
		this.kennzeichen = auto.getKennzeichen();
		
	}
}
