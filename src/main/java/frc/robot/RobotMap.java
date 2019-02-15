/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;

/**
* The RobotMap is a mapping from the ports sensors and actuators are wired into
* to a variable name. This provides flexibility changing wiring, makes checking
* the wiring easier and significantly reduces the number of magic numbers
* floating around.
*/
public class RobotMap {
    // Moco CAN IDs start at 10.
    public static int FRONT_LEFT_DRIVE_MOTOR = 14; // Talon
    public static int FRONT_RIGHT_DRIVE_MOTOR = 15; // Talon
    public static int REAR_LEFT_DRIVE_MOTOR = 10; // Talon
    public static int REAR_RIGHT_DRIVE_MOTOR = 11; // Talon
    public static int BALL_INTAKE_MOTOR = 12; // talon
    public static int INTAKE_SOLENOID = 1; 
    public static int BALL_EJECTOR_ONE = 13; // talon
    public static int BALL_EJECTOR_TWO = 17; // victor
    
}
