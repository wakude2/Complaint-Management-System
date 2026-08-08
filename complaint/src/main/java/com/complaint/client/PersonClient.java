package com.complaint.client;

import com.complaint.model.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "personClient", url = "${person.service.url}")
public interface PersonClient {
    @GetMapping("/persons/{id}")
    PersonDto getSinglePerson(@PathVariable Long id);
}
