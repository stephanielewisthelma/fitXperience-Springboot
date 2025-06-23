package com.example.fitXperience.Service.Impl;

import com.example.fitXperience.Repository.PackageRepository;
import com.example.fitXperience.Service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Package createPackage(Package pkg) {
        if (pkg.getTitle() == null || pkg.getPrice() == null) {
            throw new IllegalArgumentException("Package title and price are required");
        }
        return packageRepository.save(pkg);
    }
}
