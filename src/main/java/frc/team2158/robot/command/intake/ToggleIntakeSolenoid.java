package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import frc.team2158.robot.subsystem.intake.IntakeSubsystem;

import java.util.logging.Logger;


public class ToggleIntakeSolenoid extends Command {
    private static final Logger LOGGER = Logger.getLogger(ToggleIntakeSolenoid.class.getName());
    private IntakeSubsystem intakeSubsystem;


    public ToggleIntakeSolenoid() {
        this.intakeSubsystem = Robot.getIntakeSubsystem();
    }


    @Override
    protected void execute() {
        intakeSubsystem.toggleSolenoidState();
        LOGGER.info("Solenoid has been toggled!");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
