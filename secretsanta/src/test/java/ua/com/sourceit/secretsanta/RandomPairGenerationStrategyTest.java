package ua.com.sourceit.secretsanta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;

/**
 * User: alexkorotkikh
 * Date: 1/18/14
 * Time: 12:59 PM
 */
public class RandomPairGenerationStrategyTest {

    private PairGenerationStrategy random;

    @Before
    public void setUp() throws Exception {
        random = new RandomPairGenerationStrategy();
    }

    @Test
    public void testGeneration() throws Exception {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        ids.add(7);

        final Map<Integer, Integer> map = random.generatePairs(ids);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            assertNotEquals(entry.getKey(), entry.getValue());
        }
    }

    @After
    public void tearDown() throws Exception {


    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        final RandomPairGenerationStrategyTest test = new RandomPairGenerationStrategyTest();
        final Class<? extends RandomPairGenerationStrategyTest> clazz = test.getClass();
        final Method[] declaredMethods = clazz.getDeclaredMethods();


        for (Method declaredMethod : declaredMethods) {
            final Class<Before> annotationClass = Before.class;
            if (declaredMethod.getAnnotation(annotationClass) != null) {
                declaredMethod.invoke(test);
            }
        }

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getAnnotation(Test.class) != null) {
                declaredMethod.invoke(test);
            }
        }

    }
}
