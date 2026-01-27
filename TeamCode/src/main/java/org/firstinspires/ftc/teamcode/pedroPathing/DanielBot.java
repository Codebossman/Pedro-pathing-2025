package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name="Daniel Bot", group="Robot")
public class DanielBot extends LinearOpMode {

    private List<Features> featureList = null;

    @Override
    public void runOpMode() throws InterruptedException {
        featureList = new ArrayList<>();
//        featureList.add(new MotorDrive());
        featureList.add(new LaunchPowerTwo());
        featureList.add(new PrepBall());
        for (Features feature: featureList){
            feature.init(hardwareMap);
        }

        waitForStart();
        while (opModeIsActive()) {
            for (Features feature: featureList){
                List<String> messageList = feature.driveLoop(gamepad1, gamepad2);
                for (String message : messageList) {
                    telemetry.addLine(message);
                }
            }
            telemetry.update();
        }
    }
}
