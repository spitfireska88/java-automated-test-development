package demo;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.*;

/**
 * Test Case
 */
public class ArrayListTest { //SUT
    private ArrayList<Object> sut;

    public ArrayListTest() {
        System.out.println(">>>> CREATED!!!!!");
    }

    //    @BeforeClass, static!!!
    @Before //@After
    public void initSut() {
        sut = new ArrayList<>();
    }

    @Test
    public void shouldGetElementWhenAddNullElement() { //BDD
        //region Fixture | Arrange | Given
        Object dummyElement = null;
        assumeTrue(sut.size() == 0);
        //endregion

        //region Act | When
        sut.add(dummyElement);
        //endregion

        //region Assert | Then
        assertEquals("", dummyElement, sut.get(0));
        assertEquals(1, sut.size());
//        Assert.assertSame();
        Assert.assertEquals(0.3, .1 + .2, 0.000001);

        assertThat(sut.size())
                .isLessThan(2)
                .isPositive()
                .isEqualTo(1);
        //endregion
    }

    @Test(timeout = 5_000)
    public void shouldBeingEmptyWhenCreated() {
        assertEquals(0, sut.size());
    }

    @Test
    public void shouldUseElementsStringRepresentationWhenCallToString() {
        Object stubElement1 = mock(Object.class);
        Object stubElement2 = mock(Object.class);
        when(stubElement1.toString()).thenReturn("test1");
        when(stubElement2.toString()).thenReturn("test2");
        sut.add(stubElement1);
        sut.add(stubElement2);

        assertThat(sut.toString())
                .contains("test1")
                .contains("test2");
    }

    @Test @Ignore
    public void shouldUseElementsStringRepresentationWhenCallToString2() {
        Object mockElement = spy(new Object());
        sut.add(mockElement);

        sut.toString();
        System.out.println(sut);

        verify(mockElement, times(1)).toString();
    }

}
