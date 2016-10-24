package enumerated;

/**
 * Created by TangBin on 25/10/2016.
 */

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
