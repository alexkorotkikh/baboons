package ua.com.sourceit.secretsanta;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: alexkorotkikh
 * Date: 1/18/14
 * Time: 12:36 PM
 */
public interface PairGenerationStrategy {
    Map<Integer, Integer> generatePairs(List<Integer> ids);
}

class SimplePairGenerationStrategy implements PairGenerationStrategy {
    @Override
    public Map<Integer, Integer> generatePairs(List<Integer> ids) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < ids.size(); i++) {
            if (i == ids.size() - 1) {
                result.put(ids.get(i), ids.get(0));
            } else {
                result.put(ids.get(i), ids.get(i + 1));
            }
        }
        return result;
    }
}

class RandomPairGenerationStrategy extends SimplePairGenerationStrategy {

    @Override
    public Map<Integer, Integer> generatePairs(List<Integer> ids) {
        Collections.shuffle(ids);
        return super.generatePairs(ids);
    }
}