/*����� ��������:
I)	������� ������������ 
	�.�.�.: 8080       
	E-mail: kostasgrou@gmail.com
	��������: 6979025692
II)	��������������� ��������
	 �.�.�.: 7995   
	 E-mail: harisole@hotmail.gr
	 ��������: 6946045939 */

/*  � ����� ����� �������� ��� ��� �������� ��� ������� ��� ����������
 *  �������� ��� ������������ ���������� ����� ��� ���� ����������� constructors ��� ��� ��������� ����.
 *  �� �������� setters ��� getters ���������� ��� ��������� ��� ���������� ������������ .
 *  �����, ����������� ��� ���������  getNextMove (Board board), � ����� �� ��������� ��� ���� ��� �� ����������� ��� �����.
 */
public class RandomPlayer implements AbstractPlayer
{
  // TODO Fill the class code.

	//  �� ���������� ����� ���������� �� private ����� ������� �� ����� ������������� ���� ��� ���� ��� �������
	private int id; // ��� ��������� ��� ������� ��� ���� 1 � 2 ������� �� �� �� � ������� ����� � ������ � � ������.
	private String name; // � ��������� ���� ����� �� ����� ��� ���������� ���� ������
	private int score; // � ��������� ���� ���������� ��� ������ ��� ��������� ��� ���� ������������ � �������.
	
	
	/* 
	 * O constructor ���� ��� �������� ��� ��������� pid. 
	 * O constructor �������� ��� �� ������������ �� ����������� ��� ������ RandomPlayer , ������ ���������� ����� ��� ��� ��������� pid  
	 * ��� ��� ����������� ��� ����� ��� ������ ������ ��� �� id.
	 */
	public RandomPlayer(Integer pid) {
		
		id = pid.intValue();
		
	}
	
	
	/*
	 * O constructor ���� ��� �������� ��� �������� ���������� ��� �������. 
	 * O constructor �������� ��� �� ������������ �� ����������� ��� ������ RandomPlayer , ������ ���������� ����� ��� ��� ���������� (id,name,score )  
	 * ��� �������� �� �� ������� ��������������.
	 * ����������� �� ����-������ this ��� ������������� ���������� ����� (����������) ��� ������������.
	 */
	public RandomPlayer(Integer pid, String name, int score) {
		
		id = pid.intValue();
		this.name = name;
		this.score = score;
	}

	public int getId() {  // ����������� ��� ���� ��� id
		return id;
	}

	public void setId(int id) { // ������ ��� ���� ��� ���������� id
		this.id = id;
	}

	public String getName() { // ����������� ��� ���� ���  getName
		return name;
	}

	public void setName(String name) { // ������ ��� ���� ��� ����������  name
		this.name = name;
	}

	public int getScore() {  // ����������� ��� ���� ���  score
		return score;
	}

	public void setScore(int score) { // ������ ��� ���� ��� ���������� score
		this.score = score;
	}
	
	
	/*
	 * H ���������  getNextMove (Board board) ������� ��� ������ ��� ��������� board � ����� ����� ����������� ��� ������ Board  ��� ����������  
	 * ���� ������������ ������ ��������, �������� ��� (2) � ������ �� �������� ��� ���� (x,y) ���� ����� �� ����������� �� ������� �����.
	 * � ������� ��� ����� ������� ������. ��� �� ����������� �� ����� ������� �� ����� ��� �� ����� ��������=����(������ 0) ������������ ��� �� 
	 * ����� ������������ �������� ��� ���� ���� . � ������� ��� ������� �����  ������� �� ��� ��������� double Math.random().
	 * H ��������� getTile(int x,int y) ��������������� ��� ��� ������ ��� ���������� ���������.
	 * 
	 */
	
    public	int [] getNextMove(Board board){ // � ��������� �������� ���  public ��� �� ����� ������������ �� ��� ��� �������� ������ ��� ��������� �� ���� ������.
	    
    	int[] position = new int[2]; //���������� ���� ������������� ������ �������� ��� ������ ��� ��� ���� (x,y)
       
    	
        //�������� ��� ������� ���������
    	do{
    		position[0] = (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_COLUMNS);
/*
* ������ ��� position[0]=x; 
* � (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_COLUMNS) ��������������� ��� �� ���� ���� ��� �������� ����� ������ [0,14]���������� ���� double Math.random() .
* �  GomokuUtilities.NUMBER_OF_COLUMNS ����� ��� ������ ��� ������ ��� ������� ���� �� ����� �� 15 .
*/
            position[1]= (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_ROWS);
/*������ ��� position[1]=y;
* � (int) Math.floor(Math.random()*GomokuUtilities.NUMBER_OF_ROWS) ��������������� ��� �� ���� ���� ��� �������� ����� ������ [0,14]���������� ���� double Math.random() .
* � GomokuUtilities.NUMBER_OF_ROWS ����� ��� ������ ��� ������� ��� ������� ���� �� ����� �� 15.
*/
            
            
    	}while(board.getTile(position[0],position[1]).getColor()!=0); //������� ��� ��� ������ ��� ���������� ��� ��������� 
        /*�� �����������  board ����� ��� ��������� getTile(int x,int y) � ����� �� ��� ����� ��� ����� ��� getColor()  ��� ���������
         *�� �����  ��� �� ��� ��� ����� ��������(������ 0) �� ������ �������� ��� ������. 
         */
    		
    	return position; // ��������� ��� ������ ��� �������� ��� ���� (x,y)

	}
	
	

}
