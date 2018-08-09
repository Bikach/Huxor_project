package fr.huxor.util;

public enum CarBrand {
	
	PEU("PEUGEOT"), REN("RENAULT"), CIT("CITROEN"), FIA("FIAT"), FOR("FORD"), MER("MERCEDES-BENZ"), 
	BMW("BMW"), HYU("HUYNDAI"), KIA("KIA"), DS("DS"), SKO("SKODA"), ALF("ALFA-ROMEO"),
	OPE("OPEL"), AUS("AUSTIN-MINI"), VOL("VOLKSWAGEN");
	
	String name;
	
	CarBrand(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
