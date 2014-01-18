package ua.com.sourceit.secretsanta;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * User: alexkorotkikh
 * Date: 1/18/14
 * Time: 12:46 PM
 */
public class SimplePairGenerationStrategyTest {
    @Test
    public void testGeneratePairs() throws Exception {
        PairGenerationStrategy simple = new SimplePairGenerationStrategy();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        Map<Integer, Integer> map = simple.generatePairs(ids);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case 1:
                    assertEquals(new Integer(2), entry.getValue());
                    break;
                case 2:
                    assertEquals(new Integer(3), entry.getValue());
                    break;
                case 3:
                    assertEquals(new Integer(1), entry.getValue());
                    break;
                default:
                    fail("Unexpected key in the map: " + entry);
            }
        }

    }
}
