package ru.itis.xokken.myanimesity.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.xokken.myanimesity.dto.EquipmentDto;
import ru.itis.xokken.myanimesity.dto.WorldDto;
import ru.itis.xokken.myanimesity.services.EquipmentService;
import ru.itis.xokken.myanimesity.services.WorldService;

import java.util.List;

@RestController
public class RestApiController {
    @Autowired
    EquipmentService equipmentService;

    @Autowired
    WorldService worldService;

    @GetMapping("/worlds")
    @ResponseBody
    public ResponseEntity<List<WorldDto>> getWorlds(){
        return ResponseEntity.ok(worldService.getWorlds());
    }

    @PostMapping("/worlds")
    public ResponseEntity<WorldDto> addWorld(@RequestBody WorldDto worldDto){
        System.out.println(worldDto.toString());
        WorldDto newWorldDto = worldService.addWorld(worldDto);
        return ResponseEntity.ok(newWorldDto);
    }

    @PutMapping("/worlds/{world-id}")
    public ResponseEntity<WorldDto> updateWorld(@PathVariable("world-id") Long id, @RequestBody WorldDto worldDto){
        return ResponseEntity.ok(worldService.updateWorld(id, worldDto));
    }

    @DeleteMapping("/worlds/{world-id}")
    public ResponseEntity<?> deleteWorld(@PathVariable("world-id") Long id){
        worldService.deleteWorld(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/equipment/{equipment-id}")
    @ResponseBody
    public ResponseEntity<EquipmentDto> ajaxRequest(@PathVariable("equipment-id") Long id){
        EquipmentDto equipmentDto = equipmentService.getEquipmentById(id);
        return ResponseEntity.ok(equipmentDto);
    }


}
