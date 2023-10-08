import java.util.*;
public class Main {
	Scanner sc = new Scanner (System.in);
	Random rand = new Random();
	ArrayList <Ship> ships = new ArrayList<>();
	String type, name, avail, compName, countryName;
	String shipID = "";
	int troops, crew, menu, passanger;

	public Main() {
		// TODO Auto-generated constructor stub
		do {
			System.out.println("SEAPORT");
			System.out.println("========");
			System.out.println("A simple port and ships management systems.");
			System.out.println("\n" + "1. Insert new ship");
			System.out.println("2. View all ships");
			System.out.println("3. Update ship data");
			System.out.println("4. Exit");
			
			do {
				System.out.print(">> ");
				menu = sc.nextInt(); sc.nextLine(); 
			} while (menu < 1 || menu > 4);
				
			
		
			switch (menu) {
			case 1:
				insert();
				break;

			case 2: 
				view();
				break;
				
			case 3: 
				update();
				break;
				
				
			case 4:
				System.out.println("Thank you for managing SeaPort for us!");
				System.out.println("Press Enter to continue");

			default:
				break;
			}
		
		} while (menu != 4);
		
	}

	public void insert() {
		// TODO Auto-generated method stub
		
		do {
			System.out.print("Ship type [CruiseShip or BattleShip] (case insensitive): ");
			type = sc.nextLine();
		} while (!(type.equalsIgnoreCase("CruiseShip")|| type.equalsIgnoreCase("Battleship")));
		
		if (type.equalsIgnoreCase("CruiseShip")) {
			do {
				System.out.print("Cruiseship's name [5 -20 characters & begin with 'The ']: ");
				name = sc.nextLine();
			} while (name.length()<5 || name.length()>20 || !(name.startsWith("The ")));
			
			do {
				System.out.print("Cruiseship's total crew [higher than 0]: ");
				crew = sc.nextInt(); sc.nextLine();
			} while (crew<=0);
			
			do {
				System.out.print("Cruiseship's available [y/n] (case insensitive): ");
				avail = sc.nextLine();
			} while (!(avail.equalsIgnoreCase("Y")||avail.equalsIgnoreCase("N")));
			
			do {
				System.out.print("Cruiseship's total passanger [higher than 0]: ");
				passanger = sc.nextInt(); sc.nextLine();
			} while (passanger < 1);
			
			do {
				System.out.print("Cruiseship's company name [5 - 20 characters]: ");
				compName = sc.nextLine();
			} while (compName.length()< 5 || compName.length()> 20) ;
			
			// shipID = "CS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			System.out.println("New Cruiseship successfully inserted");
			shipID = "CS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);	
			ships.add(new Cruise(countryName, avail, shipID, crew, passanger, compName));
			System.out.println("Press enter to continue...");
			sc.nextLine();
		
		} else {
			
			do {
				System.out.print("Battleship's country name [5 -20 characters]:  ");
				countryName = sc.nextLine();
			} while (countryName.length()<5 || countryName.length()>20);
			
			
			do {
				System.out.print("Battleship's name [5 -20 characters &  & ends with ' IMS']: ");
				name = sc.nextLine();
			} while (name.length()<5 || name.length()>20 || !(name.endsWith(" IMS")));
			
			
			do {
				System.out.print("Battleship's total crew [higher than 0]: ");
				crew = sc.nextInt(); sc.nextLine();
			} while (crew<=0);
			
			do {
				System.out.print("Battleship's available [y/n] (case insensitive): ");
				avail = sc.nextLine();
			} while (!(avail.equalsIgnoreCase("Y")||avail.equalsIgnoreCase("N")));
			
			do {
				System.out.print("Battleship's total troops [higher than 0]: ");
				troops = sc.nextInt(); sc.nextLine();
			} while (troops< 0);
			
			// shipID = "BS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			System.out.println("New Cruiseship successfully inserted");
			shipID = "BS" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);	
			ships.add(new Battle(compName, avail, shipID, crew, troops, countryName));
			System.out.println("Press enter to continue...");
			sc.nextLine();
		
			
		}
	}

	public void view() {
		// TODO Auto-generated method stub
		if (ships.isEmpty()) {
			System.out.println("There are no ships in the port yet!");
			System.out.println("Press ENTER to continue");
			sc.nextLine();
		} else {
			for (int i = 0; i < ships.size();  i++) {
				if (type.equalsIgnoreCase("Cruiseship")) {
					Cruise CR = (Cruise)ships.get(i);
					System.out.println("< Cruiseships >");
					System.out.println("No: " + (i+1));
					System.out.println("ID: " + ships.get(i).getShipID());
					System.out.println("Ship Name: " + ships.get(i).getName());
					System.out.println("Crew: " + ships.get(i).getCrew());
					if (avail.equalsIgnoreCase("Y")) {
						System.out.println("Available: Yes");
					} else {
						System.out.println("Available: No");
					}
					System.out.println("Passanger: " + CR.passanger);
					System.out.println("Company Name: " + CR.compName);
					
			
				} else {
					Battle BT = (Battle)ships.get(i);
					System.out.println("< Battleships >");
					System.out.println("No: " + (i+1));
					System.out.println("ID: " + ships.get(i).getShipID());
					System.out.println("Ship Name: " + ships.get(i).getName());
					System.out.println("Crew: " + ships.get(i).getCrew());
					if (avail.equalsIgnoreCase("Y")) {
						System.out.println("Available: Yes");
					} else {
						System.out.println("Available: No");
					}
					System.out.println("Troops: " + BT.troops);
					System.out.println("Country Name: " + BT.countryName);
					
				}
				
				System.out.println("Press ENTER to continue");
				sc.nextLine();
				
			}
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		
		view();
		int choose = 0;
		do {
			System.out.println("Pick Ship [1 - " + ships.size() +"]: ");
			choose = sc.nextInt(); sc.nextLine();
		} while (choose < 1 || choose> ships.size());
		
		if (type.equalsIgnoreCase("Cruiseship")){
			do {
				System.out.print("Cruiseship's name [5 -20 characters & begin with 'The ']: ");
				name = sc.nextLine();
			} while (name.length()<5 || name.length()>20 || !(name.startsWith("The ")));
			
			do {
				System.out.print("Cruiseship's total crew [higher than 0]: ");
				crew = sc.nextInt(); sc.nextLine();
			} while (crew<=0);
			
			do {
				System.out.print("Cruiseship's available [y/n] (case insensitive): ");
				avail = sc.nextLine();
			} while (!(avail.equalsIgnoreCase("Y")||avail.equalsIgnoreCase("N")));
			
			do {
				System.out.print("Cruiseship's total passanger [higher than 0]: ");
				passanger = sc.nextInt(); sc.nextLine();
			} while (passanger < 1);
			
			do {
				System.out.print("Cruiseship's company name [5 - 20 characters]: ");
				compName = sc.nextLine();
			} while (compName.length()< 5 || compName.length()> 20) ;
			
			ships.get(choose).setName(name);
			ships.get(choose).setAvail(avail);
			ships.get(choose).setCrew(crew);
			System.out.println("Cruiseship " + ships.get(choose).shipID + "successfully updated!");
			System.out.println("Press enter to continue...");
			sc.nextLine();
			
			
		} else {
			do {
				System.out.print("Battleship's country name [5 -20 characters & ends with ' IMS']: ");
				countryName = sc.nextLine();
			} while (countryName.length()<5 || countryName.length()>20);
			
			
			do {
				System.out.print("Battleship's name [5 -20 characters]: ");
				name = sc.nextLine();
			} while (name.length()<5 || name.length()>20 || !(name.endsWith(" IMS")));
			
			
			do {
				System.out.print("Battleship's total crew [higher than 0]: ");
				crew = sc.nextInt(); sc.nextLine();
			} while (crew<=0);
			
			do {
				System.out.print("Battleship's available [y/n] (case insensitive): ");
				avail = sc.nextLine();
			} while (!(avail.equalsIgnoreCase("Y")||avail.equalsIgnoreCase("N")));
			
			do {
				System.out.print("Battleship's total troops [higher than 0]: ");
				troops = sc.nextInt(); sc.nextLine();
			} while (troops< 0);
			
			
			ships.get(choose).setName(name);
			ships.get(choose).setAvail(avail);
			ships.get(choose).setCrew(crew);
			System.out.println("Battleship " + ships.get(choose).shipID + "successfully updated!");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		

	}

}
