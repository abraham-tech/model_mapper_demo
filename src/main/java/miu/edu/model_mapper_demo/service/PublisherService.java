package miu.edu.model_mapper_demo.service;

import miu.edu.model_mapper_demo.dto.PublisherDto;

import java.util.Optional;

public interface PublisherService {
    Optional<PublisherDto> addPublisher(PublisherDto publisherDto);
    Optional<PublisherDto> updatePublisher(String publisherName, PublisherDto publisherDto);
    Optional<PublisherDto> findPublisherByName(String publisherName);
    Response deletePublisher(String publisherName);
}
