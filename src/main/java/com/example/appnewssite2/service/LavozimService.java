package com.example.appnewssite2.service;

import com.example.appnewssite2.entity.Lavozim;
import com.example.appnewssite2.payload.ApiResponce;
import com.example.appnewssite2.payload.LavozimDto;
import com.example.appnewssite2.repository.LavozimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LavozimService {

    @Autowired
    LavozimRepository lavozimRepository;

    public ApiResponce addLavozim(LavozimDto lavozimDto) {
        boolean exists = lavozimRepository.existsByName(lavozimDto.getName());
        if (exists){
            return new ApiResponce("Bunday lavozim mavjud",false);
        }
        Lavozim lavozim = new Lavozim(
                lavozimDto.getName(),
                lavozimDto.getHuquqList(),
                lavozimDto.getDescription()
        );
        lavozimRepository.save(lavozim);
        return new ApiResponce("Saqlandi",true);
    }

    public ApiResponce editLavozim(Long id, LavozimDto lavozimDto) {
        Optional<Lavozim> optionalLavozim = lavozimRepository.findById(id);
        if (optionalLavozim.isPresent()){
            Lavozim lavozim = optionalLavozim.get();
            lavozim.setName(lavozim.getName());
            lavozim.setHuquqList(lavozimDto.getHuquqList());
            lavozim.setDescription(lavozim.getDescription());
            lavozimRepository.save(lavozim);
        }
        return new ApiResponce("O'zgartirildi",true);

    }

    public ApiResponce delteLavozim(Long id) {
        lavozimRepository.deleteById(id);
        return new ApiResponce("O'chirildi",true);
    }
}
