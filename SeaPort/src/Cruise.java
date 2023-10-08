import java.util.*;

public class Cruise extends Ship {
	Random rand = new Random();
	
	protected int passanger;
	
	protected String compName;
	
	public Cruise(String name, String avail, String shipID, int crew, int passanger, String compName) {
		super(name, avail, shipID, crew);
		this.passanger = passanger;
		this.compName = compName;
	}
	public int getPassanger() {
		return passanger;
	}
	public void setPassanger(int passanger) {
		this.passanger = passanger;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	@Override
	public void GenerateID() {
		// TODO Auto-generated method stub
		shipID = "CS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);	
		
		System.out.println(shipID);
	}
	
	
	
}
