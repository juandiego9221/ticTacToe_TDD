package pe.com.jdmm21.tic.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TicTacToeSpec {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	private TicTacToe ticTacToe;

	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5, 2);
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}
	
	@Test
	public void whenOccupiedThenRuntimeException() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 1);
	}
	
	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		ticTacToe.play(1, 1);
		assertEquals("error en comparacion", 'O',ticTacToe.nextPlayer());
	}
	
	@Test
	public void givenLastTurnWasYWhenNextPlayerThenX() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		assertEquals("error",'X', ticTacToe.nextPlayer());
	}

}
