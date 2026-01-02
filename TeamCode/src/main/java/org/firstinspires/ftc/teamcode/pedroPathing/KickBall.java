package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class KickBall implements Features{
    private Servo kicker = null;
    double kick;
    @Override
    public void init(HardwareMap hardwareMap) {
        kicker = hardwareMap.get(Servo.class, "kicker");
    }

    @Override
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {
        if (gamepad1.dpad_left){
            kick = 0.25;
        }else{
            kick = 0;
        }
        kicker.setPosition(kick);
        List <String> telemetryData = new ArrayList<>();
        telemetryData.add(String.format(Locale.ENGLISH, "Kick: %4.2f", kick));
        return telemetryData;
    }
}
