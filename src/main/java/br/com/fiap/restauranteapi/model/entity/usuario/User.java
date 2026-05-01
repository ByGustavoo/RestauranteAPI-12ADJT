package br.com.fiap.restauranteapi.model.entity.usuario;

import br.com.fiap.restauranteapi.model.entity.endereco.Address;
import br.com.fiap.restauranteapi.model.entity.situacaocadastro.RegistrationStatus;
import br.com.fiap.restauranteapi.model.entity.tipousuario.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipousuario", nullable = false)
    private UserType id_tipousuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_situacaocadastro", nullable = false)
    private RegistrationStatus id_situacaocadastro;

    @UpdateTimestamp
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

    @OneToMany(mappedBy = "usuario")
    private List<Address> enderecos;

}