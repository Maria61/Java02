package flowerproject.src;

public class FlowerInfo {
	private String name;
	private String other_name;
	private String family;
	private String florescence;
	private String distribution;
	private String characteristics;
	
	public FlowerInfo(String name,String other_name,String family,
			String florescence,String distribution,String characteristics)
	{
		this.name=name;
		this.other_name=other_name;
		this.family=family;
		this.florescence=florescence;
		this.distribution=distribution;
		this.characteristics=characteristics;
	}
	
	public String getOther_name() {
		return other_name;
	}
	public void setOther_name(String other_name) {
		this.other_name = other_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getFlorescence() {
		return florescence;
	}
	public void setFlorescence(String florescence) {
		this.florescence = florescence;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	
	
	
}
