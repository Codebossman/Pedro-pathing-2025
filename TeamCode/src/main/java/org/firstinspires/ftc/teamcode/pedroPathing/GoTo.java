package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

public class GoTo implements Features{
    private Pose start = Autos.followers.getPose();

    boolean resetFlag = false;
    public int drivePos = 0;
    private Pose startingPos;


    public static Pose startingPose; //See ExampleAuto to understand how to use this
    public boolean automatedDrive;
    public Follower follower;
    private Paths paths;

    public void init(HardwareMap hardwareMap) {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(start == null ? new Pose() : start);
        paths = new Paths(follower);
        startingPos = follower.getPose();
        follower.update();

    }

    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {

        if (gamepad2.dpadUpWasPressed()) {
              drivePos += 1;


            switch (drivePos) {
                case 1:
                    follower.followPath(paths.firstBalls);
                    automatedDrive = true;
                    break;
                case 2:
                    follower.followPath(paths.secondBalls);
                    automatedDrive = true;
                    break;
                case 3:
                    follower.followPath(paths.thirdBalls);
                    automatedDrive = true;
                    break;
                case 4:
                    drivePos = 1;
            }
        }
        //Stop automated following if the follower is done
        if (automatedDrive && (gamepad2.bWasPressed() || !follower.isBusy())) {
            follower.startTeleopDrive();
            automatedDrive = false;
        }
        List <String> telemetryData = new ArrayList<>();

        telemetryData.add("start Pos is: -> " + startingPos.toString());

        return telemetryData;
    }
}
