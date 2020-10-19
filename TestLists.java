package cse12pa2student;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private StringList makeList(String[] contents) {
		switch(this.listType) {
		case "Linked": return new LinkedSL(contents);
		case "Array": return new ArraySL(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		String[] input = {"a", "b", "c"};
		StringList s = makeList(input);
		assertArrayEquals(input, s.toArray());
	}
	
	@Test
	public void testToArray() {
		String[] input = {};
		StringList s = makeList(input);
		assertArrayEquals(input, s.toArray());
	}
	
	@Test
	public void testToArray2() {
		String[] input = {"1","2","3","4","5","6","7","8",
				"9","10","11","12","13","14","15","16","17",
				"18","19","20"};
		StringList s = makeList(input);
		assertArrayEquals(input, s.toArray());
	}
	
	@Test
	public void testToArray3() {
		String[] input = {null,null,"3"};
		StringList s = makeList(input);
		assertArrayEquals(input, s.toArray());
	}
	
	@Test
	public void testTransformer1() {
		String[] input = {"a","b"};
		String[] output = {"A","B"};
		StringList s = makeList(input);
		s.transformAll(new UpperCaseTransformer());
		System.out.println(Arrays.toString(s.toArray()));
		assertArrayEquals(output,s.toArray());
	}
	
	@Test
	public void testIsEmpty() {
		String[] emptyArr = {};
		StringList s = makeList(emptyArr);
		boolean output = s.isEmpty();
		assertEquals(true, output);
	}
	
	@Test
	public void testIsEmpty2() {
		String[] emptyArr = {"A"};
		StringList s = makeList(emptyArr);
		boolean output = s.isEmpty();
		assertEquals(false, output);
	}
	@Test
	public void testChooseAll() {
		String[] contents = {"longword", "longerword", "short"};
		StringList asl = makeList(contents);
		asl.chooseAll(new LongWordChooser());
		String[] output = {"longword", "longerword"};
		System.out.println(Arrays.toString(asl.toArray()));
		assertArrayEquals(output, asl.toArray());
	}
	
	
}
