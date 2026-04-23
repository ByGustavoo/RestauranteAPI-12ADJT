package br.com.fiap.restauranteapi.service.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SituacaoCadastroService {

    private final SituacaoCadastroRepository situacaoCadastroRepository;

    @Transactional(readOnly = true)
    public SituacaoCadastroDTO getSituacaoCadastroById(Integer pId) {
        var situacaoCadastro = situacaoCadastroRepository.getReferenceById(pId);
        return new SituacaoCadastroDTO(situacaoCadastro.getId(), situacaoCadastro.getDescricao());
    }
}