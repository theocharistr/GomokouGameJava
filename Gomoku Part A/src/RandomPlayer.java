/*Ομάδα εργασίας:
I)	Γρούϊος Κωνσταντίνος 
	Α.Ε.Μ.: 8080       
	E-mail: kostasgrou@gmail.com
	Τηλέφωνο: 6979025692
II)	Τριανταφυλλίδης Θεοχάρης
	 Α.Ε.Μ.: 7995   
	 E-mail: harisole@hotmail.gr
	 Τηλέφωνο: 6946045939 */

/*  Η κλάση είναι υπεύθυνη για την εκπόνηση των παικτών του παιχνιδιού
 *  Περιέχει τις απαιτούμενες μεταβλητές καθώς και τους κατάλληλους constructors για την υλοποίηση αυτή.
 *  Με πρόσθεση setters και getters καθιστούμε την κατάσταση των μεταβλητών επεξεργάσιμη .
 *  Τέλος, προσθέτουμε την συνάρτηση  getNextMove (Board board), η οποία θα καθορίζει την θέση που θα τοποθετηθεί ένα πούλι.
 */
public class RandomPlayer implements AbstractPlayer
{
  // TODO Fill the class code.

	//  Οι μεταβλητές είναι δηλώνονται ως private γιατί θέλουμε να είναι προσπελάσιμες μόνο απο μέλη της κλάσεως
	private int id; // Μια μεταβλητή που παίρνει την τιμή 1 ή 2 ανάλογα με το αν ο παίκτης είναι ο άσπρος ή ο μαύρος.
	private String name; // Η μεταβλητή αυτή δίνει το όνομα που επιθυμούμε στον παίκτη
	private int score; // Η μεταβλητή αυτή αποθηκεύει τον αριθμό των ζαχαρωτών που έχει συγκεντρώσει ο παίκτης.
	
	
	/* 
	 * O constructor εχει σαν ορίσματα την μεταβλητή pid. 
	 * O constructor καλείται για να δημιουργήσει τα αντικείμενα της κλάσης RandomPlayer , δηλαδη δεσμεύεται χώρος για την μεταβλητή pid  
	 * και της αντιστοιχεί τις τιμές που έχουμε ορίσει για το id.
	 */
	public RandomPlayer(Integer pid) {
		
		id = pid.intValue();
		
	}
	
	
	/*
	 * O constructor εχει σαν ορίσματα τις παραπάνω μεταβλητές που ορίσαμε. 
	 * O constructor καλείται για να δημιουργήσει τα αντικείμενα της κλάσης RandomPlayer , δηλαδη δεσμεύεται χώρος για τις μεταβλητές (id,name,score )  
	 * και γίνονται οι εξ ορισμού αρχικοποιήσεις.
	 * Αξιοποιούμε τη λέξη-κλειδι this και επιτυγχάνουμε προσπέλαση μελών (μεταβλητών) του αντικειμένου.
	 */
	public RandomPlayer(Integer pid, String name, int score) {
		
		id = pid.intValue();
		this.name = name;
		this.score = score;
	}

	public int getId() {  // Επιιστρέφει την τιμή του id
		return id;
	}

	public void setId(int id) { // Ορίζει την τιμή της μεταβλητής id
		this.id = id;
	}

	public String getName() { // Επιιστρέφει την τιμή του  getName
		return name;
	}

	public void setName(String name) { // Ορίζει την τιμή της μεταβλητής  name
		this.name = name;
	}

	public int getScore() {  // Επιιστρέφει την τιμή του  score
		return score;
	}

	public void setScore(int score) { // Ορίζει την τιμή της μεταβλητής score
		this.score = score;
	}
	
	
	/*
	 * H συνάρτηση  getNextMove (Board board) παίρνει σαν όρισμα την μεταβλητή board η οποία είναι αντικείμενο της κλάσης Board  και επιστρέφει  
	 * έναν μονοδιάστατο πίνακα ακεραίων, μεγέθους δύο (2) ο οποίος θα περιέχει την θέση (x,y) στην οποία θα τοποθετηθεί το επόμενο πούλι.
	 * Η επιλογή της θέσης γίνεται τυχαία. Για να τοποθετηθεί το πούλι ελέγχει το χρώμα και αν ειναι ελεύθερο=γκρι(δηλαδη 0) τοποθετείται ενω αν 
	 * είναι κατειλημμένη επιλέγει μια άλλη θέση . Η επιλογή της τυχαίας θέσης  γίνεται με την συνάρτηση double Math.random().
	 * H συνάρτηση getTile(int x,int y) χρησιμοποιείται για τον έλεγχο της ελευθερίας πλακιδίου.
	 * 
	 */
	
    public	int [] getNextMove(Board board){ // Η συνάρτηση ορίζεται σαν  public για να είναι προσπελάσιμη κι απο τον υπόλοιπο κώδικα που βρισκεται σε αλλο πακέτο.
	    
    	int[] position = new int[2]; //Δημιουργία ενός μονοδιάστατου πίνακα ακεραίων δύο θέσεων για την θέση (x,y)
       
    	
        //Δέσμευση και έλεγχος πλακιδίου
    	do{
    		position[0] = (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_COLUMNS);
/*
* Ισχύει ότι position[0]=x; 
* Η (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_COLUMNS) χρησιμοποιειται για να πάρω όλες τις ακέραιες τιμές μεταξύ [0,14]βασιζόμενη στην double Math.random() .
* Η  GomokuUtilities.NUMBER_OF_COLUMNS δίνει τον αριθμο των στηλών που ισούται προς το παρόν με 15 .
*/
            position[1]= (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_ROWS);
/*Ισχύει ότι position[1]=y;
* Η (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_ROWS) χρησιμοποιειται για να πάρω όλες τις ακέραιες τιμές μεταξύ [0,14]βασιζόμενη στην double Math.random() .
* Η GomokuUtilities.NUMBER_OF_ROWS δίνει τον αριθμο των γραμμών που ισούται προς το παρόν με 15.
*/
            
            
    	}while(board.getTile(position[0],position[1]).getColor()!=0); //Συνθηκη για τον έλεγχο της ελευθερίας του πλακιδίου 
        /*Το αντικείμενο  board καλεί την συνάρτηση getTile(int x,int y) η οποία με την σειρά της καλεί την getColor()  και συγκρίνει
         *το χρώμα  για να δει εαν είναι ελεύθερο(δηλαδή 0) το τυχαίο πλακίδιο του ταμπλό. 
         */
    		
    	return position; // Επιστροφή του πίνακα που περιέχει την θέση (x,y)

	}
	
	

}
