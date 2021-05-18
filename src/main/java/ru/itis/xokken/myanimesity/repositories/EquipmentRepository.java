package ru.itis.xokken.myanimesity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.xokken.myanimesity.models.Equipment;



public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
