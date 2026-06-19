package com.basri.SpringDataJPA.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "app")
@Data
@Component
public class GlobalPropertiesSecond {
    private List<Server> servers;
}
