package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.enums.State;
import br.com.fiap.restauranteapi.model.dto.endereco.AddressDTO;
import br.com.fiap.restauranteapi.model.mapper.endereco.AddressMapper;
import br.com.fiap.restauranteapi.model.request.endereco.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.repository.endereco.AddressRepository;
import br.com.fiap.restauranteapi.repository.usuario.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressMapper addressMapper;

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public PageResponse<AddressDTO> findAll(Pageable pPageable) {
        return PageResponse.from(addressRepository.findAllFetchUser(pPageable), AddressDTO::new);
    }

    @Transactional
    public SuccessMessageResponse saveAddress(CreateAddressRequest pCreateAddressRequest) {
        State.validateState(pCreateAddressRequest.estado());

        var address = addressMapper.fromCreateRequestToEntity(pCreateAddressRequest);
        address.setId_usuario(userRepository.getReferenceById(pCreateAddressRequest.usuarioId()));

        addressRepository.save(address);
        return new SuccessMessageResponse(HttpStatus.CREATED.value(), "Endereço criado com sucesso!");
    }

    @Transactional
    public SuccessMessageResponse updateAddressById(Integer pId, UpdateAddressRequest pUpdateAddressRequest) {
        State.validateState(pUpdateAddressRequest.estado());
        var address = addressRepository.findById(pId).orElseThrow(EntityNotFoundException::new);

        addressMapper.updateAddress(pUpdateAddressRequest, address);
        addressRepository.save(address);

        return new SuccessMessageResponse(HttpStatus.OK.value(), "Endereço atualizado com sucesso!");
    }

    @Transactional
    public void deleteAddressById(Integer pId) {
        var address = addressRepository.findById(pId).orElseThrow(EntityNotFoundException::new);
        addressRepository.delete(address);
    }
}