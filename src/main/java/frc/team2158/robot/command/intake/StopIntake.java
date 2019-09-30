package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;

import java.util.logging.Logger;


public class StopIntake extends Command {
    private static final Logger LOGGER = Logger.getLogger(StopIntake.class.getName());

    public StopIntake() {
        requires(Robot.getIntakeSubsystem());
    }


    @Override
    protected void initialize() {
        Robot.getIntakeSubsystem().stopIntake();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
