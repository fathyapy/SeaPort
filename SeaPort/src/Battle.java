import java.util.*;

public class Battle extends Ship {
	Random rand = new Random();
	
	protected int troops;
	protected String countryName;
	
	public Battle(String name, String avail, String shipID, int crew, int troops, String countryName) {
		super(name, avail, shipID, crew);
		this.troops = troops;
		this.countryName = countryName;
	}

	public int getTroops() {
		return troops;
	}

	public void setTroops(int troops) {
		this.troops = troops;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public void GenerateID() {
		// TODO Auto-generated method stub
		shipID = "BS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		System.out.println(shipID);
	}
	
	
	
	
	
	
}
