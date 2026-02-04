package org.firstinspires.ftc.teamcode.pedroPathing;

public class Capping {
    public void capped(double min, double max, double toCap, boolean iscapped ){
        if(iscapped){
            if(toCap >= max){
                toCap = max;
            }
            if(toCap <= min){
                toCap = min;
            }
        }else{

        }


    }
}
