package com.geekster.ECommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+[0-9]+.*[A-Za-z]+.*[A-Za-z]+")
    private String email;
    
    private String password;
    
    @Size(max=10, min =10)
    @Digits(integer = 10, fraction = 0)
    private String phoneNumber;

    @JsonBackReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address;
//
//    @OneToMany(mappedBy = "")
//    private Order order;
}
