package com.betrybe.agrix.controllers.dtos;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;

/**
 * The type Crop creation dto.
 */
public record CropCreationDto(
    String name,
    Double plantedArea
) {

  /**
   * To entity crop.
   *
   * @return the crop
   */
  public Crop toEntity() {
    return new Crop(name, plantedArea);
  }
}
