package com.marks.genericstore.model;

import java.util.UUID;

import com.marks.genericstore.model.enums.ERole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissao")
public class Permissao {

    @Id
    private UUID id;

    private ERole name;
}
