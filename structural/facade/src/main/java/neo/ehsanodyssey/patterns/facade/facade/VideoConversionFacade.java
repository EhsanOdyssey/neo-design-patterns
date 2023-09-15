package neo.ehsanodyssey.patterns.facade.facade;

import neo.ehsanodyssey.patterns.facade.media_lib.AudioMixer;
import neo.ehsanodyssey.patterns.facade.media_lib.BitrateReader;
import neo.ehsanodyssey.patterns.facade.media_lib.CodecFactory;
import neo.ehsanodyssey.patterns.facade.media_lib.VideoFile;
import neo.ehsanodyssey.patterns.facade.media_lib.codecs.Codec;
import neo.ehsanodyssey.patterns.facade.media_lib.codecs.MPEG4CompressionCodec;
import neo.ehsanodyssey.patterns.facade.media_lib.codecs.OggCompressionCodec;

import java.io.File;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
