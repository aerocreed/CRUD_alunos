package br.com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O campo nome precisa ser preenchido")
    private String nome;
    private String nome_social;
    @NotBlank(message = "O campo CPF precisa ser preenchido")
    private String cpf;
    @NotNull
    private Date data_nasc;
    @NotBlank(message = "O campo gênero precisa ser preenchido")
    private String genero;
    @NotBlank(message = "O campo Raça/Cor precisa ser preenchido")
    private String cor;
    @NotBlank(message = "O campo E-mail precisa ser preenchido")
    private String e_mail;
    @NotBlank(message = "O campo telefone precisa ser preenchido")
    private String telefone;
    @NotBlank(message = "O campo nacionalidade precisa ser preenchido")
    private String nacionalidade;
    @NotNull
    private boolean possui_defic;
    @NotNull
    private boolean possui_neces;
    @NonNull
    private boolean situa_itiner;
}
