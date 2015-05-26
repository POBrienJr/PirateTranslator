import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.*;


public class PirateTranslator {

	public static void main(String[] args) throws MalformedURLException, InvalidMidiDataException, IOException, MidiUnavailableException {
            
            try {
        // From URL
        Sequence yoHo = MidiSystem.getSequence(new URL("http://www.privateerdragons.com/music/pirate.mid"));
    
        // Create a sequencer for the sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(yoHo);
    
        // Start playing
        sequencer.start();
    
            
		HashMap pirateSpeak = new HashMap<>();
		pirateSpeak.put("ID", "CHECKED");
                
		pirateSpeak.put("hello", "ahoy");
		pirateSpeak.put("pardon", "avast");
		pirateSpeak.put("excuse", "arrr");
		pirateSpeak.put("sir", "matey");
		pirateSpeak.put("madam", "proud beauty");
		pirateSpeak.put("miss", "comely wench");
		pirateSpeak.put("stranger", "scurvy dog");
		pirateSpeak.put("officer", "foul blaggart");
		pirateSpeak.put("where is", "whar be");
		pirateSpeak.put("can you help me find", "know ye");
		pirateSpeak.put("is that", "be that");
		pirateSpeak.put("how far is it to", "how many leagues to");
		pirateSpeak.put("the", "th'");
		pirateSpeak.put("a", "a briny");
		pirateSpeak.put("any", "some forsaken");
		pirateSpeak.put("nearby", "broadside");
		pirateSpeak.put("my", "me");
		pirateSpeak.put("your", "yer");
		pirateSpeak.put("old", "barnacle-covered");
		pirateSpeak.put("attractive", "comely");
		pirateSpeak.put("happy", "grog-filled");
		pirateSpeak.put("restaurant", "galley");
		pirateSpeak.put("hotel", "fleabag inn");
		pirateSpeak.put("mall", "market");		
		pirateSpeak.put("pub", "Skull & Scuppers");
		pirateSpeak.put("bank", "buried treasure");
		pirateSpeak.put("I would like to", "I be needin't'");
		pirateSpeak.put("i desire", "I've a fierce fire in me belly t'");
		pirateSpeak.put("I wish I knew how to", "I be hankerin' t'");
		pirateSpeak.put("my mother told me to", "me dear ol' mum, bless her  soul, tol' me t'");
		pirateSpeak.put("my companion would like to", "me mate, ol' Rumpot, wants t''");
		pirateSpeak.put("find", "come across");
		pirateSpeak.put("take a nap", "have a bit of a lie-down");
		pirateSpeak.put("make a withdrawal", "seize all me gold");
		pirateSpeak.put("have a cocktail", "swill a pint or two o' grog");
        pirateSpeak.put("me", "");
		
		final ImageIcon pirateIcon = new ImageIcon(new URL("http://www.united-states-flag.com/media/LandingPageImages/flags/nautical/pijrofl.png"));
		
		JOptionPane.showMessageDialog(null, "Welcome to the English-Pirate Speak Translator.\n"
				+ "This program will prompt you through entering an English sentence and will translate it to Pirate Speak for you.", 
				"English-Pirate Speak Translation Program", JOptionPane.INFORMATION_MESSAGE, pirateIcon);

		
		int print = JOptionPane.showConfirmDialog(null, "Would you like to print the Pirate Speak dictionary for your reference?", 
				"English-Pirate Speak Translation Program", JOptionPane.YES_NO_OPTION);
        
		if (print == JOptionPane.YES_OPTION) {

        	Iterator iterator = pirateSpeak.keySet().iterator();  
 		   
    		System.out.println("Pirate Speak Dictionary:\n");
    		
    		String pirateSpeakPrint = "";
    		
    		while (iterator.hasNext()) {  
    		   String key = iterator.next().toString();  
    		   String value = pirateSpeak.get(key).toString();  
    		   
    		   pirateSpeakPrint += "\"" + key + "\" = " + "\"" + value + "\"\n";
    		   
    		}
        	
    		JOptionPane.showMessageDialog(null, "Here is the dictionary:\n" + pirateSpeakPrint + "\n(The size of the Pirate Speak dictionary is " + pirateSpeak.size() 
    				+ " key and map pairings)", "English-Pirate Speak Translation Program", JOptionPane.INFORMATION_MESSAGE, pirateIcon);
   
        	
        	
        }
        else {
        	JOptionPane.showMessageDialog(null, "The dictionary will not be printed.", "English-Pirate Speak Translation Program", 
        			JOptionPane.INFORMATION_MESSAGE, pirateIcon);
        }
		
		String userInput = JOptionPane.showInputDialog(null, "Please enter a sentence to translate into Pirate.");
		//System.out.println (pirateSpeak.size());   	        
                //System.out.println (pirateSpeak);                       
         
    String greeting = "";// mappings of each element in the Hashtable) 
    
    StringTokenizer st = new StringTokenizer(userInput.toLowerCase());
        
    while(st.hasMoreTokens()) {
        String temp = st.nextToken();
            if(pirateSpeak.containsKey(temp)){   //if()
               greeting += pirateSpeak.get(temp) + " ";
               }     
            else{
                greeting += temp + " ";
                }
     
        }
        
            JOptionPane.showMessageDialog(null,"\"" + userInput + "\" in Pirate Speak is \"" + greeting + "\"");
        
        
        //Stops music
        sequencer.stop();
        
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
        }
    }
        
}