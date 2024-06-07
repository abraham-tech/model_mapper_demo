package miu.edu.model_mapper_demo.repository;

import miu.edu.model_mapper_demo.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Optional<Publisher> findPublisherByPublisherName(String publisherName);
}
