
/*Ομάδα εργασίας:
I)	Γρούϊος Κωνσταντίνος 
	Α.Ε.Μ.: 8080       
	E-mail: kostasgrou@gmail.com
	Τηλέφωνο: 6979025692
II)	Τριανταφυλλίδης Θεοχάρης
	Α.Ε.Μ.: 7995   
    E-mail: harisole@hotmail.gr
	Τηλέφωνο: 6946045939 */


/*
 *  Η κλάση υλοποιεί τα πλακίδια του ταμπλό του παιχνιδιού.
 *  Περιέχει τις μεταβλητές και  τους constructors  που απαιτούνται για την υλοποίηση των πλακιδίων.
 *  Τέλος, προσθέτουμε setters και getters ώστε η κατάσταση των μεταβλητών  του πλακιδίου να είναι επεξεργάσιμη.
 */
public class Tile implements Cloneable
{

  // TODO Fill the class code.
	
    //  Οι μεταβλητές είναι δηλώνονται ως private γιατί θέλουμε να είναι προσπελάσιμες μόνο απο μέλη της κλάσεως
	private int id; // Η μεταβλητή δείχνει το μοναδικό κωδικό ενός πλακιδίου
	private int x; // Η μεταβλητή αυτή δείχνει την θέση του πλακιδίου στον άξονα xx.
	private int y; //  Η μεταβλητή αυτή δείχνει την θέση του πλακιδίου στον άξονα yy
	private int color; // Η μεταβλητή αυτή δείχνει το χρώμα του που πλακιδίου και παίρνει τιμές με βάση τους περιορισμούς που ορίζονται στην εκφώνηση
	private boolean mark; // Μια βοηθητική μεταβλητή
	private int playerId; /*
	                       * Η μεταβλητή αυτή δείχνει αν στην θέση του συγκεκριμένου πλακιδίου έχει παίξει κάποιος από τους 2 παίκτες και αν ναι, 
	                       * ορίζει τον παίκτη στον οποίο ανήκει το συγκεκριμένο πλακίδιο.Παίρνει τιμές με βάση τους περιορισμούς που ορίζονται στην εκφώνηση
	                       */
	
	/*
	 * O constructor εχει σαν ορίσματα τις παραπάνω μεταβλητές. 
	 * O constructor καλείται για να δημιουργήσει τα αντικείμενα της κλάσης Tile, δηλαδη δεσμεύεται χώρος για τις μεταβλητές(id,x,y,color,mark,playerId)  
	 * και γίνονται οι εξ ορισμού αρχικοποιήσεις.
	 * Αξιοποιούμε τη λέξη-κλειδι this και επιτυγχάνουμε προσπέλαση μελών (μεταβλητών) του αντικειμένου.
	 */
	public Tile(int id, int x, int y, int color, boolean mark, int playerId) {

		this.id = id;
		this.x = x;
		this.y = y;
		this.color = color;
		this.mark = mark;
		this.playerId = playerId;
	}

	public int getId() { // Επιιστρέφει την τιμή του id
		return id;
	}

	public void setId(int id) { // Ορίζει την τιμή του id
		this.id = id;
	}

	public int getX() { // Επιιστρέφει την τιμή του getX
		return x;
	}

	public void setX(int x) { // Ορίζει την τιμή του x
		this.x = x;
	}

	public int getY() { // Επιιστρέφει την τιμή του  y
		return y;
	}

	public void setY(int y) {  // Ορίζει την τιμή του y
		this.y = y;
	}

	public int getColor() {  // Επιιστρέφει την τιμή του color
		return color;
	}

	public void setColor(int color) { // Ορίζει την τιμή της μεταβλητής color
		this.color = color;
	}

	public boolean getMark() {  // Επιιστρέφει την τιμή του mark
		return mark;
	}

	public void setMark(boolean mark) { // Ορίζει την τιμή της μεταβλητής mark
		this.mark = mark;
	}

	public int getPlayerId() {  // Επιιστρέφει την τιμή του playerId
		return playerId;
	}

	public void setPlayerId(int playerId) {   // Ορίζει την τιμή του playerId
		this.playerId = playerId;
	}
	
	
	
}
