package com.basri.SpringDataJPA.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceDTO {
    private String url;

    private String username;

    private String password;
}
