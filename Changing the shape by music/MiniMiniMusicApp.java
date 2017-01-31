package yan;
import javax.sound.midi.*;

public class MiniMiniMusicApp implements ControllerEventListener{    // Add listener interface;
	 static HelloWorld2 gui = new HelloWorld2();
   
	 public static void main(String[] args) {
    	 gui.go();
    	 MiniMiniMusicApp a = new MiniMiniMusicApp();
    	 a.go();
     }
     public void go(){ 
    	 try {
             Sequencer sequencer = MidiSystem.getSequencer();         
             sequencer.open();
             
             int[] eventsIWant = {12};                                                            //SetListener;
             sequencer.addControllerEventListener(this, eventsIWant);    //SetListener;
             
             Sequence seq = new Sequence(Sequence.PPQ, 4);
             Track track = seq.createTrack();   
         
         for(int i=5; i<61; i+=4){
        	 track.add(makeEvent(144,1,i,100,i));
        	
        	 track.add(makeEvent(176,1,12,0,i));    //Add event ()
        	 
        	 track.add(makeEvent(128,1,i,100,i+2));
         }
         
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(400);  //Set the tempo in beats per minute
      sequencer.start();
            
         } catch (Exception ex) {ex.printStackTrace();}
     
     }

    public static MidiEvent makeEvent(int comd, int channel ,int one, int two, int tick) {
    	  MidiEvent event = null;
    	try {
          ShortMessage a = new ShortMessage();
          a.setMessage(comd, channel, one, two);
         event = new MidiEvent(a, tick); 
      } catch (Exception ex) {ex.printStackTrace();}
       return  event;
 } 
    public void controlChange(ShortMessage event){
          gui.frame.repaint();
    }
} 