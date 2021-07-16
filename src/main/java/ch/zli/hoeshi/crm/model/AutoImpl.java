package ch.zli.hoeshi.crm.model;
/**/
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Auto")
public class AutoImpl implements Auto {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer kennzeichen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AppUserImpl mieter;
	@ManyToOne(cascade = CascadeType.DETACH)
	private GarageImpl garage;
	protected AutoImpl() {}
	
	public AutoImpl(Long id, String name, Integer kennzeichen, AppUser mieter, Garage garage) {
		this.id = id;
		this.name = name;
		this.kennzeichen = kennzeichen;
		this.mieter = (AppUserImpl) mieter;
		this.garage = (GarageImpl) garage;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Integer getKennzeichen() {
		// TODO Auto-generated method stub
		return kennzeichen;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setKennzeichen(Integer kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	@Override
	public Long getID() {
		return id;
	}

	@Override
	public AppUser getMieter() {
		return mieter;
	}
	
}
