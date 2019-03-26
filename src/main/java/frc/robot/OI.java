/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.*;
import frc.robot.triggers.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Trigger mainStickMoved =   new MainAxisTrigger(Robot.main_stick);
    private Trigger mainStickTwist =   new ZAxisTrigger(Robot.main_stick, false);
    private Trigger mainSliderMoved  = new SlideTrigger();
    private Trigger mainHatUp =        new HatTrigger(0);
    private Trigger mainHatDown =      new HatTrigger(180);
    private Button mainTrigger =       new JoystickButton(Robot.main_stick, 1);

    private Trigger liftStickMoved = new MainAxisTrigger(Robot.lift_stick);
    private Trigger liftDial      = new ZAxisTrigger(Robot.lift_stick, true);

    /**
     * To those of you that may be strugging to read by absolutely terrible button names,
     * any numbered button is read from left to right. Dome buttons are the ones that have
     * the dome indentation, and they're located on the base of the main stick. Dot buttons
     * are the ones directly beneath those dome buttons, closer to the driver. The left left
     * thing is because it is the left bank of buttons, referring to a button left of the two-dot.
     * 
     * yes, it's terrible.
     * no, there is very little I can do about it.
     * -su
     */

    private Button mainStickLeft =        new JoystickButton(Robot.main_stick, 3);
    private Button mainStickMiddle =      new JoystickButton(Robot.main_stick, 2);
    private Button mainStickRight =       new JoystickButton(Robot.main_stick, 4);
    private Button mainLeftDome1 =        new JoystickButton(Robot.main_stick, 5);
    private Button mainLeftDome2 =        new JoystickButton(Robot.main_stick, 6);
    private Button mainLeftDome3 =        new JoystickButton(Robot.main_stick, 7);
    //private Button something =          new JoystickButton(Robot.main_stick, 8);
    private Button mainTwoDotLeft =       new JoystickButton(Robot.main_stick, 9);
    private Button mainOneDotLeftLeft =   new JoystickButton(Robot.main_stick, 10);
    private Button mainRightDome3 =       new JoystickButton(Robot.main_stick, 11);
    private Button mainOneDotRightLeft =  new JoystickButton(Robot.main_stick, 14);
    private Button mainTwoDotRight =      new JoystickButton(Robot.main_stick, 15);
    private Button mainOneDotRightRight = new JoystickButton(Robot.main_stick, 16);
    private Button mainRightDome2 =       new JoystickButton(Robot.main_stick, 12);
    private Button mainRightDome1 =       new JoystickButton(Robot.main_stick, 13);
    
    private Button liftTrigger    =       new JoystickButton(Robot.lift_stick, 1);
    private Button lift2          =       new JoystickButton(Robot.lift_stick, 2);
    private Button lift3          =       new JoystickButton(Robot.lift_stick, 3);
    private Button lift8          =       new JoystickButton(Robot.lift_stick, 8);
    private Button lift9          =       new JoystickButton(Robot.lift_stick, 9);

    public OI() {
        // MAIN STICK TRIGGERS / BUTTONS
        mainStickMoved.whileActive(new DriveBot());
        mainStickTwist.whileActive(new DriveBot());
        mainStickMoved.whenInactive(new DriveFullStop());

        liftDial.whileActive(new IntakeSpin());
        liftDial.whenInactive(new IntakeStop());
        liftStickMoved.whileActive(new ControlLift());

        liftTrigger.whileActive(new EjectorOutFast()); // launch
        lift2.whileActive(new EjectorSlowReverse());  // SUCC     
        lift3.whileActive(new EjectorInSlow());

        // Intake solenoid control
        lift8.whenPressed(new OpenSolenoid(Robot.intakeSol));
        lift9.whenPressed(new CloseSolenoid(Robot.intakeSol));

        mainRightDome1.whenPressed(new CompressorOn());
        mainRightDome2.whenPressed(new CompressorOff());


        mainLeftDome1.whileActive(new OpenSolenoid(Robot.grabPiston));
        mainLeftDome2.whileActive(new OpenSolenoid(Robot.shovePiston));
        mainLeftDome3.whileActive(new OpenSolenoid(Robot.floorPiston));


        /* mech test
        rightDome3.whileActive(new mechTest(1)); // FRONT LEFT
        oneDotRightLeft.whileActive(new mechTest(2)); // FRONT RIGHT
        twoDotRight.whileActive(new mechTest(3)); // REAR LEFT
        oneDotRightRight.whileActive(new mechTest(4)); // REAR RIGHT
        */
    }

    // here lies the giant comment that existed by default in the OI
    // may he rest in peace
}
