package de.clemakro.client.rcp.atvector.navdata;

public abstract class ArincNavdata {
	private String recordType;
	private String customerAreaCode;
	private String sectionCode;

	private Integer fileRecordNumber;
	private String cycle;

	public void parse(String line) {
		recordType = parseString(line.substring(0, 0 + 1));
		customerAreaCode = parseString(line.substring(1, 1 + 3));
		sectionCode = parseString(line.substring(4, 4 + 1));
		fileRecordNumber = Integer.parseInt(line.substring(123, 123 + 5));
		cycle = parseString(line.substring(128, 128 + 4));
	}

	public String getRecordType() {
		return recordType;
	}

	public String getCustomerAreaCode() {
		return customerAreaCode;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public Integer getFileRecordNumber() {
		return fileRecordNumber;
	}

	public String getCycle() {
		return cycle;
	}

	/**
	 * Parses a string. Trims the input string. <code>null</code> or empty (trimmed) strings become null.
	 * 
	 * @param str
	 * @return
	 */
	protected static String parseString(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return str.trim();
	}

	/**
	 * Parses an ARINC altitude string (chap. 5.53, 5.73) (e.g. 10500, F105, <code>null</code>) as an Integer in feet
	 * 
	 * @param str
	 * @return Altitude in feet or <code>null</code> if <code>str</code> is <code>null</code> or empty
	 */
	protected static Integer parseAltitude(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else if (str.startsWith("F"))
			return Integer.parseInt(str.substring(1)) * 100;
		else
			return Integer.parseInt(str);
	}

	/**
	 * Parses an ARINC longest runway length (chap. 5.54) <code>String</code> (e.g. 098) as an Integer in feet (e.g. 9800)
	 * 
	 * @param str
	 * @return Length in feet or <code>null</code> if <code>str</code> is <code>null</code> or empty
	 */
	protected static Integer parseLongestRunwayLength(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return Integer.parseInt(str) * 100;
	}

	/**
	 * Parses a string equal to <code>Y</code> to true (case insensitive), <code>null</code> or empty to <code>null</code>, to <code>false</code> otherwise
	 * 
	 * @param str
	 * @return
	 */
	protected static Boolean parseYesNoCode(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else if (str.toUpperCase().equals("Y"))
			return true;
		else
			return false;
	}

	/**
	 * Parses an ARINC latitude (chap. 5.36) to a decimal degree latitude. North becomes a positive, south a negative number. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Double parseLatitude(String str) {
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
	 * Parses an ARINC longitude (chap. 5.37) to a decimal degree latitude. East becomes a positive, west a negative number. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Double parseLongitude(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		boolean east = str.substring(0, 1).toUpperCase().equals("E");
		double degrees = Double.parseDouble(str.substring(1, 1 + 3));
		double minutes = Double.parseDouble(str.substring(4, 4 + 2));
		double seconds = Double.parseDouble(str.substring(6, 6 + 2));
		double hundreds = Double.parseDouble(str.substring(8));

		seconds += hundreds / 100d;
		double degreesDecimal = degrees + minutes / 60d + seconds / 3600d;

		return east ? degreesDecimal : degreesDecimal * (-1d);
	}

	/**
	 * Parses an ARINC magnetic variation (chap. 5.39) to a decimal degree value. East becomes a positive, west a negative number. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Double parseMagneticVariation(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		boolean trueNorth = str.substring(0, 1).toUpperCase().equals("T");
		if (trueNorth)
			return 0.0d;

		boolean east = str.substring(0, 1).toUpperCase().equals("E");
		double degrees = Double.parseDouble(str.substring(1, 1 + 2));
		double hundreds = Double.parseDouble(str.substring(3, 3 + 2));

		double degreesDecimal = degrees + hundreds / 100d;

		return east ? degreesDecimal : degreesDecimal * (-1d);
	}

	/**
	 * Parses an ARINC elevation (chap. 5.55, 5.67, 5.68) to an <code>Integer</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Integer parseElevation(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return Integer.parseInt(str);
	}

	/**
	 * Parses an ARINC speed limit (chap. 5.72) to an <code>Integer</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Integer parseSpeedLimit(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return Integer.parseInt(str);
	}

	/**
	 * Parses an ARINC magnetic indicator (chap. 5.165) to a <code>Boolean</code> value. M becomes <code>true</code>, any other indicator becomes <code>false</code>. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Boolean parseMagneticIndicator(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else
			return str.toUpperCase().equals("M");
	}

	/**
	 * Parses an ARINC runway length (chap. 5.57, 5.69, 5.109) to an <code>Integer</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Integer parseRunwayLength(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		return Integer.parseInt(str);
	}

	/**
	 * Parses an ARINC runway bearing (chap. 5.58) to a <code>Double</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Double parseRunwayBearing(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		double degrees = Double.parseDouble(str.substring(0, 0 + 3));
		double tenth = str.endsWith("T") ? 0d : Double.parseDouble(str.substring(3, 3 + 1));

		return degrees + tenth / 10d;
	}

	/**
	 * Parses an ARINC runway bearing (chap. 5.58) and returns <code>falsee</code> if the value is true north, <code>false</code> otherwise. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Boolean parseRunwayBearingMagnetic(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		else if (str.endsWith("T"))
			return false;
		else
			return true;
	}

	/**
	 * Parses an ARINC runway gradient (chap. 5.212) to a <code>Double</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Double parseRunwayGradient(String str) {
		if (str == null || str.trim().length() == 0)
			return null;

		double degrees = Double.parseDouble(str.substring(0, 0 + 2));
		double thousands = Double.parseDouble(str.substring(2, 2 + 3));

		return degrees + thousands / 1000d;
	}

	/**
	 * Parses an ARINC ellipsoidal height (chap. 5.225) to a <code>Integer</code> value. <code>null</code> or empty string become <code>null</code>
	 * 
	 * @param str
	 * @return
	 */
	protected static Integer parseEllipsoidalHeight(String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		return Integer.parseInt(str);
	}
}
