package com.halfacode.userservice.feign;

import com.halfacode.userservice.dto.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department", url = "${client.post.department}")
public interface DepartmentFeign {

    @GetMapping("/{id}")
    Department findDepartmentById(@PathVariable("id") Long id);


}
