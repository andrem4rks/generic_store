package com.marks.genericstore.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(unique = true)
    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_tem_permissao", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "permissao_id", referencedColumnName = "id"))
    List<Permissao> permissoes = new ArrayList<Permissao>();

    public void setPassword(String password) {
        this.password = (new BCryptPasswordEncoder().encode(password));
    }

    public boolean hasPermission(Permissao permissao) {
        return this.permissoes.contains(permissao);
    }

    public void addPermission(Permissao permissao) {
        if (!hasPermission(permissao))
            this.permissoes.add(permissao);
    }

    public void removePermission(Permissao permissao) {
        if (!hasPermission(permissao))
            this.permissoes.remove(permissao);
    }
}
