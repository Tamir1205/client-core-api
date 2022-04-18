package com.example.clientcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="client_table")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    private String clientId;
    @Column(nullable = false,length = 50)
    private String clientName;
    @Column(nullable = false,length = 50)

    private String clientLastName;
    @Column(nullable = false,length = 50)

    private String clientEmail;
}
