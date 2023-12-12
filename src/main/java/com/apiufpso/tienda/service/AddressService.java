package com.apiufpso.tienda.service;

import com.apiufpso.tienda.exception.NotFoundException;
import com.apiufpso.tienda.model.Address;
import com.apiufpso.tienda.model.User;
import com.apiufpso.tienda.repository.AddressRepository;
import com.apiufpso.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    public Address createAddress(Address address, Long idUser){
        User user = userService.getUserById(idUser);
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address updateStatusAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            throw new NotFoundException(Constants.ADDRESS_NOT_FOUND.getMessage());
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }

    public Address getByIdAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            throw new NotFoundException(Constants.ADDRESS_NOT_FOUND.getMessage());
        }
        return address.get();
    }

    public List<Address> findAllAddress(){
        return (List<Address>) addressRepository.findAll();
    }
}
