package com.example.retos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos.entities.Farm;
import com.example.retos.repositories.FarmRepository;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }
    // CRUD

    // GET
    public List<Farm> getListFarm() {
        return this.farmRepository.findAll();
    }

    // GET ID
    public Farm getFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            return this.farmRepository.findById(id).get();
        } else {
            return null;
        }

    }

    // POST
    public Farm crearFarm(Farm Farm) {
        return this.farmRepository.save(Farm);
    }

    // DELETE
    public boolean eliminarFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            this.farmRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    // PUT ACTUALIZAR
    public boolean actualizarFarm(int id, Farm farmSet) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            Farm farm = farmRepository.findById(id).get();
            if (farmSet.getName() != null) {
                farm.setName(farmSet.getName());
            }
            if (farmSet.getAddress() != null) {
                farm.setAddress(farmSet.getAddress());
            }
            if (farmSet.getExension() != null) {
                farm.setExension(farmSet.getExension());
            }
            if (farmSet.getCategory_id() != null) {
                farm.setCategory_id(farmSet.getCategory_id());
            }
            this.farmRepository.save(farm);
            return true;

        } else {
            return false;
        }

    }
}
