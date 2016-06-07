package Miage2016.activite3;
/** implementation de la grille.
 * 
 * @author jnb
 *
 */
public class GrilleImpl implements Grille {
	/** public static char[][] magrille = new char[9][9]. 
	 * creation de la grille.
	 * 
	 */
	
	char[][] magrille = new char[][]{
			{ EMPTY, '9', '3',   EMPTY, '2', EMPTY,   EMPTY, EMPTY, '8' },
            { '7', '2', '4',   '6', EMPTY, '9',   EMPTY, '3', EMPTY },
            { EMPTY, '6', EMPTY,   EMPTY, EMPTY, '3',   EMPTY, EMPTY, '2' },
            { EMPTY, EMPTY, EMPTY,   EMPTY, EMPTY, EMPTY,   EMPTY, '2', '1' },
            { EMPTY, EMPTY, EMPTY,   '8', EMPTY, '4',   EMPTY, EMPTY, EMPTY },
            { '5', '7', EMPTY,   EMPTY, EMPTY, EMPTY,   EMPTY, EMPTY, EMPTY },
            { '9', EMPTY, EMPTY,   '3', EMPTY, EMPTY,   EMPTY, '8', EMPTY },
            { EMPTY, '3', EMPTY,   '7', EMPTY, '2',   '5', '1', '4' },
            { '2', EMPTY, EMPTY,   EMPTY, '5', EMPTY,   '6', '9', EMPTY } };
	
	public int getDimension() {
		// TODO Auto-generated method stub
		return magrille.length;
	}

	public void setValue(int x, int y, char value)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		boolean testpossible = false;
		if ((x > magrille.length) | (x < 0) | (y > magrille.length) | (y < 0)
				| magrille[x][y] != EMPTY) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i <= magrille.length; i++) {
			if (possible[i] == value) {
				testpossible = true; //c'est un caractÃ¨re possible
			}
		}
		if (testpossible == false) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < magrille.length; i++) { 
			/** on cherche verticalement et horizontalement
		* si 'value' est dÃ©jÃ  prÃ©sent
		*/ 
			if ((magrille[i][y]) == value | (magrille[x][i]) == value) {
				throw new IllegalArgumentException();
			}
		}
		magrille[x][y] = value;
	}

	
	public char getValue(int x, int y) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if ((x > magrille.length) | (x < 0) | (y > magrille.length) | (y < 0)) {
			throw new IllegalArgumentException();
		}
		return (char) magrille[x][y];
	}

	
	
	public boolean complete() {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		boolean test = true;
		while (i < magrille.length & test) {
			for (j = 0; j < magrille.length; j++) {
			if (magrille[i][j] == EMPTY)  { 
				test = false;
			}
				} 
			i++;
			}
		return test;
	}


	public boolean possible(int x, int y, char value)
			throws IllegalArgumentException {
		boolean test = false;
		boolean testpossible = false;
		// TODO Auto-generated method stub
		if ((x > magrille.length) | (x < 0) | (y > magrille.length) | (y < 0)) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i <= magrille.length; i++) {
			if (possible[i] == value) {
				testpossible = true; //c'est un caractÃ¨re possible
			}
		}
		if (testpossible == false) {
			throw new IllegalArgumentException();
		}
		
		int i = 0;
		boolean contientvalue = false;
		do { 
			/* on cherche verticalement et horizontalement
		si 'value' est dÃ©jÃ  prÃ©sent et si la case est vide */ 
			if ((magrille[i][y]) == value | (magrille[x][i]) == value | 
					(magrille[x][y]) != EMPTY) {
				contientvalue = true;
			}
			
			i++;
		} while(i < magrille.length && contientvalue == false);
		if (contientvalue == false) {
			test = true;
		}
		
		return test;
	}

}
