package org.firstinspires.ftc.teamcode.pedroPathing;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;
import java.util.List;

@Configurable
@TeleOp(name="Pedro OpMode", group="Robot")
public class PedroPathingTeleOp extends LinearOpMode {

    private Follower follower;
    public static Pose startingPose; //See ExampleAuto to understand how to use this

    private TelemetryManager telemetryM;
    private boolean slowMode = false;
    private double slowModeMultiplier = 0.5;
    private GoTo goTo;
    private Intake intake;
    public List<Features> featureList = null;
    @Override
    public void runOpMode() throws InterruptedException {
        featureList = new ArrayList<>();
        featureList.add(new Intake());
        featureList.add(new TurnTable());
//        featureList.add(new TurnSensor());
//        featureList.add(new GoTo());
//        featureList.add(new Drive());
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