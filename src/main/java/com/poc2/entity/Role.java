package com.poc2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int role_id;
private String role;

}
