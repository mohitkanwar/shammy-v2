package com.mk.blog.shammy.business.users.controller;


import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ErrorResponse;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import com.mk.blog.shammy.framework.user.dto.UserDTO;
import com.mk.blog.shammy.framework.user.errors.UserErrors;
import com.mk.blog.shammy.framework.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public DataResponse<UserDTO> getById(@PathVariable long id) {
        DataResponse<UserDTO> response = new DataResponse<>();

        try {
            Optional<UserDTO> userById = service.getUserById(id);
            if (userById.isPresent()) {
                UserDTO user = null;
                user = userById.get();
                response.setData(user);
                response.setStatus(StatusResponse.SUCCESS);
            } else {
                handleUnknownException(response, UserErrors.USER_NOT_FOUND_WITH_ID.toString(), UserErrors.USER_NOT_FOUND_WITH_ID.getDescription());
            }
        } catch (RuntimeException e) {
            handleUnknownException(response, Errors.WTF.toString(), Errors.WTF.getDescription());
        }
        return response;
    }

    private void handleUnknownException(DataResponse<UserDTO> response, String s, String description) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(s);
        error.setAdditionalInfo(description);
        response.setError(error);
        response.setStatus(StatusResponse.FAILURE);
    }

    @GetMapping("/list")
    public PaginatedListResponse<UserDTO> getList(@RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize,
                                                  @RequestParam(name = "pageNumber",required = false,defaultValue = "0") int pageNumber,
                                                    @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy){
        PaginatedListResponse<UserDTO> response ;

        try {
            response = service.getUsers(pageSize,pageNumber,sortBy);
            response.setStatus(StatusResponse.SUCCESS);
            response.setPageNumber(pageNumber);
            response.setPageSize(pageSize);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response = new PaginatedListResponse<>();
            response.setError(error);

        }
        return response;
    }

    @PostMapping
    public StatusResponse create(@RequestBody UserDTO user) {
        try {
            service.save(user);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @DeleteMapping("/{id}")
    public StatusResponse delete(@PathVariable long id) {
        try {
            service.delete(id);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @PutMapping("/{id}")
    public StatusResponse update(@RequestBody UserDTO user) {
        try {
            service.save(user);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }
}


