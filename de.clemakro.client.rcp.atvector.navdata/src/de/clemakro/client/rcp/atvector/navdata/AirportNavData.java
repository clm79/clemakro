package de.clemakro.client.rcp.atvector.navdata;

/**
 * 
 * @author clemens
 *
 */
public class AirportNavData {
	private String recordType;
	private String customerAreaCode;
	private String sectionCode;
	private String icaoCode;
	private String areaCode;
	private String subsectionCode;
	private String iataCode;
	private String continuationRecordNumber;
	private Integer speedLimitAltitude;
	private Integer longestRunwayLength;
	private Boolean longestRunwayIFRCapability;
	private String longestRunwaySurfaceCode;
	private Double latitude;
	private Double longitude;
	private Double magneticVariation;
	private Integer elevation;
	private Integer speedLimit;
	private String recommendedNavaid;
	private Integer transitionAltitude;
	private Integer transitionLevel;
	private String publicMilitaryIndicatorCode;
	private String timeZoneCode;
	private Boolean daylightTimeIndicator;
	private Boolean magneticIndicator;
	private String datumCode;
	private String airportName;
	private Integer fileRecordNumber;
	private String cycle;

	// SUSAP KMEMK7AMEM 0 111YHN35023270W089583600W001000341 1800018000C MNAR
	// MEMPHIS INTL 436721705
	public void parse(String line) {
		recordType = line.substring(0, 0 + 1);
		customerAreaCode = line.substring(1, 1 + 3);
		sectionCode = line.substring(4, 4 + 1);
		icaoCode = line.substring(6, 6 + 4);
		areaCode = line.substring(10, 10 + 2);
		subsectionCode = line.substring(12, 12 + 1);
		iataCode = line.substring(13, 13 + 3);
		continuationRecordNumber = line.substring(21, 21 + 1);
		speedLimitAltitude = parseAltitude(line.substring(22, 22 + 5));
		longestRunwayLength = parseRunwayLength(line.substring(27, 27 + 3));
		longestRunwayIFRCapability = parseYesNoCode(line.substring(30, 30 + 1));
		longestRunwaySurfaceCode = line.substring(31, 31 + 1);
		latitude = parseLatitude(line.substring(32, 32 + 9));
		longitude = parseLongitude(line.substring(41, 41 + 10));
	}

	/**
	 * Parses an altitude string (e.g. 10500, F105, <code>null</code>) as an Integer
	 * in feet
	 * 
	 * @param str
	 * @return Altitude in feet or <code>null</code> if <code>str</code> is
	 *         <code>null</code> or empty
	 */
	private static Integer parseAltitude(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else if (str.startsWith("F"))
			return Integer.parseInt(str.substring(1)) * 100;
		else
			return Integer.parseInt(str);
	}

	/**
	 * Parses a longest runway length <code>String</code> (e.g. 098) as an Integer
	 * in feet (e.g. 9800)
	 * 
	 * @param str
	 * @return Length in feet or <code>null</code> if <code>str</code> is
	 *         <code>null</code> or empty
	 */
	private static Integer parseRunwayLength(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return Integer.parseInt(str) * 100;
	}

	/**
	 * Parses a string equal to <code>Y</code> to true (case insensitive),
	 * <code>null</code> or empty to <code>null</code>, to <code>false</code>
	 * otherwise
	 * 
	 * @param str
	 * @return
	 */
	private static Boolean parseYesNoCode(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else if (str.toUpperCase().equals("Y"))
			return true;
		else
			return false;
	}

	/**
	 * Parses an ARINC latitude (chap. 5.36) to a decimal degree latitude. North
	 * becomes a positive, south a negative number. <code>null</code> or empty
	 * string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	private static Double parseLatitude(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		boolean north = str.substring(0, 1).toUpperCase().equals("N");
		double degrees = Double.parseDouble(str.substring(1, 1 + 2));
		double minutes = Double.parseDouble(str.substring(3, 3 + 2));
		double seconds = Double.parseDouble(str.substring(5, 5 + 2));
		double hundreds = Double.parseDouble(str.substring(7));

		seconds += hundreds / 100d;
		double degreesDecimal = degrees + minutes / 60d + seconds / 3600d;

		return north ? degreesDecimal : degreesDecimal * (-1d);
	}

	/**
	 * Parses an ARINC longitude (chap. 5.37) to a decimal degree latitude. East
	 * becomes a positive, west a negative number. <code>null</code> or empty string
	 * become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	private static Double parseLongitude(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		boolean east = str.substring(0, 1).toUpperCase().equals("E");
		double degrees = Double.parseDouble(str.substring(1, 1 + 3));
		double minutes = Double.parseDouble(str.substring(4, 3 + 2));
		double seconds = Double.parseDouble(str.substring(6, 5 + 2));
		double hundreds = Double.parseDouble(str.substring(8));

		seconds += hundreds / 100d;
		double degreesDecimal = degrees + minutes / 60d + seconds / 3600d;

		return east ? degreesDecimal : degreesDecimal * (-1d);
	}
}
