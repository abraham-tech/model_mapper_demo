package miu.edu.model_mapper_demo.repository;

import miu.edu.model_mapper_demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByPublisher_PublisherId (Integer publisherId);
}
