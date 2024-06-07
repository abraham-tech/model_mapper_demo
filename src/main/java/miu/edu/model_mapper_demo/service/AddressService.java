package miu.edu.model_mapper_demo.service;

import miu.edu.model_mapper_demo.dto.AddressDto;

import java.util.Optional;

public interface AddressService {
    AddressDto updateAddress(AddressDto addressDto);
    Optional<AddressDto> findAddressById(Integer id);
}
