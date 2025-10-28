package com.example.explorecalijpa.business;

import com.example.explorecalijpa.model.Staff;
import com.example.explorecalijpa.repo.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff createStaff(Integer id, String name, String surname, String email) {
        return staffRepository.findById(id)
                   .orElse(staffRepository.save(
                       new Staff(id, name, surname, email)
                   ));
    }

    public List<Staff> lookupAll() {
        return staffRepository.findAll();
    }

    public long total() {
        return staffRepository.count();
    }

}
