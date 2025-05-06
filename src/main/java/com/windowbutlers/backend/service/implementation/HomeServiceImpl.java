package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Home;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import com.windowbutlers.backend.validation.ValidUUID;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import org.springframework.stereotype.Component;
import jakarta.validation.Valid;
import java.util.List;

@Component
public class HomeServiceImpl implements HomeService {

    private final HomeRepo homeRepo;

    public HomeServiceImpl(HomeRepo homeRepo) {
        this.homeRepo = homeRepo;
    }

    @Override
    public Integer createHome(@Valid HomeRequest req) {
        
        Home home = new Home();

        home.setNotes(req.getNotes());
        home.setPictureDirectoryURL(req.getPictureDirectoryURL());
        home.setAddressLine1(req.getAddressLine1());
        home.setAddressLine2(req.getAddressLine2());
        home.setCity(req.getCity());
        home.setZipCode(req.getZipCode());
        home.setPowerSourceLocation(req.getPowerSourceLocation());

        homeRepo.save(home);
        return home.getID();
    }

    @Override
    public Home getHome(@ValidIntegerID Integer homeID) {

        return homeRepo.findById(homeID).orElseThrow(() -> new DataNotFoundException("GetHome: Home ID not found in the database"));
    }

    @Override
    public List<Home> getAllHomes() {
        return homeRepo.findAll();
    }

    @Override
    public void updatePowerSourceLocation(@ValidIntegerID Integer homeID, String powerSourceLocation) {

        Home home = homeRepo.findById(homeID).orElseThrow(() -> new DataNotFoundException("UpdatePowerSourceLocation: Home ID not found in the database"));
        home.setPowerSourceLocation(powerSourceLocation);
        homeRepo.save(home);
    }

    @Override
    public void deleteHome(@ValidIntegerID Integer homeID) {

        homeRepo.deleteById(homeID);
    }
}
