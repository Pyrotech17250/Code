package FinalCode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.Object;

public class HardwarePushbot
{
    /* Public OpMode members. */
    public DcMotor        leftDrive      = null;
    public DcMotor        rightDrive     = null;
    public DcMotor        auxLeftDrive   = null;
    public DcMotor        auxRightDrive  = null;
    public Servo          leftClaw       = null;
    public Servo          rightClaw      = null;
    public Servo          leftServoArm   = null;
    public Servo          rightServoArm  = null;
    public Servo          auxHand        = null;
    public Servo          auxArm         = null;
    public Servo          gripper        = null;
    public DistanceSensor sensorRange    = null;


    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive     = hwMap.dcMotor.get("frontLeft");
        rightDrive    = hwMap.dcMotor.get("frontRight");
        auxLeftDrive  = hwMap.dcMotor.get("backLeft");
        auxRightDrive = hwMap.dcMotor.get("backRight");
        
        rightDrive.setDirection(DcMotor.Direction.FORWARD);     //Reverse direction for ease of use
//        auxLeftDrive.setDirection(DcMotor.Direction.REVERSE);  //Reverse direction for ease of use

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        auxLeftDrive.setPower(0);
        auxRightDrive.setPower(0);
        
        // Set all motors to run without encoders.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        auxLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        auxRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // May want to use RUN_USING_ENCODERS if encoders are installed.

        // Define and initialize ALL installed servos.
        // leftClaw  = hwMap.get(Servo.class, "left_hand");
        // rightClaw = hwMap.get(Servo.class, "right_hand");
        // leftServoArm  = hwMap.get(Servo.class, "left_arm");
        // rightServoArm = hwMap.get(Servo.class, "right_arm");
        // auxHand  = hwMap.get(Servo.class, "aux_hand");
        // auxArm = hwMap.get(Servo.class, "aux_arm");
        // leftClaw.setPosition(MID_SERVO);
        // rightClaw.setPosition(MID_SERVO);
        // leftServoArm.setPosition(MID_SERVO);
        // rightServoArm.setPosition(MID_SERVO);
        // auxHand.setPosition(MID_SERVO);
        // auxArm.setPosition(MID_SERVO);
        //gripper  = hwMap.get(Servo.class, "1stHubPort5");

        // you can use this as a regular DistanceSensor.
        //sensorRange = hwMap.get(DistanceSensor.class, "sensor_range");

    }
    
    public void drive (double power, int dir, int time) {
        leftDrive.setPower(dir*power);
        auxLeftDrive.setPower(dir*power);
        rightDrive.setPower(-dir*power);
        auxRightDrive.setPower(-dir*power);
        ElapsedTime timer = new ElapsedTime();
        while (timer.seconds()<time) {
        }
        leftDrive.setPower(0);
        auxLeftDrive.setPower(0);
        rightDrive.setPower(0);
        auxRightDrive.setPower(0);
    }
    
    public void strafe (double power, int dir, int time) {
        leftDrive.setPower(dir*power);
        auxLeftDrive.setPower(-dir*power);
        rightDrive.setPower(-dir*power);
        auxRightDrive.setPower(dir*power);
        ElapsedTime timer = new ElapsedTime();
        while (timer.seconds()<time) {
        }
        leftDrive.setPower(0);
        auxLeftDrive.setPower(0);
        rightDrive.setPower(0);
        auxRightDrive.setPower(0);
    }
    
 }
