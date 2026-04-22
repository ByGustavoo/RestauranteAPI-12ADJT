package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional(readOnly = true)
    public EnderecoDTO getEnderecoById(Integer id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado com o ID: " + id));
        return new EnderecoDTO(
                endereco.getId(),
                endereco.getUsuario().getNome(),
                endereco.getRua(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getComplemento(),
                endereco.getPontoReferencia(),
                endereco.getCep()
        );
    }
}
