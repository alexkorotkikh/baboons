package ua.com.sourceit.secretsanta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}
