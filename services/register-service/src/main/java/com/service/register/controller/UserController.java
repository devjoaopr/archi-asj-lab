package com.service.register.controller;

import com.service.register.dto.CreateUserRequest;
import com.service.register.dto.UserResponse;
import com.service.register.service.TenantMigrationService;
import com.service.register.service.TenantService;
import com.service.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private TenantMigrationService migrationService;


    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PostMapping("/tenant/create")
    public String createTenant(@RequestParam("tenantName") String tenantName) {
        tenantService.createTenant(tenantName);
        return "Tenant" + tenantName + "created successfully";
    }

    @PostMapping("/tenants/migrate_all")
    public ResponseEntity<String> migrateAll() {
        migrationService.runLiquibase();
        return new ResponseEntity<>("Migration complete", HttpStatus.OK);
    }


}
