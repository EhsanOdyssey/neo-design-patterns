package neo.ehsanodyssey.patterns.proxy;

import neo.ehsanodyssey.patterns.proxy.downloader.YouTubeDownloader;
import neo.ehsanodyssey.patterns.proxy.media_lib.ThirdPartyYouTubeClass;
import neo.ehsanodyssey.patterns.proxy.proxy.YouTubeCacheProxy;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Wed 24 Nov 2021
 */
public class DemoProxy {

    /**
     * Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object.
     * A proxy controls access to the original object, allowing you to perform something either before or after
     * the request gets through to the original object.
     * You have a massive object that consumes a vast amount of system resources. You need it from time to time, but not always.
     * You could implement lazy initialization: create this object only when it’s actually needed. All the object’s clients
     * would need to execute some deferred initialization code. Unfortunately, this would probably cause a lot of code duplication.
     *
     * The Proxy pattern suggests that you create a new proxy class with the same interface as an original service object.
     * Then you update your app so that it passes the proxy object to all of the original object’s clients.
     * Upon receiving a request from a client, the proxy creates a real service object and delegates all the work to it.
     */

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }
}
