package com.halfacode.userservice.service;

import com.halfacode.userservice.dto.Department;
import com.halfacode.userservice.dto.ResponseTemplateVO;
import com.halfacode.userservice.entity.User;
import com.halfacode.userservice.feign.DepartmentFeign;
import com.halfacode.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DepartmentFeign departmentFeign;
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userid) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userid);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getUserId(), Department.class);
      //  Department department = restTemplate.getForObject("http://localhost:9001/department/"+user.getUserId(), Department.class);
       // Department department =departmentFeign.findDepartmentById(user.getUserId());
        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);
      //  Department department =  departmentFeign.findByDepartmentId(user.getUserId());
//                restTemplate.getForObject("http://localhost:9001/department/"+user.getUserId(), Department.class);
      //  responseTemplateVO.setUser(user);
       // responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
