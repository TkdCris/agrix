package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.repositories.CropRepository;
import com.betrybe.agrix.services.exceptions.CropNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   */
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Gets crop by id.
   *
   * @param cropId the crop id
   * @return the crop by id
   */
  public Crop getCropById(Long cropId) {
    return cropRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
  }

  /**
   * Create crop crop.
   *
   * @param crop the crop
   * @return the crop
   */
  public Crop createOrUpdateCrop(Crop crop) {
    return cropRepository.save(crop);
  }


  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }
}
