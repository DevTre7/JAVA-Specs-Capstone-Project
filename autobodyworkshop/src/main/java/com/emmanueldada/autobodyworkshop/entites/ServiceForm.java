package com.emmanueldada.autobodyworkshop.entites;


import com.emmanueldada.autobodyworkshop.dtos.ServiceFormDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ServiceForm")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long customerticketnumber;

    private Long repairstatus;

    private double repairtime;

    private Long starrating;



    @ManyToOne
    @JsonBackReference
    private User user;

    public ServiceForm(ServiceFormDto serviceFormDto){
        if (serviceFormDto.getId() != null){
            this.id = serviceFormDto.getId();
        }
        if (serviceFormDto.getCustomerticketnumber() != null){
            this.customerticketnumber = serviceFormDto.getCustomerticketnumber();
        }
        if (serviceFormDto.getRepairstatus() != null){
            this.repairstatus = serviceFormDto.getRepairstatus();
        }
        if (serviceFormDto.getRepairtime() != 0){
            this.repairtime = serviceFormDto.getRepairtime();
        }
        if (serviceFormDto.getStarrating() != null){
            this.starrating = serviceFormDto.getStarrating();
        }
    }

}
