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
    private Button trigger = new JoystickButton(Robot.main_stick, 1);
    // below hat button
    private Button button1 = new JoystickButton(Robot.main_stick, 2);
    private Button leftDome1 = new JoystickButton(Robot.main_stick, 5);
    private Button leftDome2 = new JoystickButton(Robot.main_stick, 6);
    private Button leftDome3 = new JoystickButton(Robot.main_stick, 7);
    private Button twoDotLeft = new JoystickButton(Robot.main_stick, 9);
    private Button oneDotLeftLeft = new JoystickButton(Robot.main_stick, 10);

  
    public OI() {
        // MAIN STICK TRIGGERS / BUTTONS
        stickMoved.whileActive(new DriveBot());
        stickMoved.whenInactive(new DriveFullStop());
        sliderMoved.whileActive(new IntakeSpin());
        sliderMoved.whenInactive(new IntakeStop());

        trigger.whileActive(new EjectorControlledSpin(false)); // launch
        button1.whileActive(new EjectorControlledSpin(true));  // SUCC
        leftDome1.whenPressed(new SetEjectorSpeed(0.25));
        leftDome2.whenPressed(new SetEjectorSpeed(0.5));
        leftDome3.whenPressed(new SetEjectorSpeed(1));

        // disable test pneumatics controls
        twoDotLeft.whenPressed(new OpenSolenoid());
        oneDotLeftLeft.whenPressed(new CloseSolenoid());
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
