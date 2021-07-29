package br.ericpinto.consumerms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private Double[] coordinates;
}
