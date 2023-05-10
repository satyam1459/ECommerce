package com.geekster.ECommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.jdi.LongType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Pattern(regexp = "^[A-Z].*")
    private String userName;

    @NotBlank
    @Email
    private String email;

    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20 characters")   // The @Pattern annotation specifies that the password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character (i.e., one of @#$%^&+=!).
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$", message = "Password must contain at least one digit, one lowercase, one uppercase letter and one special character")
    private String password;
    
    @Size(max=12, min =10)
    @Digits(integer = 12, fraction = 0)
    private String phoneNumber;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address;
}
