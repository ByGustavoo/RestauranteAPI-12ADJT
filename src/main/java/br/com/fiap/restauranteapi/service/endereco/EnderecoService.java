package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public EnderecoDTO getEnderecoById(Integer id) {
        var endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado com o ID: " + id));

        return new EnderecoDTO(
                endereco.getId(),
                endereco.getUsuario().getNome(),
                endereco.getRua(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getComplemento(),
                endereco.getPontoReferencia(),
                endereco.getCep());
    }
}