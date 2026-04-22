package br.com.fiap.restauranteapi.model.entity.endereco;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enderecos", schema = "public")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String rua;

    @NotBlank
    @Column(nullable = false, length = 70)
    private String cidade;

    @NotBlank
    @Column(nullable = false, length = 2)
    private String estado;

    @Column(length = 100)
    private String complemento;

    @Column(name = "ponto_referencia", length = 100)
    private String pontoReferencia;

    @NotBlank
    @Column(nullable = false, length = 8)
    private String cep;

}