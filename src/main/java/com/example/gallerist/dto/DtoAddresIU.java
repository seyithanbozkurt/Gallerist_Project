package com.example.gallerist.dto;



import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DtoAddresIU { //Insert Ederken kullanıcam geriye Dto Address kullanıcam.

    @NotEmpty
    private String city;

    @NotEmpty
    private String district;

    @NotEmpty
    private String neighborhood;

    @NotEmpty
    private String street;
}
