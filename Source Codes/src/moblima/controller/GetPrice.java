package moblima.controller;

import java.util.ArrayList;

/**
 * Returns all prices for different categories and types
 * 
 * @version 1.0
 */

public class GetPrice {

	private ArrayList<Double> prices = TicketPrice.readPrices();

	/**
	 * @return 3D Movie surcharge
	 */
	public double get3DPrice() {
		return prices.get(0);
	}

	/**
	 * @return Standard ticket surcharge
	 */
	public double getStandardPrice() {
		return prices.get(1);
	}

	/**
	 * @return Premium ticket surcharge
	 */
	public double getPremiumPrice() {
		return prices.get(2);
	}

	/**
	 * @return Platinum ticket surcharge
	 */
	public double getPlatinumPrice() {
		return prices.get(3);
	}

	/**
	 * @return Child ticket reduction price
	 */
	public double getChildPrice() {
		return prices.get(4);
	}

	/**
	 * @return Senior citizen reduction price
	 */
	public double getSeniorCitizenPrice() {
		return prices.get(5);
	}

	/**
	 * @return Public holiday surcharge
	 */
	public double getPublicHolidayPrice() {
		return prices.get(6);
	}

	/**
	 * @return GST percentage
	 */
	public double getGSTPrice() {
		return prices.get(7);
	}

}
