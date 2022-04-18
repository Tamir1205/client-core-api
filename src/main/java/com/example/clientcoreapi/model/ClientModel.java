package com.example.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
   @NotNull
   private String clientId;
   private String clientName;
   private String clientLastName;
   @NotNull(message = "Email can not be empty")
   @Email(message="Incorrect Email")
   private String clientEmail;
}
