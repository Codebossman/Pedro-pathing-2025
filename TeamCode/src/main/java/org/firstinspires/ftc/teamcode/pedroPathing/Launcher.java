package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Collections;
import java.util.List;

public class Launcher implements Features{
    private Servo launch = null;
    double pos;
    long runTime = System.currentTimeMillis();



    @Override
    public void init(HardwareMap hardwareMap) {
        launch = hardwareMap.get(Servo.class, "launch");
        launch.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if (gamepad2.yWasPressed()) {
            pos = 0.025;
        }
        if(gamepad2.yWasReleased()){
            pos = 0;
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
}
