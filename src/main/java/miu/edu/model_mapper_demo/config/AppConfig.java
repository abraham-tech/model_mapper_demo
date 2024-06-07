package miu.edu.model_mapper_demo.config;

import miu.edu.model_mapper_demo.dto.PublisherDto;
import miu.edu.model_mapper_demo.model.Publisher;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Publisher to Publisher DTO
        modelMapper.addMappings(
                new PropertyMap<Publisher, PublisherDto>() {
                    @Override
                    protected void configure() {
                        map().getAddressDto().setCity(source.getPublisherAddress().getCity());
                        map().getAddressDto().setState(source.getPublisherAddress().getState());
                        map().getAddressDto().setStreet(source.getPublisherAddress().getStreet());
                    }
                }
        );

        // Publisher Dto to Publisher
        modelMapper.addMappings(
                new PropertyMap<PublisherDto, Publisher>() {
                    @Override
                    protected void configure() {
                        map().getPublisherAddress().setCity(source.getAddressDto().getCity());
                        map().getPublisherAddress().setState(source.getAddressDto().getState());
                        map().getPublisherAddress().setStreet(source.getAddressDto().getStreet());
                    }
                }
        );

        return modelMapper;
    }
}
