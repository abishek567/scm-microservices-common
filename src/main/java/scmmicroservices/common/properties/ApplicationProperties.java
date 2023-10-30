package scmmicroservices.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplicationProperties {

    @Value("${db.driverclass}")
    private String dbDriverClass;
    @Value("${db.url:jdbc:mysql}")
    private String dbUrl;
    @Value("${db.username}")
    private String dbUserName;
    @Value("${db.password}")
    private String dbPassword;

    @Value("${priceService}")
    private String priceService;

    @Value("${createPrice}")
    private String createPrice;
}
