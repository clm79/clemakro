package de.clemakro.client.rcp.atvector.navdata;

/**
 * 
 * @author clemens
 *
 */
public class AirportNavData extends ArincNavdata {
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

	public static void main(String[] args) {
		String line = "SUSAP KAWMK4AAWM     0     060YHN35080620W090140400E001000213         1800018000C    MNAR    WEST MEMPHIS MUNI             212801702";
		AirportNavData airportNavData = new AirportNavData();
		airportNavData.parse(line);
		airportNavData.hashCode();
	}

	@Override
	public void parse(String line) {
		super.parse(line);
		icaoCode = parseString(line.substring(6, 6 + 4));
		areaCode = parseString(line.substring(10, 10 + 2));
		subsectionCode = parseString(line.substring(12, 12 + 1));
		iataCode = parseString(line.substring(13, 13 + 3));
		continuationRecordNumber = parseString(line.substring(21, 21 + 1));
		speedLimitAltitude = parseAltitude(line.substring(22, 22 + 5));
		longestRunwayLength = parseLongestRunwayLength(line.substring(27, 27 + 3));
		longestRunwayIFRCapability = parseYesNoCode(line.substring(30, 30 + 1));
		longestRunwaySurfaceCode = line.substring(31, 31 + 1);
		latitude = parseLatitude(line.substring(32, 32 + 9));
		longitude = parseLongitude(line.substring(41, 41 + 10));
		magneticVariation = parseMagneticVariation(line.substring(51, 51 + 5));
		elevation = parseElevation(line.substring(56, 56 + 5));
		speedLimit = parseSpeedLimit(line.substring(61, 61 + 3));
		recommendedNavaid = parseString(line.substring(64, 64 + 4));
		transitionAltitude = parseAltitude(line.substring(70, 70 + 5));
		transitionLevel = parseAltitude(line.substring(75, 75 + 5));
		publicMilitaryIndicatorCode = parseString(line.substring(80, 80 + 1));
		timeZoneCode = parseString(line.substring(81, 81 + 3));
		daylightTimeIndicator = parseYesNoCode(line.substring(84, 84 + 1));
		magneticIndicator = parseMagneticIndicator(line.substring(85, 85 + 1));
		datumCode = parseString(line.substring(86, 86 + 3));
		airportName = parseString(line.substring(93, 93 + 30));
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getSubsectionCode() {
		return subsectionCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public String getContinuationRecordNumber() {
		return continuationRecordNumber;
	}

	public Integer getSpeedLimitAltitude() {
		return speedLimitAltitude;
	}

	public Integer getLongestRunwayLength() {
		return longestRunwayLength;
	}

	public Boolean getLongestRunwayIFRCapability() {
		return longestRunwayIFRCapability;
	}

	public String getLongestRunwaySurfaceCode() {
		return longestRunwaySurfaceCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getMagneticVariation() {
		return magneticVariation;
	}

	public Integer getElevation() {
		return elevation;
	}

	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public String getRecommendedNavaid() {
		return recommendedNavaid;
	}

	public Integer getTransitionAltitude() {
		return transitionAltitude;
	}

	public Integer getTransitionLevel() {
		return transitionLevel;
	}

	public String getPublicMilitaryIndicatorCode() {
		return publicMilitaryIndicatorCode;
	}

	public String getTimeZoneCode() {
		return timeZoneCode;
	}

	public Boolean getDaylightTimeIndicator() {
		return daylightTimeIndicator;
	}

	public Boolean getMagneticIndicator() {
		return magneticIndicator;
	}

	public String getDatumCode() {
		return datumCode;
	}

	public String getAirportName() {
		return airportName;
	}
}
