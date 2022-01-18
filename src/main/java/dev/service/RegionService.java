package dev.service;

import dev.dto.RegionDto;
import dev.entity.Region;
import dev.repository.RegionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Transactional
    public void createRegions(List<RegionDto> regions) {
        for (RegionDto regionDto : regions) {
            Region region = new Region(regionDto.getNom(), regionDto.getCode());
            this.regionRepository.save(region);
        }
    }
}
