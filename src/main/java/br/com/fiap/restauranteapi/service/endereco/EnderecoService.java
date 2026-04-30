package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.enums.Estado;
import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoMapper;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoMapper enderecoMapper;

    private final UsuarioRepository usuarioRepository;

    private final EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public PageResponse<EnderecoDTO> findAll(Pageable pageable) {
        return PageResponse.from(enderecoRepository.findAllFetchUsuario(pageable), EnderecoDTO::new);
    }

    @Transactional
    public MensagemSucessoResponse saveAddress(CriarEnderecoRequest pCriarEnderecoRequest) {
        Estado.verificarEstado(pCriarEnderecoRequest.estado());

        var endereco = enderecoMapper.fromCreateRequestToEntity(pCriarEnderecoRequest);
        endereco.setUsuario(usuarioRepository.getReferenceById(pCriarEnderecoRequest.usuarioId()));

        enderecoRepository.save(endereco);
        return new MensagemSucessoResponse(HttpStatus.CREATED.value(), "Endereço criado com sucesso!");
    }

    @Transactional
    public MensagemSucessoResponse updateAddressById(Integer pId, UpdateAddressRequest pUpdateAddressRequest) {
        Estado.verificarEstado(pUpdateAddressRequest.estado());
        var endereco = enderecoRepository.findById(pId).orElseThrow(EntityNotFoundException::new);

        enderecoMapper.updateEnderecoFromDTO(pUpdateAddressRequest, endereco);
        enderecoRepository.save(endereco);

        return new MensagemSucessoResponse(HttpStatus.OK.value(), "Endereço atualizado com sucesso!");
    }

    @Transactional
    public void deleteAddressById(Integer pId) {
        var address = enderecoRepository.findById(pId).orElseThrow(EntityNotFoundException::new);
        enderecoRepository.delete(address);
    }
}