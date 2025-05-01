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

    private Integer GetHomeID(String address_line_1, String city, String zip_code) {
        return homeRepo.findByAddressLine1AndCityAndZipCode(address_line_1, city, zip_code).orElseThrow(() -> new RuntimeException("GetHomeID: Indexing parameters not found in the database"));
    }

    @Override
    public void CreateHome(Home home) {
        homeRepo.save(home);
    }

    @Override
    public Home GetHome(String address_line_1, String city, String zip_code) {

        try {

            Integer homeID = GetHomeID(address_line_1, city, zip_code);

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
    public Home UpdateHome(Home home, String address_line_1, String city, String zip_code) {

        try {

            Integer homeID = GetHomeID(address_line_1, city, zip_code);

            // Retrieve the existing home from the database
            Home existingHome = homeRepo.findById(homeID).orElseThrow(() -> new RuntimeException("UpdateHome: Home not found in the database"));

            // Update the existing home with the new values
            existingHome.setNotes(home.getNotes());
            existingHome.setPicture_directory_url(home.getPicture_directory_url());
            existingHome.setAddress_line_1(home.getAddress_line_1());
            existingHome.setAddress_line_2(home.getAddress_line_2());
            existingHome.setCity(home.getCity());
            existingHome.setZip_code(home.getZip_code());
            existingHome.setPower_source_location(home.getPower_source_location());

            return homeRepo.save(existingHome);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void DeleteHome(String address_line_1, String city, String zip_code) {

        try {
            Integer homeID = GetHomeID(address_line_1, city, zip_code);
            homeRepo.deleteById(homeID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteClient: Client not found");
        }
    }
}
