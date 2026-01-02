package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LaunchPowerTwo implements Features{
    private DcMotor eject = null;
    double power = 0;

    @Override
    public void init(HardwareMap hardwareMap) {
        eject = hardwareMap.get(DcMotor.class, "eject");


    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if (gamepad1.xWasPressed()){
            power = 0.8;
        }
        if (gamepad1.bWasPressed()){
            power = 1;
        }
        if (gamepad1.aWasPressed()){
            power = 0;
        }
        eject.setPower(power);
        List <String> telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Launch Power: %4.2f", power));
        return telemetryData;

//        return Collections.emptyList();
    }
}
