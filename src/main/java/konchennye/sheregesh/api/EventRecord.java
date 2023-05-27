package konchennye.sheregesh.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class EventRecord {
    private String mylocation;
    private String timeopened;
    private String timezone;
    private String pageon;
    private String referrer;
    private String previousSites;
    private String browserVersion1b;
    private String browserLanguage;
    private String browserOnline;
    private String browserPlatform;
    private String javaEnabled;
    private String dataCookiesEnabled;
    private String dataCookies1;
    private String dataCookies2;
    private String dataStorage;
    private String sizeScreenW;
    private String sizeScreenH;
    private String sizeDocW;
    private String sizeDocH;
    private String sizeInW;
    private String sizeInH;
    private String sizeAvailW;
    private String sizeAvailH;
    private String scrColorDepth;
    private String scrPixelDepth;
    private String latitude;
    private String longitude;
    private String accuracy;
    private String altitude;
    private String altitudeAccuracy;
    private String heading;
    private String speed;
    private String timestamp;
    private String iniframe;
}
