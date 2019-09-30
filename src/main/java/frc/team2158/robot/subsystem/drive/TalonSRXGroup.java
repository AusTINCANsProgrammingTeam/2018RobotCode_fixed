package frc.team2158.robot.subsystem.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;

import java.util.logging.Logger;

public class TalonSRXGroup implements SpeedController {
    private static final Logger LOGGER = Logger.getLogger(TalonSRXGroup.class.getName());
    private WPI_TalonSRX master;



    public TalonSRXGroup(WPI_TalonSRX master, WPI_TalonSRX... slaves) {
        this.master = master;

        master.configContinuousCurrentLimit(20, 0);
        master.configPeakCurrentLimit(30, 0);
        master.configPeakCurrentDuration(250, 0);
        master.enableCurrentLimit(true);
        master.configOpenloopRamp(0.250, 0);
        master.configClosedloopRamp(0.250, 0);
        master.config_kP(0, 0.4, 0);
        master.config_kI(0, 0.0, 0);
        master.config_kD(0, 0.0, 0);

        for(WPI_TalonSRX slave : slaves) {
            slave.follow(master);
        }
    }


    @Override
    public void pidWrite(double output) {
        master.pidWrite(output);
    }


    @Override
    public void set(double speed) {
        master.set(ControlMode.PercentOutput, speed);
    }


    @Override
    public double get() {
        return master.get();
    }


    @Override
    public void setInverted(boolean isInverted) {
        master.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return master.getInverted();
    }


    @Override
    public void disable() {
        master.disable();
    }


    @Override
    public void stopMotor() {
        master.stopMotor();
    }
}
