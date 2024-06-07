package miu.edu.model_mapper_demo;

import lombok.RequiredArgsConstructor;
import miu.edu.model_mapper_demo.dto.AddressDto;
import miu.edu.model_mapper_demo.dto.PublisherDto;
import miu.edu.model_mapper_demo.service.PublisherService;
import miu.edu.model_mapper_demo.service.Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ModelMapperDemoApplication implements CommandLineRunner {

    private final PublisherService publisherService;

    @Override
    public void run(String... args) throws Exception {
        PublisherDto publisherDto = new PublisherDto("Apres");
        AddressDto addressDto = new AddressDto("2000 N Court", "Fairfield", "IA");

        publisherDto.setAddressDto(addressDto);

        System.out.println(
                publisherService.addPublisher(publisherDto).get() + " is saved."
        );
        //update
        PublisherDto publisherDto2 = new PublisherDto("Apress");
        System.out.println(
                publisherService.updatePublisher("Apres", publisherDto2).get() + " Modified."
        );

        // Delete
        Response response = publisherService.deletePublisher("Apress");
        System.out.println("Apress " + response.getVal());

    }

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }

}
