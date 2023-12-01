package scmmicroservices.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplicationProperties {

    // for env db connection
    @Value("${db.driverclass}")
    private String dbDriverClass;
    @Value("${db.url:jdbc:mysql}")
    private String dbUrl;
    @Value("${db.username}")
    private String dbUserName;
    @Value("${db.password}")
    private String dbPassword;

    // db4free - temp hosted db, TBD if needed long-term
    @Value("${dbfree.driverclass}")
    private String dbFreeDriverClass;
    @Value("${dbfree.url:jdbc:mysql}")
    private String dbFreeUrl;
    @Value("${dbfree.username}")
    private String dbFreeUserName;
    @Value("${dbfree.password}")
    private String dbFreePassword;

    // price-service endpoints
    @Value("${priceService}")
    private String priceService;
    @Value("${createPrice}")
    private String createPrice;

    // refdata-service endpoints
    @Value("${refDataService}")
    private String refDataService;
    @Value("${refDataService.getLocationByGeoCode}")
    private String getLocationByGeoCode;
    @Value("${refDataService.validateGeoCodes}")
    private String validateGeoCodes;

    // customer-service endpoints
    @Value("${customerService}")
    private String customerService;
    @Value("${customerService.getCustomer}")
    private String getCustomer;
    @Value("${customerService.validateCustomerIds}")
    private String validateCustomerIds;

}
