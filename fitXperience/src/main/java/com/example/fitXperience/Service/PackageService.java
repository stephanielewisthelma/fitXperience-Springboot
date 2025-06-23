package com.example.fitXperience.Service;


import java.util.List;

public interface PackageService {
    List<Package> getAllPackages();
    Package createPackage(Package pkg);
}