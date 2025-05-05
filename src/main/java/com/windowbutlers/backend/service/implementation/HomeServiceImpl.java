package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Home;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.repository.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepo homeRepo;

    private Integer GetHomeID(String addressLine1, String city, String zipCode) {
        return homeRepo.findByAddressLine1AndCityAndZipCode(addressLine1, city, zipCode).orElseThrow(() -> new RuntimeException("GetHomeID: Indexing parameters not found in the database"));
    }

    @Override
    public void CreateHome(Home home) {
        homeRepo.save(home);
    }

    @Override
    public Home GetHome(String addressLine1, String city, String zipCode) {

        try {

            Integer homeID = GetHomeID(addressLine1, city, zipCode);

            return homeRepo.findById(homeID).orElseThrow(() -> new RuntimeException("GetHome: Home not found in the database"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Home> GetAllHomes() {
        return homeRepo.findAll();
    }

    @Override
    public Home UpdateHome(Home home, String addressLine1, String city, String zipCode) {

        try {

            Integer homeID = GetHomeID(addressLine1, city, zipCode);

            // Retrieve the existing home from the database
            Home existingHome = homeRepo.findById(homeID).orElseThrow(() -> new RuntimeException("UpdateHome: Home not found in the database"));

            // Update the existing home with the new values
            existingHome.setNotes(home.getNotes());
            existingHome.setPictureDirectoryURL(home.getPictureDirectoryURL());
            existingHome.setAddressLine1(home.getAddressLine1());
            existingHome.setAddressLine2(home.getAddressLine2());
            existingHome.setCity(home.getCity());
            existingHome.setZipCode(home.getZipCode());
            existingHome.setPowerSourceLocation(home.getPowerSourceLocation());

            return homeRepo.save(existingHome);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void DeleteHome(String addressLine1, String city, String zipCode) {

        try {
            Integer homeID = GetHomeID(addressLine1, city, zipCode);
            homeRepo.deleteById(homeID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteClient: Client not found");
        }
    }
}
