package com.basri.SpringDataJPA.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    private String ip;
    private String location;
}
