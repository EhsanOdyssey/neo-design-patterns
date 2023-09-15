package neo.ehsanodyssey.patterns.proxy.media_lib;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Wed 24 Nov 2021
 */

import java.util.HashMap;

/**
 * Remote Service Interface
 */
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
