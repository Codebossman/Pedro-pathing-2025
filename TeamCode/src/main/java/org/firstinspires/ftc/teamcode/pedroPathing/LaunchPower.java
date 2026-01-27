package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LaunchPower implements Features{
    private DcMotor eject = null;
    double power;
    boolean firstTap = false;
    boolean isOff = true;

    @Override
    public void init(HardwareMap hardwareMap) {
        eject = hardwareMap.get(DcMotor.class, "eject");
        eject.setDirection(DcMotorSimple.Direction.REVERSE);
        power = 0;
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if(!firstTap){
            if(gamepad2.rightBumperWasPressed()){
                power = 0.65;
                firstTap = true;

            }
        }
        if(firstTap) {
            if (gamepad2.rightBumperWasPressed()) {
                power += 0.05;
            }
            if (gamepad2.leftBumperWasPressed()) {
                power -= 0.05;
            }
            if (gamepad2.dpadDownWasPressed()) {
                power = 0;
                firstTap = false;
                isOff = true;
            }
        }

        // capping

        if(power >= 1){
            power = 1;
        }
        if(power <= 0.5 && firstTap){
            power = 0.5;
        }
        eject.setPower(power);
        List <String> telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Launch Power: %4.2f", power));
        telemetryData.add("Is firstTap: -> " + firstTap);
        telemetryData.add("Is off: -> " + isOff);
        return telemetryData;

//        return Collections.emptyList();
    }
}
