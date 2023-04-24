package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.MotorCompanyBrand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class MotorCompanyAutomobileResponseDTO implements Serializable {
    private Integer id;
    private MotorCompanyBrand brand;
    private String model;
    private Date created;
    private Date updated;
}
