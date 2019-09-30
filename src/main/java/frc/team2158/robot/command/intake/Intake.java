package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import frc.team2158.robot.subsystem.intake.IntakeSubsystem;

import java.util.logging.Logger;


public class Intake extends Command {
    private static final Logger LOGGER = Logger.getLogger(Intake.class.getName());


    public Intake() {
        requires(Robot.getIntakeSubsystem());
        LOGGER.info("Intake Command Initialized.");
    }


    @Override
    protected void initialize() {
        Robot.getIntakeSubsystem().runIntake(IntakeSubsystem.IntakeDirection.IN);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
