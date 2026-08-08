package com.society.client;

import com.society.model.dto.ComplaintDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMPLAINT")
public interface ComplaintClient {
    @GetMapping("/complaints/person/{personId}")
    List<ComplaintDto> getComplaintByPersonId(@PathVariable Long personId);
}
