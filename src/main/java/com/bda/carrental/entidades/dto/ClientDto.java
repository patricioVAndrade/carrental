package com.bda.carrental.entidades.dto;

import com.bda.carrental.entidades.ClientCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {


    private long id;

    private String firstName;

    private String lastName;

    private String sex;

    private LocalDateTime birthDate;

    private ClientCompany company;

}
