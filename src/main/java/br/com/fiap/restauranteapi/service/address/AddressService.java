package br.com.fiap.restauranteapi.service.address;

import br.com.fiap.restauranteapi.enums.State;
import br.com.fiap.restauranteapi.model.dto.address.AddressDTO;
import br.com.fiap.restauranteapi.model.mapper.address.AddressMapper;
import br.com.fiap.restauranteapi.model.request.address.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.address.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.repository.address.AddressRepository;
import br.com.fiap.restauranteapi.repository.user.UserRepository;
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
        address.setUsuario(userRepository.getReferenceById(pCreateAddressRequest.usuarioId()));

        addressRepository.save(address);
        return new SuccessMessageResponse(HttpStatus.CREATED.value(), "Endereço criado com sucesso!");
    }

    @Transactional
    public SuccessMessageResponse updateAddressById(Integer pId, UpdateAddressRequest pUpdateAddressRequest) {
        if (pUpdateAddressRequest.estado() != null) {
            State.validateState(pUpdateAddressRequest.estado());

        }

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