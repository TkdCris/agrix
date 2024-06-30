package com.betrybe.agrix.controllers.dtos;

import com.betrybe.agrix.entities.Farm;

/**
 * The type Farm creation dto.
 */
public record FarmCreationDto(
    String name,
    Double size
) {

  /**
   * To entity farm.
   *
   * @return the farm
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }

}
