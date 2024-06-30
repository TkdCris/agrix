package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.repositories.FarmRepository;
import com.betrybe.agrix.services.exceptions.FarmNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  /**
   * The Farm repository.
   */
  private final FarmRepository farmRepository;
  private final CropService cropService;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   * @param cropService    the crop service
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropService cropService) {
    this.farmRepository = farmRepository;
    this.cropService = cropService;
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm saveFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param farmId the farm id
   * @return the by id
   */
  public Farm getFarmById(Long farmId) {
    return farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Sets crop farm.
   *
   * @param farmId the farm id
   * @param cropId the crop id
   * @return the crop farm
   */
  public Crop setCropFarm(Long farmId, Long cropId) {
    Farm farm = getFarmById(farmId);
    Crop crop = cropService.getCropById(cropId);

    crop.setFarm(farm);

    return cropService.createOrUpdateCrop(crop);
  }

  /**
   * Remove crop farm crop.
   *
   * @param cropId the crop id
   * @return the crop
   */
  public Crop removeCropFarm(Long cropId) {
    Crop crop = cropService.getCropById(cropId);

    crop.setFarm(null);

    return cropService.createOrUpdateCrop(crop);
  }

  /**
   * Gets farm crops by id.
   *
   * @param farmId the farm id
   * @return the farm crops by id
   */
  public List<Crop> getFarmCropsById(Long farmId) {
    Farm farm = farmRepository.findById(farmId)
        .orElseThrow(FarmNotFoundException::new);

    return farm.getCrops();
  }
}
