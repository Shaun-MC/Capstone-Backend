package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.PowerSourceLocationUpdateRequest;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class HomeServiceImpl implements HomeService {

    private final HomeRepo homeRepo;

    public HomeServiceImpl(HomeRepo homeRepo) {
        this.homeRepo = homeRepo;
    }

    @Override
    public String createHome(HomeRequest req) {
        
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
    public Homes getHome(UUID id) {

        return homeRepo.findById(id).orElseThrow(() -> new DataNotFoundException("GetHome: Home ID not found in the database"));
    }

    @Override
    public List<Homes> getAllHomes() {
        return homeRepo.findAll();
    }

    @Override
    public String updateNotes(UUID id, NotesUpdateRequest req) {
        
        String notes = req.getNotes();

        Homes home = homeRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateNotes: Home ID not found in the database"));
        home.setNotes(notes);
        homeRepo.save(home);

        return home.getNotes();
    }

    @Override
    public String updatePowerSourceLocation(UUID id, PowerSourceLocationUpdateRequest req) {

        String location = req.getPowerSourceLocation();

        Homes home = homeRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdatePowerSourceLocation: Home ID not found in the database"));
        home.setPowerSourceLocation(location);
        homeRepo.save(home);

        return home.getPowerSourceLocation();
    }

    @Override
    public void deleteHome(UUID id) {

        if (!homeRepo.existsById(id)) {
            throw new DataNotFoundException("DeleteHome: Home ID not found in the database");
        }
        homeRepo.deleteById(id);
    }
}
