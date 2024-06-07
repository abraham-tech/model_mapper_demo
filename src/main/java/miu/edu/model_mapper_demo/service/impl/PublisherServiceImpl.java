package miu.edu.model_mapper_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.model_mapper_demo.dto.PublisherDto;
import miu.edu.model_mapper_demo.model.Publisher;
import miu.edu.model_mapper_demo.repository.PublisherRepository;
import miu.edu.model_mapper_demo.service.PublisherService;
import miu.edu.model_mapper_demo.service.Response;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<PublisherDto> addPublisher(PublisherDto publisherDto) {
        //publisherDto contains publisher name and addressDto
        //Create Publisher entity
        Publisher publisher = modelMapper.map(publisherDto, Publisher.class);

        publisher.getPublisherAddress().setPublisher(publisher);
        Publisher savedPublisher = publisherRepository.save(publisher);

        PublisherDto savedPublisherDto = modelMapper.map(savedPublisher, PublisherDto.class);
        return Optional.of(savedPublisherDto);
    }

    @Override
    public Optional<PublisherDto> updatePublisher(String publisherName, PublisherDto publisherDto) {
        Optional<Publisher> foundPublisher = publisherRepository.findPublisherByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            publisher.setPublisherName(publisherDto.getPublisherName());
            Publisher savedPublisher = publisherRepository.save(publisher);

            PublisherDto savedPublisherDto = modelMapper.map(savedPublisher, PublisherDto.class);

            return Optional.of(savedPublisherDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<PublisherDto> findPublisherByName(String publisherName) {
        Optional<Publisher> foundPublisher = publisherRepository.findPublisherByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
            return Optional.of(publisherDto);
        }
        return Optional.empty();
    }

    @Override
    public Response deletePublisher(String publisherName) {
        Optional<Publisher> foundPublisher = publisherRepository.findPublisherByPublisherName(publisherName);
        Response response = Response.ERROR;
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            publisherRepository.delete(publisher);
            response = Response.DELETED;
            return response;
        }
        return response;
    }
}