package de.clemakro.client.rcp.atvector.navdata;

public class RunwayNavData extends ArincNavdata {
	private String icaoCode;
	private String areaCode;
	private String subsectionCode;
	private String runwayIdent;
	private String continuationRecordNumber;
	private Integer runwayLength;
	private Double runwayBearing;
	private Boolean runwayBearingMagnetic;
	private Double latitude;
	private Double longitude;
	private Double runwayGradient;
	private Integer ltpEllipsoidalHeight;
	private Integer landingThresholdElevation;
	private Integer thresholdDisplacementDistance;
	private Integer thresholdCrossingHeight;
	private Integer runwayWidth;
	private String primaryLMGIdentifier;
	private String primaryLMGClass;
	private Integer primaryStopway;
	private String secondaryLMGIdentifier;
	private String secondaryLMGClass;
	private String runwayDescription;

	public static void main(String[] args) {
		String line = "SUSAP KMEMK7GRW36C   0111203600 N35012658W089583190         +0076500341000056150IITSE3                                     452791705";
		RunwayNavData runwayNavData = new RunwayNavData();
		runwayNavData.parse(line);
		runwayNavData.hashCode();
	}

	@Override
	public void parse(String line) {
		super.parse(line);
		icaoCode = parseString(line.substring(6, 6 + 4));
		areaCode = parseString(line.substring(10, 10 + 2));
		subsectionCode = parseString(line.substring(12, 12 + 1));
		runwayIdent = parseString(line.substring(13, 13 + 5));
		continuationRecordNumber = parseString(line.substring(21, 21 + 1));
		runwayLength = parseRunwayLength(line.substring(22, 22 + 5));
		runwayBearing = parseRunwayBearing(line.substring(27, 27 + 4));
		runwayBearingMagnetic = parseRunwayBearingMagnetic(line.substring(27, 27 + 4));
		latitude = parseLatitude(line.substring(32, 32 + 9));
		longitude = parseLongitude(line.substring(41, 41 + 10));
		runwayGradient = parseRunwayGradient(line.substring(51, 51 + 5));
		ltpEllipsoidalHeight = parseEllipsoidalHeight(line.substring(60, 60 + 6));
		landingThresholdElevation = parseElevation(line.substring(66, 66 + 5));
		thresholdDisplacementDistance = parseRunwayLength(line.substring(71, 71 + 4));
		thresholdCrossingHeight = parseElevation(line.substring(75, 75 + 2));
		runwayWidth = parseRunwayLength(line.substring(77, 77 + 3));
		primaryLMGIdentifier = parseString(line.substring(81, 81 + 4));
		primaryLMGClass = parseString(line.substring(85, 85 + 1));
		primaryStopway = parseRunwayLength(line.substring(86, 86 + 4));
		secondaryLMGIdentifier = parseString(line.substring(90, 90 + 4));
		secondaryLMGClass = parseString(line.substring(94, 94 + 1));
		runwayDescription = parseString(line.substring(101, 101 + 22));
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

	public String getRunwayIdent() {
		return runwayIdent;
	}

	public String getContinuationRecordNumber() {
		return continuationRecordNumber;
	}

	public Integer getRunwayLength() {
		return runwayLength;
	}

	public Double getRunwayBearing() {
		return runwayBearing;
	}

	public Boolean getRunwayBearingMagnetic() {
		return runwayBearingMagnetic;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getRunwayGradient() {
		return runwayGradient;
	}

	public Integer getLtpEllipsoidalHeight() {
		return ltpEllipsoidalHeight;
	}

	public Integer getLandingThresholdElevation() {
		return landingThresholdElevation;
	}

	public Integer getThresholdDisplacementDistance() {
		return thresholdDisplacementDistance;
	}

	public Integer getThresholdCrossingHeight() {
		return thresholdCrossingHeight;
	}

	public Integer getRunwayWidth() {
		return runwayWidth;
	}

	public String getPrimaryLMGIdentifier() {
		return primaryLMGIdentifier;
	}

	public String getPrimaryLMGClass() {
		return primaryLMGClass;
	}

	public Integer getPrimaryStopway() {
		return primaryStopway;
	}

	public String getSecondaryLMGIdentifier() {
		return secondaryLMGIdentifier;
	}

	public String getSecondaryLMGClass() {
		return secondaryLMGClass;
	}

	public String getRunwayDescription() {
		return runwayDescription;
	}

}
