package FinalCode;

import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="HardwarePushBot: Teleop_Simple", group="HardwarePushBot")

public class TeleOp_Simple extends LinearOpMode{

    private HardwarePushbot robot   = new HardwarePushbot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            double left = -5*gamepad1.left_stick_y;
            double right = 5*gamepad1.right_stick_y;

            robot.leftDrive.setPower(left);
            robot.auxLeftDrive.setPower(left);
            robot.rightDrive.setPower(right);
            robot.auxRightDrive.setPower(right);

            if (gamepad1.left_bumper) {
                robot.leftDrive.setPower(1);
                robot.auxLeftDrive.setPower(-1);
                robot.rightDrive.setPower(1);
                robot.auxRightDrive.setPower(-1);
            }

            if (gamepad1.right_bumper) {
                robot.leftDrive.setPower(-1);
                robot.auxLeftDrive.setPower(1);
                robot.rightDrive.setPower(-1);
                robot.auxRightDrive.setPower(1);
            }
            
        }
    }
}
