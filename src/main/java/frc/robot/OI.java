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
    private Trigger stickMoved = new MainAxisTrigger(); // what is going on
    private Trigger sliderMoved  = new SlideTrigger();
    private Trigger hatUp = new HatTrigger(0);
    private Trigger hatDown = new HatTrigger(180);
    private Button trigger = new JoystickButton(Robot.main_stick, 1);
    // below hat button

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

    private Button stickLeft =       new JoystickButton(Robot.main_stick, 3);
    private Button stickMiddle =     new JoystickButton(Robot.main_stick, 2);
    private Button stickRight =      new JoystickButton(Robot.main_stick, 4);
    private Button leftDome1 =       new JoystickButton(Robot.main_stick, 5);
    private Button leftDome2 =       new JoystickButton(Robot.main_stick, 6);
    private Button leftDome3 =       new JoystickButton(Robot.main_stick, 7);
    //private Button something =       new JoystickButton(Robot.main_stick, 8);
    private Button twoDotLeft =      new JoystickButton(Robot.main_stick, 9);
    private Button oneDotLeftLeft =  new JoystickButton(Robot.main_stick, 10);
    private Button rightDome2 =      new JoystickButton(Robot.main_stick, 12);
    private Button rightDome1 =      new JoystickButton(Robot.main_stick, 13);
    private Button oneDotRightLeft = new JoystickButton(Robot.main_stick, 14);
    private Button twoDotRight =     new JoystickButton(Robot.main_stick, 15);

  
    public OI() {
        // MAIN STICK TRIGGERS / BUTTONS
        stickMoved.whileActive(new DriveBot());
        stickMoved.whenInactive(new DriveFullStop());

        sliderMoved.whileActive(new IntakeSpin());
        sliderMoved.whenInactive(new IntakeStop());

        trigger.whileActive(new EjectorOutFast()); // launch
        stickMiddle.whileActive(new EjectorSlowReverse());  // SUCC
        /* avoid using these too often
        leftDome1.whenPressed(new SetEjectorSpeed(0.25));
        leftDome2.whenPressed(new SetEjectorSpeed(0.5));
        leftDome3.whenPressed(new SetEjectorSpeed(1));
        */
        stickLeft.whileActive(new EjectorInSlow());
        stickRight.whileActive(new EjectorOutFast());

        // Intake solenoid control
        twoDotLeft.whenPressed(new OpenSolenoid(Robot.intakeSol));
        oneDotLeftLeft.whenPressed(new CloseSolenoid(Robot.intakeSol));

        rightDome1.whenPressed(new CompressorOn());
        rightDome2.whenPressed(new CompressorOff());

        hatUp.whileActive(new RaiseLift());
        hatDown.whileActive(new LowerLift());

        leftDome1.whileActive(new OpenSolenoid(Robot.grabPiston));
        leftDome2.whileActive(new OpenSolenoid(Robot.shovePiston));
        leftDome3.whileActive(new OpenSolenoid(Robot.floorPiston));

    }
    // here lies the giant comment that existed by default in the OI
    // may he rest in peace
}
