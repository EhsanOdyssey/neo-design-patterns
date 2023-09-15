package neo.ehsanodyssey.patterns.facade.media_lib;

import neo.ehsanodyssey.patterns.facade.media_lib.codecs.Codec;
import neo.ehsanodyssey.patterns.facade.media_lib.codecs.MPEG4CompressionCodec;
import neo.ehsanodyssey.patterns.facade.media_lib.codecs.OggCompressionCodec;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
