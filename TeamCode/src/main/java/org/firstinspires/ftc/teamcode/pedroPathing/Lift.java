package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Collections;
import java.util.List;

public class Lift implements Features{
    private Servo launch = null;
    double pos;
    double LIFT = 0.03;
    double OFF = 0;
    long runTime = System.currentTimeMillis();



    @Override
    public void init(HardwareMap hardwareMap) {
        launch = hardwareMap.get(Servo.class, "launch");
        launch.setDirection(Servo.Direction.REVERSE);
    }


    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if (gamepad2.yWasPressed()) {
            pos = LIFT;
        }
        if(gamepad2.yWasReleased()){
            pos = OFF;
        }
        launch.setPosition(pos);
//        if(pos >= 0.04){
//            pos = 0;
//        }

        return Collections.emptyList();
    }
    private void wait(double ms){
        boolean isPaused = true;
        long timeElasped = System.currentTimeMillis();
        while(runTime >= (timeElasped+ms)){

        }
    }
    public double getPos(){
        return pos;
    }
    public void setPos(double newPos){
        this.pos = newPos;
    }

    public double getLIFT() {
        return LIFT;
    }

    public double getOFF() {
        return OFF;
    }
}
