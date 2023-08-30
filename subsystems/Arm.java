// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private WPI_TalonFX armMotor; 

  /** Creates a new Arm. */
  public Arm() {
    armMotor = new WPI_TalonFX(Constants.ArmPidConstants.motorID);
    armMotor.config_kF(Constants.ArmPidConstants.kSlotIdx, Constants.ArmPidConstants.F , Constants.ArmPidConstants.kTimeoutMs);
    armMotor.config_kF(Constants.ArmPidConstants.kSlotIdx, Constants.ArmPidConstants.P , Constants.ArmPidConstants.kTimeoutMs);
    armMotor.config_kF(Constants.ArmPidConstants.kSlotIdx, Constants.ArmPidConstants.I , Constants.ArmPidConstants.kTimeoutMs);
    armMotor.config_kF(Constants.ArmPidConstants.kSlotIdx, Constants.ArmPidConstants.D , Constants.ArmPidConstants.kTimeoutMs);
    
  }
  
  public void putInPointArm(double setpoint , DoubleSupplier speed){
    armMotor.set(TalonFXControlMode.Position, setpoint, null, setpoint);
    armMotor.set(speed.getAsDouble());
    



    
  
    
  }
    
  


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


