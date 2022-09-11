package com.github.jcarloscody.restbasicospring.demo.dominio;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    @NotEmpty(message = "CPF é um campo obrigatório!")
    String CPF;
}
