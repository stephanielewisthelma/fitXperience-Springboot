package com.example.fitXperience.Service;


import com.example.fitXperience.Model.Package;

import java.util.List;

public interface PackageService {
    List<Package> getAllPackages();
    Package createPackage(Package pkg);
}