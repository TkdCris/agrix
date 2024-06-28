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
   * @param createdFarm the created farm
   * @return the farm dto
   */
  public static FarmDto fromEntity(Farm createdFarm) {
    FarmDto farmDto = new FarmDto(
        createdFarm.getId(),
        createdFarm.getName(),
        createdFarm.getSize()
    );
    return farmDto;
  }


  /**
   * To entity farm.
   *
   * @param farmDto the farm dto
   * @return the farm
   */
  public Farm toEntity(FarmDto farmDto) {
    Farm farm = new Farm(farmDto.name(), farmDto.size());
    return farm;
  }
}
