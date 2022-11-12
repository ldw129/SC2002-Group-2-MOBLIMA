package moblima.controller;

import java.util.ArrayList;

/**
 * Returns all prices for different categories and types
 * 
 * @version 1.0
 */

public class GetPrice {

	private ArrayList<Double> prices = TicketPriceIO.readPrices();

	/**
	 * @return 3D Movie surcharge
	 */
	public double get3DPrice() {
		return prices.get(0);
	}

	/**
	 * @return Standard ticket base price
	 */
	public double getStandardPrice() {
		return prices.get(1);
	}

	/**
	 * @return Premium ticket base price
	 */
	public double getPremiumPrice() {
		return prices.get(2);
	}

	/**
	 * @return Platinum ticket base price
	 */
	public double getPlatinumPrice() {
		return prices.get(3);
	}

	/**
	 * @return Child ticket discount price
	 */
	public double getChildPrice() {
		return prices.get(4);
	}

	/**
	 * @return Senior citizen discount price
	 */
	public double getSeniorCitizenPrice() {
		return prices.get(5);
	}

	/**
	 * @return Student discount price
	 */
	public double getStudentPrice() {
		return prices.get(6);
	}

	/**
	 * @return Public holiday surcharge
	 */
	public double getPublicHolidayPrice() {
		return prices.get(7);
	}

	/**
	 * @return GST percentage
	 */
	public double getGSTPrice() {
		return prices.get(8);
	}

}
