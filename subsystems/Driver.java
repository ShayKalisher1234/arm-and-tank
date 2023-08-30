// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.RelativeEncoder;


public class Driver extends SubsystemBase {
  private CANSparkMax LeftFrontMotor;
  private CANSparkMax LeftBackMotor;
  private MotorControllerGroup lefMotorControllerGroup;
  private CANSparkMax RightFrontMotor;
  private CANSparkMax RightBackMotor;
  private MotorControllerGroup rightControllerGroup;
  private DifferentialDrive arcadeDrive;
  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;
  private double distanceTraveled; //ticks
  private double distanceTraveledMeters;  //meters
  
 

  /** Creates a new turnMotor. */
  public Driver() {
    LeftBackMotor = new CANSparkMax(18, MotorType.kBrushless);
    LeftBackMotor.setInverted(false);

    LeftFrontMotor = new CANSparkMax(18, MotorType.kBrushless);
    LeftFrontMotor.setInverted(false);

    lefMotorControllerGroup = new MotorControllerGroup(LeftBackMotor, LeftFrontMotor);

    RightBackMotor = new CANSparkMax(18, MotorType.kBrushless);
    RightBackMotor.setInverted(false);

    RightFrontMotor = new CANSparkMax(18, MotorType.kBrushless);
    RightFrontMotor.setInverted(false);

    rightControllerGroup = new MotorControllerGroup(RightBackMotor, RightFrontMotor);
    
    arcadeDrive = new DifferentialDrive(rightControllerGroup, lefMotorControllerGroup);
    
    this.rightEncoder = RightFrontMotor.getEncoder();
    rightEncoder.setPositionConversionFactor(1 / 10);
    distanceTraveled = rightEncoder.getPosition();
  }


  public void driveMeters(double targetDistance ) {

    double encoderStartValue = rightEncoder.getPosition();
    arcadeDrive.arcadeDrive(0.5, 0);

    distanceTraveled = rightEncoder.getPosition(); //ticksWheel
    distanceTraveledMeters = (distanceTraveled / 420) * 0.25; //turning the line before to meters

    
    while (distanceTraveledMeters <= targetDistance + encoderStartValue){
      arcadeDrive.arcadeDrive(0.5, 0);
      distanceTraveled = rightEncoder.getPosition();
      distanceTraveledMeters = (( distanceTraveled /420 )* 25);
      
    }
    rightEncoder.setPosition(0);
    arcadeDrive.arcadeDrive(0, 0); // סבבה זה נראה טוב   
  }
    
    
    

    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void motorspeed(DoubleSupplier speed, DoubleSupplier rotation) {
    arcadeDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble()); 
    
  }
}

    
