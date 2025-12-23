package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Collections;
import java.util.List;

public class Drive implements Features {
    GoTo goTo = null;


    public void init(HardwareMap hardwareMap) {
        goTo = new GoTo();
    }


    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {
        if (!goTo.automatedDrive) {
            //Make the last parameter false for field-centric
            //In case the drivers want to use a "slowMode" you can scale the vectors

            //This is the normal version to use in the TeleOp
            goTo.follower.setTeleOpDrive(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x,
                    -gamepad1.right_stick_x,
                    true // Robot Centric
            );
        }
        return Collections.emptyList();
    }
}
