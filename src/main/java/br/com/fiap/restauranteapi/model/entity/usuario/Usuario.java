package br.com.fiap.restauranteapi.model.entity.usuario;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.model.entity.situacao.SituacaoCadastro;
import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
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
public class Usuario {

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
    private TipoUsuario tipoUsuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_situacaocadastro", nullable = false)
    private SituacaoCadastro situacaoCadastro;

    @UpdateTimestamp
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

}