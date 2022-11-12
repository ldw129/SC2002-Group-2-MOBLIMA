package moblima.view;

import java.util.*;
import moblima.controller.GetPrice;
import moblima.controller.TicketPriceIO;
import moblima.model.AdminChangeStatus;

/**
 * 
 * UI to configure ticket prices
 * 
 * @version 1.0
 *
 */
public class ConfigureTicketPrices {

	/**
	 * Configure all ticket prices
	 * 
	 * @param args default argument
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TicketPrice TP = new TicketPrice();

		boolean back = false;
		double newPrice;
		ArrayList<Double> prices = new ArrayList<>();
		prices = TicketPriceIO.readPrices();

		System.out.println("-- Configure Ticket Prices --");

		while (true) {

			GetPrice getQuotation = new GetPrice();
			System.out.println("");
			System.out.println("1. 3D Movie Surcharge");
			System.out.println("2. Seat Type - Standard");
			System.out.println("3. Seat Type - Premium");
			System.out.println("4. Seat Type - Platinum");
			System.out.println("5. Child Discount");
			System.out.println("6. Senior Citizen Discount");
			System.out.println("7. Student Discount");
			System.out.println("8. Public Holiday Surcharge");
			System.out.println("9. GST %");
			System.out.println("10. IMPLEMENT ALL CHANGES");
			System.out.println("11. Back");
			System.out.println("");

			System.out.print("Select an option: ");
			int choice = input.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Current Surcharge: " + getQuotation.get3DPrice());
					System.out.print("Enter New Surcharge: ");
					newPrice = input.nextDouble();
					prices.set(0, newPrice);
					break;

				case 2:
					System.out.println("Current Surcharge: " + getQuotation.getStandardPrice());
					System.out.print("Enter New Surcharge: ");
					newPrice = input.nextDouble();
					prices.set(1, newPrice);
					break;

				case 3:
					System.out.println("Current Surcharge: " + getQuotation.getPremiumPrice());
					System.out.print("Enter New Surcharge: ");
					newPrice = input.nextDouble();
					prices.set(2, newPrice);
					break;

				case 4:
					System.out.println("Current Surcharge: " + getQuotation.getPlatinumPrice());
					System.out.print("Enter New Surcharge: ");
					newPrice = input.nextDouble();
					prices.set(3, newPrice);
					break;

				case 5:
					System.out.println("Current Reduction: " + getQuotation.getChildPrice());
					System.out.print("Enter New Reduction: ");
					newPrice = input.nextDouble();
					prices.set(4, newPrice);
					break;

				case 6:
					System.out.println("Current Reduction: " + getQuotation.getSeniorCitizenPrice());
					System.out.print("Enter New Reducion: ");
					newPrice = input.nextDouble();
					prices.set(5, newPrice);
					break;

				case 7:
					System.out.println("Current Reduction: " + getQuotation.getStudentPrice());
					System.out.print("Enter New Reducion: ");
					newPrice = input.nextDouble();
					prices.set(6, newPrice);

				case 8:
					System.out.println("Current Surcharge: " + getQuotation.getPublicHolidayPrice());
					System.out.print("Enter New Surcharge: ");
					newPrice = input.nextDouble();
					prices.set(7, newPrice);
					break;

				case 9:
					System.out.println("Current Price: " + getQuotation.getGSTPrice());
					System.out.print("Enter New Price: ");
					newPrice = input.nextDouble();
					prices.set(8, newPrice);
					break;

				case 10:
					TicketPriceIO.writePrices(prices);
					System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
					System.out.println("");
					break;

				case 11:
					back = true;
					break;

				default:
					System.out.println("");
					System.err.println("Invalid Input, Please Try Again!");
					System.out.println("");
					break;
			}

			if (back == true)
				// input.close();
				return;
		}
	}
}
