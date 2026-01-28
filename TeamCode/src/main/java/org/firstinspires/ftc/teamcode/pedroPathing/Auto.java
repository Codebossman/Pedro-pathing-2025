package org.firstinspires.ftc.teamcode.pedroPathing;

//import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.draw;
//import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.drawOnlyCurrent;
//import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.follower;
//import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.telemetryM;

import com.bylazar.configurables.PanelsConfigurables;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.configurables.annotations.IgnoreConfigurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.telemetry.SelectableOpMode;
import com.pedropathing.util.PoseHistory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.ftccommon.internal.manualcontrol.commands.MotorCommands;

import java.util.ArrayList;
import java.util.List;

@Configurable
@Autonomous(name = "Auto List", group = "Pedro Pathing")
public class Auto extends SelectableOpMode {
    public static Follower followers;



    @IgnoreConfigurable
    static PoseHistory posehistory;

    @IgnoreConfigurable
    static TelemetryManager telemetryMan;

    @IgnoreConfigurable
    static ArrayList<String> changes = new ArrayList<>();

    public Auto() {
        super("Select a Tuning OpMode", s -> {
            s.folder("All Autos", l -> {
                l.add("Low Red", RedLow::new);
                l.add("High Red", RedHigh::new);
                l.add("Low Blue", BlueLow::new);
                l.add("High Blue", BlueHigh::new);
            });
        });
    }
    @Override
    public void onSelect() {
        if (followers == null) {
            followers = Constants.createFollower(hardwareMap);
            PanelsConfigurables.INSTANCE.refreshClass(this);
        } else {
            followers = Constants.createFollower(hardwareMap);
        }

        followers.setStartingPose(new Pose());

        posehistory = followers.getPoseHistory();

        telemetryMan = PanelsTelemetry.INSTANCE.getTelemetry();

        Drawing.init();
    }

    @Override
    public void onLog(List<String> lines) {}

    public static void drawOnlyCurr() {
        try {
            Drawing.drawRobot(followers.getPose());
            Drawing.sendPacket();
        } catch (Exception e) {
            throw new RuntimeException("Drawing failed " + e);
        }
    }

    public static void draw() {
        Drawing.drawDebug(followers);
    }

    /** This creates a full stop of the robot by setting the drive motors to run at 0 power. */
    public static void stopRobot() {
        followers.startTeleopDrive(true);
        followers.setTeleOpDrive(0,0,0,true);
    }
}
class RedLow extends OpMode {
    static Paths paths;
    private PathChain redLow;

    /**
     * This runs the OpMode, updating the Follower as well as printing out the debug statements to
     * the Telemetry, as well as the Panels.
     */
    @Override
    public void loop() {
        Auto.followers.update();
        Auto.draw();

        if (Auto.followers.atParametricEnd()) {
            Auto.followers.followPath(redLow, true);
        }
    }

    @Override
    public void init() {
        paths = new Paths(Auto.followers);
        Auto.followers.update();
        Auto.drawOnlyCurr();

    }

    @Override
    public void init_loop() {
        Auto.telemetryMan.debug("This is the red low auto");

        Auto.telemetryMan.update(telemetry);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void start() {
        Auto.followers.setStartingPose(paths.redStartLow);

        redLow = paths.redLow;
        Auto.followers.followPath(redLow);
    }
}
class RedHigh extends OpMode {
    static Paths paths;
    private PathChain redHigh;

    /**
     * This runs the OpMode, updating the Follower as well as printing out the debug statements to
     * the Telemetry, as well as the Panels.
     */
    @Override
    public void loop() {
        Auto.followers.update();
        Auto.draw();

        if (Auto.followers.atParametricEnd()) {
            Auto.followers.followPath(redHigh, true);
        }
    }

    @Override
    public void init() {
        paths = new Paths(Auto.followers);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void init_loop() {
        Auto.telemetryMan.debug("This is the red high auto");

        Auto.telemetryMan.update(telemetry);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void start() {
        Auto.followers.setStartingPose(paths.redStartHigh);

        redHigh = paths.redLow;
        Auto.followers.followPath(redHigh);
    }
}
class BlueLow extends OpMode {
    static Paths paths;
    private PathChain blueLow;

    /**
     * This runs the OpMode, updating the Follower as well as printing out the debug statements to
     * the Telemetry, as well as the Panels.
     */
    @Override
    public void loop() {
        Auto.followers.update();
        Auto.draw();

        if (Auto.followers.atParametricEnd()) {
            Auto.followers.followPath(blueLow, true);
        }
    }

    @Override
    public void init() {
        paths = new Paths(Auto.followers);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void init_loop() {
        Auto.telemetryMan.debug("This is the blue low auto");

        Auto.telemetryMan.update(telemetry);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void start() {
        Auto.followers.setStartingPose(paths.blueStartLow);

        blueLow = paths.redLow;
        Auto.followers.followPath(blueLow);
    }
}
class BlueHigh extends OpMode {
    static Paths paths;
    private PathChain blueHigh;

    /**
     * This runs the OpMode, updating the Follower as well as printing out the debug statements to
     * the Telemetry, as well as the Panels.
     */
    @Override
    public void loop() {
        Auto.followers.update();
        Auto.draw();

        if (Auto.followers.atParametricEnd()) {
            Auto.followers.followPath(blueHigh, true);
        }
    }

    @Override
    public void init() {
        paths = new Paths(Auto.followers);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void init_loop() {
        Auto.telemetryMan.debug("This is the blue high auto");

        Auto.telemetryMan.update(telemetry);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void start() {
        Auto.followers.setStartingPose(paths.blueStartHigh);

        blueHigh = paths.redLow;
        Auto.followers.followPath(blueHigh);
    }
}
class Shooting extends OpMode{
    static Paths paths;
    private PathChain blueHigh;

    /**
     * This runs the OpMode, updating the Follower as well as printing out the debug statements to
     * the Telemetry, as well as the Panels.
     */
    @Override
    public void loop() {
        Auto.followers.update();
        Auto.draw();

        if (Auto.followers.atParametricEnd()) {
            Auto.followers.followPath(blueHigh, true);
        }
    }

    @Override
    public void init() {
        paths = new Paths(Auto.followers);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void init_loop() {
        Auto.telemetryMan.debug("This is the blue high auto");

        Auto.telemetryMan.update(telemetry);
        Auto.followers.update();
        Auto.drawOnlyCurr();
    }

    @Override
    public void start() {
        Auto.followers.setStartingPose(paths.blueStartHigh);

        blueHigh = paths.redLow;
        Auto.followers.followPath(blueHigh);
    }
}
