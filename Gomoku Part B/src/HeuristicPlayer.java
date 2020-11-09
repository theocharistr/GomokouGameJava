
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
              //����������� ��� ��������� ������������ ������� ��� �� (������) ������ (x0=((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2),y0=((GomokuUtilities.NUMBER_OF_ROWS-1)/2)) �� ���� ��� ���������� ���� ��� ������.
              distance=((((GomokuUtilities.NUMBER_OF_ROWS-1)/2)-y)*(((GomokuUtilities.NUMBER_OF_ROWS-1)/2)-y))+((((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)-x)*(((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)-x));
              // � sqrt() ���������� double ����� ������ �� ��� ������������ �� float, ������ ���� typecasting
              distance=(float)(Math.sqrt(distance)); 
              //��������� ��� �������� ��� �� ������ �� ��� ������� �������� ���� �� ������ ���� ������ ��� �������� [0,1].
              distance/=((float)(Math.sqrt((((GomokuUtilities.NUMBER_OF_ROWS)-1)/2)*((GomokuUtilities.NUMBER_OF_ROWS-1)/2)+((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2)*((GomokuUtilities.NUMBER_OF_COLUMNS-1)/2))));
              //������������ �� �������������� �� ���� 1 ��� ������� ��� ������ ����� ������� � ����������� ����������� �� ���������� ��� ��������� �������� ��� �� ������.
              distance=1-distance; 
              //������������ ���� float ������ ��� ������ ��� [0,100] � ������ ���������� ��� ������������.
              distance*=100; 
              return distance; 
              
           }
           
           /*  ��������� ��� ������ ��� ��������� ��� ������� ���� ������ ���� ��� ����������� ���������� ������� �� �� dirX ��� dirY .
            *  � count ��� ����� ��� ���������� ������� ���� ������ �����������(��������� �����, ������ ���� �� ����, ����� ��������� ���� ����� ��� ������������ ��������� ���� �����) ����
            *  ��� ������������� ��� ���� ���������������� ���� �������� ���������� (��������� ��������, ������ ���� �� ����, ������������ �������� ���� �������� ��� ����� �������� ���� ��������) 
            */
           public int count( int color, int col, int row , Board board,int dirX, int dirY) {
               
               int ct = 1;  // � ������� ��� �������� ��� ������� ���� ������. O ct ����� ���� ��������.
               
               int r, c;    // �� ������������� ���  ��������� ��� �� ���������.
               
               c= col + dirX;  // ���� �� �������� �� ���� ��� ���������, ������ ����� ��� ������������� ��� �������� ��������� .
               r= row + dirY;
               // ������� ������� ��� �������� ��������� ���� ��������. ���������� �� ��� ��������� ��� �� ���� ��� ������.
               while ( r >= 0 && r < GomokuUtilities.NUMBER_OF_ROWS && c >= 0 && c < GomokuUtilities.NUMBER_OF_COLUMNS && board.getTile(c,r).getColor() == color ) {
                       //�� �������� ������ ���� ������ ����� ��������� ��� �������.
                  ct++;
                  c += dirX;  // ������� ��� ������� ������� �� ���� ��� ���������. 
                  r += dirY;
               }


                              
               c= col - dirX;  // ������ �� �������� ���� �������� ���������, ���� ���������� ��� ������ ������������ ��� ������� ��� ������������� (��� ������� ��� ���� ��� ��������)
               r = row - dirY;
                // ������� ������� ��� ��������� ���� ��������. ���������� �� ��� ��������� ��� �� ���� ��� ������.
               while ( r >= 0 && r < GomokuUtilities.NUMBER_OF_ROWS && c >= 0 && c < GomokuUtilities.NUMBER_OF_COLUMNS && board.getTile(c,r).getColor()== color ) {
             	  //�� �������� ������ ���� ������ ����� ��������� ��� �������.
                  ct++;
                  c -= dirX;   // ������� ��� ������� ������� �� ���� ��� ��������� .
                  r -= dirY;
               }

               return ct;

             }  // ��������� ��� ������� ����� ���� ��� ��������� �������� ��� ������ ���� ������ ���� ��� ���������� ����.
           
           
           //��������� ������� ��� �������� � ��� ���������� ��� ����� �������� ���� ����� ���� ������.
           public boolean createsQuintuple(int x,int y,int color,Board board){
        	   /*  ��������������� ���  count ���  �������� �� ������ ����������� ��� ����� �������� ���� �����.
        	    *  � count ��� ����� ��� ���������� ������� ���� ������ ��� ������������� �����������.����� ������� ��������� ��� ������ ������������ ��� 
        	    *  ���� ��� ���������� ���� ������������ ��� �� �������� ��� ���� �������������.
        	    */
        	   
        	   //��������������� ��� int ��������� ���� count ��� �� ���������� if ������� ��� ������� ���� ������ ��� ��������� ������������ ���� ��� count
        		 int i=count( color, y, x,board, 1, 0 );
        		 
        		 if (i >= 5)
        	         return true;// ������� ��� ��������� �������
        	      if (count( color, y, x,board, 0, 1 ) >= 5)// ������� ��� ������ �������
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) >= 5)// ������� ���  ������� ���� ������������ ��������
        	         return true;
        	      if (count( color, y,x,board , 1, 1) >= 5)// ������� ���  ������� ���� ����� ��������
        	         return true;
        	  
        	  
        	      return false; // ���������� false �� ����� if ��� ������������ 
        	      
        			  }
           
         //��������� ������� ��� ��������
        	 public boolean createsQuatro(int x,int y,int color,Board board){
        		 
        		 /* 
          	      *  � count ��� ����� ��� ���������� ������� ���� ������ ��� ������������� �����������.����� ������� ��������� ��� ������ ������������ ��� 
          	      *  ���� ��� ���������� ���� ������������ ��� �� �������� ��� ���� �������������.
          	      */
        		 
        		//��������������� ��� int ��������� ���� count ��� �� ���������� if ������� ��� ������� ���� ������ ��� ��������� ������������ ���� ��� count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 4)// ������� ��� ��������� �������
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 4)// ������� ��� ������ �������
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 4)// ������� ���  ������� ���� ������������ ��������
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 4)// ������� ���  ������� ���� ����� ��������
        	         return true;
        	         
        	   

        	  
        	      return false;// ���������� false �� ����� if ��� ������������ 
        	      
        			  }
        	 
        	//��������� ������� ��� �������
        	 public boolean createsTriple(int x,int y,int color,Board board){
        		 
        		 /*  ��������������� ���  count ���  �������� �� ������ ���� �������� ���� �����.
          	      *  � count ��� ����� ��� ���������� ������� ���� ������ ��� ������������� �����������.����� ������� ��������� ��� ������ ������������ ��� 
          	      *  ���� ��� ���������� ���� ������������ ��� �� �������� ��� ���� �������������.
          	      */
        		 
        		//��������������� ��� int ��������� ���� count ��� �� ���������� if ������� ��� ������� ���� ������ ��� ��������� ������������ ���� ��� count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 3)// ������� ��� ��������� ������
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 3)// ������� ��� ������ ������
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 3)// ������� ���  ������ ���� ������������ ��������
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 3)// ������� ���  ������ ���� ����� ��������
        	         return true;
        	         
        	    
        	  
        	      return false;// ���������� false �� ����� if ��� ������������ 
        	      
        			  }
        	 
        	//��������� ������� ��� ������
        	 public boolean createsDouble(int x,int y,int color,Board board){
        		 
        		 /*  ��������������� ���  count ���  �������� �� ������ ��� �������� ���� �����.
          	      *  � count ��� ����� ��� ���������� ������� ���� ������ ��� ������������� �����������.����� ������� ��������� ��� ������ ������������ ��� 
          	      *  ���� ��� ���������� ���� ������������ ��� �� �������� ��� ���� �������������.
          	      */
        		 
        		//��������������� ��� int ��������� ���� count ��� �� ���������� if ������� ��� ������� ���� ������ ��� ��������� ������������ ���� ��� count
        		 int i=count( color, y, x,board, 1, 0 );
        		 if (i == 2)// ������� ��� ��������� �����
        	         return true;
        	      if (count( color, y, x,board, 0, 1 ) == 2)// ������� ��� ������ �����
        	         return true;
        	      if (count( color, y, x,board, 1, -1 ) == 2)// ������� ���  ����� ���� ������������ ��������
        	         return true;
        	      if (count( color, y,x,board , 1, 1) == 2)// ������� ���  ����� ���� ����� ��������
        	         return true;
        	         
        	    
        	  
        	      return false;// ���������� false �� ����� if ��� ������������ 
        	      
        			  }
        	 
           
           


           
           public int[] getNextMove (Board board)  {
          	 
                int evaluation ;
                int[] position = new int[2]; // � ������ ��� �� ���������� ��� ����� ��� �� �������� ��� ������������� ��� �������� �������
                ArrayList<int[]> evaluatedPosition = new ArrayList<int[]>(); //����������  ���� ArrayList �� ����� evaluatedPosition 
                /* �� ��� ��� for ��������� ���� ��� ��������� ������  ��� ������ ������ ��� ������, ������� ������ 225 �������� ����������. (15*15=225 �� �������� ��� ������)
                 * ���� �������� �������� �� ����������� ��� �� ����������� ���� ArrayList.
                 */
                   for (int x=0;x<GomokuUtilities.NUMBER_OF_COLUMNS; x++ ){
                        for (int y=0;y<GomokuUtilities.NUMBER_OF_ROWS; y++){
                             if( board.getTile(x,y).getColor()==0)// ������� ��� �������� ���������
                             { evaluation=evaluate (x,y,board);//���������� ���� ����� ��������� 
                             int[] flagArray = new int[3]; //���������� ������������� flagarray �� 3������ 
                             //����������� ��� ������������� ��� ���������� ��� ��������� ���� flagarray
                             flagArray[0]=x;
                             flagArray [1]=y;
                             flagArray[2]=evaluation;
                             evaluatedPosition.add(flagArray);//�������� �� flagarray ���� ArrayList  
                             }
                        }
                   }
                   
                int max1=-1,k=0,l=0; //max ��� �������� ���������� 
                int[] flagArray2 = new int[3];//���������� flagarray2 � ������ �� �� ����� evaluatedPosition.get(i) ������� ��� ���������� ���� ��������� ��� �� ������ ��� ��������
                   for (int i=0;i<evaluatedPosition.size();i++)// ������� ����� ����������� ���� ��� �� ������ ��� �����������
                   {
                    flagArray2=evaluatedPosition.get(i);// ������ ��� ���� ���� ��� ArrayList
                    //��������� ��� �������� ������������ ����
                     if (max1<flagArray2[2]){
                        max1= flagArray2[2];  k=flagArray2[0];
                        l=flagArray2[1];
                     }

                   }
           // ��������� ������ position ��� �������� ������������� ��� ������� �� �������� ���������� 
                position[0]=k;
                position[1]=l;

           return position; //
           } 

          //���������� ����� ��� 1-100 ��� ���� ���� �������� ��� ���������� ���� �����. ��� ��� ����� ������� ���� ��� ���� ������
           int evaluate (int x, int y, Board board){
        	   
               int color2;
               int color1=id;// ��������� �� ����� ��� ������ ���
               // ��������� �� ����� ��� ���������
               if (color1==1) {color2=2;}
                  else{color2=1;}
               
               if(createsQuintuple(x,y,color1,board) ==true){
                  return ( 100);} //�� �������������� 5��� ������������ 100
                      else if(createsQuintuple(x,y,color2,board) ==true){
                         return ( 99);}//�� ������ ���������� �� ������������ 5��� ��� ��������� ������������ 99 ���� ���� �� ��� ������� ��� �������� �� ������ �������� �����
                            else 
                              {double q=0 ;
                               int c=(int)centrality(x,y);// ��������� ��� ������������ ��� ������
                            // ������� colorpercentage �� ������ 4 ��� �������� �� ������� ��������� ��� ��� ������� ���� ������ ���� �� �������� ������� ��������
                               q=(GomokuUtilities.colorPercentage(board, x, y, 4, id));
                               q=q*100;
                                   if (createsQuatro(x,y,color1,board)==true)
                                  { return (int)(80+0.1*c)/2;}// �� ������� 4��� ��� ������� �� ���� �������� ������ � ������ ������������ ��� ����
                                     else if (createsTriple(x,y,color1,board)==true )
                                        { return (int)(60+0.1*c)/2;}//�� �������� 4��� ��� ������� �� ���� �������� ������ � ������ ������������ ��� ����
                                          else if (createsDouble(x,y,color1,board)==true)
                                            { return (int)(50+0.1*c)/2;}//�� ������� 3��� ��� ������� �� ���� �������� ������ � ������ ������������ ��� ����
                                             else{
                                                 int a =( (int)( 0.7*(q+c))/ (int)2.0);//������������ ���� ��� centrality ��� colorpercentage ��� ������������ ��� ������� ����� ��� ����� ����

                                                 //�������� ��� ����������� ���� ���� ��� ������ ��� ��� ��� ������ �� ��������� ���
                                                 System.out.print(x+" ");
                                                 System.out.print(y+" ");
                                                 System.out.println(a+" ");
                                                 
                                                 return (a); //������������ ��� ���������� ��� �����
                                                 }
                                }
                         }
          }

        