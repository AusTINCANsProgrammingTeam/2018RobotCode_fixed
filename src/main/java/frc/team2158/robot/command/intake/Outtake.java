package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import frc.team2158.robot.subsystem.intake.IntakeSubsystem;

import java.util.logging.Logger;


public class Outtake extends Command {
    private static final Logger LOGGER = Logger.getLogger(Outtake.class.getName());


    public Outtake() {
        requires(Robot.getIntakeSubsystem());
    }


    @Override
    protected void initialize() {
        Robot.getIntakeSubsystem().runIntake(IntakeSubsystem.IntakeDirection.OUT);
        LOGGER.info("Outtake is initializing!");

    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
