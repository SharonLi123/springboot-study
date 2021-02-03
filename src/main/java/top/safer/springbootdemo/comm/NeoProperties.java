package top.safer.springbootdemo.comm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 同时注入多个属性
 * @author sakura
 */
@Component
@ConfigurationProperties(prefix = "neo")
@Data
public class NeoProperties {
    private String title;
    private String description;
}
