package com.betrybe.agrix.controllers.dtos;

import com.betrybe.agrix.entities.Farm;

/**
 * The type Farm dto.
 */
public record FarmDto(
    Long id,
    String name,
    Double size
) {

  /**
   * From entity farm dto.
   *
   * @param farm the farm
   * @return the farm dto
   */
  public static FarmDto fromEntity(Farm farm) {
    FarmDto farmDto = new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
    return farmDto;
  }


  /**
   * To entity farm.
   *
   * @return the farm
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
