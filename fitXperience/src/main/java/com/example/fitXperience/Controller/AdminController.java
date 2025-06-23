package com.example.fitXperience.Controller;

import com.example.fitXperience.Service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PackageService packageService;

    @PostMapping("/package")
    public ResponseEntity<Package> addPackage(@RequestBody Package pkg) {
        return ResponseEntity.ok(packageService.createPackage(pkg));
    }

    @GetMapping("/packages")
    public ResponseEntity<List<Package>> getAll() {
        return ResponseEntity.ok(packageService.getAllPackages());
    }
}
