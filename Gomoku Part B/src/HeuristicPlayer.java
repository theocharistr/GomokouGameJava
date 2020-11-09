
          import java.util.ArrayList;
          import java.lang.Math;

          public class HeuristicPlayer implements AbstractPlayer
          {
           int score;
           int id;
           String name;
           public HeuristicPlayer (Integer pid)
           {
           id = pid;
           score = 0;
           }

           public HeuristicPlayer(Integer pid, int pscore, String pname){
           score = pscore;
           id = pid;
           name=pname;

           }  public String getName ()
           {
           return "Heuristic";
           }
           public int getId ()
           {
           return id;
           }
           public void setScore (int score)
           {
           this.score = score;
           }
           public int getScore ()
           {
           return score;
           }
           public void setId (int id)
           {
            this.id = id;
           }
           public void setName (String name)
           {

           this.name = name;
           }


           float centrality(int x, int y){
          	 
               float distance=0;
              //Υπολογισμός της απόστασης οποιουδήποτε σημείου απο το (σημείο) κέντρο (x0=((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2),y0=((GomokuUtilities.NUMBER_OF_ROWS-1)/2)) με βάση τον μαθηματικο τυπο που ισχυει.
              distance=((((GomokuUtilities.NUMBER_OF_ROWS-1)/2)-y)*(((GomokuUtilities.NUMBER_OF_ROWS-1)/2)-y))+((((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)-x)*(((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)-x));
              // Η sqrt() επιστρέφει double οπότε πρέπει να τον μετατρέψουμε σε float, δηλαδή κάνω typecasting
              distance=(float)(Math.sqrt(distance)); 
              //Διαιρούμε την απόσταση από το κέντρο με την μέγιστη απόσταση ώστε να έχουμε έναν αριθμό στο διάστημα [0,1].
              distance/=((float)(Math.sqrt((((GomokuUtilities.NUMBER_OF_ROWS)-1)/2)*((GomokuUtilities.NUMBER_OF_ROWS-1)/2)+((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)*((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2))));
              //Επιστρέφουμε το συμπληρωματικό ως προς 1 του αριθμού που πήραμε διότι θέλουμε ο μεγαλύτερος συντελεστής να υποδηλώνει την μικρότερη απόσταση από το κέντρο.
              distance=1-distance; 
              //Επιστρέφουμε έναν float αριθμό που ανήκει στο [0,100] ο οποίος συμβολίζει την κεντρικότητα.
              distance*=100; 
              return distance; 
              
           }
           
           /*  Απαριθμεί τον αριθμό των πλακιδίων που ανήκουν στον παίκτη προς μια καθορισμένη κατεύθυνση ανάλογα με τα dirX και dirY .
            *  Η count μας δίνει την δυνατότητα ελέγχου στις κύριες κατεθύνσεις(οριζόντια δεξιά, κάθετα προς τα πάνω, κύρια διαγώνιος πάνω δεξιά και δευτερεύουσα διαγώνιος κάτω δεξιά) αλλα
            *  και δευτερεύουσες για τους προσανατολισμούς στην αντίθετη κατεύθυνση (οριζόντια αριστερά, κάθετα προς τα κάτω, δευτερεύουσα διαγώνιο πάνω αριστερά και κύρια διαγώνιο κάτω αριστερά) 
            */
           public int count( int color, int col, int row , Board board,int dirX, int dirY) {
               
               int ct = 1;  // Ο αριθμός των πλακιδών που ανήκουν στον παίκτη. O ct είναι ένας μετρητής.
               
               int r, c;    // Οι συντεταγμένες του  πλακιδίου που θα ελεγξουμε.
               
               c= col + dirX;  // Ψάξε το πλακίδιο σε αυτή την διεύθυνση, δηλαδή δίνει τις συντεταγμένες του επόμενου πλακιδίου .
               r= row + dirY;
               // γίνεται έλεγχος του επόμενου πλακιδίου βάση χρώματος. Προσέχουμε να μην ξεφύγουμε απο τα όρια του ταμπλό.
               while ( r >= 0 && r < GomokuUtilities.NUMBER_OF_ROWS && c >= 0 && c < GomokuUtilities.NUMBER_OF_COLUMNS && board.getTile(c,r).getColor() == color ) {
                       //Το πλακίδιο ανήκει στον παίκτη οπότε αυξάνουμε τον μετρητή.
                  ct++;
                  c += dirX;  // Πήγαινε στο επόμενο πλκίδιο σε αυτή την διεύθυνση. 
                  r += dirY;
               }


                              
               c= col - dirX;  // Ψάχνει το πλακίδιο στην αντίθετη διεύθυνση, αφου μετατρέψει τις κύριες κατευθύνσεις που δέχεται για δευτερεύουσες (τις αφαιρεί ενώ πριν τις πρόσθετε)
               r = row - dirY;
                // γίνεται έλεγχος του πλακιδίου βάση χρώματος. Προσέχουμε να μην ξεφύγουμε απο τα όρια του ταμπλό.
               while ( r >= 0 && r < GomokuUtilities.NUMBER_OF_ROWS && c >= 0 && c < GomokuUtilities.NUMBER_OF_COLUMNS && board.getTile(c,r).getColor()== color ) {
             	  //Το πλακίδιο ανήκει στον παίκτη οπότε αυξάνουμε τον μετρητή.
                  ct++;
                  c -= dirX;   // Πήγαινε στο επόμενο πλκίδιο σε αυτή την διεύθυνση .
                  r -= dirY;
               }

               return ct;

             }  // Επιστροφή του μετρητή μόλις βρει τον τελευταίο πλακίδιο που ανήκει στον παίκτη προς την κατεύθυνση αυτή.
           
           
           //Συνάρτηση ελέγχου για πεντάδες ή και περσσότερα απο πέντε πλακίδια στην σειρά ενος παίκτη.
           public boolean createsQuintuple(int x,int y,int color,Board board){
        	   /*  εκμεταλευόμαστε την  count και  βλέπουμε αν έχουμε περισσότερα απο πέντε πλακίδια στην σειρά.
        	    *  Η count μας δίνει την δυνατότητα ελέγχου στις κύριες και δευτερεύουσες κατεθύνσεις.Εμείς δίνουμε διαδοχικά τις κύριες κατευθύνσεις και 
        	    *  αυτή τις μετατρέπει οπως προαναφέραμε για να εξετάσει και στις δευτερεύουσες.
        	    */
        	   
        	   //Αντιστοιχίζουμε μια int μεταβλητή στην count και με διαδοχικες if κάνουμε τον εξέταση στις κύριες και αντίθετες κατευθύνσεις μέσω της count
        		 int i=count( color, y, x,board, 1, 0 );
        		 
        		 if (i >= 5)
        	         return true;// έλεγχος για οριζόντια πεντάδα
        	      if (count( color, y, x,board, 0, 1 ) >= 5)// έλεγχος για κάθετη πεντάδα
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) >= 5)// έλεγχος για  πεντάδα στην δευτερεύουσα διαγώνιο
        	         return true;
        	      if (count( color, y,x,board , 1, 1) >= 5)// έλεγχος για  πεντάδα στην κύρια διαγώνιο
        	         return true;
        	  
        	  
        	      return false; // Επιστρέφει false αν καμία if δεν ικανοποιηθεί 
        	      
        			  }
           
         //Συνάρτηση ελέγχου για τετράδες
        	 public boolean createsQuatro(int x,int y,int color,Board board){
        		 
        		 /* 
          	      *  Η count μας δίνει την δυνατότητα ελέγχου στις κύριες και δευτερεύουσες κατεθύνσεις.Εμείς δίνουμε διαδοχικά τις κύριες κατευθύνσεις και 
          	      *  αυτή τις μετατρέπει οπως προαναφέραμε για να εξετάσει και στις δευτερεύουσες.
          	      */
        		 
        		//Αντιστοιχίζουμε μια int μεταβλητή στην count και με διαδοχικες if κάνουμε τον εξέταση στις κύριες και αντίθετες κατευθύνσεις μέσω της count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 4)// έλεγχος για οριζόντια τετράδα
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 4)// έλεγχος για κάθετη τετράδα
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 4)// έλεγχος για  τετράδα στην δευτερεύουσα διαγώνιο
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 4)// έλεγχος για  τετράδα στην κύρια διαγώνιο
        	         return true;
        	         
        	   

        	  
        	      return false;// Επιστρέφει false αν καμία if δεν ικανοποιηθεί 
        	      
        			  }
        	 
        	//Συνάρτηση ελέγχου για τριάδες
        	 public boolean createsTriple(int x,int y,int color,Board board){
        		 
        		 /*  εκμεταλευόμαστε την  count και  βλέπουμε αν έχουμε τρία πλακίδια στην σειρά.
          	      *  Η count μας δίνει την δυνατότητα ελέγχου στις κύριες και δευτερεύουσες κατεθύνσεις.Εμείς δίνουμε διαδοχικά τις κύριες κατευθύνσεις και 
          	      *  αυτή τις μετατρέπει οπως προαναφέραμε για να εξετάσει και στις δευτερεύουσες.
          	      */
        		 
        		//Αντιστοιχίζουμε μια int μεταβλητή στην count και με διαδοχικες if κάνουμε τον εξέταση στις κύριες και αντίθετες κατευθύνσεις μέσω της count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 3)// έλεγχος για οριζόντια τριάδα
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 3)// έλεγχος για κάθετη τριάδα
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 3)// έλεγχος για  τριάδα στην δευτερεύουσα διαγώνιο
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 3)// έλεγχος για  τριάδα στην κύρια διαγώνιο
        	         return true;
        	         
        	    
        	  
        	      return false;// Επιστρέφει false αν καμία if δεν ικανοποιηθεί 
        	      
        			  }
        	 
        	//Συνάρτηση ελέγχου για δυάδες
        	 public boolean createsDouble(int x,int y,int color,Board board){
        		 
        		 /*  εκμεταλευόμαστε την  count και  βλέπουμε αν έχουμε δυο πλακίδια στην σειρά.
          	      *  Η count μας δίνει την δυνατότητα ελέγχου στις κύριες και δευτερεύουσες κατεθύνσεις.Εμείς δίνουμε διαδοχικά τις κύριες κατευθύνσεις και 
          	      *  αυτή τις μετατρέπει οπως προαναφέραμε για να εξετάσει και στις δευτερεύουσες.
          	      */
        		 
        		//Αντιστοιχίζουμε μια int μεταβλητή στην count και με διαδοχικες if κάνουμε τον εξέταση στις κύριες και αντίθετες κατευθύνσεις μέσω της count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 2)// έλεγχος για οριζόντια δυάδα
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 2)// έλεγχος για κάθετη δυάδα
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 2)// έλεγχος για  δυάδα στην δευτερεύουσα διαγώνιο
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 2)// έλεγχος για  δυάδα στην κύρια διαγώνιο
        	         return true;
        	         
        	    
        	  
        	      return false;// Επιστρέφει false αν καμία if δεν ικανοποιηθεί 
        	      
        			  }
        	 
           
           


           
           public int[] getNextMove (Board board)  {
          	 
                int evaluation ;
                int[] position = new int[2]; // Ο πίνκας που θα επιστραφεί στο τέλος και θα περιέχει τις συντεταγμένες της επόμενης κίνησης
                ArrayList<int[]> evaluatedPosition = new ArrayList<int[]>(); //Δημιουργια  μιας ArrayList με όνομα evaluatedPosition 
                /* Με τις δυο for ελέγχουμε όλες τις ελεύθερες θέσεις  του ταμπλό εκείνη την στιγμή, κάνουμε δηλαδή 225 ελέγχους ελευθερίας. (15*15=225 τα πλακίδια του ταμπλό)
                 * Κάθε ελέυθερο πλακίδιο το αξιολογούμε και το τοποθετούμε στην ArrayList.
                 */
                   for (int x=0;x<GomokuUtilities.NUMBER_OF_COLUMNS; x++ ){
                        for (int y=0;y<GomokuUtilities.NUMBER_OF_ROWS; y++){
                             if( board.getTile(x,y).getColor()==0)// έλεγχος για ελεθερία πλακιδίου
                             { evaluation=evaluate (x,y,board);//Αξιολογηση κάθε κενού πλακιδιου 
                             int[] flagArray = new int[3]; //Δημιουργια μονοδιαστατου flagarray με 3θεσεις 
                             //Τοποθετούμε τις συντεταγμένες την αξιολόγηση του πλακιδίου στον flagarray
                             flagArray[0]=x;
                             flagArray [1]=y;
                             flagArray[2]=evaluation;
                             evaluatedPosition.add(flagArray);//προσθετω το flagarray στην ArrayList  
                             }
                        }
                   }
                   
                int max1=-1,k=0,l=0; //max για καλυτερη αξιολογηση 
                int[] flagArray2 = new int[3];//δημιουργια flagarray2 ο οποίος με τη χρηση evaluatedPosition.get(i) παίρνει την αξιολόγηση κάθε πλακιδίου για να βρούμε την καλύτερη
                   for (int i=0;i<evaluatedPosition.size();i++)// Κάνουμε τόσες επαναλήψεις όσες και οι θέσεις που εξετάστηκαν
                   {
                    flagArray2=evaluatedPosition.get(i);// Παίρνω την κάθε θέση της ArrayList
                    //Βρίσκουμε την καλύτερα αξιολογημένη θέση
                     if (max1<flagArray2[2]){
                        max1= flagArray2[2];  k=flagArray2[0];
                        l=flagArray2[1];
                     }

                   }
           // επιστροφη πινακα position που περιεχει συντεταγμένες του σημειου με καλυτερη αξιολογηση 
                position[0]=k;
                position[1]=l;

           return position; //
           } 

          //επιστρεφει τιμες απο 1-100 μια τιμή ππου αποτελεί την αξιολόγηση μιας θέσης. Όσο πιο υψηλο νουμερο τοσο πιο καλη κινηση
           int evaluate (int x, int y, Board board){
        	   
               int color2;
               int color1=id;// παίρνουμε το χρωμα του παικτη μας
               // Βρίσκουμε το χρώμα του αντιπάλου
               if (color1==1) {color2=2;}
                  else{color2=1;}
               
               if(createsQuintuple(x,y,color1,board) ==true){
                  return ( 100);} //αν δημιουργησουμε 5αδα επιστρεφουμε 100
                      else if(createsQuintuple(x,y,color2,board) ==true){
                         return ( 99);}//αν έχουμε δυνατότητα να σταματήσουμε 5αδα του αντιπαλου επιστρεφουμε 99 έτσι ώστε να μην χάνουμε την ευκαιρία να κάνουμ επεντάδα εμείς
                            else 
                              {double q=0 ;
                               int c=(int)centrality(x,y);// Βρίσκουμε την κεντρικότητα της θέσεως
                            // καλουμε colorpercentage με ακτινα 4 και βλέπουμε το ποσοστό πλακιδίων που μας ανήκουν στην περοχή αυτή με απόσταση τέσσερα πλακίδια
                               q=(GomokuUtilities.colorPercentage(board, x, y, 4, id));
                               q=q*100;
                                   if (createsQuatro(x,y,color1,board)==true)
                                  { return (int)(80+0.1*c)/2;}// αν κανουμε 4αδα και αναλογα το ποσο κεντρικα γινετε η κινηση επιστρεφουμε μια τιμη
                                     else if (createsTriple(x,y,color1,board)==true )
                                        { return (int)(60+0.1*c)/2;}//αν εκανουμε 4αδα και αναλογα το ποσο κεντρικα γινετε η κινηση επιστρεφουμε μια τιμη
                                          else if (createsDouble(x,y,color1,board)==true)
                                            { return (int)(50+0.1*c)/2;}//αν κανουμε 3αδα και αναλογα το ποσο κεντρικα γινετε η κινηση επιστρεφουμε μια τιμη
                                             else{
                                                 int a =( (int)( 0.7*(q+c))/ (int)2.0);//υπολογιζουμε μεσο ορο centrality και colorpercentage και επιστρέφουμε ένα ποσοστό αυτού του μέσου όρου

                                                 //Βλέπουμε πως αξιολγείται κάθε θέση του πίνακα την ώρα που τρέχει το πρόγραμμα μας
                                                 System.out.print(x+" ");
                                                 System.out.print(y+" ");
                                                 System.out.println(a+" ");
                                                 
                                                 return (a); //επιστρέφουμε την αξιολόγηση της θέσης
                                                 }
                                }
                         }
          }

        