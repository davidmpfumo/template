package com.cifra.template.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
    private String firstname;
    private String lastname;
	private String username;
	private String password;

//	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//            @JoinTable(
//                    name = "user_role",
//                    joinColumns = {@JoinColumn(name = "user_id")},
//                    inverseJoinColumns = {@JoinColumn(name = "role_id")}
//            )
//	Set<Role> roles = new HashSet<>();

}
