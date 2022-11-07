package profundizacion.examen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Vector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MatriculaTest {

	Matricula mat;

	@Test
	public void EmptySubjectVectorTest() {
		mat = new Matricula(new Vector<Asignatura>());
		assertThrows(Exception.class, new Executable() {
			public void execute() throws Throwable {
				mat.getImporte();
			}
		});
	}

	@Test
	public void getImporteTest() {
		Asignatura a = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(100.00);
		Asignatura b = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(150.00);
		Asignatura c = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(200.00);

		Vector<Asignatura> asignaturas = new Vector<Asignatura>();
		asignaturas.add(a);
		asignaturas.add(b);
		asignaturas.add(c);
		Matricula mat = new Matricula(asignaturas);

		try {
			assertEquals(450.00, mat.getImporte());
		} catch (Exception e) {
			fail("No hay asignaturas en la matricula");
		}
	}

	@Test
	public void getImporteIterTest() {
		Asignatura a = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(100.00);
		Asignatura b = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(150.00);
		Asignatura c = mock(Asignatura.class);
		when(a.getImporte()).thenReturn(200.00);

		Vector<Asignatura> asignaturas = new Vector<Asignatura>();
		asignaturas.add(a);
		asignaturas.add(b);
		asignaturas.add(c);
		Matricula mat = new Matricula(asignaturas);
		
		try {
			mat.getImporte();
		} catch (Exception e) {
			fail("No hay asignaturas en la matricula");
		}
		
		verifyNoMoreInteractions(a, times(1));
		verifyNoMoreInteractions(b, times(1));
		verifyNoMoreInteractions(c, times(1));

	}

}
