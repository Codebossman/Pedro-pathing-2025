package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public interface Features {
    public void init(HardwareMap hardwareMap);
    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException;

}
