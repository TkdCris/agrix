package com.betrybe.agrix.controllers.dtos;

import com.betrybe.agrix.entities.Crop;

/**
 * The type Crop dto.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId
) {

  /**
   * From entity crop dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId()
    );
  }

  /**
   * To entity crop.
   *
   * @param cropDto the crop dto
   * @return the crop
   */
  public Crop toEntity(CropDto cropDto) {
    return new Crop(
        cropDto.name(),
        cropDto.plantedArea()
    );
  }
}
