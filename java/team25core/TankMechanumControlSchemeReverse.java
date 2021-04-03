
package team25core;

import com.qualcomm.robotcore.hardware.Gamepad;

import team25core.JoystickDriveControlScheme;
import team25core.MotorValues;

/**
 * Created by Breanna Chan on 1/6/2018.
 */


public class TankMechanumControlSchemeReverse implements JoystickDriveControlScheme {

    protected double fr;
    protected double fl;
    protected double rr;
    protected double rl;
    protected double leftX;
    protected double rightX;
    protected double leftY;
    protected double rightY;
    protected Gamepad gamepad;

    protected double leftWheelForward;
    protected double leftWheelBackward;
    protected double rightWheelForward;
    protected double rightWheelBackward;


    public TankMechanumControlSchemeReverse(Gamepad gamepad)
    {
        this.gamepad = gamepad;
    }

    public MotorValues getMotorPowers()
    {
        leftX = gamepad.left_stick_x;
        rightX = gamepad.right_stick_x;
        leftY = gamepad.left_stick_y;
        rightY = gamepad.right_stick_y;

        leftWheelForward   = -1;
        leftWheelBackward  = 1;
        rightWheelForward  = -1;
        rightWheelBackward = 1;

        // If joysticks are pointed left (negative joystick values), counter rotate wheels.
        // Threshold for joystick values in the x may vary.

        if (leftX > 0.5 && rightX > 0.5) {          // both X-sticks sideways left
            fl = leftWheelBackward;
            rl = leftWheelForward;
            fr = rightWheelForward;
            rr = rightWheelBackward;

        } else if (leftX < -0.5 && rightX < -0.5) { // both X-sticks sideways right
            fl = leftWheelForward;
            rl = leftWheelBackward;
            fr = rightWheelBackward;
            rr = rightWheelForward;

        } else if (gamepad.right_trigger > 0.5) {   // rotate right
            fr = rightWheelBackward;
            rr = rightWheelBackward;
            fl = leftWheelForward;
            rl = leftWheelForward;

        } else if (gamepad.left_trigger > 0.5) {    // rotate left
            fl = leftWheelBackward;
            rl = rightWheelBackward;
            rr = leftWheelForward;
            fr = leftWheelBackward;

        } else if (gamepad.left_bumper) {           // forward diagonal to the left
            fr = rightWheelForward;
            rl = leftWheelForward;

        } else if (gamepad.right_bumper) {          // forward diagonal to the right
            fl = leftWheelForward;
            rr = rightWheelForward;

        } else {                                    // forward or backward
            fl = leftY;
            rl = leftY;
            fr = rightY;
            rr = rightY;
        }

        return new MotorValues(fl, fr, rl, rr);
    }
}
