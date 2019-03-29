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

    public static int FRONT_LEFT_DRIVE_MOTOR = 18; // Spark MAX
    public static int FRONT_RIGHT_DRIVE_MOTOR = 11; // Talon
    public static int REAR_LEFT_DRIVE_MOTOR = 14; // Talon
    public static int REAR_RIGHT_DRIVE_MOTOR = 12; // Talon

    public static int BALL_INTAKE_MOTOR = 16; // Victor
    public static int INTAKE_SOLENOID = 1; 
    public static int FLOOR_SOLENOID = 2;
    public static int BALL_EJECTOR_ONE = 15; // talon
    public static int BALL_EJECTOR_TWO = 17; // victor
    public static int LIFT_MOTOR = 10; // Talon
    public static int GRAB_PISTON = 5;
    public static int SHOVE_PISTON = 7;
    public static double UP_LIFT_SPEEDINESS = 0.6;
    public static double DOWN_LIFT_SPEEDINESS = 0.15;
}