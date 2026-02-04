package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoCommands {
    private TurnTable turnTable;
    private Lift lift;
    private LaunchPower launcher;
    private Intake intake;
    private KickBall kicker;
    private Haptics haptics;
    private ServoEncoder encoder;
    public AutoCommands(TurnTable turnTable, Lift lift, LaunchPower launcher, Intake intake, KickBall kicker, Haptics haptics, ServoEncoder encoder ){
        this.turnTable = turnTable;
        this.lift = lift;
        this.launcher = launcher;
        this.intake = intake;
        this.kicker = kicker;
        this.haptics = haptics;
        this.encoder = encoder;
    }
    public void shoot(int shots, Telemetry telemetry){

        telemetry.addLine("Launcher before on");

        telemetry.addLine("Launcher on");

        for(int i = 0; i < shots; i++){
            telemetry.addLine("Shot #" + shots);

            double startTicks = encoder.getEncoderPos();
            double targetTicks = encoder.getEncoderPos()+encoder.getRIGHTANGLE();
            long timer2 = System.currentTimeMillis();
            long endTime = timer2 + 5000;
            turnTable.setPos(turnTable.getPOWER());
            while(startTicks <= targetTicks && timer2 < endTime){
                timer2 = System.currentTimeMillis();
            }
            turnTable.setPos(0);

            lift();

        }
        telemetry.update();


    }
    public void intake(double timeSec){
        double timerDown = timeSec;
        ElapsedTime runtime = new ElapsedTime();
//        double time = runtime.time();
        while(true){
            double current = runtime.time();
            timerDown = timeSec-current;
            if(timerDown >= 0){
                lift.setPos(lift.LIFT);
            }else{
                lift.setPos(lift.getOFF());
            }
        }
    }
    /*
        #NOTE: lift is used INSIDE shoot()
    */
    public void launcher(boolean isOn){
        if(isOn){
            launcher.setPower(0.55);
        }else{
            launcher.setPower(0);
        }
    }

    public void lift(){
        lift.setPos(lift.getLIFT());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lift.setPos(lift.getOFF());
    }
}
