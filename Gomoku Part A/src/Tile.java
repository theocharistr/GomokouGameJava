
/*����� ��������:
I)	������� ������������ 
	�.�.�.: 8080       
	E-mail: kostasgrou@gmail.com
	��������: 6979025692
II)	��������������� ��������
	�.�.�.: 7995   
    E-mail: harisole@hotmail.gr
	��������: 6946045939 */


/*
 *  � ����� �������� �� �������� ��� ������ ��� ����������.
 *  �������� ��� ���������� ���  ���� constructors  ��� ����������� ��� ��� ��������� ��� ���������.
 *  �����, ����������� setters ��� getters ���� � ��������� ��� ����������  ��� ��������� �� ����� ������������.
 */
public class Tile implements Cloneable
{

  // TODO Fill the class code.
	
    //  �� ���������� ����� ���������� �� private ����� ������� �� ����� ������������� ���� ��� ���� ��� �������
	private int id; // � ��������� ������� �� �������� ������ ���� ���������
	private int x; // � ��������� ���� ������� ��� ���� ��� ��������� ���� ����� x�x.
	private int y; //  � ��������� ���� ������� ��� ���� ��� ��������� ���� ����� y�y
	private int color; // � ��������� ���� ������� �� ����� ��� ��� ��������� ��� ������� ����� �� ���� ���� ������������ ��� ��������� ���� ��������
	private boolean mark; // ��� ��������� ���������
	private int playerId; /*
	                       * � ��������� ���� ������� �� ���� ���� ��� ������������� ��������� ���� ������ ������� ��� ���� 2 ������� ��� �� ���, 
	                       * ������ ��� ������ ���� ����� ������ �� ������������ ��������.������� ����� �� ���� ���� ������������ ��� ��������� ���� ��������
	                       */
	
	/*
	 * O constructor ���� ��� �������� ��� �������� ����������. 
	 * O constructor �������� ��� �� ������������ �� ����������� ��� ������ Tile, ������ ���������� ����� ��� ��� ����������(id,x,y,color,mark,playerId)  
	 * ��� �������� �� �� ������� ��������������.
	 * ����������� �� ����-������ this ��� ������������� ���������� ����� (����������) ��� ������������.
	 */
	public Tile(int id, int x, int y, int color, boolean mark, int playerId) {

		this.id = id;
		this.x = x;
		this.y = y;
		this.color = color;
		this.mark = mark;
		this.playerId = playerId;
	}

	public int getId() { // ����������� ��� ���� ��� id
		return id;
	}

	public void setId(int id) { // ������ ��� ���� ��� id
		this.id = id;
	}

	public int getX() { // ����������� ��� ���� ��� getX
		return x;
	}

	public void setX(int x) { // ������ ��� ���� ��� x
		this.x = x;
	}

	public int getY() { // ����������� ��� ���� ���  y
		return y;
	}

	public void setY(int y) {  // ������ ��� ���� ��� y
		this.y = y;
	}

	public int getColor() {  // ����������� ��� ���� ��� color
		return color;
	}

	public void setColor(int color) { // ������ ��� ���� ��� ���������� color
		this.color = color;
	}

	public boolean getMark() {  // ����������� ��� ���� ��� mark
		return mark;
	}

	public void setMark(boolean mark) { // ������ ��� ���� ��� ���������� mark
		this.mark = mark;
	}

	public int getPlayerId() {  // ����������� ��� ���� ��� playerId
		return playerId;
	}

	public void setPlayerId(int playerId) {   // ������ ��� ���� ��� playerId
		this.playerId = playerId;
	}
	
	
	
}
