package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dtos.CropCreationDto;
import com.betrybe.agrix.controllers.dtos.CropDto;
import com.betrybe.agrix.controllers.dtos.FarmCreationDto;
import com.betrybe.agrix.controllers.dtos.FarmDto;
import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  private final FarmService farmService;
  private final CropService cropService;


  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   * @param cropService the crop service
   */
  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Create response entity.
   *
   * @param farmCreationDto the farm creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    Farm farm = farmService.saveFarm(farmCreationDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(FarmDto.fromEntity(farm));
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> farmList = farmService.getAllFarms();
    return ResponseEntity.ok().body(farmList.stream()
        .map(FarmDto::fromEntity).toList());
  }

  /**
   * Gets by id.
   *
   * @param farmId the farm id
   * @return the by id
   */
  @GetMapping("/{farmId}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long farmId) {
    Farm farm = farmService.getFarmById(farmId);

    return ResponseEntity.ok().body(FarmDto.fromEntity(farm));
  }

  /**
   * Create crop response entity.
   *
   * @param farmId          the farm id
   * @param cropCreationDto the crop dto
   * @return the response entity
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(
      @PathVariable Long farmId,
      @RequestBody CropCreationDto cropCreationDto
  ) {
    Farm farmToAddCrop = farmService.getFarmById(farmId);
    Crop cropToCreate = new Crop(cropCreationDto);
    cropToCreate.setFarm(farmToAddCrop);

    Crop createdCrop = cropService.createOrUpdateCrop(cropToCreate);
    farmToAddCrop.getCrops().add(createdCrop);

    farmService.saveFarm(farmToAddCrop);

    return ResponseEntity.status(HttpStatus.CREATED).body(CropDto.fromEntity(createdCrop));
  }

  /**
   * Get farm crops by id response entity.
   *
   * @param farmId the farm id
   * @return the response entity
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getFarmCropsById(@PathVariable Long farmId) {
    List<Crop> cropList = farmService.getFarmCropsById(farmId);
    return ResponseEntity.ok().body(cropList.stream()
        .map(CropDto::fromEntity).toList());
  }
}
