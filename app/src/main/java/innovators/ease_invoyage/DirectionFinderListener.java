package innovators.ease_invoyage;

/**
 * Created by DELL on 25-Nov-17.
 */

import java.util.List;

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
