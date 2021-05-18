package ru.itis.xokken.myanimesity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.xokken.myanimesity.dto.EquipmentDto;
import ru.itis.xokken.myanimesity.repositories.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public EquipmentDto getEquipmentById(Long id) {
        return EquipmentDto.from(equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Error")));
    }
}
