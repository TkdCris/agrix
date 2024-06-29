package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dtos.FarmDto;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  /**
   * The Farm service.
   */
  FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Create response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDto> create(@RequestBody FarmDto farmDto) {
    Farm createdFarm = farmService.create(farmDto.toEntity(farmDto));
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(FarmDto.fromEntity(createdFarm));
  }

  @GetMapping
  public ResponseEntity<List<FarmDto>> getAll() {
    List<Farm> farmList = farmService.getAll();
    return ResponseEntity.ok().body(farmList.stream().map(FarmDto::fromEntity).toList());
  }

}
