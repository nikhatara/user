package com.demon.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {

        @Id
        private long id;
        private String firstName;
        private String lastName;
        private String emailId;
}
