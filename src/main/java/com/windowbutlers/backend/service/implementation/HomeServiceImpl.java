package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Component;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Component
public class HomeServiceImpl implements HomeService {

    private final HomeRepo homeRepo;

    public HomeServiceImpl(HomeRepo homeRepo) {
        this.homeRepo = homeRepo;
    }

    @Override
    public String createHome(@Valid HomeRequest req) {
        
        Homes home = new Homes();

        home.setNotes(req.getNotes());
        home.setPictureDirectoryURL(req.getPictureDirectoryURL());
        home.setAddressLine1(req.getAddressLine1());
        home.setAddressLine2(req.getAddressLine2());
        home.setCity(req.getCity());
        home.setZipCode(req.getZipCode());
        home.setPowerSourceLocation(req.getPowerSourceLocation());

        homeRepo.save(home);
        return home.getId().toString();
    }

    @Override
    public Homes getHome(@ValidUUID String ID) {

        return homeRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("GetHome: Home ID not found in the database"));
    }

    @Override
    public List<Homes> getAllHomes() {
        return homeRepo.findAll();
    }

    @Override
    public void updatePowerSourceLocation(@ValidUUID String ID, String powerSourceLocation) {

        Homes home = homeRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdatePowerSourceLocation: Home ID not found in the database"));
        home.setPowerSourceLocation(powerSourceLocation);
        homeRepo.save(home);
    }

    @Override
    public void deleteHome(@ValidUUID String ID) {

        homeRepo.deleteById(UUID.fromString(ID));
    }
}
