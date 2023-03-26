//Luis Camacho

import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
	String name;
	String serialNum;
	int val;

	public void setName(String name) {
		this.name = name;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public int getVal() {
		return val;
	}

	public Inventory(String name, String serialNum, int val) {
		this.name = name;
		this.serialNum = serialNum;
		this.val = val;
	}

	@Override
	public String toString() {
		return name + "," + serialNum + "," + val;
	}
}

class Main {
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		ArrayList<Inventory> inv = new ArrayList<Inventory>();

		int check = 0;

		while (check != 5) {
			System.out.println("Press 1 to add an item.");
			System.out.println("Press 2 to delete an item.");
			System.out.println("Press 3 to update an item.");
			System.out.println("Press 4 to show all the item.");
			System.out.println("Press 5 to quit the program.");

			check = std.nextInt();
			std.nextLine();
			switch (check) {
				// Add Item
				case 1:
					System.out.println("Enter the name:");
					String name = std.nextLine();
					System.out.println("Enter the serial number:");
					String serialNum = std.nextLine();
					System.out.println("Enter the value in dollars (whole number):");
					int val = std.nextInt();
					Inventory item = new Inventory(name, serialNum, val);
					inv.add(item);
					break;

				// Delete Item
				case 2:
					System.out.println("Enter the serial number of the item to delete:");
					String temp = std.nextLine();
					inv.remove(inv.indexOf(temp));
					break;

				// Update Item
				case 3:
					int index = -1;

					System.out.println("Enter the serial number of the item to change:");
					String serialNum2 = std.nextLine();
					for (int i = 0; i < inv.size(); i++)
						if (serialNum2.equals(inv.get(i).getSerialNum()))
							index = i;

					System.out.println("Enter the new name:");
					String name2 = std.nextLine();
					System.out.println("Enter the new value in dollars (whole number):");
					int val2 = std.nextInt();
					std.nextLine();

					inv.get(index).setName(name2);
					inv.get(index).setVal(val2);
					break;

				// Show Items
				case 4:
					for (Inventory i : inv)
						System.out.println(i);
					break;
				// While loop take care of case 5 (exit)
			}

		}

	}
}