package frc.team2158.robot.command.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;

import java.util.logging.Logger;

public class StopLift extends Command {
    private static final Logger LOGGER = Logger.getLogger(StopLift.class.getName());


    public StopLift() {
        requires(Robot.getLiftSubsystem());
    }

    @Override
    protected void initialize() {
        Robot.getLiftSubsystem().stopLift();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
