package com.example.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "tbl_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El número de documento no puede ser vacío")
    @Size( min = 8 , max = 8, message = "El tamaño del número de documento es 8")
    @Column(name = "number_id" , unique = true, length = 8, nullable = false)
    private String numberID;

    @NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name="first_name", nullable=false)
    private String firstName;

    @NotEmpty(message = "El apellido no puede ser vacío")
    @Column(name="last_name", nullable=false)
    private String lastName;

    @NotEmpty(message = "el correo no puede estar vacío")
    @Email(message = "no es un dirección de correo bien formada")
    @Column(unique=true, nullable=false)
    private String email;

    @Column(name="photo_url")
    private String photoUrl;

    @NotNull(message = "la región no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    private String state;
}
