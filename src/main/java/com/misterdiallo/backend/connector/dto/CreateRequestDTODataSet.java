package com.misterdiallo.backend.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestDTODataSet {
//    @NotNull(message = "NAME can't be empty.")
//    @Size(min = 2, message = "NAME can't be less than 2 characters." )
    private String name;

    private String dataSourceId;

}
