package br.com.fiap.restauranteapi.service.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SituacaoCadastroService {

    private final SituacaoCadastroRepository situacaoCadastroRepository;

    public SituacaoCadastroDTO getSituacaoCadastroById(Integer id) {
        var situacaoCadastro = situacaoCadastroRepository.findById(id).orElseThrow(() -> new RuntimeException("Situação de Cadastro não encontrada com o ID: " + id));
        return new SituacaoCadastroDTO(situacaoCadastro.getId(), situacaoCadastro.getDescricao());
    }
}