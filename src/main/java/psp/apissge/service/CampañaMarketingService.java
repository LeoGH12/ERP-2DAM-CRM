package psp.apissge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.CampañaMarketingDTO;
import psp.apissge.model.CampañaMarketing;
import psp.apissge.repository.CampañaMarketingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampañaMarketingService {

    @Autowired
    private CampañaMarketingRepository campañaRepository;

    @Autowired
    private FabricaCampañaService fabricaCampaña;

    public CampañaMarketingDTO save(CampañaMarketingDTO dto) {
        CampañaMarketing campana = fabricaCampaña.createCampaña(dto);
        CampañaMarketing guardada = campañaRepository.save(campana);
        return fabricaCampaña.createCampañaDTO(guardada);
    }

    public List<CampañaMarketingDTO> findAll() {
        return campañaRepository.findAll()
                .stream()
                .map(fabricaCampaña::createCampañaDTO)
                .collect(Collectors.toList());
    }

    public CampañaMarketingDTO findById(Integer id) {
        return campañaRepository.findById(id)
                .map(fabricaCampaña::createCampañaDTO)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        campañaRepository.deleteById(id);
    }
}
