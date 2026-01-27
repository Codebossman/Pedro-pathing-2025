package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Collections;
import java.util.List;

public class GoTo implements Features{
    private Pose start = Auto.followers.getPose();

    boolean resetFlag = false;
    public int drivePos = 0;


    public static Pose startingPose; //See ExampleAuto to understand how to use this
    public boolean automatedDrive;
    public Follower follower;

    public void init(HardwareMap hardwareMap) {

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(start == null ? new Pose() : start);
        follower.update();

    }

    public List<String> driveLoop(Gamepad gamepad1, Gamepad gamepad2) {

        if (gamepad1.dpadUpWasPressed()) {
              drivePos += 1;
//
//
//            switch (drivePos) {
//                case 1:
//                    follower.followPath(pathChainLow.get());
//                    automatedDrive = true;
//                    break;
//                case 2:
//                    follower.followPath(pathChainMiddle.get());
//                    automatedDrive = true;
//                    break;
//                case 3:
//                    follower.followPath(pathChainHigh.get());
//                    automatedDrive = true;
//                    break;
//                case 4:
//                    drivePos = 1;
//            }
        }
        //Stop automated following if the follower is done
        if (automatedDrive && (gamepad1.bWasPressed() || !follower.isBusy())) {
            follower.startTeleopDrive();
            automatedDrive = false;
        }
        return Collections.emptyList();
    }
}
