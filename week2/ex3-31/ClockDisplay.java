
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean usaClock;       // If true this clock is a 12 hour clock
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay(boolean usaClock)
    {
        // If the boolean passed trough the constructor is false
        if (usaClock == false) {    
            // Initialize a NumberDisplay object and store it in the hours variable. Set it's limit to 24 (24 hour clock)
            hours = new NumberDisplay(24);  
        } else { 
            // If true, set the object to a limit of 13
            hours = new NumberDisplay(13); 
            hours.increment();          // Instantly increment the hour so the starting value is 1. (0 + 1)
            this.usaClock = usaClock;   // Store the boolean in our Class field/attribute
        }
        minutes = new NumberDisplay(60);
        updateDisplay();
    }
    
    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean usaClock)
    {
        // See constructor comments above
        if (usaClock == false) {
            hours = new NumberDisplay(24);
        } else {
            hours = new NumberDisplay(13);
            hours.increment();
            this.usaClock = usaClock;
        }
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            // Whenever a minute goes to it's limit (60 in this case) it's value becomes 0, then just increment an the value by 1 of the hour object. 
            hours.increment();
            // if the hour hits it's limit (24 or 13), it will also become 0. If this is the case while our object's usaClock is also set to true
            // then increment another hour so it skips becomes 01:00 instead of 00:00
            if(hours.getValue() == 0 && this.usaClock == true) {
                // hours.setValue(1); would also be possible
                hours.increment();
            }
        } 
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
