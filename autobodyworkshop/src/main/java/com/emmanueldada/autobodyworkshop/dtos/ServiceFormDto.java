package com.emmanueldada.autobodyworkshop.dtos;

import com.emmanueldada.autobodyworkshop.entites.ServiceForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFormDto implements Serializable {
    private Long id;

    private Long customerticketnumber;

    private Long repairstatus;

    private double repairtime;

    private Long starrating;


    //
    private UserDto userDto;




    public ServiceFormDto(ServiceForm serviceForm){
        if (serviceForm.getId() != null){
            this.id = serviceForm.getId();
        }
        if (serviceForm.getCustomerticketnumber() != null){
            this.customerticketnumber = serviceForm.getCustomerticketnumber();
        }
        if (serviceForm.getRepairstatus() != null){
            this.repairstatus = serviceForm.getRepairstatus();
        }


            try {
                this.repairtime = serviceForm.getRepairtime();

            }
            catch(Exception e) {
                System.out.println(e);
            }

        if (serviceForm.getStarrating() != null){
            this.starrating = serviceForm.getStarrating();
        }


    }
}
