
public abstract class Ship {
	
	protected String name, avail, shipID;
	protected int crew;
	
	public Ship(String name, String avail, String shipID, int crew) {
		super();
		this.name = name;
		this.avail = avail;
		this.shipID = shipID;
		this.crew = crew;
	}

	
	public abstract void GenerateID();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

	public String getShipID() {
		return shipID;
	}

	public void setShipID(String shipID) {
		this.shipID = shipID;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	} 
	
	
	

}
